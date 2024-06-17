package br.com.conversor.modelo;

public class Moeda {
    private String codigo;

    public Moeda(String codigo){
        this.codigo = codigo;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
