/*
Creare la classe Pila su tipo generico vincolato (metodi: costruttori, size, pop, push,
importa ed esporta) e la classe PacchettoAzionario (metodi: costruttori, set/get) che
implementi interfaccia FileCsv.
 */
import java.io.*;
import java.util.LinkedList;

public class Pila<E> {
    private LinkedList<E> pila;
    public Pila(){
        pila=new LinkedList<>();
    }
    public int size(){
        return this.pila.size();
    }
    public boolean isEmpty(){
        return this.pila.isEmpty();
    }
    public E pop(){
        if(!pila.isEmpty())
            return this.pila.removeLast();
        else
            throw new IllegalArgumentException("la pila è vuota");
    }
    public void push(E el){
        if(el!=null)
            pila.addLast(el);
        else
            throw new IllegalArgumentException("elemeno inesistente");
    }
    public void imp(){
        try {
            BufferedReader fin = new BufferedReader(new FileReader("file.csv"));
            String s = fin.readLine();
            while (s != null) {
                PacchettoAzionario az = new PacchettoAzionario();
                az.FromCSV(s);
                pila.add(az);
                s = fin.readLine();
            }
            fin.close();
        }catch(IOException e){
            System.out.println("errore file"+e.getMessage());
        }
    }
    public void esp(){
        if(pila.isEmpty()) {
            try {
                PrintWriter fin = new PrintWriter(new FileWriter(), true);
                for (E el : pila)
                    fin.printf(el.toCSV());
                fin.close();
            } catch (IOException e) {
                System.out.println("errore file, dettagli:" + e.getMessage());
            }
        }else
            throw new IllegalArgumentException("lista vuota");
    }
}
