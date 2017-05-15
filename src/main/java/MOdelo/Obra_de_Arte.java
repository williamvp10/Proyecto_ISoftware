/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MOdelo;

/**
 *
 * @author Labing
 */
public class Obra_de_Arte {
    
    private String nombre;
    private String discripcion;
    private String estilo;
    private double valor;
    private Artista artista;

    public Obra_de_Arte(String nombre, String discripcion, String estilo, double valor, Artista artista) {
        this.nombre = nombre;
        this.discripcion = discripcion;
        this.estilo = estilo;
        this.valor = valor;
        this.artista = artista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiscripcion() {
        return discripcion;
    }

    public void setDiscripcion(String discripcion) {
        this.discripcion = discripcion;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    
    
    
    
}
