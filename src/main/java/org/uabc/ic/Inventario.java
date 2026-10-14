package org.uabc.ic;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private int capacidadMaxima;
    private List<Inventariable> items;

    public Inventario(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.items = new ArrayList<>();
    }

    public int getCapacidadMaxima() { return capacidadMaxima; }

    public List<Inventariable> getItems() { return items; }

    public boolean agregarItem(Inventariable item) {
        if (items.size() < capacidadMaxima) {
            items.add(item);
            item.registrar();
            return true;
        }
        System.out.println("Inventario lleno, no se pudo agregar el item");
        return false;
    }

    public boolean eliminarItem(Inventariable item) {
        boolean eliminado = items.remove(item);
        if (eliminado) {
            item.borrar();
        }
        return eliminado;
    }

    public void listarItems() {
        System.out.println("Items del inventario (" + items.size() + "/" + capacidadMaxima + "):");
        for (Inventariable item : items) {
            System.out.println(" - " + item);
        }
    }
}