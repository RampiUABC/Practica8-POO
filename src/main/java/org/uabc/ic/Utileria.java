package org.uabc.ic;

public class Utileria implements ElementoDinamico {
    private String nombre;
    private String descripcion;
    private int posicionX;
    private int posicionY;
    private boolean usada;

    public Utileria(String nombre, String descripcion, int posicionX, int posicionY) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.usada = false;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getPosicionX() { return posicionX; }
    public int getPosicionY() { return posicionY; }
    public boolean isUsada() { return usada; }

    public void usar() {
        usada = true;
        System.out.println("Se usó la utilería: " + nombre);
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
        System.out.println("Utilería " + nombre + " se movió " + distancia
                + " hacia el " + direccion + " -> (" + posicionX + ", " + posicionY + ")");
    }
}