/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MOdelo;

/**
 *
 * @author willy
 */
public class Horario {
    private int id;
    private String materia;
    private int dia;
    private int hinicio;
    private int hfin;

    public Horario(int id, String materia, int dia, int hinicio, int hfin) {
        this.id = id;
        this.materia = materia;
        this.dia = dia;
        this.hinicio = hinicio;
        this.hfin = hfin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHinicio() {
        return hinicio;
    }

    public void setHinicio(int hinicio) {
        this.hinicio = hinicio;
    }

    public int getHfin() {
        return hfin;
    }

    public void setHfin(int hfin) {
        this.hfin = hfin;
    }
    
}
