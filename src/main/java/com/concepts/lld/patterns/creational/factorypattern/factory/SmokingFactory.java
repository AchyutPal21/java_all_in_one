package com.concepts.lld.patterns.creational.factorypattern.factory;

public class SmokingFactory {
    public static Smoking startSmoking(String type) {
        if (type == null) {
            return null;
        }

        return (switch (type.toLowerCase()) {
            case "flake" -> new Flake();
            case "goldflake" -> new GoldFlake();
            case "premiumgoldflake" -> new PremiumGoldFlake();
            default -> null;
        });


    }
}
