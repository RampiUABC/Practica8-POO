package org.uabc.ic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Nivel {
    private String nombre;
    private int numero;
    private String dificultad;
    private List<Obstaculo> obstaculos;
    private List<CheckPoint> checkPoints;
    private List<ElementoDinamico> elementosDinamicos;
    private Inventario inventario;

    public Nivel(String nombre, int numero, String dificultad, Inventario inventario) {
        this.nombre = nombre;
        this.numero = numero;
        this.dificultad = dificultad;
        this.inventario = inventario;
        this.obstaculos = new ArrayList<>();
        this.checkPoints = new ArrayList<>();
        this.elementosDinamicos = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public int getNumero() { return numero; }
    public String getDificultad() { return dificultad; }

    public void agregarObstaculo(Obstaculo obstaculo) {
        obstaculos.add(obstaculo);
    }

    public void agregarCheckPoint(CheckPoint checkPoint) {
        checkPoints.add(checkPoint);
    }

    public void agregarElementoDinamico(ElementoDinamico elemento) {
        elementosDinamicos.add(elemento);
    }

    public void moverElementosDinamicos() {
        String[] direcciones = {"norte", "sur", "este", "oeste"};
        Random random = new Random();

        for (ElementoDinamico elemento : elementosDinamicos) {
            String direccion = direcciones[random.nextInt(direcciones.length)];
            int distancia = random.nextInt(5) + 1;
            elemento.mover(direccion, distancia);
        }
    }

    public void mostrarEstado() {
        System.out.println("===== Nivel " + numero + ": " + nombre + " (" + dificultad + ") =====");

        System.out.println("Obstáculos (" + obstaculos.size() + "):");
        for (Obstaculo o : obstaculos) {
            System.out.println(" - " + o.getNombre() + " | daño: " + o.getDanio()
                    + " | posición: (" + o.getPosicionX() + ", " + o.getPosicionY() + ")"
                    + " | destruido: " + o.isDestruido());
        }

        System.out.println("CheckPoints (" + checkPoints.size() + "):");
        for (CheckPoint c : checkPoints) {
            System.out.println(" - " + c.getNombre() + " | posicion: (" + c.getPosicionX()
                    + ", " + c.getPosicionY() + ") | activado: " + c.isActivado());
        }

        System.out.println("Elementos dinámicos: " + elementosDinamicos.size());
        inventario.listarItems();
    }
}