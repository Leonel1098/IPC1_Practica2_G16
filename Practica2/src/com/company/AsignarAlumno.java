package com.company;

public class AsignarAlumno {

    private int idAlumno;
    private int idCurso;

    public AsignarAlumno(int alumno,int idCurso){
        this.idAlumno=alumno;
        this.idCurso=idCurso;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idProfesor) {
        this.idCurso = idProfesor;
    }
}
