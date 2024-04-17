package com.azship.api.domain.shipping;

import java.util.Arrays;

public enum Status {

    PREPARING("preparing"),
    READY("ready"),
    SENT("sent"),
    RETURNED("returned"),
    DELIVERED("delivered");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getstatus() {
        return value;
    }

    public static Status fromString(String value) {
        for (Status status : Status.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("No constant with text " + value + " found");
    }

}
