package com.gestiondeportiva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Emparejamiento {
    private static List<String[]> emparejamientos;

    public Emparejamiento() {
        Emparejamiento.emparejamientos = new ArrayList<>();
    }

    public static void mostrarEmparejamientos() {
        if (emparejamientos.isEmpty()) {
            System.out.println("No hay emparejamientos.");
            return;
        }

        for (int i = 0; i < emparejamientos.size(); i++) {
            String[] emparejamiento = emparejamientos.get(i);
            System.out.println(emparejamiento[0] + " - " + emparejamiento[1]);
        }
    }

    public static void crearEmparejamiento(String jugador1, String jugador2) {
        if (Jugador.buscarJugador(jugador1) && Jugador.buscarJugador(jugador2)) {
            String[] emparejamiento = { jugador1, jugador2 };
            emparejamientos.add(emparejamiento);
        } else {
            System.out.println("No se puede emparejar.");
        }
    }

    public static void borrarEmparejamientos() {
        emparejamientos.clear();
    }

    public static void emparejarAleatoriamente() {
        List<Jugador> jugadores = Jugador.jugadores;
        if (jugadores.size() % 2 != 0) {
            System.out.println("No se pueden emparejar todos los jugadores, el número de jugadores es impar.");
            return;
        }

        Collections.shuffle(jugadores);
        emparejamientos.clear();
        for (int i = 0; i < jugadores.size(); i += 2) {
            emparejamientos.add(new String[] { jugadores.get(i).getNombre(), jugadores.get(i + 1).getNombre() });
        }
    }
}
