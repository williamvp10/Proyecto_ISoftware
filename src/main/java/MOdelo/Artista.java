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
public class Artista extends Usuario{
    
    private String curriculum;
    private String distincion;

    public Artista(String curriculum, String distincion, String user, String nombre) {
        super(user, nombre);
        this.curriculum = curriculum;
        this.distincion = distincion;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public String getDistincion() {
        return distincion;
    }

    public void setDistincion(String distincion) {
        this.distincion = distincion;
    }
}
