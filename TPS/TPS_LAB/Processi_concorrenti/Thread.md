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
Il metodo `join()` in Java, quando usato con i **thread**, serve a **far attendere il completamento di un thread prima che un altro continui l'esecuzione**.
`join()` fa sì che il thread "padre" aspetti che i suoi "figli" abbiano finito il loro lavoro prima di andare avanti.
### In parole semplici:

Se hai un thread `t1` e chiami `t1.join()` nel thread principale (o in un altro thread), **il thread chiamante si blocca finché `t1` non ha finito di eseguire**.

lock

quando un thread accede a una risorsa, imposta un flag lock che fa capire   
agli altri thread che quella risorsa è inaccessibile fino a quando non termina la sua esecuzione

Thread.currentThread().getName();

come posso far sospenderer un thread che ha una risorsa assegnata?
abbiamo p1 e p2 sincronizzati, p1 è il primo ad accedere alla risorsa quindi lo locka in modo che nel mentre che è assegnata a lui nessun altro ci puo accedere.
se voglio sospendere il thread attivo chiamo la wait che puo essere chiamata solo se i due thread sono sincronizzati.
quindi con la wait il processo viene deallocato e messo nella losta di attesa e la risorsa viene assegnato all'altra. questo altro thread quando accede alla risorsa deve richiamare il metodo notifie che nel momento che viene rilevato dal t1 fa capire che la risorsa è di nuovo libera(quindi risveglia il thread in attesa).
oltre alla notifie esiste la notifie all che notifica tutti i processi che hanno effettuato la wait sullka risorsa condivisa di risvegliarsi. ma se io ho piu processi in attesa l'assegnamento della risorssa sara casuale(se voglio cercare di gestirlo posso assegnare una certa priorita al thread(grado di importanza)).
La classe thread presenta delle costanti, MINPRIORITY e mAXPRIORITY quando creo un thread la priorita è a metà di default.

il metodo activeCount() restituisce il numero di thread in esecuzione
se lo si richiama all'avvio del programma nel main senza nessun ulteriore thread creato, ne ritorna 2, uno è il main ,

il tasto control break richiama il dump che restituisce tipo uan "fotografia" del programma al momento( questo fa capire che quando eseguiamo un programma non viene eseguito solo il main)

demon thread sono thread vincolati strettamente <lla jvm, ovvero se l'istanza termina del'oggetto demon allora anche tutti gli altri terminano

sono creati dal programmatore e non sono vincolati strettamente al programma

getAllSTackTraces() contiene tutti i riferimentiai thread in esecuzione del programma


setPriority() serve per settare la priorita

setDeamon() 

Thread.currentThread().wait() non va bene se sto facendo concorrere due thread, perche il thread non puo fermarsi da solo, pero deve essere l'altro a fermarlo.

nessuno ha notificato significa che nessuno ha detto di partire ( a un thread)

quando creo un thread java di default gli assegna un nome

il thread che ad esempio è auto deve estendere la classe Thread(classe di sistema), oltre ad avere i propri attributi deve modificare anche il l'attributo nome, ereditato da Thread .


in java è piu complesso gestire le eccezzioni, perche piu thread potrebbero lanciarlla allo stesso tempo quindi si usa a1.setUncaughtEceptionHandler(new  setUncaughtEceptionHandler(crezione oggeto handler/gestore) ) poi compare il suo metodo automaticamente e cosi esso senza try catch potra  gestire le eccezioni da solo