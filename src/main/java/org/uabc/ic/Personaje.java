package org.uabc.ic;

public class Personaje implements Destruible, ElementoDinamico {
    private String nombre;
    private int vida;
    private int posicionX;
    private int posicionY;

    public Personaje(String nombre, int vida, int posicionX, int posicionY) {
        this.nombre = nombre;
        this.vida = vida;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getPosicionX() { return posicionX; }
    public int getPosicionY() { return posicionY; }

    public void setPosicion(int x, int y) {
        this.posicionX = x;
        this.posicionY = y;
    }

    public void recibirDaño(int daño) {
        vida = vida - daño;
        if (vida <= 0) {
            vida = 0;
            destruye();
        }
    }

    @Override
    public void mover(String direccion, int distancia) {
        if (direccion.equals("norte")) {
            posicionY = posicionY + distancia;
        } else if (direccion.equals("sur")) {
            posicionY = posicionY - distancia;
        } else if (direccion.equals("este")) {
            posicionX = posicionX + distancia;
        } else if (direccion.equals("oeste")) {
            posicionX = posicionX - distancia;
        }
        System.out.println("Personaje " + nombre + " se movió " + distancia
                + " hacia el " + direccion + " -> (" + posicionX + ", " + posicionY + ")");
    }

    @Override
    public void destruye() {
        System.out.println("El personaje " + nombre + " fue destruido");
    }
}