package com.company;

public class Profesor {

    private int id ;
    private int RegistroPersonal;
    private String nombre;
    private String FNac;
    private String FContrato;
    private String Genero ;

    //Constructor
    public Profesor(int id , int RegistroPersona,String nombre ,String FNac, String FContrato,String Genero){
        this.id=id;
        this.RegistroPersonal=RegistroPersona;
        this.nombre=nombre;
        this.FNac=FNac;
        this.FContrato=FContrato;
        this.Genero=Genero;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegistroPersonal() {
        return RegistroPersonal;
    }

    public void setRegistroPersonal(int registroPersonal) {
        RegistroPersonal = registroPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFNac() {
        return FNac;
    }

    public void setFNac(String FNac) {
        this.FNac = FNac;
    }

    public String getFContrato() {
        return FContrato;
    }

    public void setFContrato(String FContrato) {
        this.FContrato = FContrato;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }
}
