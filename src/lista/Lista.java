package lista;

import cola.Cola;
import dato.Persona;

public class Lista {
    private int len;
    private Nodo head;
    private Nodo tail;
    private final Cola cache;

    public Lista() {
        this(5);
    }

    public Lista(int lenCache) {
        len = 0;
        head = null;
        tail = null;
        cache = new Cola(lenCache);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(Persona dato) {
        len++;
        head = new Nodo(dato, head);
        if (tail == null) tail = head;
    }

    public int length() {
        return len;
    }

    private void addCache(Persona dato) {
        if (!cache.push(dato)) {
            cache.pop();
            cache.push(dato);
        }
    }

    private Persona searchCache(String nombreCompleto) {
        return cache.search(nombreCompleto);
    }

    private Persona searchList(String nombreCompleto) {
        Nodo aux = head.next;
        while (aux != tail) {
            Persona dato = aux.getDato();
            if (dato.equals(nombreCompleto)) return dato;
            aux = aux.next;
        }
        return null;
    }

    public Persona search(String nombreCompleto) {
        if (!isEmpty()) {
            if (head.getDato().equals(nombreCompleto)) return head.getDato();
            else if (tail.getDato().equals(nombreCompleto)) return tail.getDato();
            else {
                Persona dato = searchCache(nombreCompleto);
                if (dato == null) dato = searchList(nombreCompleto);
                addCache(dato);
                return dato;
            }
        }
        return null;
    }

    public Persona head() {
        return head.getDato();
    }

    public Persona tail() {
        return tail.getDato();
    }

    @Override
    public String toString() {
        StringBuilder n = new StringBuilder();
        Nodo aux = head;
        while (aux != null) {
            n.append(aux.getDato().toString()).append('\n');
            aux = aux.next;
        }
        return n.toString();
    }
}
