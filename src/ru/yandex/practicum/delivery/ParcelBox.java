package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    public List<T> parcelBox = new ArrayList<>();
    public int maxWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T newParcel) {
        int allWeight = 0;
        for (T parcel : parcelBox) {
            allWeight += parcel.weight;
        }

        if (allWeight + newParcel.weight <= maxWeight) {
            parcelBox.add(newParcel);
        } else {
            System.out.println("В коробке недостаточно места!");
        }
    }

    public void getAllParcels() {
        for(T parcel : parcelBox) {
            System.out.println(parcel.description);
        }
    }
}
