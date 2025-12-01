package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelBoxTest {
    public static final int WEIGHT_TEST = 1000;
    public static final String DESCRIPTION_TEST = "Описание";
    public static final String ADDRESS_TEST = "Адрес";
    public static final int DAY_TEST = 1;
    public static final int MAX_WEIGHT_TEST = 5000;

    @Test
    public void testAddParcel() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(MAX_WEIGHT_TEST);
        StandardParcel parcel = new StandardParcel(DESCRIPTION_TEST, WEIGHT_TEST, ADDRESS_TEST, DAY_TEST);
        box.addParcel(parcel);
        assertEquals(1, box.parcelBox.size());

        parcel = new StandardParcel(DESCRIPTION_TEST, WEIGHT_TEST*4, ADDRESS_TEST, DAY_TEST*2);
        box.addParcel(parcel);
        assertEquals(1, box.parcelBox.size());
    }
}
