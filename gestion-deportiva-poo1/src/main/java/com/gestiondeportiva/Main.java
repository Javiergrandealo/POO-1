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
        System.out.println("Bienvenido al sistema de gestion de jugadores. Que desea hacer");
        while (fin == false) {
            System.out.println("1. Dar de alta un jugador");
            System.out.println("2. Dar baja jugador");
            System.out.println("3. Mostrar jugadores");
            System.out.println("4. Establecer una puntuacion a un jugador");
            System.out.println("5. Rankear jugadores");
            System.out.println("6. Mostrar emparejamientos");
            System.out.println("7. Borrar emparejamiento");
            System.out.println("8. Crear emparejamiento");
            System.out.println("9. Emparejamiento aleatorio");
            System.out.println("Cualquier otra tecla hace que la ejecución del programa se detenga");
            System.out.println("Elija una opcion: ");
            System.out.println("-----------------------------------------------");
            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("¿Cual es el nombre del jugador que desea dar de alta?");
                    String nombre = sc.nextLine();
                    Jugador j = new Jugador(nombre, 0.0);
                    Jugador.darAlta(j);
                    break;
                case 2:
                    System.out.println("¿Cual es el jugador que deasea dar de baja?");
                    String n = sc.nextLine();
                    Jugador.darBaja(n);
                    System.out.println("Se ha dado de baja al jugador " + n);
                    break;
                case 3:
                    Jugador.mostrarJugadores();
                    break;

                case 4:
                    System.out.println("¿A que jugador quieres darle puntuacion?");
                    String n2 = sc.nextLine();
                    System.out.println("¿Que puntuación quieres darle?");
                    double puntuacion = sc.nextDouble();
                    Jugador.darPuntuacion(n2, puntuacion);
                    break;

                case 5:
                    Jugador.mostrarJugadoresPorPuntuacion();
                    break;

                case 6:
                Emparejamiento.mostrarEmparejamientos();
                    break;

                case 7:
                    Emparejamiento.borrarEmparejamientos();
                    break;

                case 8:
                    System.out.println("¿Cual es el nombre del primer jugador?");
                    String jugador1 = sc.nextLine();
                    System.out.println("¿Cual es el nombre del segundo jugador?");
                    String jugador2 = sc.nextLine();
                    Emparejamiento.crearEmparejamiento(jugador1, jugador2);
                    break;
                case 9:
                    Emparejamiento.emparejarAleatoriamente();
                    break;
                default:
                    System.out.println("No ha elegido una opcion valida. Fin de la ejecución");
                    fin = true;
                    break;
            }
        }
        sc.close();
    }
}