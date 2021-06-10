package com.company;

public class Alumno {
    private int id ;
    private int carne;
    private String nombre;
    private String Fnac;
    private String Genero;
    public Alumno(int id ,int carne, String nombre , String Fnac,String Genero){
        this.id=id;
        this.carne=carne;
        this.nombre=nombre;
        this.Fnac=Fnac;
        this.Genero=Genero;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarne() {
        return carne;
    }

    public void setCarne(int carne) {
        this.carne = carne;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFnac() {
        return Fnac;
    }

    public void setFnac(String fnac) {
        Fnac = fnac;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }
}
