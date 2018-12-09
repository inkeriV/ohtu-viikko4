/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author inkeriv
 */
public class Summa implements Komento {
    
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private Sovelluslogiikka sovellus;
    
    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    @Override
    public void peru() {
    }

    @Override
    public void suorita() {
        int syote = Integer.parseInt(syotekentta.getCharacters().toString());
        int nyk = Integer.parseInt(tuloskentta.getCharacters().toString());
        int summa = syote + nyk;
        tuloskentta.setText(Integer.toString(summa));
    }   
}
