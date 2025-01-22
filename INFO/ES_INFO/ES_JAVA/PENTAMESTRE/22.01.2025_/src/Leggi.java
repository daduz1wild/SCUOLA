import java.util.Scanner;

public class Leggi {
    public static int lgInt(int minimo, int massimo, String messaggio) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        while (true) {
            try {
                System.out.print(messaggio);
                numero = scanner.nextInt();
                if (numero >= minimo && numero <= massimo) {
                    return numero;
                } else {
                    System.out.println("Errore, valore fuori range.");
                }
            } catch (Exception e) {
                System.out.println("Errore di input. Riprovare.");
                scanner.next();
            }
        }
    }

    public static double lgDbl(double minimo, double massimo, String messaggio) {
        Scanner scanner = new Scanner(System.in);
        double numero;
        while (true) {
            try {
                System.out.print(messaggio);
                numero = scanner.nextDouble();
                if (numero >= minimo && numero <= massimo) {
                    return numero;
                } else {
                    System.out.println("Errore, valore fuori range.");
                }
            } catch (Exception e) {
                System.out.println("Errore di input. Riprovare.");
                scanner.next();
            }
        }
    }

    public static char lgChar(String messaggio) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(messaggio);
        return scanner.next().charAt(0);
    }
}
