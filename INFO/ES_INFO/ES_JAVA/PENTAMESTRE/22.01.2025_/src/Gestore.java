import java.util.Iterator;
import java.util.LinkedList;

public class Gestore {
    private final LinkedList<Figura> figure;

    public Gestore() {
        this.figure = new LinkedList<>();
    }

    public void add(Figura figura) {
        if (figura != null)
            this.figure.add(figura);
        else
            throw new NullPointerException("Puntatore nullo non valido");
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Iterator<Figura> it = this.figure.iterator();
        Figura figura;
        for (int k = 1; it.hasNext(); k++) {
            figura = it.next();
            s.append(k).append(") ").append(figura.toString()).append("\n");
        }
        return s.toString();
    }

    public String elencoAree() {
        StringBuilder s = new StringBuilder();
        Iterator<Figura> it = this.figure.iterator();
        Figura figura;
        for (int k = 1; it.hasNext(); k++) {
            figura = it.next();
            s.append(k).append(") ").append(figura.getClass()).append(": Area = ").append(figura.area()).append("\n");
        }
        return s.toString();
    }
}
