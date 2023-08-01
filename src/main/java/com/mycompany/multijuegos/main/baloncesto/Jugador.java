package com.mycompany.multijuegos.main.baloncesto;

public class Jugador {
    
    private String nombre;
    private int punteo = 0;
    
    public void guardarNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String obtenerNombre() {
        return nombre;
    }
    
    public void aumentarPunteo(int aumento) {
        this.punteo += aumento;
    }
    
    public int obtenerPunteo() {
        return punteo;
    }
}
