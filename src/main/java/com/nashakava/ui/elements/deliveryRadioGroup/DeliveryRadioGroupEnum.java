package com.nashakava.ui.elements.deliveryRadioGroup;


public enum DeliveryRadioGroupEnum {
    STORE_PICKUP("Самовивіз з нашого магазину(м. Миколаїв, вул. Сінна 23) - безкоштовно;"),
    UKLON_TAXI("Таксі Уклон по м. Миколаєву"),
    NOVA_POSHTA_BRANCH("У відділення або поштомат Нової Пошти;"),
    NOVA_POSHTA_COURIER("Кур’єром Нової Пошти;"),
    UKR_POSHTA_BRANCH("У відділення Укрпошти.");

    private final String name;

    DeliveryRadioGroupEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
