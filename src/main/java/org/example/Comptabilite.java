package org.example;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Comptabilite implements Observer {
    private String comptabilite;

    public Comptabilite(String pComptabilite) {
        this.comptabilite = pComptabilite;
    }
    public void traite(String contenu) {
        System.out.println("comptabilite:" + contenu.toString().toLowerCase());
    }

    @Override
    public void update(Observable pSujet, Object pObject) {
        traite((String)(pObject).toString());
    }
}
