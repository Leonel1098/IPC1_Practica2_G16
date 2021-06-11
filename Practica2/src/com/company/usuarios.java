package com.company;

public class usuarios {
    private String nombre;
    private char[] contra;
    public usuarios(String nombre, char[] contra)
    {
        this.nombre=nombre;
        this.contra=contra;
    }
    public String getnombre()
    {
        return nombre;
    }
    public char[] getcontra()
    {
        return contra;
    }
}
