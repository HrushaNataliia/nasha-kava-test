package com.nashakava.ui.elements.coffeeWeightOption;

public enum CoffeeWeightEnum {

    DRIP("Дріп"),
    WEIGHT_100G("100г"),
    WEIGHT_150G("150г"),
    WEIGHT_250G("250г"),
    WEIGHT_1KG("1кг");

    private final String name;

    CoffeeWeightEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
