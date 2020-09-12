package lista;

import dato.Persona;

public class Nodo {
    private Persona dato;
    protected Nodo next;

    public Nodo(Persona dato) {
        this(dato, null);
    }

    public Nodo(Persona dato, Nodo next) {
        this.next = next;
        this.dato = dato;
    }

    public Persona getDato() {
        return dato;
    }
}
