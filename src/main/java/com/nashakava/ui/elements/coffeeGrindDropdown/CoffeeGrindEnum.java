package com.nashakava.ui.elements.coffeeGrindDropdown;


public enum CoffeeGrindEnum {

    TURKISH_GRIND("Турка"),
    CUP_GRIND("Чашка"),
    ESPRESSO_GRIND("Еспресо"),
    MOKA_POT_GRIND("Гейзер"),
    DRIP_FILTER_GRIND("Фільтр (крапельна)"),
    POUROVER_GRIND("Пуровер"),
    CHEMEX_GRIND("Кемекс"),
    FRENCH_PRESS_GRIND("Френч-прес"),
    COLD_BREW_GRIND("Колдбрю");

    private final String name;

    CoffeeGrindEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
