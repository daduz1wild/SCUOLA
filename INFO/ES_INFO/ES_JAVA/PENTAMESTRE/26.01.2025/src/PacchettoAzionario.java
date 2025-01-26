import java.util.StringTokenizer;

public class PacchettoAzionario implements FileCSV {
    private String nome;
    private double valore;
    public PacchettoAzionario() {
    }
    public PacchettoAzionario(String nome, double valore) {
        this.nome = nome;
        this.valore = valore;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if(!nome.isEmpty() && nome!=null)
            this.nome = nome;
        else
            throw new IllegalArgumentException("errore");
    }

    public double getValore() {
        return valore;
    }

    public void setValore(double valore) {
        if(valore>0)
            this.valore = valore;
        else
            throw new IllegalArgumentException("valore errato");
    }
    @Override
    public void fromCSV(String s) {
        if (s != null) {
            if (!s.isEmpty()) {
                StringTokenizer toks = new StringTokenizer(s, ";");
                if(toks.countTokens() >= 2) {
                    this.nome = toks.nextToken().trim();
                    this.valore = Double.parseDouble(toks.nextToken());
                }else
                    throw new IllegalArgumentException("non ci sono abbastanza token nella riga");
            } else
                throw new IllegalArgumentException("Stringa vuota");
        } else
            throw new NullPointerException("Puntatore a NULL non consentito");
    }

    @Override
    public String toCSV() {
        return nome + "," + valore+ ";";
    }
}