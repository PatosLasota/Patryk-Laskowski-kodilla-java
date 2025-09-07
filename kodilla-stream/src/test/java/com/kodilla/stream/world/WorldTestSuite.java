package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        // Given
        Country poland = new Country("Poland", new BigDecimal("38000000"));
        Country germany = new Country("Germany", new BigDecimal("83000000"));
        Country france = new Country("France", new BigDecimal("67000000"));

        Country china = new Country("China", new BigDecimal("1410000000"));
        Country india = new Country("India", new BigDecimal("1380000000"));

        Country usa = new Country("USA", new BigDecimal("331000000"));
        Country canada = new Country("Canada", new BigDecimal("38000000"));

        Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(france);

        Continent asia = new Continent("Asia");
        asia.addCountry(china);
        asia.addCountry(india);

        Continent northAmerica = new Continent("North America");
        northAmerica.addCountry(usa);
        northAmerica.addCountry(canada);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(northAmerica);

        // When
        BigDecimal totalPeople = world.getPeopleQuantity();

        // Then
        BigDecimal expectedPeople = new BigDecimal("1410000000")
                .add(new BigDecimal("1380000000"))
                .add(new BigDecimal("38000000"))
                .add(new BigDecimal("83000000"))
                .add(new BigDecimal("67000000"))
                .add(new BigDecimal("331000000"))
                .add(new BigDecimal("38000000"));

        assertEquals(expectedPeople, totalPeople);
    }
}