package com.gestiondeportiva;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean fin = false;
        Scanner sc = new Scanner(System.in);
        Jugador j1 = new Jugador("Luisa", 4.5);
        Jugador.darAlta(j1);
        Jugador j2 = new Jugador("Manuel", 2.7);
        Jugador.darAlta(j2);
        Jugador j3 = new Jugador("Kurt", 4.0);
        Jugador.darAlta(j3);
        Jugador j4 = new Jugador("Sofia", 3.8);
        Jugador.darAlta(j4);
        Jugador j5 = new Jugador("Robert", 3.8);
        Jugador.darAlta(j5);
        @SuppressWarnings("unused") // esto es para que quede bonito en el IDE, en verdad si que se usa.
        Emparejamiento e1 = new Emparejamiento();
        System.out.println("Bienvenido al sistema de gestion de jugadores. Que desea hacer");
        while (fin == false) {
            System.out.println("create <nombre> -> Dar de alta un jugador");
            System.out.println("remove <nombre> -> Dar de baja un jugador");
            System.out.println("show -> Mostrar todos los jugadores");
            System.out.println("score <nombre;puntuacion> -> Dar puntuacion a un jugador");
            System.out.println("rank -> Mostrar jugadores ordenados por puntuacion");
            System.out.println("show_matchmake -> Mostrar emparejamientos");
            System.out.println("clear_matchmake -> Borrar emparejamientos");
            System.out.println("matchmake <nombre1;nombre2> -> Crear emparejamiento");
            System.out.println("random_matchmake -> Emparejar aleatoriamente");
            System.out.println("exit -> Salir del programa");
            System.out.println("-----------------------------------------------");
            System.out.println();
            System.out.println(">");
            String opcion = sc.next();
            switch (opcion) {
                case "create":
                    String nombre = sc.next();
                    Jugador j = new Jugador(nombre, 0.0);
                    boolean dado = Jugador.darAlta(j);
                    if (dado) {
                        System.out.println("Se ha dado de alta al jugador " + nombre);
                    } else {
                        System.out.println("El jugador ya existe");
                    }
                    break;
                case "remove":
                    String n = sc.next();
                    boolean a = Jugador.darBaja(n);
                    if (a) {
                        System.out.println("Se ha dado de baja al jugador " + n);
                        System.out.println();
                    } else {
                        System.out.println("El jugador no existe");
                        System.out.println();
                    }
                    break;
                case "show":
                    Jugador.mostrarJugadores();
                    break;
                case "score":
                    String nombres1 = sc.next();
                    String n2 = nombres1.split(";")[0];
                    double puntuacion = Double.parseDouble(nombres1.split(";")[1]);
                    Jugador.darPuntuacion(n2, puntuacion);
                    break;
                case "rank":
                    Jugador.mostrarJugadoresPorPuntuacion();
                    break;
                case "show_matchmake":
                    Emparejamiento.mostrarEmparejamientos();
                    break;
                case "clear_matchmake":
                    Emparejamiento.borrarEmparejamientos();
                    break;
                case "matchmake":
                    String nombres2 = sc.next();
                    String jugador1 = nombres2.split(";")[0];
                    String jugador2 = nombres2.split(";")[1];
                    Emparejamiento.crearEmparejamiento(jugador1, jugador2);
                    break;
                case "random_matchmake":
                    Emparejamiento.emparejarAleatoriamente();
                    break;
                case "exit":
                    System.out.println("Fin de la ejecución.");
                    fin = true;
                    break;
                default:
                    System.out.println("No ha elegido una opcion valida.");
                    break;
            }
        }
        sc.close();
    }
}
