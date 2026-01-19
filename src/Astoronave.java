import java.util.*;

// Classe Astronave - Thread che corre verso il traguardo
class Astronave extends Thread {
    private String nome;
    private int posizione;
    private int lunghezzaGara;
    private Giudice giudice;
    private Random random;

    public Astronave(String nome, int lunghezzaGara, Giudice giudice) {
        this.nome = nome;
        this.posizione = 0;
        this.lunghezzaGara = lunghezzaGara;
        this.giudice = giudice;
        this.random = new Random();
    }

    public String getNomeAstronave() {
        return nome;
    }

    public int getPosizione() {
        return posizione;
    }

    @Override
    public void run() {
        System.out.println(nome + " parte!");

        while (posizione < lunghezzaGara) {
            try {
                Thread.sleep(random.nextInt(401) + 100); // Attesa 100-500ms

                int avanzamento = random.nextInt(3) + 1; // Avanza 1-3 posizioni
                posizione += avanzamento;

                if (posizione > lunghezzaGara) {
                    posizione = lunghezzaGara;
                }

                System.out.println(nome + " a " + posizione + "/" + lunghezzaGara);

                if (posizione >= lunghezzaGara) {
                    giudice.astronaveArrivata(this);
                    System.out.println(nome + " ha finito!");
                }

            } catch (InterruptedException e) {
                break;
            }
        }
    }
}