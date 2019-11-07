package com.exemple.algamoney.api.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class RecursoCriadoEvent extends ApplicationEvent {

    private HttpServletResponse response;
    private Long codigo;


    private static final long serialVersionUID = 1L;
    public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
        super(source);
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Long getCodigo() {
        return codigo;
    }
}
