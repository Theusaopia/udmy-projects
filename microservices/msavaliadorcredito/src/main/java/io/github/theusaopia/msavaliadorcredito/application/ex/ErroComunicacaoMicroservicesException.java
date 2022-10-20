package io.github.theusaopia.msavaliadorcredito.application.ex;

import lombok.Getter;

@Getter
public class ErroComunicacaoMicroservicesException extends Exception {

    private Integer status;

    public ErroComunicacaoMicroservicesException(String message, Integer status) {
        super(message);
        this.status = status;
    }
}
