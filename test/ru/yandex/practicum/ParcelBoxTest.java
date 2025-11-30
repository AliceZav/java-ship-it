package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParcelBoxTest {
    @Test
    public void testAddParcel() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(5000);
        StandardParcel parcel = new StandardParcel("Описание", 1000, "Адрес", 1);
        box.addParcel(parcel);
        assertEquals(1, box.parcelBox.size());

        parcel = new StandardParcel("Другое описание", 4001, "Другой адрес", 2);
        box.addParcel(parcel);
        assertEquals(1, box.parcelBox.size());
    }
}
