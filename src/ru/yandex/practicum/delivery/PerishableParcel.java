package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    public int timeToLive;
    public static final int DELIVERY_COST = 3;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        if (sendDay + timeToLive >= currentDay) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int calculateDeliveryCost() {
        return weight*DELIVERY_COST;
    }
}