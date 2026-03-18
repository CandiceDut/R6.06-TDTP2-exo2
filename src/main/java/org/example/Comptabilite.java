package org.example;

import java.util.ArrayList;

public class Comptabilite {
    private String comptabilite;

    public Comptabilite(String pComptabilite) {
        this.comptabilite = pComptabilite;
    }
    public void traite(String contenu) {
        System.out.println("comptabilite:" + contenu.toString().toLowerCase());
    }
}
