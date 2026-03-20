package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class PanierTest {

    private Panier panier;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        GestionDeStock stock = new GestionDeStock("stock");
        Comptabilite compta = new Comptabilite("Compta");
        panier = new Panier(stock, compta);
        System.setOut(new PrintStream(outputStreamCaptor));
        outputStreamCaptor.reset();
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
    void should_return_gestion_stock_and_compta_when_declencherCommande() {
        //GIVEN

        //WHEN
        panier.declencherCommande();

        //THEN
        assertThat(outputStreamCaptor.toString()).isEqualTo("G.DES.STOCKS:CONTENU DU PANIER" + System.lineSeparator() + "comptabilite:contenu du panier" + System.lineSeparator());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}