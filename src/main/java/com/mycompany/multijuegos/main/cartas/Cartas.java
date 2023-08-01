
package com.mycompany.multijuegos.main.cartas;

import java.util.Random;
import java.util.Scanner;

public class Cartas {
    
    public void empezarPartida() {
        Scanner scanner = new Scanner(System.in);
        int dinero = 0;
        
        while (true) {
            System.out.println("Escriba la Cantidad de Dinero con la que desea Jugar:");
            try {
                dinero = Integer.parseInt(scanner.nextLine());
                
                if (dinero <= 0) {
                    System.out.println();
                    System.out.println("------------------------------------------------");
                    System.out.println("El Dinero Ingresado tiene que ser Mayor que Cero");
                    System.out.println("------------------------------------------------");
                    System.out.println();
                } else {
                    break;
                }
            }catch (NumberFormatException ex) {
                System.out.println();
                System.out.println("------------------------------------");
                System.out.println("Debe Ingresar una Cantidad de Dinero");
                System.out.println("------------------------------------");
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("(Tome en cuenta que el Mazo contiene 52 cartas)");
        while (dinero > 0) {
            Random random = new Random();
            int numeroMayor = 0, numeroMenor = 0;
            
            while (true) {
                numeroMayor = obtenerLimite();
                       
                if (numeroMayor >= 2) {
                    break;
                }
            }
            
            while (true) {
                numeroMenor = obtenerLimite();
                       
                if (numeroMenor < numeroMayor) {
                    break;
                }
            }
            System.out.println();
            System.out.println("SALDO: Q." + dinero);
            System.out.println("Sus dos cartas Limites son:");
            System.out.println("    1. La carta Número: " + numeroMayor);
            System.out.println("    2. La carta Número: " + numeroMenor);
            System.out.println();
            
            int apuesta = 0;
            
            while (true) {
                System.out.println("Escriba la cantidad de dinero que sea Apostar tomando en cuenta la");
                System.out.println("probalibilidad de que el Número que salga este entre el rango establecido:");
                try {
                    apuesta = Integer.parseInt(scanner.nextLine());
                    System.out.println();

                    if (apuesta > dinero) {
                        System.out.println("--------------------------------------------------");
                        System.out.println("Error, no tienes esa cantidad de Dinero disponible");
                        System.out.println("Intentalo Nuevamente");
                        System.out.println("--------------------------------------------------");
                        System.out.println();
                    } else {
                        break;
                    }
                }catch (NumberFormatException ex) {
                    System.out.println();
                    System.out.println("------------------------------------");
                    System.out.println("Debe Ingresar una Cantidad de Dinero");
                    System.out.println("------------------------------------");
                    System.out.println();
                }
            }
            
            int numeroPrueba = (random.nextInt(52) + 1);
            System.out.println("-----------------------------------");
            System.out.println("La carta Obtenida fue la Número: " + numeroPrueba);
            
            if (numeroPrueba >= numeroMenor && numeroPrueba <= numeroMayor) {
                System.out.println("Ganaste");
            } else {
                System.out.println("Perdiste Q." + apuesta);
                dinero -= apuesta;
            }
            System.out.println("-----------------------------------");
        }
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("Te quedaste sin Dinero, partida Terminada");
        System.out.println("-----------------------------------------");
        System.out.println();
    }
    
    public int obtenerLimite() {
        Random random = new Random();
        int limite = (random.nextInt(52) + 1);
        return limite;
    }
}
