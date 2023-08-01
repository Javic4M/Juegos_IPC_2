
package com.mycompany.multijuegos.main.baloncesto;

public class MotorDelJuego {
    
    private int numeroDeTiro = 0, numeroDeDefensa = 0;
    
    public MotorDelJuego(int numeroDeTiro, int numeroDeDefensa) { 
        this.numeroDeTiro = numeroDeTiro;
        this.numeroDeDefensa = numeroDeDefensa;
    }
    
    public int jugarRonda(String nombreJugador_1, String nombreJugador_2) {
        double probabilidadDeTiro = 0.0, probabilidadDeFalta = 0.0;
        int puntos = 0;
        
        if (numeroDeTiro == 1) {
            probabilidadDeTiro = 0.65;
            puntos = 3;
        } else {
            probabilidadDeTiro = 0.80;
            puntos = 2;
        }
        
        if (numeroDeDefensa == 1) {
            probabilidadDeFalta = 0.35;
            probabilidadDeTiro = probabilidadDeTiro - 0.15;
        } else {
            probabilidadDeFalta = 0.65;
            probabilidadDeTiro = probabilidadDeTiro - 0.30;
        }
        
        double randomFalta = Math.random();
        
        if (randomFalta <= probabilidadDeFalta) {
            System.out.println("--------------------------------");
            System.out.println("Falta, tiro libre para " + nombreJugador_1);
            double randomTiroLibre = Math.random();
            
            if (randomTiroLibre <= 0.90) {
                System.out.println("Anotación obtienes: 2 puntos");
                if (puntos == 3) {
                    puntos--;
                }
            } else {
                System.out.println("¡¡¡Tiro Fallado!!!");
                puntos = 0;
            }
            System.out.println("--------------------------------");
            System.out.println();
        } else {
            double randomTiro = Math.random();
            
            System.out.println("----------------------------");
            if (randomTiro <= probabilidadDeTiro) {
                System.out.println("Anotación obtienes: " + puntos + " puntos");
            } else {
                System.out.println("¡¡¡Tiro Fallado!!!");
                puntos = 0;
            }
            System.out.println("----------------------------");
            System.out.println();
        }
        return puntos;
    }
}
