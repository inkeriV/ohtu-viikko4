
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int ALKUKOKO = 5; // taulukon koko aluksi
    public final static int OLETUSKASVATUS = 5;  // kasvatuskoko alustetaan viideksi
    
    private int kasvatuskoko;     // lukujono-listaa kasvattaessa se kasvaa kasvatuskoon verran
    private int[] lukujono;      // lista joukon lukuja varten
    private int alkioidenLkm;    // listan alkioiden lukumäärä

    public IntJoukko() {
        this.lukujono = new int[ALKUKOKO];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }
        this.lukujono = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = OLETUSKASVATUS;
    }
       
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            return;
        }
        this.lukujono = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public void lisaa(int luku) { //kesken

        if (isEmpty()) {
            lukujono[0] = luku;
            kasvataLukumaaraa();
            
        } else if (!kuuluukoLukuListaan(luku)) {
            
            if (alkioidenLkm % lukujono.length == 0) {
                kasvataLukujononKokoa();
            }
            lukujono[alkioidenLkm] = luku;
            kasvataLukumaaraa();
        }
    }
    
    public void kasvataLukujononKokoa() {
        
        int[] uusiTaulukko = new int[alkioidenLkm + kasvatuskoko];
        kopioiLukujono(uusiTaulukko);
        lukujono = uusiTaulukko;
    }
    
    public boolean isEmpty() {
        if (alkioidenLkm == 0) {
            return true;
        }
        return false;
    }
    
    private void kasvataLukumaaraa() {
        alkioidenLkm++;
    }
    private void vahennaLukumaaraa()  {
        alkioidenLkm--;
    }

    public boolean kuuluukoLukuListaan(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (lukujono[i] == luku) {
                return true;
            }
        }
        return false;
    }

    public void poistaLuku(int luku) {
        int kohta = etsiIndeksi(luku); 
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                int apu = lukujono[j];
                lukujono[j] = lukujono[j + 1];
                lukujono[j + 1] = apu;
            }
            vahennaLukumaaraa();
        }
    }
    
    private int etsiIndeksi(int luku) {
    
        for (int i=0; i<alkioidenLkm; i++) {
            if (lukujono[i] == luku) {
                return i;
            }
        }
        return -1;
    }

    private int[] kopioiLukujono( int[] uusi) {
        for (int i = 0; i < lukujono.length; i++) {
            uusi[i] = lukujono[i];
        }
        return uusi;
    }

    public int getAlkioidenLukumaara() {
        return alkioidenLkm;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }
    

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;
    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poistaLuku(i);
        }
        return z;
    }
      
    @Override
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        String joukko="{";
        for (int i=0; i<alkioidenLkm-1; i++) {
            joukko += lukujono[i] + ", ";
        }
        joukko += lukujono[alkioidenLkm - 1] + "}";
        return joukko;
    }
}