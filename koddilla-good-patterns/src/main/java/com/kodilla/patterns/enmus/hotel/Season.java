package com.kodilla.patterns.enmus.hotel;

import java.math.BigDecimal;

public enum Season {

        LOW(new BigDecimal(250), new BigDecimal(350)),
        HIGH(new BigDecimal(320), new BigDecimal(400)),
        HOLIDAY(new BigDecimal(400), new BigDecimal(500)),;

        private BigDecimal getSingleBedPrice;
        private BigDecimal getDoubleBedPrice;

        Season(BigDecimal getSingleBedPrice, BigDecimal getDoubleBedPrice) {
            this.getSingleBedPrice = getSingleBedPrice;
            this.getDoubleBedPrice = getDoubleBedPrice;
        }

    public BigDecimal getGetSingleBedPrice() {
        return getSingleBedPrice;
    }

    public BigDecimal getGetDoubleBedPrice() {
        return getDoubleBedPrice;
    }
}
