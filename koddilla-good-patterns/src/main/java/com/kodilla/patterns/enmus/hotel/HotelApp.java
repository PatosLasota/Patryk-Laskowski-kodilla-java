package com.kodilla.patterns.enmus.hotel;

public class HotelApp {
    public static void main(String[] args) {
        System.out.println("Accomodation pries: ");
        System.out.println("1.Single Bed rooms");
        System.out.println("   - low season: " +
                Season.LOW.getGetSingleBedPrice());
        System.out.println("   - high season: " +
                Season.HIGH.getGetSingleBedPrice());
        System.out.println("   - holiday season: " +
                Season.HOLIDAY.getGetSingleBedPrice());
        System.out.println("   - low season: " +
                Season.LOW.getGetDoubleBedPrice());
        System.out.println("   - high season: " +
                Season.HIGH.getGetDoubleBedPrice());
        System.out.println("   - holiday season: " +
                Season.HOLIDAY.getGetDoubleBedPrice());

        Season season = Season.HOLIDAY;
        System.out.println(season);

    }
}
