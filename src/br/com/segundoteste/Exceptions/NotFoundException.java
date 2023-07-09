package br.com.segundoteste.Exceptions;

public class NotFoundException extends Exception {
    public NotFoundException() {
        super("Este candidato não existe no nosso banco de dados!");
    }
}