import java.util.*;

// Classe Giudice - gestisce la gara e la classifica
class Giudice {
    private List<Astronave> astronavi;
    private List<Astronave> classifica;
    private int lunghezzaGara;

    public Giudice(int lunghezzaGara) {
        this.astronavi = new ArrayList<>();
        this.classifica = new ArrayList<>();
        this.lunghezzaGara = lunghezzaGara;
    }

    public void aggiungiAstronave(Astronave astronave) {
        astronavi.add(astronave);
    }

    public void avviaGara() {
        System.out.println("\nIL GIUDICE AVVIA LA GARA!");
        System.out.println("Lunghezza: " + lunghezzaGara + " - Astronavi: " + astronavi.size() + "\n");

        for (Astronave a : astronavi) {
            a.start();
        }
    }

    public synchronized void astronaveArrivata(Astronave astronave) {
        if (!classifica.contains(astronave)) {
            classifica.add(astronave);
        }
    }

    private void generaClassificaFinale() {
        List<Astronave> tutteAstronavi = new ArrayList<>(astronavi);
        tutteAstronavi.sort((a1, a2) -> Integer.compare(a2.getPosizione(), a1.getPosizione()));
        classifica.clear();
        classifica.addAll(tutteAstronavi);
    }
    public void dichiaraFinita() {
        System.out.println("\nIL GIUDICE DICHIARA LA GARA FINITA!");

        for (Astronave a : astronavi) {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        generaClassificaFinale();
    }
    public void stampaClassifica() {
        System.out.println("\nCLASSIFICA FINALE:");
        for (int i = 0; i < classifica.size(); i++) {
            Astronave a = classifica.get(i);
            System.out.println((i + 1) + ". " + a.getNomeAstronave() +
                    " - Posizione: " + a.getPosizione() + "/" + lunghezzaGara);
        }
    }
}