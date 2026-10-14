package org.uabc.ic;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario(5);
        inventario.agregarItem(new Arma("Espada", 25, 1.5));
        inventario.agregarItem(new Recompensa("Moneda de oro", 100, "moneda"));

        Nivel nivel = new Nivel("Bosque Oscuro", 1, "fácil", inventario);

        nivel.agregarObstaculo(new Obstaculo("Roca", 10, 5, 5));
        nivel.agregarObstaculo(new Obstaculo("Fuego", 20, 8, 3));

        nivel.agregarCheckPoint(new CheckPoint("Inicio", 0, 0));
        nivel.agregarCheckPoint(new CheckPoint("Mitad", 10, 10));

        Personaje heroe = new Personaje("Heroe", 100, 0, 0);
        Utileria caja = new Utileria("Caja", "Caja de madera", 3, 3);
        Utileria barril = new Utileria("Barril", "Barril con pólvora", 6, 2);

        nivel.agregarElementoDinamico(heroe);
        nivel.agregarElementoDinamico(caja);
        nivel.agregarElementoDinamico(barril);

        System.out.println("--- Estado inicial ---");
        nivel.mostrarEstado();
        System.out.println("Heroe: (" + heroe.getPosicionX() + ", " + heroe.getPosicionY() + ")");

        System.out.println("\n--- Moviendo elementos dinámicos ---");
        nivel.moverElementosDinamicos();

        System.out.println("\n--- Estado final ---");
        nivel.mostrarEstado();
        System.out.println("Heroe: (" + heroe.getPosicionX() + ", " + heroe.getPosicionY() + ")");
    }
}