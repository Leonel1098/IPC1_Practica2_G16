package com.company;

public class AsignarProfe {
    private int idProf;
    private int IdCurso;
    public AsignarProfe(int idProf, int idCurso){
        this.IdCurso = idCurso;
        this.idProf = idProf;

    }

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public int getIdCurso() {
        return IdCurso;
    }

    public void setIdCurso(int idCurso) {
        IdCurso = idCurso;
    }
}
