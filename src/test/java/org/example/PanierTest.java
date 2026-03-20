package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Observable;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class PanierTest {

    private Panier panier;
    private GestionDeStock stock;
    private Comptabilite compta;

    @BeforeEach
    void setUp() {
        stock = mock(GestionDeStock.class);
        compta = mock(Comptabilite.class);
        panier = new Panier(stock, compta);
    }

    @Test
    void should_return_contenu_panier_when_getContenu() {
        //GIVEN

        //WHEN
        String result = panier.getContenu();

        //THEN
        assertThat(result).isEqualTo("Contenu du panier");
    }

    @Test
    void should_notify_observateurs_compta_and_stock_when_declencher_commande() {
        //GIVEN
        Panier.DeclenchementCommande sujet = panier.new DeclenchementCommande();

        //WHEN
        sujet.addObserver(compta);
        sujet.addObserver(stock);
        sujet.setChanged();
        sujet.notifyObservers(panier.getContenu());

        //THEN
        verify(compta, times(1)).update(any(Observable.class), eq("Contenu du Panier"));
        verify(stock, times(1)).update(any(Observable.class), eq("Contenu du Panier"));
    }
}