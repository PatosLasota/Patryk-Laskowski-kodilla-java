package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    public void testBigmacBuilder() {
        // Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("brioche")
                .roll("with sesame")
                .burgers(2)
                .sauce("standard")
                .ingredient("lettuce")
                .ingredient("onion")
                .ingredient("bacon")
                .ingredient("cheese")
                .build();

        // When
        int numberOfIngredients = bigmac.getIngredients().size();

        // Then
        assertEquals("brioche", bigmac.getBun());
        assertEquals("with sesame", bigmac.getRoll());
        assertEquals(2, bigmac.getBurgers());
        assertEquals("standard", bigmac.getSauce());
        assertEquals(4, numberOfIngredients);
        assertTrue(bigmac.getIngredients().contains("bacon"));
        assertTrue(bigmac.getIngredients().contains("cheese"));
    }
}