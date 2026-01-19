public class Main {
    public static void main(String[] args) {
        // Crea il giudice con lunghezza gara 100
        Giudice giudice = new Giudice(100);

        // Crea le astronavi
        Astronave a1 = new Astronave("Apollo", 100, giudice);
        Astronave a2 = new Astronave("Artemis", 100, giudice);
        Astronave a3 = new Astronave("Discovery", 100, giudice);
        Astronave a4 = new Astronave("Voyager", 100, giudice);

        // Aggiungi le astronavi al giudice
        giudice.aggiungiAstronave(a1);
        giudice.aggiungiAstronave(a2);
        giudice.aggiungiAstronave(a3);
        giudice.aggiungiAstronave(a4);

        // Avvia la gara
        giudice.avviaGara();

        // Attendi che tutte le astronavi finiscano
        giudice.dichiaraFinita();

        // Stampa la classifica finale
        giudice.stampaClassifica();
    }
}