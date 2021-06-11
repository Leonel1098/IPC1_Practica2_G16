package com.company;

import java.io.*;

import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);
    //Alumonos
    public static Alumno[] alumnos = new Alumno[100];
    static int contadorAlumnos;
    //Profesores
    public static Profesor[] profesores = new Profesor[20];
    static int contadorProfe;
    //Asignacion de Alumnos
    public static AsignarAlumno[] AsignacionesAlumnos = new AsignarAlumno[200];
    static int contadorAsignacionAlunos;
    //Se crean Los arreglos de objetos
    static Cursos[] curso = new Cursos[15];
    static Notas[] notas = new Notas[100];
    static AsignarProfe[] asignarProfes = new AsignarProfe[30];
    //Contadores
    static  int contadorCursos=0;
    static int contadorNotas = 0;
    static int  asignarprofcont = 0;
    public static usuarios[] u = new usuarios[50];
    public static int posicion=0;



    public static void main(String[] args) {
        login();


    }
    public static void login()
    {
        if (verif()) {
            if (posicion==0) {
                System.out.println();
                Menu();
                CargarCursos();
                mostrarCursos();
                CargarNotas();
                mostrarNotas();
                AsiganacionProf();
                mostrarAsiganicionProf();
                CrearReporteCursos();
            }else
            {
                Menu2();
                mostrarCursos();
                mostrarNotas();
                mostrarAsiganicionProf();
                CrearReporteCursos();

            }
        }
        else
        {
            System.out.println("Ingreso denegado");
            System.out.println();
            login();}

    }

    public static boolean verif() {

        boolean b = false;
        usuarios admin = new usuarios("admin", "admin");
        u[0] = admin;
        System.out.println("Ingrese nombre de usuario");
        String n = sc.nextLine();
        System.out.println("Ingrese contraseña");
        String c = sc.nextLine();
        System.out.println("Igrese de nuevo su contraseña");
        String co = sc.nextLine();
        for (int i = 0; i < u.length; i++)
            try {
                if (u[i]!=null&&n.equals(u[i].getnombre()) && c.equals(u[i].getcontra()) && co.equals(c)) {
                    System.out.println("Bienvenido  " + u[i].getnombre());
                    posicion = i;
                    b = true;
                    return b;
                }

            } catch (Exception e) {
                return false;
            }
        return b;
    }


    // public static int nuevousuario=0;
    public static void nuevousuario()//CREACION DE UN NUEVO USUARIO, Y VERIFICACION DE QUE NO EXISTA EL NUEVO USUARIO
    {
        System.out.println("Ingrese Nuevo Nombre de Usuario");
        String nn = sc.nextLine().trim();
        System.out.println("Ingrese contraseña");
        String nc = sc.nextLine();
        System.out.println("Vuelva a ingresar la nueva ccontraseña");
        String nco = sc.nextLine();
        // try {
        for (int i = 0; i < u.length; i++)

            if (u[i]!=null&&nn.equals(u[i].getnombre())) {
                System.out.println("Este nombre ya se encuentra registrado:  " + u[i].getnombre());
                System.out.println("Ingrese un nuevo nombre de usuario y su respectiva conraseñaa");
                System.out.println();
                nuevousuario();
                break;
            }
            else
            {
                if (u[i]==null)
                {
                    if (nc.equals(nco))
                    {
                        usuarios nuevo = new usuarios(nn,nc);
                        u[i]=nuevo;
                        break;
                    }
                    else
                    {
                        System.out.println("Las contraseñas no coinciden");
                        nuevousuario();
                        break;
                    }

                }

            }

        //  } catch (Exception e) {
        //   System.out.println("ya no se pueden agregar más usuarios");



        // }

    }
    public static void Menu2()
    {
        boolean flag = true;
        do {


            //Opciones del Menu
            System.out.println("---Menu----");
            System.out.println("Mostrar Alumnos ");
            System.out.println("2.Cargar Profesores ");
            System.out.println("3.Cargar Cursos ");
            System.out.println("4.Asignar alumnos ");
            System.out.println("5.Asignar profesores ");
            System.out.println("6.Carga de notas");
            System.out.println("7.Agregar usuario al sistema:");
            System.out.println("8.Reportar");
            System.out.println("9.Manerjo de Errores  ");
            System.out.println("10.Cerrar sesión");
            System.out.println("10.Saler");
            String Op = sc.nextLine();
            switch (Op) {
                case "1":

                    System.out.printf("t----------------------");
                    mostrarAlumons();
                    System.out.println("-------------------------");

                    break;
                case "2":
                    System.out.println("--Cargar Profesores ---");

                    CargarProfesores();
                    break;
                case "3":
                    System.out.println("**Cargar Cursos--");
                    CargarCursos();

                    break;
                case "4":
                    System.out.println("--Asignar alumnos-- ");

                    asignarAlumno();
                    break;
                case "5":
                    System.out.println("--Asignar profesores--");


                    break;
                case "6":
                    System.out.println("--Carga de notas--");


                    break;
                case "7":
                    System.out.println("--Agregar usuarios al sistema --");
                    nuevousuario();


                    break;
                case "8":
                    System.out.println("--Reportar--");
                    Alumno a = new Alumno(12, 326, "Carlos", "lasdf", "M");
                    alumnos[0] = a;
                    CrearReporteAlunos();


                    break;
                case "9":
                    System.out.println("--Manejo de Errores -- ");
                    break;

                case "10":
                    login();
                    break;

                case "11":
                    flag = false;
                    break;

                default:
                    System.out.println("ERROR: OPCION INVALIDA ");
                    System.out.println();
                    break;
            }

        } while (flag);
    }
    //Menu  Principal --
    public static void Menu() {
        boolean flag = true;
        do {


            //Opciones del Menu
            System.out.println("---Menu----");
            System.out.println("1.Cargar Alumnos ");
            System.out.println("2.Cargar Profesores ");
            System.out.println("3.Cargar Cursos ");
            System.out.println("4.Asignar alumnos ");
            System.out.println("5.Asignar profesores ");
            System.out.println("6.Carga de notas");
            System.out.println("7.Agregar usuario al sistema:");
            System.out.println("8.Reportar");
            System.out.println("9.Manerjo de Errores  ");
            System.out.println("10.Cerrar Sesion");
            System.out.println("11.Salir");
            String Op = sc.nextLine();
            switch (Op) {
                case "1":
                    System.out.println("--Cargar Alumnos");
                    CargarAlumnos();
                    System.out.printf("t----------------------");
                    mostrarAlumons();
                    System.out.println("-------------------------");

                    break;
                case "2":
                    System.out.println("--Cargar Profesores ---");
                    CargarProfesores();

                    break;
                case "3":
                    System.out.println("**Cargar Cursos--");
                    CargarCursos();

                    break;
                case "4":
                    System.out.println("--Asignar alumnos-- ");

                    asignarAlumno();
                    break;
                case "5":
                    System.out.println("--Asignar profesores--");


                    break;
                case "6":
                    System.out.println("--Carga de notas--");


                    break;
                case "7":
                    System.out.println("--Agregar usuarios al sistema --");
                    nuevousuario();


                    break;
                case "8":
                    System.out.println("--Reportar--");

                    CrearReporteAlunos();


                    break;
                case "9":
                    System.out.println("--Manejo de Errores -- ");
                    break;

                case "10":
                    login();
                    break;


                case "11":
                    flag = false;
                    break;

                default:
                    System.out.println("ERROR: OPCION INVALIDA ");
                    System.out.println();
                    break;
            }

        } while (flag);

    }

    //Cargar Alumons
    public static void CargarAlumnos() {
        // ruta en donde stael archivo
        String ruta;
        System.out.println("Ingrese la ruta del archivo csv a leer ;");

        ruta = sc.nextLine();
        // codigo para abrir archivos
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // OBJETOS PARA ABRIR LOS ARCHIVOS
            // Una libreria no es mas que una clase que ya esta en JAVA,
            //entonces cuando importamos "librerias"
            // Estamos importando una clase
            archivo = new File(ruta);

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // LEYENDO EL ARCHIVO
            // Hack: si el archivo tiene encabezado, utilizar un br.readLine()
            //antes de la lectura
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                // Aqui estamos leyendo fila por fila, entonces vamos a
                //almacenar esa informacion en nuestro arreglo de Alumnos
                System.out.println(linea);
                // Separando los datos por una coma
                String[] Datos = linea.split(",");

                // Segun la estructura del archivo, sabemos que como vienen los datos:
                // Recordemos que estos datos son string, entonces si es
                //necesario convertimos los datos
                int id = Integer.parseInt(Datos[0]);
                int Carne = Integer.parseInt(Datos[1]);
                String nombre = Datos[2];
                String Fnac = Datos[3];
                String Genero = Datos[4];

                //Con nuestros datos, com.company.Alumno crear un objeto de tipo com.company.Alumno

                Alumno nuevo = new Alumno(id, Carne, nombre, Fnac, Genero);
                //agregamos este objeto a nuestro arreglo
                alumnos[contadorAlumnos] = nuevo;
                //EscribirPokemon(pokemons);
                //y aumentamos a uno nuestro contador de pokemones;
                contadorAlumnos++;


            }
        } catch (Exception e) {
            System.out.println("Ruta No Encontrasa :(");
            System.out.println(e);
            System.out.println("ERROR EN LA CARGA DEL ARCHIVO");

        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println(e2);
                System.out.println("ERROR EN LA CARGA DEL ARCHIVO");
            }

        }
    }

    //Metodo Cargar Profesores
    public static void CargarProfesores() {
        // ruta en donde stael archivo
        String ruta;
        System.out.println("Ingrese la ruta del archivo csv a leer ;");

        ruta = sc.nextLine();
        // codigo para abrir archivos
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // OBJETOS PARA ABRIR LOS ARCHIVOS
            // Una libreria no es mas que una clase que ya esta en JAVA,
            //entonces cuando importamos "librerias"
            // Estamos importando una clase
            archivo = new File(ruta);

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // LEYENDO EL ARCHIVO
            // Hack: si el archivo tiene encabezado, utilizar un br.readLine()
            //antes de la lectura
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                // Aqui estamos leyendo fila por fila, entonces vamos a
                //almacenar esa informacion en nuestro arreglo de Profesores
                System.out.println(linea);
                // Separando los datos por una coma
                String[] Datos = linea.split(",");

                // Segun la estructura del archivo, sabemos que como vienen los datos:
                // Recordemos que estos datos son string, entonces si es
                //necesario convertimos los datos
                int id = Integer.parseInt(Datos[0]);
                int Registro_de_Personal = Integer.parseInt(Datos[1]);
                String nombre = Datos[2];
                String Fnac = Datos[3];
                String FContrato = Datos[4];
                String Genero = Datos[5];

                //Con nuestros datos, com.company.Alumno crear un objeto de tipo com.company.Alumno

                Profesor nuevo = new Profesor(id, Registro_de_Personal, nombre, Fnac, FContrato, Genero);
                //agregamos este objeto a nuestro arreglo
                profesores[contadorProfe] = nuevo;
                //EscribirPokemon(pokemons);
                //y aumentamos a uno nuestro contador de pokemones;
                contadorProfe++;


            }
        } catch (Exception e) {
            System.out.println("Ruta No Encontrasa :(");
            System.out.println(e);
            System.out.println("ERROR EN LA CARGA DEL ARCHIVO");

        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println(e2);
                System.out.println("ERROR EN LA CARGA DEL ARCHIVO");
            }

        }
    }

    public static void mostrarAlumons() {
        System.out.println("Mostrando Todos los Datos Dentro Del Objeto ");
        for (int i = 0; i < contadorAlumnos; i++) {
            System.out.println("Nombre : " + alumnos[i].getNombre() + " Carne :"
                    + alumnos[i].getCarne() + " Genero : " + alumnos[i].getGenero());
        }
    }

    public static void asignarAlumno() {

        // ruta en donde stael archivo
        String ruta;
        System.out.println("Ingrese la ruta del archivo csv a leer ;");

        ruta = sc.nextLine();
        // codigo para abrir archivos
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // OBJETOS PARA ABRIR LOS ARCHIVOS
            // Una libreria no es mas que una clase que ya esta en JAVA,
            //entonces cuando importamos "librerias"
            // Estamos importando una clase
            archivo = new File(ruta);

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // LEYENDO EL ARCHIVO
            // Hack: si el archivo tiene encabezado, utilizar un br.readLine()
            //antes de la lectura
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                // Aqui estamos leyendo fila por fila, entonces vamos a
                //almacenar esa informacion en nuestro arreglo de Alumnos
                System.out.println(linea);
                // Separando los datos por una coma
                String[] Datos = linea.split(",");

                // Segun la estructura del archivo, sabemos que como vienen los datos:
                // Recordemos que estos datos son string, entonces si es
                //necesario convertimos los datos
                int idAlumon = Integer.parseInt(Datos[0]);
                int idProfesor = Integer.parseInt(Datos[1]);


                //Con nuestros datos, com.company.AsignarAlumno crear un objeto de tipo com.company.AsignarAlumno

                AsignarAlumno nuevo = new AsignarAlumno(idAlumon, idProfesor);
                //agregamos este objeto a nuestro arreglo
                AsignacionesAlumnos[contadorAsignacionAlunos] = nuevo;
                //EscribirPokemon(pokemons);
                //y aumentamos a uno nuestro contador de pokemones;
                contadorAsignacionAlunos++;


            }
        } catch (Exception e) {
            System.out.println("Ruta No Encontrasa :(");
            System.out.println(e);
            System.out.println("ERROR EN LA CARGA DEL ARCHIVO");

        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println(e2);
                System.out.println("ERROR EN LA CARGA DEL ARCHIVO");
            }

        }


    }

    public static void CargarCursos () {
        // ruta en donde stael archivo
        String ruta;
        System.out.println("Ingrese la ruta del archivo csv a leer ;");

        ruta = sc.nextLine();
        // codigo para abrir archivos
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // OBJETOS PARA ABRIR LOS ARCHIVOS
            // Una libreria no es mas que una clase que ya esta en JAVA,
            //entonces cuando importamos "librerias"
            // Estamos importando una clase
            archivo = new File(ruta);

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // LEYENDO EL ARCHIVO
            // Hack: si el archivo tiene encabezado, utilizar un br.readLine()
            //antes de la lectura
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                // Aqui estamos leyendo fila por fila, entonces vamos a
                //almacenar esa informacion en nuestro arreglo de Alumnos
                System.out.println(linea);
                // Separando los datos por una coma
                String[] Datos = linea.split(",");

                // Segun la estructura del archivo, sabemos que como vienen los datos:
                // Recordemos que estos datos son string, entonces si es
                //necesario convertimos los datos
                int id = Integer.parseInt(Datos[0]);
                int codigo = Integer.parseInt(Datos[1]);
                String nombre = Datos[2];


                //Con nuestros datos, Alumno crear un objeto de tipo Alumno

                Cursos nuevo = new Cursos(id,codigo,nombre);
                //agregamos este objeto a nuestro arreglo
                curso[contadorCursos]=nuevo;
                //EscribirPokemon(pokemons);
                //y aumentamos a uno nuestro contador de pokemones;
                contadorCursos++;

            }
        } catch (Exception e) {
            System.out.println("Ruta No Encontrada :(");
            System.out.println(e);
            System.out.println("ERROR EN LA CARGA DEL ARCHIVO");

        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println(e2);
                System.out.println("ERROR EN LA CARGA DEL ARCHIVO");
            }

        }
    }
    public static void  mostrarCursos(){
        System.out.println("Mostrando Todos los Datos Dentro Del Objeto ");
        for (int i =0;i<contadorCursos;i++){
            System.out.println("ID : "+curso[i].getId()+" Nombre :"+curso[i].getNombre()+" Código :"
                    +curso[i].getCodigo());
        }
    }
    public static void CargarNotas () {
        // ruta en donde stael archivo
        String ruta;
        System.out.println("Ingrese la ruta del archivo csv a leer ;");

        ruta = sc.nextLine();
        // codigo para abrir archivos
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // OBJETOS PARA ABRIR LOS ARCHIVOS
            // Una libreria no es mas que una clase que ya esta en JAVA,
            //entonces cuando importamos "librerias"
            // Estamos importando una clase
            archivo = new File(ruta);

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // LEYENDO EL ARCHIVO
            // Hack: si el archivo tiene encabezado, utilizar un br.readLine()
            //antes de la lectura
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                // Aqui estamos leyendo fila por fila, entonces vamos a
                //almacenar esa informacion en nuestro arreglo de Alumnos
                System.out.println(linea);
                // Separando los datos por una coma
                String[] Datos = linea.split(",");

                // Segun la estructura del archivo, sabemos que como vienen los datos:
                // Recordemos que estos datos son string, entonces si es
                //necesario convertimos los datos
                int idalumno = Integer.parseInt(Datos[0]);
                int idcurso = Integer.parseInt(Datos[1]);
                double nota = Double.parseDouble(Datos[2]);


                //Con nuestros datos, Alumno crear un objeto de tipo Alumno

                Notas nuevo = new Notas(idalumno,idcurso,nota);
                //agregamos este objeto a nuestro arreglo
                notas[contadorNotas]=nuevo;
                //EscribirPokemon(pokemons);
                //y aumentamos a uno nuestro contador de pokemones;
                contadorNotas++;

            }
        } catch (Exception e) {
            System.out.println("Ruta No Encontrada :(");
            System.out.println(e);
            System.out.println("ERROR EN LA CARGA DEL ARCHIVO");

        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println(e2);
                System.out.println("ERROR EN LA CARGA DEL ARCHIVO");
            }

        }
    }
    public static void  mostrarNotas(){
        System.out.println("Mostrando Todos los Datos Dentro Del Objeto ");
        for (int i =0;i<contadorNotas;i++){
            System.out.println("ID Alumno : "+notas[i].getIdalumno()+" ID Curso :"+notas[i].getIdcurso()+" Nota :"
                    +notas[i].getNota());
        }
    }

    public static void AsiganacionProf () {
        // ruta en donde stael archivo
        String ruta;
        System.out.println("Ingrese la ruta del archivo csv a leer ;");

        ruta = sc.nextLine();
        // codigo para abrir archivos
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // OBJETOS PARA ABRIR LOS ARCHIVOS
            // Una libreria no es mas que una clase que ya esta en JAVA,
            //entonces cuando importamos "librerias"
            // Estamos importando una clase
            archivo = new File(ruta);

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // LEYENDO EL ARCHIVO
            // Hack: si el archivo tiene encabezado, utilizar un br.readLine()
            //antes de la lectura
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                // Aqui estamos leyendo fila por fila, entonces vamos a
                //almacenar esa informacion en nuestro arreglo de Alumnos
                System.out.println(linea);
                // Separando los datos por una coma
                String[] Datos = linea.split(",");

                // Segun la estructura del archivo, sabemos que como vienen los datos:
                // Recordemos que estos datos son string, entonces si es
                //necesario convertimos los datos
                int idProf = Integer.parseInt(Datos[0]);
                int idCurso = Integer.parseInt(Datos[1]);



                //Con nuestros datos, Alumno crear un objeto de tipo Alumno

                AsignarProfe nuevo = new AsignarProfe(idProf,idCurso);
                //agregamos este objeto a nuestro arreglo
                asignarProfes[asignarprofcont]=nuevo;
                //EscribirPokemon(pokemons);
                //y aumentamos a uno nuestro contador de pokemones;
                asignarprofcont++;

            }
        } catch (Exception e) {
            System.out.println("Ruta No Encontrada :(");
            System.out.println(e);
            System.out.println("ERROR EN LA CARGA DEL ARCHIVO");

        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println(e2);
                System.out.println("ERROR EN LA CARGA DEL ARCHIVO");
            }

        }
    }
    public static void  mostrarAsiganicionProf(){
        System.out.println("Mostrando Todos los Datos Dentro Del Objeto ");
        for (int i =0;i<asignarprofcont;i++){
            System.out.println("ID Profesor : "+asignarProfes[i].getIdProf()+" ID Curso :"+asignarProfes[i].getIdCurso());
        }
    }


    // ----------------------------------------------------------------------------
    //REPORTES
    static String ReporteInicio = "", ReporteFinal = "";

    public static void variableReporte() {
        ReporteInicio = "<!DOCTYPE html><!--Declarar el tipo de cumento -->\r\n"
                + "<html>\r\n"
                + "\r\n"
                + "<!--Encabezado-->\r\n"
                + "<head>\r\n"
                + "<meta charset=\"UTF-8\"><!--codififcaion de caracteres ñ y á-->\r\n"
                + "\r\n"
                + "\r\n"
                + "<meta name=\"name\" content=\"Reporte\"><!--nombre de la pagina-->\r\n"
                + "<meta name=\"description\" content=\"name\"><!--autor de la pagina-->\r\n"
                + "<meta name=\"keywods\" content=\"uno,dos,tres\"><!--Palabras claavez para, separadas por comas-->\r\n"
                + "<meta name=\"robots\" content=\"Index, Follow\"><!--Mejora la busqueda-->\r\n"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><!--visibilidaad en diferentes pantallas -->\r\n"
                + "\r\n"
                + "\r\n"
                + "<link href=\"style.css\" rel=\"stylesheet\">"
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"Reportes/css/styles.css\"/><!--css /estilo/tipo/ruta relativa -->\r\n"
                + "\r\n"
                + "<title>Reporte</title><!--Titulo visible de la pagina-->\r\n"
                + "</head>\r\n"
                + "\r\n"
                + "<body>\r\n"

                + "\r\n"
                + "<center><!--centra todos lo que este dentro-->\r\n"
                + "\r\n"
                + "<!----tabla 1-->\r\n"

                + ""
                + "<!----tabla 1-->\r\n"
                + "<h6 class=\"titulos\"><b> Reporte   </b></h6>\r\n"
                + "";

        ReporteFinal = "\r\n"
                + "</center>\r\n"
                + "\r\n"
                + "</body>\r\n"
                + "</html>";
    }

    //-----------------------
    static String ReporteAlumnos = "<h1>Reportar Alumnos </h1>";
