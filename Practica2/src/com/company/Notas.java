package com.company;

public class Notas {
    private int Idalumno;
    private int Idcurso;
    private double nota;

    public Notas(int idalumno, int idcurso, double nota){
        this.Idalumno = idalumno;
        this.Idcurso = Idcurso;
        this.nota = nota;

    }


    public int getIdalumno() {
        return Idalumno;
    }

    public void setIdalumno(int idalumno) {
        Idalumno = idalumno;
    }

    public int getIdcurso() {
        return Idcurso;
    }

    public void setIdcurso(int idcurso) {
        Idcurso = idcurso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
