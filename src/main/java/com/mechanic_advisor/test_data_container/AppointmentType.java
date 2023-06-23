package com.mechanic_advisor.test_data_container;

public enum AppointmentType {
    WAITING("Waiting"),
    DROPPING_OFF("Dropping Off"),
    NONE("None");

    final private String value;

    AppointmentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}