// crea Reporte Entrenadores   en HTML

    public static void CrearReporteAlunos() {
        variableReporte();
        ReporteAlumnos += "<table class=\"steelBlueCols\">";
        ReporteAlumnos += "<h6 class=\"titulos\"><b> Reportes/Reporte Alumnos</b></h6>\r\n";
        ReportandoAlumnos();
        try {

            FileWriter archivo = new FileWriter("ReporteAlunos.html");
            archivo.write(ReporteInicio + ReporteAlumnos + ReporteFinal);
            archivo.close();

        } catch (Exception e) {

        }
    }

    public static void CrearReporteCursos() {
        variableReporte();
        ReporteAlumnos += "<table class=\"steelBlueCols\">";
        ReporteAlumnos += "<thead><tr>"
                + "<th>  " + curso[0].getId() + curso[0].getNombre() + curso[0].getCodigo()+
                + curso[1].getId() + curso[1].getNombre() + curso[1].getCodigo()+"</th>"
                + "</tr> "
                + "</ thead ></table>";
        try {

            FileWriter archivo = new FileWriter("Reportes/ReporteAlunos.html");
            archivo.write(ReporteInicio + ReporteAlumnos + ReporteFinal);
            archivo.close();

        } catch (Exception e) {

        }
    }

    public static void ReportandoAlumnos() {

        for (int i = 0; i < contadorAlumnos; i++) {
            String Genero = "";
            if (alumnos[i].getGenero().equals("M")) {
                Genero = "Masculino";
            }
            if (alumnos[i].getGenero().equals("F")) {
                Genero = "Femenino";
            }
            String Fecha = alumnos[i].getFnac();
            System.out.println(alumnos[i].getFnac());
            String Datos [] =Fecha.split("/");
            int edad = Integer.parseInt(Datos[2]);
            edad =2021-edad;


            ReporteAlumnos+="<!----tabla 2-->\n" +
                    "<table class=\"steelBlueCols\">\n" +
                    "<thead>\n" +
                    "   <tr> <th>Carne </th> " +
                    "<th>Nombre</th> " +
                    "<th>Edad </th>" +
                    "<th>Genero </th> </tr>" +
                    "</thead>\n" +
                    "<tbody>\n" +
                    "   <tr> <td>"+alumnos[i].getCarne()+ "</td>" +
                    " <td>"+alumnos[i].getNombre()+" </td> " +
                    "<td>"+edad+"</td> " +
                    "<td>"+Genero+"</td></tr>"+

                    "</tbody>\n" +
                    "</table>\n" +
                    " <!----termina tabla 2-->";


        }


    }
}
