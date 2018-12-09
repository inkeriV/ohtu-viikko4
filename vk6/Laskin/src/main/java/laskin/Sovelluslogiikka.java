package laskin;

public class Sovelluslogiikka implements SovellusLog {
 
    private int tulos;
    
    @Override
    public void plus(int luku) {
        tulos += luku;
    }
     
    @Override
    public void miinus(int luku) {
        tulos -= luku;
    }
 
    @Override
    public void nollaa() {
        tulos = 0;
    }
 
    @Override
    public int tulos() {
        return tulos;
    }

}