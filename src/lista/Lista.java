package lista;

import dato.Persona;

public class Lista {
    private int len;
    private Nodo head;
    private Nodo tail;
    private final Persona[] cache;

    public Lista() {
        this(5);
    }

    public Lista(int lenCache) {
        len = 0;
        head = null;
        tail = null;
        cache = new Persona[lenCache];
        for (int i = 0; i < lenCache; i++) cache[i] = null;
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
        if (dato != null) {
            // Comprobando que el dato no exista en el cache
            int index;
            for (index = 0; index < cache.length; index++) {
                if (cache[index] == null) break;
                else if (cache[index].equals(dato.getNombreCompleto())) return;
            }

            // Buscando espacios vacíos para añadir el dato en el cache
            if (index < 5) {
                cache[index] = dato;
                return;
            }

            // añadiendo el dato a cache como si fuese una cola limitada
            for (int i = 0; i < cache.length - 1; i++) cache[i] = cache[i + 1];
            cache[cache.length - 1] = dato;
        }
    }

    private Persona searchCache(String nombreCompleto) {
        if (cache[0] != null && cache[0].equals(nombreCompleto))
            return cache[0];
        else if (cache[cache.length - 1] != null && cache[cache.length - 1].equals(nombreCompleto))
            return cache[cache.length - 1];
        else
            for (Persona persona : cache)
                if (persona != null && persona.equals(nombreCompleto))
                    return persona;
        return null;
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
