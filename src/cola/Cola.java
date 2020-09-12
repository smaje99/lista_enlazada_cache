package cola;

import dato.Persona;

public class Cola {
    private int tope;
    private final int limite;
    private final Persona[] cola;

    public Cola(int limite) {
        cola = new Persona[limite];
        tope = 0;
        this.limite = limite;
        for (int i = 0; i < limite; i++) cola[i] = null;
    }

    public boolean isEmpty() {
        return tope == 0;
    }

    public boolean isFull() {
        return tope == limite;
    }

    public boolean push(Persona dato) {
        if (dato != null && !isFull()) {
            cola[tope++] = dato;
            return true;
        }
        return false;
    }

    public Persona pop() {
        if (!isEmpty()) {
            Persona pop = cola[0];
            for (int i = 0; i < limite - 1; i++) cola[i] = cola[i + 1];
            tope--;
            cola[tope] = null;
            return pop;
        }
        return null;
    }

    public Persona search(String nombreCompleto) {
        if (!isEmpty()) {
            if (cola[0].equals(nombreCompleto))
                return cola[0];
            else if (tope > 1 && cola[tope - 1].equals(nombreCompleto))
                return cola[tope - 1];
            else {
                for (int i = 1; i < tope - 1; i++)
                    if (cola[i].equals(nombreCompleto))
                        return cola[i];
            }
        }
        return null;
    }

    public boolean contains(String nombreCompleto) {
        return search(nombreCompleto) != null;
    }
}
