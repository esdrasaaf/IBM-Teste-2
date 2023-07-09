package br.com.segundoteste;

public class User {
    private int id;
    private String name;
    private String status;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = "Recebido";
    }

    public User() {
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
