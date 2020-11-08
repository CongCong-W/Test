/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import Business.Customer.Customer;
import Business.Customer.CustomerDirectory;
import Business.DeliveryMan.DeliveryMan;
import Business.DeliveryMan.DeliveryManDirectory;
import Business.Restaurant.Restaurant;
import Business.Restaurant.RestaurantDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.WorkQueue.Order;

import java.util.ArrayList;

/**
 * @author MyPC1
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private final RestaurantDirectory restaurantDirectory;
    private final CustomerDirectory customerDirectory;
    private final DeliveryManDirectory deliveryManDirectory;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    private EcoSystem() {
        super(null);
        customerDirectory = new CustomerDirectory(getUserAccountDirectory());
        restaurantDirectory = new RestaurantDirectory(getUserAccountDirectory());
        deliveryManDirectory = new DeliveryManDirectory(getUserAccountDirectory());
    }

    public void createOrder(Customer receiver, Restaurant sender) {
        Order order = new Order(receiver, sender);
        receiver.getWorkQueue().getWorkRequestList().add(order);
        sender.getWorkQueue().getWorkRequestList().add(order);
        customerDirectory.update(order.getReceiver());
        restaurantDirectory.update(order.getSender());
    }

    public void updateOrder(Order order) {
        customerDirectory.update(order.getReceiver());
        restaurantDirectory.update(order.getSender());
        if (order.getDeliveryMan() != null) {
            deliveryManDirectory.update(order.getDeliveryMan());
        }
    }

    public void deliverOrder(Order order, DeliveryMan deliveryMan) {
        order.delivering(deliveryMan);
        deliveryMan.getWorkQueue().getWorkRequestList().add(order);
        customerDirectory.update(order.getReceiver());
        restaurantDirectory.update(order.getSender());
        deliveryManDirectory.update(order.getDeliveryMan());
    }

    public void finishOrder(Order order) {
        order.delivered();
        customerDirectory.update(order.getReceiver());
        restaurantDirectory.update(order.getSender());
        deliveryManDirectory.update(order.getDeliveryMan());
    }

    public boolean checkIfUserIsUnique(String userName) {
        //
        return false;
    }

    public RestaurantDirectory getRestaurantDirectory() {
        return restaurantDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public DeliveryManDirectory getDeliveryManDirectory() {
        return deliveryManDirectory;
    }
}
