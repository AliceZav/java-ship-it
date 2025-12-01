package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerishableParcelExpirationTest {
    @Test
    public void testIsExpired() {
        PerishableParcel perishableParcel = new PerishableParcel("Описание", 8,
                "Адрес", 1, 5);
        assertFalse(perishableParcel.isExpired(6));
        assertTrue(perishableParcel.isExpired(7));
    }
}
