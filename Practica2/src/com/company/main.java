package com.company;




import java.io.*;
import java.sql.SQLOutput;
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


    public static void main(String[] args) {
        Menu();
        System.out.println("asdfsdfasdf");
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
            System.out.println("10.Saler");
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


                    break;
                case "3":
                    System.out.println("**Cargar Cursos--");


                    break;
                case "4":
                    System.out.println("--Asignar alumnos-- ");


                    break;
                case "5":
                    System.out.println("--Asignar profesores--");


                    break;
                case "6":
                    System.out.println("--Carga de notas--");


                    break;
                case "7":
                    System.out.println("--Agregar usuarios al sistema --");


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
                + "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/styles.css\"/><!--css /estilo/tipo/ruta relativa -->\r\n"
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
        ReporteAlumnos += "<h6 class=\"titulos\"><b> Reporte Alumnos</b></h6>\r\n";
        ReportandoAlumnos();
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
                    "<td>"+alumnos[i].getFnac()+"</td> " +
                    "<td>"+Genero+"</td></tr>"+

                    "</tbody>\n" +
                    "</table>\n" +
                    " <!----termina tabla 2-->";


        }


    }
}
