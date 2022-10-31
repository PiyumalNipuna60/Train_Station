package model;

import java.util.Date;

public class BookingCustomer {
    private String id;
    private String name;
    private String address;
    private String contact;
    private String trainFrom;
    private String trainTo;
    private String time;
    private String train;
    private String seatNo;
    private String trainClass;
    private String price;
    private java.util.Date Date;

    public BookingCustomer() {
    }

    public BookingCustomer(String id, String name, String address, String contact, String trainFrom, String trainTo, String time, String train, String seatNo, String trainClass, String price, java.util.Date date) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.trainFrom = trainFrom;
        this.trainTo = trainTo;
        this.time = time;
        this.train = train;
        this.seatNo = seatNo;
        this.trainClass = trainClass;
        this.price = price;
        Date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTrainFrom() {
        return trainFrom;
    }

    public void setTrainFrom(String trainFrom) {
        this.trainFrom = trainFrom;
    }

    public String getTrainTo() {
        return trainTo;
    }

    public void setTrainTo(String trainTo) {
        this.trainTo = trainTo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTrain() {
        return train;
    }

    public void setTrain(String train) {
        this.train = train;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getTrainClass() {
        return trainClass;
    }

    public void setTrainClass(String trainClass) {
        this.trainClass = trainClass;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "BookingCustomer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", trainFrom='" + trainFrom + '\'' +
                ", trainTo='" + trainTo + '\'' +
                ", time='" + time + '\'' +
                ", train='" + train + '\'' +
                ", seatNo='" + seatNo + '\'' +
                ", trainClass='" + trainClass + '\'' +
                ", price='" + price + '\'' +
                ", Date=" + Date +
                '}';
    }
}
