package org.uabc.ic;

public class Obstaculo implements Destruible {
    private String nombre;
    private int danio;
    private int posicionX;
    private int posicionY;
    private boolean destruido;

    public Obstaculo(String nombre, int danio, int posicionX, int posicionY) {
        this.nombre = nombre;
        this.danio = danio;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.destruido = false;
    }

    public String getNombre() { return nombre; }
    public int getDanio() { return danio; }
    public int getPosicionX() { return posicionX; }
    public int getPosicionY() { return posicionY; }

    public boolean isDestruido() { return destruido; }

    @Override
    public void destruye() {
        destruido = true;
        System.out.println("El obstáculo " + nombre + " fue destruido");
    }
}