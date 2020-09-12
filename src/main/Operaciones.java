package main;

import dato.Persona;
import lista.Lista;

public class Operaciones {
    private final Lista lista;

    {
        lista = new Lista();
    }

    public void cargarLista() {
        lista.add(new Persona(123, "José", "Perez", true));
        lista.add(new Persona(124, "Julia", "Rendón", false));
        lista.add(new Persona(125, "Jefferson", "Barrera", true));
        lista.add(new Persona(126, "Lisbeth", "Cabrera", false));
        lista.add(new Persona(127, "Sergio", "Majé", true));
        lista.add(new Persona(128, "Andrés", "Franco", true));
        lista.add(new Persona(129, "Luisa", "Zuluaga", false));
        lista.add(new Persona(130, "Veronica", "Lofiego", false));
        lista.add(new Persona(131, "Johan", "García", true));
        lista.add(new Persona(132, "Fernanda", "Chacón", false));
        lista.add(new Persona(133, "Arley", "García", true));
        lista.add(new Persona(134, "Oscar", "Guzman", true));
        lista.add(new Persona(135, "Luisa", "Ortiz", false));
        lista.add(new Persona(136, "Lisbeth", "Rodriguez", false));
        lista.add(new Persona(137, "Lizeth", "Marin", false));
        lista.add(new Persona(138, "Yessica", "Majé", false));
        lista.add(new Persona(139, "Matias", "Leyton", true));
        lista.add(new Persona(140, "Reymon", "Barreira", true));
        lista.add(new Persona(141, "Lizeth", "Ramirez", false));
    }

    public void cargarBusquedas() {
        lista.search("Fernanda Chacón");
        lista.search("Lisbeth Cabrera");
        lista.search("Johan García");
        lista.search("Veronica Lofiego");
        lista.search("Luisa Zuluaga");
        lista.search("José Perez");
        lista.search("Andrés Franco");
        lista.search("Jefferson Barrera");
    }

    public void cargarSegundaBusqueda() {
        lista.search("Fernanda Chacón");
        lista.search("Lisbeth Cabrera");
        lista.search("Johan García");
    }

    public String buscar() {
        long start = System.currentTimeMillis();
        Persona persona = lista.search("Sergio Majé");
        long end = System.currentTimeMillis();
        return (end - start) + "ms\n" + (persona != null ? persona.toString() : "Not Found!");
    }
}
