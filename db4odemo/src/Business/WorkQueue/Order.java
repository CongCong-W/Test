/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package Business.WorkQueue;

import Business.Customer.Customer;
import Business.DeliveryMan.DeliveryMan;
import Business.Restaurant.Restaurant;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhicheng.czc
 * @version $ Id: Order.java, v 0.1 2020年11月08日 1:51 PM zhicheng.czc Exp $
 */
public class Order extends WorkRequest {

    private DeliveryMan deliveryMan;

    public Order() {
        super();
        setStatus(Status.Ordered.status);
    }

    public Order(Customer receiver, Restaurant sender) {
        setReceiver(receiver);
        setSender(sender);
        setStatus(Status.Ordered.status);
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public enum Status {
        Ordered("Ordered"),
        Accepted("Accepted"),
        Rejected("Rejected"),
        Delivering("Delivering"),
        Delivered("Delivered");

        private String status;

        Status(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public String getRequestDateStr() {
        DateFormat format = new SimpleDateFormat("YY/MM/dd hh:mm:ss");
        return format.format(getRequestDate());
    }

    public String getResolveDateStr() {
        DateFormat format = new SimpleDateFormat("YY/MM/dd hh:mm:ss");
        return format.format(getResolveDate());
    }

    public void accept() {
        setStatus(Status.Accepted.status);
    }

    public void reject() {
        setStatus(Status.Rejected.status);
    }

    public void delivering(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
        setStatus(Status.Delivering.status);
    }

    public void delivered() {
        setStatus(Status.Delivered.status);
        setResolveDate(new Date());
    }

    @Override
    public Restaurant getSender() {
        return (Restaurant) super.getSender();
    }

    public void setSender(Restaurant sender) {
        super.setSender(sender);
    }

    @Override
    public Customer getReceiver() {
        return (Customer) super.getReceiver();
    }

    public void setReceiver(Customer receiver) {
        super.setReceiver(receiver);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
