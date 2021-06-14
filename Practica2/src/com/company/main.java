package com.company;

import com.sun.javafx.binding.StringFormatter;

import javax.xml.crypto.Data;
import java.io.*;

import java.text.BreakIterator;
import java.util.Date;
import java.util.Queue;
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
    static int contadorCursos;
    static int contadorNotas;
    static int asignarprofcont;
    public static usuarios[] u = new usuarios[6];
    public static int posicion = 0;


    //MAIN
    public static void main(String[] args) {

        Menu();


    }

    public static void login() {
        if (verif()) {
            if (posicion == 0) {
                System.out.println("Menu de admin");
                Menu();
               /* CargarCursos();
                mostrarCursos();
                CargarNotas();
                mostrarNotas();
                AsiganacionProf();
                mostrarAsiganicionProf();*/
                // CrearReporteCursos();
            } else {
                System.out.println("Menu de usuario");
                Menu2();
               /* mostrarCursos();
                mostrarNotas();
                mostrarAsiganicionProf();*/
                // CrearReporteCursos();

            }
        } else {
            System.out.println("Ingreso denegado");
            System.out.println();
            login();
        }
    }

    public static boolean verif() {

        boolean b = false;
        char[] k = new char[]{'a', 'd', 'm', 'i', 'n'};
        System.out.println(k);
        usuarios admin = new usuarios("admin", k);
        u[0] = admin;
        System.out.println("Ingrese nombre de usuario");
        String n = sc.nextLine();
        System.out.println("Ingrese contraseña");
        Console bbcita = System.console();
        char[] contra = bbcita.readPassword();
        System.out.println("Igrese de nuevo su contraseña");
        Console bblin = System.console();
        char[] contra2 = bblin.readPassword();

        for (int i = 0; i < u.length; i++)
            try {
                if (u[i] != null && n.equals(u[i].getnombre()) && java.util.Arrays.equals(u[i].getcontra(), contra) && java.util.Arrays.equals(contra2, contra)) {
                    System.out.println("Bienvenido  " + u[i].getnombre());
                    posicion = i;
                    b = true;
                    return b;
                }

            } catch (Exception e) {
                System.out.println("dio error");
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
        Console bbcita = System.console();
        char[] contra = bbcita.readPassword();

        System.out.println("Vuelva a ingresar la nueva ccontraseña");
        Console bblin = System.console();
        char[] contra2 = bblin.readPassword();

        try {
            for (int i = 0; i < u.length; i++)

                if (u[i] != null && nn.equals(u[i].getnombre())) {
                    System.out.println("Este nombre ya se encuentra registrado:  " + u[i].getnombre());
                    System.out.println("Ingrese un nuevo nombre de usuario y su respectiva conraseñaa");
                    System.out.println();
                    nuevousuario();
                    break;
                } else {
                    if (u[i] == null) {
                        if (java.util.Arrays.equals(contra2, contra)) {
                            usuarios nuevo = new usuarios(nn, contra);
                            u[i] = nuevo;
                            break;
                        } else {
                            System.out.println("Las contraseñas no coinciden");
                            nuevousuario();
                            break;
                        }

                    }

                }

        } catch (Exception e) {
            System.out.println("ya no se pueden agregar más usuarios");


        }


    }

    public static void Menu2() {
        boolean flag = true;
        do {
            //Opciones del Menu
            System.out.println("1.Reportar");
            System.out.println("2.Cerrar Sesión");
            System.out.println("3.Salir");
            String Op = sc.nextLine();
            switch (Op) {
                case "1":


                    submenu();


                    break;
                case "2":
                    login();

                    break;
                case "3":
                    System.exit(12);
                    break;


                default:
                    System.out.println("ERROR: OPCION INVALIDA ");
                    System.out.println();
                    break;
            }

        } while (flag);
    }

    public static void submenu() {
        boolean flag = true;
        do {
            //Opciones del Menu
            System.out.println("--REPORTES");

            System.out.println("1.Reporte de Alumnos");
            System.out.println("2.Reporte de Asignación de alumnos");
            System.out.println("3.Reporte de Asignación de profesores");
            System.out.println("4.Reporte General de Cursos ");
            System.out.println("5.Reporte de Curso Específico");
            System.out.println("6.Top 5 Mejors Alumnos de un Curso");
            System.out.println("7.Regresar al menú");

            String Op = sc.nextLine();
            switch (Op) {
                case "1":
                    ReportandoAlumnos();

                    break;
                case "2":
                    ReportandoAsinacionAlumnos();

                    break;
                case "3":
                    ReportandoAsinacionProfesores();
                    break;
                case "4":
                    ReportaandoReporteGeneralCuros();
                    break;
                case "5":
                    //reporte de curso específico
                    break;
                case "6":
                    //top 5 de alumnos
                    break;
                case "7":
                    Menu2();
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
                    CrearReporLogAlumnos();
                    ReportandoAsinacionAlumnos();
                    break;
                case "2":
                    System.out.println("--Cargar Profesores ---");
                    CargarProfesores();
                    CrearReporLogProfesores();
                    break;
                case "3":
                    System.out.println("**Cargar Cursos--");
                    CargarCursos();

                    break;
                case "4":
                    System.out.println("--Asignar alumnos-- ");

                    asignarAlumno();
                    ReportandoAsinacionAlumnos();
                    CrearReporteAsignacionAlumnos();
                    break;
                case "5":
                    System.out.println("--Asignar profesores--");
                    AsiganacionProf();
                    ReportandoAsinacionProfesores();
                    CrearReporteAsignacionProfesores();
                    break;
                case "6":
                    System.out.println("--Carga de notas--");
                    CargarNotas();

                    break;
                case "7":
                    System.out.println("--Agregar usuarios al sistema --");
                    nuevousuario();


                    break;
                case "8":
                    System.out.println("--Reportar--");
                    CrearReporteTop ();
                    CrearReporteAlunos();
                    CrearReporteGeneralCursoss();
                    ReporteCursoEspecifico();

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
            int contLineas = 1;
            while ((linea = br.readLine()) != null) {

                // Aqui estamos leyendo fila por fila, entonces vamos a
                //almacenar esa informacion en nuestro arreglo de Alumnos
                System.out.println(linea);
                // Separando los datos por una coma
                String[] Datos = linea.split(",");


                Datos[0] = Datos[0].replaceAll(" ", "");
                Datos[1] = Datos[1].replaceAll(" ", "");
                Datos[3] = Datos[3].replaceAll(" ", "");
                Datos[4] = Datos[4].replaceAll(" ", "");
                System.out.println(Datos[4]);

                if (Datos[0].matches(".[/!#$%&/()=¿) ].*")) {
                    VariableParaGuardarLog += "Linea " + contLineas + " Error en id Caracter incorrecto\n";
                    contLineas++;
                    break;
                }
                if (Datos[1].matches(".[/!#$%&/()=¿)].*")) {
                    VariableParaGuardarLog += "Linea " + contLineas + " Error en Carne Caracter incorrecto\n";
                    contLineas++;
                    break;
                }
                if (Datos[2].matches(".[/123456789!#$%&/()=¿)].*")) {
                    VariableParaGuardarLog += "Linea " + contLineas + " Error en Nombre Caracter incorrecto\n";
                    contLineas++;
                    break;
                }
                if (Datos[3].matches(".[!#$%&()=¿)].*")) {
                    VariableParaGuardarLog += "Linea " + contLineas + "  Error en Fecha de NAcimiento Caracter incorrecto\n";
                    contLineas++;
                    break;
                }
                if (Datos[4].matches(".[/!#$%&/()=¿)].*")) {
                    VariableParaGuardarLog += "Linea  " + contLineas + "  Error en id GEenero  incorrecto\n";
                    contLineas++;
                    break;
                }
                //Verificar Carne
                for (int i = 0; i < contadorAlumnos; i++) {
                    if (Datos[1].equals(alumnos[i].getCarne())) {
                        VariableParaGuardarLog += "Linea  " + contLineas + "  Error en Cerne caracter  incorrecto\n";
                        break;
                    }
                }


                // Segun la estructura del archivo, sabemos que como vienen los datos:
                // Recordemos que estos datos son string, entonces si es
                //necesario convertimos los datos
                try {
                    contLineas++;
                    int id = Integer.parseInt(Datos[0]);
                    int Carne = Integer.parseInt(Datos[1]);
                    String nombre = Datos[2];
                    String Fnac = Datos[3];
                    String Genero = Datos[4];

                    boolean CarneRepetido = false;
                    for (int i = 0; i < contadorAlumnos; i++) {
                        if (Carne == alumnos[i].getCarne()) {

                            CarneRepetido = true;

                        }
                    }
                    if (CarneRepetido) {
                        VariableParaGuardarLog += "Linea  : " + contLineas + "  Error en Cerne Repetido  incorrecto\n";
                        contLineas++;
                        continue;
                    }
                    boolean idRepetido = false;
                    for (int i = 0; i < contadorAlumnos; i++) {
                        if (id == alumnos[i].getId()) {
                            idRepetido = true;
                        }
                    }
                    if (idRepetido) {
                        VariableParaGuardarLog += "Linea : " + contLineas + " Error  en Id Repetido  incorrecto\n";
                        contLineas++;
                        continue;
                    }
                    if (!Genero.equals("M")) {
                        if (!Genero.equals("F")) {
                            VariableParaGuardarLog += "Linea ;  " + contLineas + "  Error en GEnero  caracter  incorrecto\n";
                            contLineas++;
                            continue;
                        }
                    }
                    if (Genero.equals(" ")) {
                        VariableParaGuardarLog += "Linea ; " + contLineas + "  Error en  caracter  incorrecto\n";
                        contLineas++;
                        continue;
                    }
                    if (Genero.equals("")) {
                        VariableParaGuardarLog += "Linea ;" + contLineas + "  Error en  caracter  incorrecto\n";
                        contLineas++;
                        continue;
                    }


                    Alumno nuevo = new Alumno(id, Carne, nombre, Fnac, Genero);
                    //agregamos este objeto a nuestro arreglo
                    alumnos[contadorAlumnos] = nuevo;
                    //EscribirPokemon(pokemons);
                    //y aumentamos a uno nuestro contador de pokemones;
                    contadorAlumnos++;


                    //Con nuestros datos, com.company.Alumno crear un objeto de tipo com.company.Alumno


                } catch (Exception e) {
                    System.out.println(e.toString());
                    String error = e.getMessage();
                    String erro2 = e.getLocalizedMessage();
                    System.out.println(erro2);
                    String DErr[] = error.split(":");
                    if (DErr[0].equals("For input string")) {
                        System.out.println("Error en la Linea " + contLineas);
                        System.out.println(DErr[1] + " No es un Numero ");
                        VariableParaGuardarLog += "Linea:  " + contLineas + "   Error en  caracter  incorrecto\n";

                    }

                }

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
            int contLineas = 1;
            while ((linea = br.readLine()) != null) {

                // Aqui estamos leyendo fila por fila, entonces vamos a
                //almacenar esa informacion en nuestro arreglo de Profesores
                System.out.println(linea);
                // Separando los datos por una coma
                String[] Datos = linea.split(",");
                Datos[0] = Datos[0].replaceAll(" ", "");
                Datos[1] = Datos[1].replaceAll(" ", "");
                Datos[3] = Datos[3].replaceAll(" ", "");
                Datos[4] = Datos[4].replaceAll(" ", "");
                Datos[5] = Datos[5].replaceAll(" ", "");


                if (Datos[0].matches(".[/!#$%&/()=¿) ].*")) {
                    VariableParaGuardarLogProfes += "Linea " + contLineas + " Error en id Caracter incorrecto\n";
                    contLineas++;
                    continue;
                }
                if (Datos[1].matches(".[/!#$%&/()=¿)].*")) {
                    VariableParaGuardarLogProfes += "Linea " + contLineas + " Error en Carne Caracter incorrecto\n";
                    contLineas++;
                    continue;
                }
                if (Datos[2].matches(".[/123456789!#$%&/()=¿)].*")) {
                    VariableParaGuardarLogProfes += "Linea " + contLineas + " Error en Nombre Caracter incorrecto\n";
                    contLineas++;
                    continue;
                }
                if (Datos[3].matches(".[!#$%&()=¿)].*")) {
                    VariableParaGuardarLogProfes += "Linea " + contLineas + "  Error en Fecha de NAcimiento Caracter incorrecto\n";
                    contLineas++;
                    continue;
                }
                if (Datos[4].matches(".[!#$%&()=¿)].*")) {
                    VariableParaGuardarLogProfes += "Linea  " + contLineas + "  Error en id GEenero  incorrecto\n";
                    contLineas++;
                    continue;
                }
                if (Datos[5].matches(".[!#$%&()=¿)].*")) {
                    VariableParaGuardarLogProfes += "Linea  " + contLineas + "  Error en id GEenero  incorrecto\n";
                    contLineas++;
                    continue;
                }
                //Verificar Carne
                for (int i = 0; i < contadorProfe; i++) {
                    if (Datos[1].equals(profesores[i].getRegistroPersonal())) {
                        VariableParaGuardarLogProfes += "Linea  " + contLineas + "  Error en Registro Personal caracter  incorrecto\n";
                        break;
                    }
                }

                // Segun la estructura del archivo, sabemos que como vienen los datos:
                // Recordemos que estos datos son string, entonces si es
                //necesario convertimos los datos
                try {
                    contLineas++;
                    int id = Integer.parseInt(Datos[0]);
                    int Registro_de_Personal = Integer.parseInt(Datos[1]);
                    String nombre = Datos[2];
                    String Fnac = Datos[3];
                    String FContrato = Datos[4];
                    String Genero = Datos[5];
                    boolean RpRepetido = false;
                    for (int i = 0; i < contadorProfe; i++) {
                        if (Registro_de_Personal == profesores[i].getRegistroPersonal()) {

                            RpRepetido = true;

                        }
                    }
                    if (RpRepetido) {
                        VariableParaGuardarLogProfes += "Linea  : " + contLineas + "  Error en RegistroPersonal  incorrecto\n";
                        contLineas++;
                        continue;
                    }
                    boolean idRepetido = false;
                    for (int i = 0; i < contadorProfe; i++) {
                        if (id == profesores[i].getId()) {
                            idRepetido = true;
                        }
                    }
                    if (idRepetido) {
                        VariableParaGuardarLogProfes += "Linea : " + contLineas + " Error  en Id Repetido  incorrecto\n";
                        contLineas++;
                        continue;
                    }
                    if (!Genero.equals("M")) {
                        if (!Genero.equals("F")) {
                            VariableParaGuardarLogProfes += "Linea ;  " + contLineas + "  Error en GEnero  caracter  incorrecto\n";
                            contLineas++;
                            continue;
                        }
                    }
                    if (Genero.equals(" ")) {
                        VariableParaGuardarLogProfes += "Linea ; " + contLineas + "  Error en  caracter  incorrecto\n";
                        contLineas++;
                        continue;
                    }
                    if (Genero.equals("")) {
                        VariableParaGuardarLogProfes += "Linea ;" + contLineas + "  Error en  caracter  incorrecto\n";
                        contLineas++;
                        continue;
                    }


                    //Con nuestros datos, com.company.Alumno crear un objeto de tipo com.company.Alumno

                    Profesor nuevo = new Profesor(id, Registro_de_Personal, nombre, Fnac, FContrato, Genero);
                    //agregamos este objeto a nuestro arreglo
                    profesores[contadorProfe] = nuevo;
                    //EscribirPokemon(pokemons);
                    //y aumentamos a uno nuestro contador de pokemones;
                    contadorProfe++;
                } catch (Exception e) {
                    System.out.println(e.toString());
                    String error = e.getMessage();
                    String erro2 = e.getLocalizedMessage();
                    System.out.println(erro2);
                    String DErr[] = error.split(":");
                    if (DErr[0].equals("For input string")) {
                        System.out.println("Error en la Linea " + contLineas);
                        System.out.println(DErr[1] + " No es un Numero ");
                    }

                }


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
        for (int i = 0; i < contadorProfe; i++) {
            System.out.println(profesores[i].getId() + "|" + profesores[i].getNombre());
        }

    }

    public static void mostrarAlumons() {
        System.out.println("Mostrando Todos los Datos Dentro Del Objeto ");
        for (int i = 0; i < contadorAlumnos; i++) {
            System.out.println(alumnos[i].getId() + "   Nombre : " + alumnos[i].getNombre() + " Carne :"
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
                int contLineas = 2;
                // Aqui estamos leyendo fila por fila, entonces vamos a
                //almacenar esa informacion en nuestro arreglo de Alumnos
                System.out.println(linea);
                // Separando los datos por una coma
                String[] Datos = linea.split(",");

                // Segun la estructura del archivo, sabemos que como vienen los datos:
                // Recordemos que estos datos son string, entonces si es
                //necesario convertimos los datos
                try {
                    contLineas++;
                    int idAlumon = Integer.parseInt(Datos[0]);
                    int idProfesor = Integer.parseInt(Datos[1]);


                    //Con nuestros datos, com.company.AsignarAlumno crear un objeto de tipo com.company.AsignarAlumno

                    AsignarAlumno nuevo = new AsignarAlumno(idAlumon, idProfesor);
                    //agregamos este objeto a nuestro arreglo
                    AsignacionesAlumnos[contadorAsignacionAlunos] = nuevo;
                    //EscribirPokemon(pokemons);
                    //y aumentamos a uno nuestro contador de pokemones;
                    contadorAsignacionAlunos++;
                } catch (Exception e) {
                    System.out.println(e.toString());
                    String error = e.getMessage();
                    String erro2 = e.getLocalizedMessage();
                    System.out.println(erro2);
                    String DErr[] = error.split(":");
                    if (DErr[0].equals("For input string")) {
                        System.out.println("Error en la Linea " + contLineas);
                        System.out.println(DErr[1] + " No es un Numero ");
                    }
                }


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

    public static void CargarCursos() {
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
            int contLineas = 1;
            while ((linea = br.readLine()) != null) {

                // Aqui estamos leyendo fila por fila, entonces vamos a
                //almacenar esa informacion en nuestro arreglo de Alumnos
                System.out.println(linea);
                // Separando los datos por una coma
                String[] Datos = linea.split(",");
                Datos[0] = Datos[0].replaceAll(" ", "");
                Datos[1] = Datos[1].replaceAll(" ", "");
                ;


                if (Datos[0].matches(".[/!#$%&/()=¿) ].*")) {
                    VLogCurso += "Linea " + contLineas + " Error en id Caracter incorrecto\n";
                    contLineas++;
                    continue;
                }
                if (Datos[1].matches(".[/!#$%&/()=¿)].*")) {
                    VLogCurso += "Linea " + contLineas + " Error en Carne Caracter incorrecto\n";
                    contLineas++;
                    continue;
                }
                if (Datos[2].matches(".[/!#$%&/()=¿)].*")) {
                    VLogCurso += "Linea " + contLineas + " Error en Nombre Caracter incorrecto\n";
                    contLineas++;
                    continue;
                }

                //Verificar Carne


                // Segun la estructura del archivo, sabemos que como vienen los datos:
                // Recordemos que estos datos son string, entonces si es
                //necesario convertimos los datos
                try {
                    contLineas++;
                    int id = Integer.parseInt(Datos[0]);
                    int codigo = Integer.parseInt(Datos[1]);
                    String nombre = Datos[2];
                    boolean ids = false;
                    for (int i = 0; i < contadorCursos; i++) {
                        if (id == curso[i].getId()) {
                            ids = true;
                        }
                    }
                    if (ids) {
                        VLogCurso += "Linea : " + contLineas + " Error  en id Repetido  incorrecto\n";
                        contLineas++;
                        continue;
                    }

                    boolean cod = false;
                    for (int i = 0; i < contadorCursos; i++) {
                        if (codigo == curso[i].getCodigo()) {
                            cod = true;
                        }
                    }
                    if (cod) {
                        VLogCurso += "Linea : " + contLineas + " Error  en Codigod Repetido  incorrecto\n";
                        contLineas++;
                        continue;
                    }

                    if (nombre.equals(" ")) {
                        VLogCurso += "Linea ; " + contLineas + "  Error en  caracter  incorrecto\n";
                        contLineas++;
                        continue;
                    }
                    if (nombre.equals("")) {
                        VLogCurso += "Linea ;" + contLineas + "  Error en  caracter  incorrecto\n";
                        contLineas++;
                        continue;
                    }


                    //Con nuestros datos, Alumno crear un objeto de tipo Alumno

                    Cursos nuevo = new Cursos(id, codigo, nombre);
                    //agregamos este objeto a nuestro arreglo
                    curso[contadorCursos] = nuevo;
                    //EscribirPokemon(pokemons);
                    //y aumentamos a uno nuestro contador de pokemones;
                    contadorCursos++;
                } catch (Exception e) {
                    System.out.println(e.toString());
                    String error = e.getMessage();
                    String erro2 = e.getLocalizedMessage();
                    System.out.println(erro2);
                    String DErr[] = error.split(":");
                    if (DErr[0].equals("For input string")) {
                        System.out.println("Error en la Linea " + contLineas);
                        System.out.println(DErr[1] + " No es un Numero ");
                    }
                }


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
        CrearReporLogCursos();
        mostrarCursos();
    }

    public static void mostrarCursos() {
        System.out.println("Mostrando Todos los Datos Dentro Del Objeto ");
        for (int i = 0; i < contadorCursos; i++) {
            System.out.println("ID : " + curso[i].getId() + " Nombre :" + curso[i].getNombre() + " Código :"
                    + curso[i].getCodigo());
        }
    }

    public static void CargarNotas() {
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
                int contLineas = 0;
                // Aqui estamos leyendo fila por fila, entonces vamos a
                //almacenar esa informacion en nuestro arreglo de Alumnos
                System.out.println(linea);
                // Separando los datos por una coma
                String[] Datos = linea.split(",");

                // Segun la estructura del archivo, sabemos que como vienen los datos:
                // Recordemos que estos datos son string, entonces si es
                //necesario convertimos los datos
                try {
                    contLineas++;
                    int idalumno = Integer.parseInt(Datos[0]);
                    int idcurso = Integer.parseInt(Datos[1]);
                    double nota = Double.parseDouble(Datos[2]);


                    //Con nuestros datos, Alumno crear un objeto de tipo Alumno

                    Notas nuevo = new Notas(idalumno, idcurso, nota);
                    //agregamos este objeto a nuestro arreglo
                    notas[contadorNotas] = nuevo;
                    //EscribirPokemon(pokemons);
                    //y aumentamos a uno nuestro contador de pokemones;
                    contadorNotas++;
                } catch (Exception e) {
                    System.out.println(e.toString());
                    String error = e.getMessage();
                    String erro2 = e.getLocalizedMessage();
                    System.out.println(erro2);
                    String DErr[] = error.split(":");
                    if (DErr[0].equals("For input string")) {
                        System.out.println("Error en la Linea " + contLineas);
                        System.out.println(DErr[1] + " No es un Numero ");
                    }
                }


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

    public static void mostrarNotas() {
        System.out.println("Mostrando Todos los Datos Dentro Del Objeto ");
        for (int i = 0; i < contadorNotas; i++) {
            System.out.println("ID Alumno : " + notas[i].getIdalumno() + " ID Curso :" + notas[i].getIdcurso() + " Nota :"
                    + notas[i].getNota());
        }
    }

    public static void AsiganacionProf() {
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
                int contLineas = 1;
                // Aqui estamos leyendo fila por fila, entonces vamos a
                //almacenar esa informacion en nuestro arreglo de Alumnos
                System.out.println(linea);
                // Separando los datos por una coma
                String[] Datos = linea.split(",");

                // Segun la estructura del archivo, sabemos que como vienen los datos:
                // Recordemos que estos datos son string, entonces si es
                //necesario convertimos los datos
                try {
                    contLineas++;
                    int idProf = Integer.parseInt(Datos[0]);
                    int idCurso = Integer.parseInt(Datos[1]);


                    //Con nuestros datos, Alumno crear un objeto de tipo Alumno

                    AsignarProfe nuevo = new AsignarProfe(idProf, idCurso);
                    //agregamos este objeto a nuestro arreglo
                    asignarProfes[asignarprofcont] = nuevo;
                    //EscribirPokemon(pokemons);
                    //y aumentamos a uno nuestro contador de pokemones;
                    asignarprofcont++;
                } catch (Exception e) {
                    System.out.println(e.toString());
                    String error = e.getMessage();
                    String erro2 = e.getLocalizedMessage();
                    System.out.println(erro2);
                    String DErr[] = error.split(":");
                    if (DErr[0].equals("For input string")) {
                        System.out.println("Error en la Linea " + contLineas);
                        System.out.println(DErr[1] + " No es un Numero ");
                    }

                }


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

    public static void mostrarAsiganicionProf() {
        System.out.println("Mostrando Todos los Datos Dentro Del Objeto ");
        for (int i = 0; i < asignarprofcont; i++) {
            System.out.println("ID Profesor : " + asignarProfes[i].getIdProf() + " ID Curso :" + asignarProfes[i].getIdCurso());
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
        ReporteAlumnos += "<thead><tr>"
                + "<th>  " + "REPORTE ALUMNOS" + "</th>"
                + "<th>  " + new Date().toString() + "</th>"
                + "</tr> "
                + "</ thead ></table>";
        ReportandoAlumnos();
        try {

            FileWriter archivo = new FileWriter("ReporteAlunos.html");
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
            String Datos[] = Fecha.split("/");
            int edad = Integer.parseInt(Datos[2]);
            edad = 2021 - edad;


            ReporteAlumnos += "<!----tabla 2-->\n" +
                    "<table class=\"steelBlueCols\">\n" +
                    "<thead>\n" +
                    "   <tr> <th>Carne </th> " +
                    "<th>Nombre</th> " +
                    "<th>Edad </th>" +
                    "<th>Genero </th> </tr>" +
                    "</thead>\n" +
                    "<tbody>\n" +
                    "   <tr> <td>" + alumnos[i].getCarne() + "</td>" +
                    " <td>" + alumnos[i].getNombre() + " </td> " +
                    "<td>" + edad + "</td> " +
                    "<td>" + Genero + "</td></tr>" +

                    "</tbody>\n" +
                    "</table>\n" +
                    " <!----termina tabla 2-->";


        }


    }

    //Reportando Asignacion de Alumnos
    static String VReporteAsignacionAlumnos = "";
    static String VReporteAsignacionProfesores = "";

    public static void CrearReporteAsignacionAlumnos() {
        variableReporte();

        VReporteAsignacionAlumnos += "<table class=\"steelBlueCols\">";
        VReporteAsignacionAlumnos += "<thead><tr>"
                + "<th>  " + "REPORTE ASIDGNACION DE ALUMNoS" + "</th>"
                + "<th>  " + new Date().toString() + "</th>"
                + "</tr> "
                + "</ thead ></table>";
        try {

            FileWriter archivo = new FileWriter("ReporteAsignacionAlumnos.html");
            archivo.write(ReporteInicio + VReporteAsignacionAlumnos + ReporteFinal);
            archivo.close();

        } catch (Exception e) {

        }
    }

    public static void ReportandoAsinacionAlumnos() {

        for (int i = 0; i < contadorAsignacionAlunos; i++) {

            VReporteAsignacionAlumnos += "<!----tabla 2-->\n" +
                    "<table class=\"steelBlueCols\">\n" +
                    "<thead>\n" +
                    "   <tr> <th>Carne Alumno</th> " +
                    "<th>Nombre Alumno </th> " +
                    "<th>Codigo de Curso </th>" +
                    "<th>Nombre de Curso </th> </tr>" +
                    "</thead>\n" +
                    "<tbody>\n" +
                    "   <tr> <td>" + BuscarCarneAlumno(AsignacionesAlumnos[i].getIdAlumno()) + "</td>" +
                    " <td>" + BuscarNombreAlumnos(AsignacionesAlumnos[i].getIdAlumno()) + " </td> " +
                    " <td>" + BuscarCodigodeCurso(AsignacionesAlumnos[i].getIdCurso()) + " </td> " +
                    " <td>" + BuscarNombreCurso(AsignacionesAlumnos[i].getIdCurso()) + " </td> " +


                    "</tbody>\n" +
                    "</table>\n" +
                    " <!----termina tabla 2-->";


        }


    }

    public static void CrearReporteAsignacionProfesores() {
        variableReporte();

        VReporteAsignacionProfesores += "<table class=\"steelBlueCols\">";
        VReporteAsignacionProfesores += "<thead><tr>"
                + "<th>  " + "REPORTE ASIGNACION DE PROFESORES" + "</th>"
                + "<th>  " + new Date().toString() + "</th>"
                + "</tr> "
                + "</ thead ></table>";
        ReportandoAsinacionProfesores();
        try {

            FileWriter archivo = new FileWriter("ReporteAsignacionProfesores.html");
            archivo.write(ReporteInicio + VReporteAsignacionProfesores + ReporteFinal);
            archivo.close();

        } catch (Exception e) {

        }
    }

    public static void ReportandoAsinacionProfesores() {

        for (int i = 0; i < asignarprofcont; i++) {

            VReporteAsignacionProfesores += "<!----tabla 2-->\n" +
                    "<table class=\"steelBlueCols\">\n" +
                    "<thead>\n" +
                    "   <tr> <th>Registro Personal</th> " +
                    "<th>Nombre Profesor </th> " +
                    "<th>Codigo de Curso </th>" +
                    "<th>Nombre de Curso </th> </tr>" +
                    "</thead>\n" +
                    "<tbody>\n" +
                    "   <tr> <td>" + BuscarRegistroPersonal(asignarProfes[i].getIdProf()) + "</td>" +
                    " <td>" + BuscarNombreProfesor(asignarProfes[i].getIdProf()) + " </td> " +
                    " <td>" + BuscarCodigodeCurso(asignarProfes[i].getIdCurso()) + " </td> " +
                    " <td>" + BuscarNombreCurso(asignarProfes[i].getIdCurso()) + " </td> " +


                    "</tbody>\n" +
                    "</table>\n" +
                    " <!----termina tabla 2-->";
        }

    }

    //-------------------------------------------------------------------------
    public static String BuscarNombreAlumnos(int id) {
        for (int i = 0; i < contadorAlumnos; i++) {
            if (alumnos[i].getId() == id) {
                return alumnos[i].getNombre();

            }

        }
        return "";
    }

    public static int BuscarCarneAlumno(int id) {
        for (int i = 0; i < contadorAlumnos; i++) {
            if (alumnos[i].getId() == id) {
                return alumnos[i].getCarne();

            }

        }


        return 0;
    }

    public static String BuscarNombreCurso(int id) {
        for (int i = 0; i < contadorCursos; i++) {
            if (id == curso[i].getId()) {
                System.out.println(curso[i].getNombre());
                return curso[i].getNombre();
            }
        }


        return "";

    }

    public static int BuscarCodigodeCurso(int id) {
        for (int i = 0; i < contadorCursos; i++) {
            if (id == curso[i].getId()) {
                System.out.println(curso[i].getCodigo());
                return curso[i].getCodigo();
            }
        }
        return 0;
    }


    public static String BuscarNombreProfesor(int id) {
        for (int i = 0; i < contadorProfe; i++) {
            if (id == profesores[i].getId()) {
                return profesores[i].getNombre();
            }

        }

        return "";
    }

    public static int BuscarRegistroPersonal(int id) {
        for (int i = 0; i < contadorProfe; i++) {
            if (id == profesores[i].getId()) {
                System.out.println(profesores[i].getRegistroPersonal());
                return profesores[i].getRegistroPersonal();
            }

        }

        return 0;
    }

    //----------------
    //Reporte General de Curso
    static String VReporteGEneralCursos = "";

    public static void CrearReporteGeneralCursoss() {
        variableReporte();

        VReporteGEneralCursos += "<table class=\"steelBlueCols\">";
        VReporteGEneralCursos += "<thead><tr>"
                + "<th>  " + "REPORTE General de Cursos" + "</th>"
                + "<th>  " + new Date().toString() + "</th>"
                + "</tr> "
                + "</ thead ></table>";
        ReportaandoReporteGeneralCuros();
        try {

            FileWriter archivo = new FileWriter("ReporteGeneralCursos.html");
            archivo.write(ReporteInicio + VReporteGEneralCursos + ReporteFinal);
            archivo.close();

        } catch (Exception e) {

        }
    }


    public static void ReportaandoReporteGeneralCuros() {
        for (int i = 0; i < contadorCursos; i++) {

            VReporteGEneralCursos += "<table class=\"steelBlueCols\">";
            VReporteGEneralCursos += "<!----tabla 2-->\n" +
                    "<table class=\"steelBlueCols\">\n" +
                    "<thead>\n" +
                    "   <tr> <th>Codigo </th> " +
                    "<th>Nombre </th> " +
                    "<th>Cantidad de Alumnos </th>" +

                    "</thead>\n" +
                    "<tbody>\n" +
                    "   <tr> <td>" + curso[i].getNombre() + "</td>" +
                    " <td>" + curso[i].getCodigo() + " </td> " +
                    " <td>" + contadorAlumnosEnCursos(curso[i].getId()) + " </td> " +


                    "</tbody>\n" +
                    "</table>\n" +
                    " <!----termina tabla 2-->";


        }


    }

    public static int contadorAlumnosEnCursos(int idCurso) {
        int NoAlunmons = 0;
        ;
        for (int i = 0; i < contadorAsignacionAlunos; i++) {
            if (idCurso == AsignacionesAlumnos[i].getIdCurso()) {
                NoAlunmons++;
            }
        }


        return NoAlunmons;
    }

    //Reporet Cursos espesificos
    public static void EncabezadoReporteCursoEspecifico() {
        //Emcabezado ------
        System.out.println("ingrese Codigo Curso");
        int CodigoCurso = sc.nextInt();


        int idCurso = BuscarIdCurso(CodigoCurso);
        String NombreCurso = BuscarNombreCurso(idCurso);
        System.out.println(idCurso);
        System.out.println(NombreCurso);
        ;


        VReporteCursoEspesfifico += "<table class=\"steelBlueCols\">";
        VReporteCursoEspesfifico += "<thead><tr>"
                + "<th>  " + "Curso" + "</th>"
                + "<th>  " + CodigoCurso + "</th>"
                + "<th>  " + NombreCurso + "</th>"


                + "</tr> "
                + "</ thead ></table>";
        int idPrfe = BuscarIdProfe(idCurso);
        String NombreProfe = BuscarNombreProfesor(idPrfe);
        int RPersonalProf = BuscarRegistroPersonal(idPrfe);
        VReporteCursoEspesfifico += "<table class=\"steelBlueCols\">";
        VReporteCursoEspesfifico += "<thead><tr>"
                + "<th>  " + "Profesor" + "</th>"
                + "<th>  " + RPersonalProf + "</th>"
                + "<th>  " + NombreProfe + "</th>"

                + "</tr> "
                + "</ thead ></table>";
        System.out.println(idCurso + "<-------");
        AlumnosEnCurso(idCurso);
        System.out.println("sale Encabezado ");


    }

    public static int BuscarIdCurso(int CodigoCurso) {

        for (int i = 0; i < contadorCursos; i++) {
            if (CodigoCurso == curso[i].getCodigo()) {
                return curso[i].getId();
            }
        }
        return 0;
    }


    public static int BuscarIdProfe(int idCurso) {
        for (int i = 0; i < asignarprofcont; i++) {
            if (idCurso == asignarProfes[i].getIdCurso()) {
                return asignarProfes[i].getIdProf();
            }
        }
        return 0;

    }

    public static void AlumnosEnCurso(int idCurso) {
        System.out.println("alumnos en Cuerso");

        for (int i = 0; i < contadorNotas; i++) {

            if (idCurso == notas[i].getIdcurso()) {
                System.out.println(i);
                System.out.println(notas[i].getIdalumno());
                CueropoReporteCursoEspesifico(notas[i].getIdalumno());

            }
        }
    }


    //Repeporte de Cuerpo de Reporte Espesifico----------------------
    public static void CueropoReporteCursoEspesifico(int idAlumno) {
        System.out.println("Entra Al Cuerpo");
        for (int i = 0; i < contadorAlumnos; i++) {
            if (idAlumno == alumnos[i].getId()) {
                int Carne = alumnos[i].getCarne();
                String Nombre = alumnos[i].getNombre();
                System.out.println(Nombre);


                VReporteCursoEspesfifico += "<!----tabla 2-->\n" +
                        "<table class=\"steelBlueCols\">\n" +
                        "<thead>\n" +
                        "   <tr> <th>Carne Personal</th> " +
                        "<th>Nombre  </th> " +
                        "<th> Nota </th>" +
                        "<th>Estatus  </th> </tr>" +
                        "</thead>\n" +
                        "<tbody>\n" +
                        "   <tr> <td>" + Carne + "</td>" +
                        " <td>" + Nombre + " </td> " +
                        " <td>" + BuscarNota(idAlumno) + " </td> " +
                        " <td>" + Estatus(BuscarNota(idAlumno)) + " </td> " +

                        "</tbody>\n" +
                        "</table>\n" +
                        " <!----termina tabla 2-->";


            }
        }

    }

    public static double BuscarNota(int idAlumno) {
        for (int i = 0; i < contadorNotas; i++) {
            if (idAlumno == notas[i].getIdalumno()) {
                return notas[i].getNota();
            }
        }
        return 0;
    }

    public static String VReporteCursoEspesfifico = "";
    ///Crea el Reporte de Curso Especifico <----------------------------------------Reporte  Cruso Esfico

    public static void ReporteCursoEspecifico() {
        VReporteCursoEspesfifico += "<table class=\"steelBlueCols\">";
        VReporteCursoEspesfifico += "<thead><tr>"
                + "<th>  " + "REPORTE CURSO ESPESIFICO" + "</th>"
                + "<th>  " + new Date().toString() + "</th>"
                + "</tr> "
                + "</ thead ></table>";
        EncabezadoReporteCursoEspecifico();
        try {

            FileWriter archivo = new FileWriter("ReporteCursoEspecifico000.html");
            archivo.write(ReporteInicio + VReporteCursoEspesfifico + ReporteFinal);
            archivo.close();

        } catch (Exception e) {

        }

    }

    public static String Estatus(double nota) {
        if (nota > 61.0) {
            return "Aprobado";
        }
        if (nota < 60.9) {
            return "Reprobado";
        } else {
            return "###";
        }
    }

    //-------------------------------------------------
    //Creado LogAlumnos  <------------------------------------------------------Log
    static String VariableParaGuardarLog = "";


    public static void CrearReporLogAlumnos() {
        System.out.println("SE DETERCTARON ERRORES LOS PUEDE VER EN logALUMNOS.csv\n ");
        VariableParaGuardarLog += " REPORET DE LOG Alumnos\n";
        String date = new Date().toString();
        VariableParaGuardarLog += "Fecha / Hora " + date + "\n";
        try {

            FileWriter archivo = new FileWriter("logALUMNOS.csv");
            archivo.write(ReporteInicio + VariableParaGuardarLog + ReporteFinal);
            archivo.close();

        } catch (Exception e) {

        }
    }

    //Creado Profesores  <------------------------------------------------------Log
    static String VariableParaGuardarLogProfes = "";

    public static void CrearReporLogProfesores() {
        System.out.println("SE DETERCTARON ERRORES LOS PUEDE VER EN logProfesoresS.csv\n ");
        VariableParaGuardarLogProfes += " REPORET DE LOG Alumnos\n";
        String date = new Date().toString();
        VariableParaGuardarLogProfes += "Fecha / Hora " + date + "\n";
        try {

            FileWriter archivo = new FileWriter("logPROFESORES.csv");
            archivo.write(ReporteInicio + VariableParaGuardarLogProfes + ReporteFinal);
            archivo.close();

        } catch (Exception e) {

        }
    }

    //Crear log Cusos
    static String VLogCurso = "";

    public static void CrearReporLogCursos() {
        System.out.println("SE DETERCTARON ERRORES LOS PUEDE VER EN logCUROSS.csv\n ");
        VLogCurso += " REPORET DE LOG Alumnos\n";
        String date = new Date().toString();
        VLogCurso += "Fecha / Hora " + date + "\n";
        try {

            FileWriter archivo = new FileWriter("logCURSOS.csv");
            archivo.write(ReporteInicio + VLogCurso + ReporteFinal);
            archivo.close();

        } catch (Exception e) {

        }
    }
    //Crear Top Alumnos<-------------------------------------------------TopAlumnos
    static String VReporteTopNotas="";
    public static void Ordenar(int CodCurso) {

        double n[] = new double[notas.length];

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] != null) {
                n[i] = notas[i].getNota();
            } else {
                break;
            }

        }
        for (int j = 0; j < n.length; j++) {

            for (int i = 0; i < n.length - 1; i++) {
                if (n[i] > n[i + 1]) {
                    double aux = n[i];
                    n[i] = n[i + 1];
                    n[i + 1] = aux;
                }
            }

        }
        int cont=0;
        for(int contador=n.length-1; contador>=0; contador--){

            System.out.println(n[contador]);

            int IdCurso=BuscarCursoNotas(n[contador]);
            int CodigoCuurso=BuscarCodigodeCurso(IdCurso);
            System.out.println(CodCurso+"||"+CodigoCuurso);
            if (CodCurso==CodigoCuurso){
                int idAlumno  =BuscaridAlumnoNotas(n[contador]);
                System.out.println(BuscarNombreAlumnos(idAlumno));
                //----Reportando

                VReporteTopNotas += "<!----tabla 2-->\n" +
                        "<table class=\"steelBlueCols\">\n" +
                        "<thead>\n" +
                        "   <tr> <th>Carnet del Alumno</th> " +
                        "<th>Nombre del Alumno  </th> " +
                        "<th> Nota del Alumno </th>" +
                        "</thead>\n" +
                        "<tbody>\n" +
                        "   <tr> <td>" +BuscarCarneAlumno(idAlumno)+"</td>" +
                        " <td>" + BuscarNombreAlumnos(idAlumno) +" </td> " +
                        " <td>" +n[contador] +" </td> " +
                        "</tbody>\n" +
                        "</table>\n" +
                        " <!----termina tabla 2-->";











                //---------

            }
            if (cont==10){
                break;
            }else{
                cont++;
            }

        }

    }
    public static int  BuscarCursoNotas(double nota){
        for (int i=0;i<contadorNotas;i++){
            if (nota==notas[i].getNota()){
                return notas[i].getIdcurso();
            }
        }
        return 0;
    }

    public static int  BuscaridAlumnoNotas(double nota){
        for (int i=0;i<contadorNotas;i++){
            if (nota==notas[i].getNota()){
                return notas[i].getIdalumno();
            }
        }
        return 0;
    }

    public static void EncabezadoReporteTopNotas(){
        System.out.println("Por favor ingrese el códdigo del curso");
        int codigo = sc.nextInt();
     int cursoId = BuscarIdCurso(codigo);
          String cursoNombre = BuscarNombreCurso(cursoId);
        System.out.println(cursoId);
        System.out.println(cursoNombre);

        VReporteTopNotas += "<table class=\"steelBlueCols\">";
        VReporteTopNotas += "<thead><tr>"
                + "<th>  " + "Curso" + "</th>"
                + "<th>  " + codigo + "</th>"
                + "<th>  " + cursoNombre + "</th>"


                + "</tr> "
                + "</ thead ></table>";
        int idPrfe = BuscarIdProfe(cursoId);
        String ProfeNombre = BuscarNombreProfesor(idPrfe);
        int ProfeRegistro = BuscarRegistroPersonal(idPrfe);
        VReporteTopNotas += "<table class=\"steelBlueCols\">";
        VReporteTopNotas += "<thead><tr>"
                + "<th>  " + "Profesor" + "</th>"
                + "<th>  " + ProfeNombre + "</th>"
                + "<th>  " + ProfeRegistro + "</th>"
                + "</tr> "
                + "</ thead ></table>";

        System.out.println(codigo);
        Ordenar(codigo);
        System.out.println("sale Encabezado ");
    }
    public static void CrearReporteTop (){
        variableReporte();

        VReporteTopNotas += "<table class=\"steelBlueCols\">";
        VReporteTopNotas += "<thead><tr>"
                + "<th>  " + "REPORTE TOP NOTAS" + "</th>"
                + "<th>  " + new Date().toString() + "</th>"
                + "</tr> "
                + "</ thead ></table>";
        EncabezadoReporteTopNotas();
        try {
            FileWriter archivo = new FileWriter("ReporteTop.html");
            archivo.write(ReporteInicio + VReporteTopNotas + ReporteFinal);
            archivo.close();
        } catch (Exception e) {

        }
    }


    //


}
