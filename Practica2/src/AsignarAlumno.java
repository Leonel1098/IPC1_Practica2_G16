public class AsignarAlumno {

    private int idAlumno;
    private int idProfesor;

    public AsignarAlumno(int alumno,int idProfesor){
        this.idAlumno=alumno;
        this.idProfesor=idProfesor;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }
}
