
package com.mycompany.multijuegos.main.baloncesto;

import java.util.Scanner;

public class Baloncesto {
    
    public void empezarPartida() {
        Scanner scanner = new Scanner(System.in);
        Jugador jugador_1 = new Jugador(), jugador_2 = new Jugador();
        int turnos = 1, numeroDeTiro = 0, numeroDeDefensa = 0;
        
        System.out.println("Escriba el Nombre del Primer Jugador");
        jugador_1.guardarNombre(scanner.nextLine());
        System.out.println("Escriba el Nombre del Segundo Jugador");
        jugador_2.guardarNombre(scanner.nextLine());
        System.out.println("Escriba el Número de Turnos");
        
        while (true) {
            try {
                turnos = Integer.parseInt(scanner.nextLine());
                
                if (turnos > 0) {
                    break;
                } else {
                    System.out.println("Debe Ingresar el Número de Turnos");
                }
            }catch (NumberFormatException ex) {
                System.out.println("Debe Ingresar el Número de Turnos");
            }
        }
        System.out.println();

        int indice = 1, ronda = 1;
        
        while (indice != turnos + 1) {
            String nombreJugador_1, nombreJugador_2;
            
            if (ronda == 1) {
                nombreJugador_1 = jugador_1.obtenerNombre(); nombreJugador_2 = jugador_2.obtenerNombre();
            } else {
                nombreJugador_2 = jugador_1.obtenerNombre(); nombreJugador_1 = jugador_2.obtenerNombre();
            }
            System.out.println("TURNO: " + indice);
            while (true) {
                System.out.println("(" + nombreJugador_1 + ") seleccina el tipo de Lanzamiento que desea Realizar:");
                System.out.println("    1. Tiro Largo");
                System.out.println("    2. Tiro Corto");
                try {
                    numeroDeTiro = Integer.parseInt(scanner.nextLine());
                    
                    if (numeroDeTiro == 1 || numeroDeTiro == 2) {
                        break;
                    } else {
                        System.out.println();
                        System.out.println("-------------------------------");
                        System.out.println("Debe Ingresar el Número de Tiro");
                        System.out.println("-------------------------------");
                        System.out.println();
                    }
                }catch (NumberFormatException ex) {
                    System.out.println();
                    System.out.println("-------------------------------");
                    System.out.println("Debe Ingresar el Número de Tiro");
                    System.out.println("-------------------------------");
                    System.out.println();
                }
            }
            
            while (true) {
                System.out.println("(" + nombreJugador_2 + ") seleccina el tipo de Defensa que desea Realizar:");
                System.out.println("    1. Defensa Cuerpo a Cuerpo");
                System.out.println("    2. Defensa Fuerte");
                try {
                    numeroDeDefensa = Integer.parseInt(scanner.nextLine());
                    
                    if (numeroDeDefensa == 1 || numeroDeDefensa == 2) {
                        break;
                    } else {
                        System.out.println();
                        System.out.println("-----------------------------------");
                        System.out.println("Debe Ingresar el Número de Deefensa");
                        System.out.println("-----------------------------------");
                        System.out.println();
                    }
                }catch (NumberFormatException ex) {
                    System.out.println();
                    System.out.println("----------------------------------");
                    System.out.println("Debe Ingresar el Número de Defensa");
                    System.out.println("----------------------------------");
                    System.out.println();
                }
            }
            System.out.println();
            
            MotorDelJuego juego = new MotorDelJuego(numeroDeTiro, numeroDeDefensa);
            int resultado = juego.jugarRonda(nombreJugador_1, nombreJugador_2);
            
            if (ronda == 1) {
                jugador_1.aumentarPunteo(resultado);
                ronda = 2;
            } else {
                jugador_2.aumentarPunteo(resultado);
                ronda = 1;
                indice++;
            }
        }
        System.out.println(jugador_1.obtenerNombre() + " obtuvo: " + jugador_1.obtenerPunteo() + " puntos");
        System.out.println(jugador_2.obtenerNombre() + " obtuvo: " + jugador_2.obtenerPunteo() + " puntos");
        System.out.println();
        
        if (jugador_1.obtenerPunteo() > jugador_2.obtenerPunteo()) {
            System.out.println("------------------");
            System.out.println(jugador_1.obtenerNombre() + " Ganó");
            System.out.println("------------------");
        } else if (jugador_2.obtenerPunteo() > jugador_1.obtenerPunteo()) {
            System.out.println("------------------");
            System.out.println(jugador_2.obtenerNombre() + " Ganó");
            System.out.println("------------------");
        } else {
            System.out.println("------");
            System.out.println("Empate");
            System.out.println("------");
        }
    }
}
