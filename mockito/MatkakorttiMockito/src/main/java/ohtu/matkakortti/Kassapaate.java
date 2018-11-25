package ohtu.matkakortti;

public class Kassapaate {
    private int myytyjaLounaita;
    public static final int HINTA = 5;

    public Kassapaate() {
        this.myytyjaLounaita = 0;
    }
    
    public void lataa(Matkakortti kortti, int summa){
        if (summa <= 0) { //jos summa on nolla tai negatiivinen, kortille ei ladata mitään
            return;
        }
        kortti.lataa(summa); //muussa tapauksessa summa ladataan kortille
    }
    
    public void ostaLounas(Matkakortti kortti) {
        if (kortti.getSaldo()<HINTA) { //jos kortilla ei ole varaa lounaaseen, sitä ei makseta
            return;
        }
        kortti.osta(HINTA); //muussa tapauksessa maksetaan ja lounas myydään
        myytyjaLounaita++;
    }

    public int getMyytyjaLounaita() {
        return myytyjaLounaita;
    }
}
