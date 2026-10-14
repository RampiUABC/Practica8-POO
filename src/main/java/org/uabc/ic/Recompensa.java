package org.uabc.ic;

public class Recompensa implements Inventariable {
    private String nombre;
    private int valor;
    private String tipo;

    public Recompensa(String nombre, int valor, String tipo) {
        this.nombre = nombre;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public int getValor() { return valor; }
    public String getTipo() { return tipo; }

    @Override
    public void registrar() {
        System.out.println("Recompensa registrada en el inventario: " + nombre);
    }

    @Override
    public void borrar() {
        System.out.println("Recompensa eliminada del inventario: " + nombre);
    }

    @Override
    public String toString() {
        return "Recompensa [nombre=" + nombre + ", valor=" + valor + ", tipo=" + tipo + "]";
    }
}