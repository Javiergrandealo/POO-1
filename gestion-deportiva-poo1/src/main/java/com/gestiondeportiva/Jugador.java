package com.gestiondeportiva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Jugador {
    private String nombre;
    private double puntuacion = 0.0;
    ArrayList<Jugador> jugadores = new ArrayList<>();

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

    public boolean buscarJugador(String nombre) {
        boolean p = false;
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador a = jugadores.get(i);
            if (a.getNombre().equalsIgnoreCase(nombre)) { // hay un juagdor con el mismo nombre
                return p;
            } else {
                p = true;
                return p;
            }
        }
        return p;
    }

    public boolean darAlta(Jugador jugador) {
        boolean add = false;
        String nombre = jugador.getNombre();
        if (buscarJugador(nombre) == false) {
            System.out.println("No se puede añadir este jugador, ya hay uno con el mismo nombre");
            return add;
        } else {
            jugadores.add(jugador);
            add = true;
            System.out.println("Se ha dado de alta el jugador " + nombre);
            return add;
        }
    }

    public boolean darBaja(String nombre) {
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                jugadores.remove(i);  //Eliminar el jugador encontrado
                return true;
            }
        }
        return false;  //No se encontró al jugador
    }

    public void darPuntuacion(String nombre, double puntuacion) {
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

    public void mostrarJugadores(){
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            System.out.println(jugador.getNombre()); 
        }
        
    }

    public void mostrarJugadoresPorPuntuacion() {
        // Ordenar los jugadores por puntuación
        Collections.sort(jugadores, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador j1, Jugador j2) {
                return Double.compare(j1.getPuntuacion(), j2.getPuntuacion());
            }
        });
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            System.out.println("Nombre: "+jugador.getNombre() + " Puntuación: " + jugador.getPuntuacion());
        }
    }
}
