
package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private final String bun;
    private final String roll;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    private Bigmac(String bun, String roll, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.roll = roll;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public String getRoll() {
        return roll;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", roll='" + roll + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public static class BigmacBuilder {
        private String bun;
        private String roll;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder roll(String roll) {
            if (!"with sesame".equals(roll) && !"without sesame".equals(roll)) {
                throw new IllegalArgumentException("Roll must be 'with sesame' or 'without sesame'");
            }
            this.roll = roll;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers < 1) {
                throw new IllegalArgumentException("Number of burgers must be at least 1");
            }
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if (!"standard".equals(sauce) && !"1000 islands".equals(sauce) && !"barbecue".equals(sauce)) {
                throw new IllegalArgumentException("Sauce must be 'standard', '1000 islands', or 'barbecue'");
            }
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            if (!"lettuce".equals(ingredient) && !"onion".equals(ingredient) &&
                    !"bacon".equals(ingredient) && !"cucumber".equals(ingredient) &&
                    !"chili peppers".equals(ingredient) && !"mushrooms".equals(ingredient) &&
                    !"shrimps".equals(ingredient) && !"cheese".equals(ingredient)) {
                throw new IllegalArgumentException("Invalid ingredient: " + ingredient);
            }
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            if (roll == null || sauce == null) {
                throw new IllegalStateException("Roll and sauce are required");
            }
            if (burgers == 0) {
                throw new IllegalStateException("Number of burgers must be specified");
            }
            return new Bigmac(bun, roll, burgers, sauce, ingredients);
        }
    }
}

