package br.com.segundoteste;

import java.util.ArrayList;
import java.util.List;

import br.com.segundoteste.Exceptions.AlreadyRegistered;
import br.com.segundoteste.Exceptions.NotFoundException;

public class Segundo {
    int idCandidato = 1;
    List<User> candidatos = new ArrayList<User>();
    List<User> recebidos = new ArrayList<User>();
    List<User> qualificados = new ArrayList<User>();
    List<User> aprovados = new ArrayList<User>();

    public int iniciarProcesso(String nome) throws AlreadyRegistered {
        for (int i = 0; i < candidatos.size(); i++) {
            if (candidatos.get(i).getName().equals(nome)) throw new AlreadyRegistered(nome); 
        }

        User candidato = new User(idCandidato, nome);

        candidatos.add(candidato);
        recebidos.add(candidato);
        idCandidato++;

        return candidato.getId();
    }

    public void marcarEntrevista(int codCandidato) throws NotFoundException {
        for (int i = 0; i < recebidos.size(); i++) {
            User candidato = recebidos.get(i);

            if (candidato.getId() == codCandidato && candidato.getStatus().equals("Recebido")) {
                recebidos.remove(i);
                qualificados.add(candidato);
                candidato.setStatus("Qualificado");
                return;
            }
        }

        throw new NotFoundException();
    }

    public void desqualificarCandidato(int codCandidato) throws NotFoundException {
        User candidato = new User();

        for (int i = 0; i < candidatos.size(); i++) {
            if(candidatos.get(i).getId() == codCandidato) {
                candidato = candidatos.get(i);
                candidatos.remove(i);
                break;
            }
        }

        if (candidato.getName() == null) {
            throw new NotFoundException();
        } else { 
            switch (candidato.getStatus()) {
            case "Recebido":        
                for (int i = 0; i < recebidos.size(); i++) {
                    if(recebidos.get(i).getId() == codCandidato) {
                        recebidos.remove(i);
                        break;
                    }
                }

            case "Qualificado":        
                for (int i = 0; i < qualificados.size(); i++) {
                    if(qualificados.get(i).getId() == codCandidato) {
                        qualificados.remove(i);
                        break;
                    }
                } 

            case "Aprovado":        
                for (int i = 0; i < aprovados.size(); i++) {
                    if(aprovados.get(i).getId() == codCandidato) {
                        aprovados.remove(i);
                        break;
                    }
                } 
        
            default: break;
        }
        }
    }

    public String verificarStatusCandidato(int codCandidato) throws NotFoundException {
        for (int i = 0; i < candidatos.size(); i++) {
            User candidato = candidatos.get(i);

            if (candidato.getId() == codCandidato) return candidato.getStatus();
        }

        throw new NotFoundException();
    }

    public void aprovarCandidato(int codCandidato) throws NotFoundException {
        for (int i = 0; i < qualificados.size(); i++) {
            User candidato = qualificados.get(i);

            if (candidato.getId() == codCandidato && candidato.getStatus().equals("Qualificado")) {
                qualificados.remove(i);
                aprovados.add(candidato);
                candidato.setStatus("Aprovado");
                return;
            }
        }

        throw new NotFoundException();
    }

    public List<User> obterAprovados() {
        return aprovados;
    }
}
