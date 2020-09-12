package main;

public class Main {
    public static void main(String[] args) {
        Operaciones o = new Operaciones();
        o.cargarLista();
        o.cargarBusquedas();

        System.out.println("Sin Cache");
        System.out.println(o.buscar());

        o.cargarSegundaBusqueda();

        System.out.println("Con Cache");
        System.out.println(o.buscar());
    }
}
