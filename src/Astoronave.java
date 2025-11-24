public abstract class Astoronave implements Runnable  {
    private String nome;
    private double velocita;
    private int distanzaPercorsa = 0;

    public void Astronave(String nome, double velocita, int distanzaPercorsa){
        this.nome = nome;
        this.velocita = velocita;
        this.distanzaPercorsa = distanzaPercorsa;
    }

    @Override
    public void run(int distanzaPercorsa){
        distanzaPercorsa++;
    }

}
