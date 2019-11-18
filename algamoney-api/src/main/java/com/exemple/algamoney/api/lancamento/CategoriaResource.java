package com.exemple.algamoney.api.lancamento;

import com.exemple.algamoney.api.comum.RecursoCriadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
class CategoriaResource {

    @Autowired //Ache uma implementação de categoriaRepository e entregue aqui
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    /* Retorna apenas a lista do banco, estando cheia ou vazia - Status 200 OK. */
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
    List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    //Buscar a categoria e caso não exista, retornar 404
    @GetMapping("/{codigo}")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
    ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable long codigo) {
        Categoria categoria = categoriaRepository.findOne(codigo);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

    /* Para saber o código da categoria que ele criou, usando responseentity */
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva); //Passa URI e a categoria que foi salva
    }


}


/* --------------------------------USANDO GET------------------------------------*/

    /* Retorna uma mensagem 404, não encontrado. Porém não está correto.
    @GetMapping
    ResponseEntity<?> listar() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.notFound().build();
    }
     */

    /* Retorna uma mensagem 204 - Nenhum conteúdo quando a lista estiver vazia
    @GetMapping
    ResponseEntity<?> listar() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.noContent().build();
    }
     */

     /*Busca a categoria pelo codigo
    @GetMapping("/{codigo}")
    Categoria buscarPeloCodigo(@PathVariable long codigo) {
        return categoriaRepository.findOne(codigo);
    }*/

/* --------------------------------USANDO POST------------------------------------*/

    /* Insere no banco uma categoria via POST e retorna um 201 CREATED.
    @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
    void criar(@RequestBody Categoria categoria) {
        categoriaRepository.save(categoria);
    }
     */

    /* Através da classe ServletURI Builder, vai através da requisição atual que foi pra /categoria (via post),
    vai pegar o código e adicionar ele na URI, por fim, setar o HEADER LOCATION com essa URI
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void criar(@RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(categoriaSalva.getCodigo()).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
    */
/* --------------------------------/////////------------------------------------*/
