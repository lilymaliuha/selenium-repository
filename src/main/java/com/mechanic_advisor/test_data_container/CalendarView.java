package com.mechanic_advisor.test_data_container;

public enum CalendarView {
    DAY("Day"),
    WEEK("Week"),
    MONTH("Month"),
    FOUR_DAYS("4 Days");

    final private String value;

    CalendarView(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
