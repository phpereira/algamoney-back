package com.exemple.algamoney.api.resource;

import com.exemple.algamoney.api.model.Categoria;
import com.exemple.algamoney.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired //Ache uma implementação de categoriaRepository e entregue aqui
    private CategoriaRepository categoriaRepository;


    //USANDO GET

    /* Retorna apenas a lista do banco, estando cheia ou vazia - Status 200 OK. */
    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    /* Retorna uma mensagem 404, não encontrado. Porém não está correto.
    @GetMapping
    public ResponseEntity<?> listar() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.notFound().build();
    }
     */

    /* Retorna uma mensagem 204 - Nenhum conteúdo quando a lista estiver vazia
    @GetMapping
    public ResponseEntity<?> listar() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return !categorias.isEmpty() ? ResponseEntity.ok(categorias) : ResponseEntity.noContent().build();
    }
     */

    //USANDO POST

    /* Insere no banco uma categoria via POST e retorna um 201 CREATEAD.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody Categoria categoria) {
        categoriaRepository.save(categoria);
    }
     */

/* Através da classe ServletURI Builder, vai através da requisição atual que foi pra /categoria (via post),
vai pegar o código e adicionar ele na URI, por fim, setar o HEADER LOCATION com essa URI
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(categoriaSalva.getCodigo()).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
 */

    /* Para saber o código da categoria que ele criou, usando responseentity */
    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriaSalva = categoriaRepository.save(categoria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(categoriaSalva.getCodigo()).toUri();
        response.setHeader("Location", uri.toASCIIString());

        return ResponseEntity.created(uri).body(categoriaSalva); //Passa URI e a categoria que foi salva
    }

    @GetMapping("/{codigo}")
    public Categoria buscarPeloCodigo(@PathVariable long codigo) {
        return categoriaRepository.findOne(codigo);
    }

}
