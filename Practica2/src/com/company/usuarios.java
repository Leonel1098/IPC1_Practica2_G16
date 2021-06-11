package com.company;

public class usuarios {
    private String nombre,contra;
    public usuarios(String nombre, String contra)
    {
        this.nombre=nombre;
        this.contra=contra;
    }
    public String getnombre()
    {
        return nombre;
    }
    public String getcontra()
    {
        return contra;
    }
}
