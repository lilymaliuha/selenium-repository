package com.mechanic_advisor.pages.models;

import com.mechanic_advisor.test_data_container.AppointmentType;

public class AppointmentModel {
    private String title;
    private AppointmentType appointmentType;
    private String customer;
    private String vehicle;
    private String status;
    private String details;

    public AppointmentModel(String title, AppointmentType appointmentType) {
        this.title = title;
        this.appointmentType = appointmentType;
    }

    public AppointmentModel(String title, AppointmentType appointmentType, String customer,
                           String vehicle, String status, String details) {
        this.title = title;
        this.appointmentType = appointmentType;
        this.customer = customer;
        this.vehicle = vehicle;
        this.status = status;
        this.details = details;
    }

    public String getAppointmentTitle() {
        return title;
    }
    public void setAppointmentTitle(String title) {
        this.title = title;
    }

    public AppointmentType getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(AppointmentType appointmentType) {
        this.appointmentType = appointmentType;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
