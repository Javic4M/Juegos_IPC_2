
package com.mycompany.multijuegos.main.MenuPrincipal;

import com.mycompany.multijuegos.main.ahorcado.Ahorcado;
import com.mycompany.multijuegos.main.baloncesto.Baloncesto;
import java.util.Scanner;

public class MultiJuegos {
    
    public void irAlMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println();
            System.out.println("MENU PRINCIPAL");
            System.out.println();
            System.out.println("Seleccione el juego que desea Jugar:");
            System.out.println("    1. Ahorcado");
            System.out.println("    2. Baloncesto");
            System.out.println("    3. Cartas");
            System.out.println("    4. Salir");
            int opcion = Integer.parseInt(scanner.nextLine());
            System.out.println();
            
            if (opcion == 1) {
                Ahorcado ahorcado = new Ahorcado();
                ahorcado.empezarPartida();
            } else if (opcion == 2) {
                Baloncesto baloncesto = new Baloncesto();
                baloncesto.empezarPartida();
            } else if (opcion == 3) {
                
            } else {
                System.out.println("-----------------");
                System.out.println("Gracias por Jugar");
                System.out.println("-----------------");
                System.out.println();
                break;
            }
        }
    }
}
