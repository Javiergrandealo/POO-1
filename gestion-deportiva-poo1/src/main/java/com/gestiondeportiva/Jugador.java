package com.gestiondeportiva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Jugador {
    private String nombre;
    private double puntuacion = 0.0;
    static ArrayList<Jugador> jugadores = new ArrayList<>();

    public Jugador(String nombre, double puntuacion) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public static boolean buscarJugador(String nombre) {
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador a = jugadores.get(i);
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                return true; // Jugador encontrado
            }
        }
        return false; // Jugador no encontrado
    }

    public static boolean darAlta(Jugador jugador) {
        boolean alta = false;
        String nombre = jugador.getNombre();
        if (!buscarJugador(nombre)) {
            jugadores.add(jugador);
            alta = true; // Jugador añadido con éxito
        }
        return alta; // Jugador ya existe
    }

    public static boolean darBaja(String nombre) {
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador a = jugadores.get(i);
            if (a.getNombre().equalsIgnoreCase(nombre)) {
                jugadores.remove(i);
                return true; // Jugador eliminado con éxito
            }
        }
        return false; // Jugador no encontrado
    }

    public static void darPuntuacion(String nombre, double puntuacion) {
        if (puntuacion < -999999.0) {
            System.out.println("Un jugador no puede tener una puntuación tan baja");
            return;
        }
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador ju = jugadores.get(i);
            if (ju.getNombre().equalsIgnoreCase(nombre)) {
                // Si encontramos al jugador, asignamos la nueva puntuación
                ju.setPuntuacion(puntuacion);
                System.out.println("Se le ha dado una puntuación de " + puntuacion + " al jugador " + ju.getNombre());
                return;
            }
        }
        // Si llegamos aquí, significa que no encontramos al jugador
        System.out.println("No existe ese jugador");
    }

    public static void mostrarJugadores() {
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            System.out.println(jugador.getNombre());
        }

    }

    public static void mostrarJugadoresPorPuntuacion() {
        // Ordenar los jugadores por puntuación
        Collections.sort(jugadores, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador j1, Jugador j2) {
                return Double.compare(j1.getPuntuacion(), j2.getPuntuacion());
            }
        });
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            System.out.println("Nombre: " + jugador.getNombre() + " Puntuación: " + jugador.getPuntuacion());
        }
    }
}
