package com.razah.dev.bookstore.transaction.constant;

public enum PhotoType {
    GROUP(15),
    COUPLE(2),
    PERSONAL(1);
    private final int value;

    PhotoType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
