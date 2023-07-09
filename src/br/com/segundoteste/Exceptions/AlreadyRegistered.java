package br.com.segundoteste.Exceptions;

public class AlreadyRegistered extends Exception {
    public AlreadyRegistered(String name) {
        super("O candidato " + name + " já participa do processo!");
    }
}