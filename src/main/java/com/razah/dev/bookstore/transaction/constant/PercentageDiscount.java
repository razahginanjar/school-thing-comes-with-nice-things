package com.razah.dev.bookstore.transaction.constant;

public enum PercentageDiscount {
    TEN_PERCENT(10),
    FIFTY_PERCENT(50),
    THIRTY_PERCENT(30),
    TWENTY_PERCENT(20),;

    private final int value;

    PercentageDiscount(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
