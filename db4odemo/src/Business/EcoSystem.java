/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import Business.Customer.CustomerDirectory;
import Business.DeliveryMan.DeliveryManDirectory;
import Business.Restaurant.RestaurantAdminDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;

import java.util.ArrayList;

/**
 * @author MyPC1
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private final RestaurantAdminDirectory restaurantAdminDirectory = new RestaurantAdminDirectory();
    private final CustomerDirectory customerDirectory = new CustomerDirectory();
    private final DeliveryManDirectory deliveryManDirectory = new DeliveryManDirectory();

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
        // networkList=new ArrayList<Network>();
    }

    public boolean checkIfUserIsUnique(String userName) {
        //
        return false;
    }

    public RestaurantAdminDirectory getRestaurantDirectory() {
        return restaurantAdminDirectory;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public DeliveryManDirectory getDeliveryManDirectory() {
        return deliveryManDirectory;
    }
}
