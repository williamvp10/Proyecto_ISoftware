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
public class Estudiante {
    private int id;
    private String nombre;
    private String apellido;
    private String correoAcudiente;
    private String nombreAcudiente;
    private int curso;

    public Estudiante(int id, String nombre, String apellido, String correoAcudiente, String nombreAcudiente, int curso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoAcudiente = correoAcudiente;
        this.nombreAcudiente = nombreAcudiente;
        this.curso = curso;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoAcudiente() {
        return correoAcudiente;
    }

    public void setCorreoAcudiente(String correoAcudiente) {
        this.correoAcudiente = correoAcudiente;
    }

    public String getNombreAcudiente() {
        return nombreAcudiente;
    }

    public void setNombreAcudiente(String nombreAcudiente) {
        this.nombreAcudiente = nombreAcudiente;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    
    
}
