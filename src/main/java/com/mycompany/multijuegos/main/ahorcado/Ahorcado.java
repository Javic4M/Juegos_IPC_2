
package com.mycompany.multijuegos.main.ahorcado;

import java.util.Scanner;

public class Ahorcado {
    
    public void empezarPartida() {
        String[][] dibujo = {{"-","-","-","-","-"," "," "},{"|"," "," "," ","|"," "," "},{"|"," "," "," ","O"," "," "},{"|"," "," ","-","-","-"," "},{"|"," "," "," ","|"," "," "},{"|"," "," "," ","-"," "," "},{"|"," "," ","|"," ","|"," "}};
        String[][] dibujoAMostrar = {{"-","-","-","-","-"," "," "},{"|"," "," "," ","|"," "," "},{"|"," "," "," "," "," "," "},{"|"," "," "," "," "," "," "},{"|"," "," "," "," "," "," "},{"|"," "," "," "," "," "," "},{"|"," "," "," "," "," "," "}};
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        
        System.out.println("Escriba la palabra a Adivinar:");
        String palabra = scanner.nextLine();
        System.out.println();
        
        String[] palabraOculta = palabra.split("");
        String[] palabraAMostrar = new String[palabraOculta.length];
        
        for (int i = 0; i < palabraAMostrar.length; i++) {
            palabraAMostrar[i] = "_";
        }

        while (!salir) {
            visualizarDibujo(dibujoAMostrar);
            
            for (int i = 0; i < palabraAMostrar.length; i++) {
                System.out.print(palabraAMostrar[i] + " ");
            }
            
            System.out.println();
            System.out.println("Escriba una letra:");
            String letra = scanner.nextLine();
            System.out.println();
            
            boolean letraCorrecta = false, perdio = false;
            
            for (int i = 0; i < palabraOculta.length; i++) {
                if (letra.equals(palabraOculta[i])) {
                    palabraAMostrar[i] = letra;
                    letraCorrecta = true;
                }
                if (i == palabraOculta.length - 1 && !letraCorrecta) {
                    perdio = dibujarPersona(dibujo, dibujoAMostrar);
                }
            }
            
            if (!perdio) {
                int contador = 0;

                for (int i = 0; i < palabraAMostrar.length; i++) {
                    if ("_".equals(palabraAMostrar[i])) {
                        contador++;
                    }
                    if (i == palabraAMostrar.length - 1) {
                        if (contador == 0) {
                            System.out.println("Ganaste");
                            salir = true;
                            break;
                        }
                    }
                }
            } else {
                visualizarDibujo(dibujoAMostrar);
                System.out.println("--------");
                System.out.println("Perdiste");
                System.out.println("--------");
                break;
            }
        }
    }
    
    public void visualizarDibujo(String[][] dibujo) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(dibujo[i][j]);
            }
            System.out.println();
        }    
        System.out.println();
    }
    
    public boolean dibujarPersona(String[][] dibujo, String[][] dibujoAMostrar) {
        for (int i = 0; i < dibujo.length; i++) {
            for (int j = 0; j < dibujo[0].length; j++) {
                if (!dibujo[i][j].equals(dibujoAMostrar[i][j])) {
                    dibujoAMostrar[i][j] = dibujo[i][j];
                    
                    if (i == 6 && j == 5) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
