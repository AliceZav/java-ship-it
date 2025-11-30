package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelCostTest {
    @Test
    public void testStandardParcelCost() {
        StandardParcel standardParcel = new StandardParcel("Описание", 10,
                                                        "Адрес", 1);
        assertEquals(20, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void testFragileParcelCost() {
        FragileParcel fragileParcel = new FragileParcel("Описание", 5,
                                                        "Адрес", 1);
        assertEquals(20, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void testPerishableParcelCost() {
        PerishableParcel perishableParcel = new PerishableParcel("Описание", 8,
                                                                "Адрес", 1, 3);
        assertEquals(24, perishableParcel.calculateDeliveryCost());
    }
}
