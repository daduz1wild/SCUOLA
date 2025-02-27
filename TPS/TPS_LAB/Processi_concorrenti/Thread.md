user level(thread) non e vincolata alla JVM quindi se main termina e i thread non sono ancora terminati, finiscono da soli

invece ad esempio i demon thread se il main termina allora allo stesso tempo anche essi vengono bloccati. per attendere la terminazione dei thread si puo usare la wait ma meglio la join con i thread

2 tipi di thread: user thread (UT) e demon thread (DT)  
  
UT  
  
creati dall' utente/applicazione, non vincolati dalla JVM( la JVM aspetta la loro terminazione), priorità maggiore, svolgono attività specifiche  
  
DT  
  
di solito creati dalla JVM, vincolati dalla JVM, priorità minore, avviati in background (come garbage collector), supportano altri thread  
  
si creano:  
1) con l'ereditarietà di Thread  
public class Lampadina extends Thread{  
  
}  
problema che la classe lampadina non può ereditare da nessun altro  
  
1) implementare interfaccia Runnable  
  
public class Lampadina implements Runnable{  
  
  @Override  
  public void run(){  
  
  }  
  
}  
si deve definire nella classe il metodo run()  
  
si crea oggetto della classe che si implementa runnable  
poi si crea un oggetto della classe thread che ha nel costruttore come paramentro l oggetto creato precedentemente  
  
main(){  
  Lampadina l1=new Lampadina();  
  Thread t1= new Thread(l1)  
}  
  
si usa start() per avere l'elaborazione concorrente invece del semplice run  
  
t1.start();  
  
Thread.sleep(tempo in millisecondi) mette in attesa il thread

le variabili di classi , sono condivisi in quella classe , invece i metodi della classe run sono attributi visibili da specifici threads  
  
se il main termina , i thread user vengono eseguiti lo stesso , ma se gli faccio diventare Deamon saranno vincolati alla JVM , anche facendo una join su un solo processo ,i processi tipo p1  e p2 eseguiti verranno eseguiti  
comunque prima del padre

LOCK : e un flag che fa capire agli altri thread che una risorsa e inaccessibile , finche la risorsa non finisce di eseguire , cosi si evita che piu processi accedano allla stessa risorsa evitando errori .

ACCESSO MEMORIA (thread o runnable)

tutti gli attributi di classe sono accessibili a qualsiasi thread di quella classe.

gli attributi locali del metodo run, sono attributi accessibli solamente agli specifici thread.

class Persona implements Runnable{  
  private String nome;  
  private int eta;

  //costruttori, getter e setter

  @Override  
  public void run(){  
    sout("Ciao sono il thread");  
  }  
}  
metodo setDemon(true o false) imposta thread a demon mode

join(); riunisce i thread quando terminano e fa attendere il padre ai figli.  
t1.join();  
t2.join();

lock

quando un thread accede a una risorsa, imposta un flag lock che fa capire   
agli altri thread che quella risorsa è inaccessibile fino a quando non termina la sua esecuzione

Thread.currentThread().getName();