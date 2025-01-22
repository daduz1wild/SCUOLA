public class Main {
    public static void main(String[] args) {
        Gestore gestore = new Gestore();
        System.out.println(gestore.getClass().toString());
        int scelta;
        Figura figura;
        do {
            mostraMenu();
            scelta = Leggi.lgInt(0, 3, "Inserire funzione desiderata: ");
            switch (scelta) {
                case 0: {
                    break;
                }
                case 1: {
                    aggiungiFigura(gestore);
                    break;
                }
                case 2: {
                    System.out.println(gestore);
                    break;
                }
                case 3: {
                    System.out.println(gestore.elencoAree());
                    break;
                }
            }
        } while (scelta != 0);
    }

    private static void aggiungiFigura(Gestore gestore) {
        char tipoFigura;
        double lato1, lato2, lato3, lato4;
        boolean valido = false;
        do {
            tipoFigura = Leggi.lgChar("Vuoi inserire un quadrilatero o un triangolo (q/t)? ");
            if (tipoFigura == 'q') {
                try {
                    lato1 = Leggi.lgDbl(0, Double.MAX_VALUE, "Inserisci primo lato: ");
                    lato2 = Leggi.lgDbl(0, Double.MAX_VALUE, "Inserisci secondo lato: ");
                    lato3 = Leggi.lgDbl(0, Double.MAX_VALUE, "Inserisci terzo lato: ");
                    lato4 = Leggi.lgDbl(0, Double.MAX_VALUE, "Inserisci quarto lato: ");
                    gestore.add(new Quadrilatero(lato1, lato2, lato3, lato4));
                    valido = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (tipoFigura == 't') {
                try {
                    lato1 = Leggi.lgDbl(0, Double.MAX_VALUE, "Inserisci primo lato: ");
                    lato2 = Leggi.lgDbl(0, Double.MAX_VALUE, "Inserisci secondo lato: ");
                    lato3 = Leggi.lgDbl(0, Double.MAX_VALUE, "Inserisci terzo lato: ");
                    gestore.add(new Triangolo(lato1, lato2, lato3));
                    valido = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Errore, riprova.");
            }
        } while (tipoFigura != 'q' && tipoFigura != 't' && !valido);
    }

    private static void mostraMenu() {
        System.out.println("1) Inserire una figura;");
        System.out.println("2) Stampare tutti i dati delle figure inserite;");
        System.out.println("3) Stampare le aree delle figure inserite;");
        System.out.println("0) Termina il programma;");
    }
}