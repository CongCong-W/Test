/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Employee.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harold
 */
public class RestaurantAdminDirectory {

    private final List<RestaurantAdmin> customerList = new ArrayList<>();

    public List<RestaurantAdmin> getEntityList() {
        return customerList;
    }

    public void add(RestaurantAdmin entity){
        customerList.add(entity);
    }

    public RestaurantAdmin createEntity(String username, String password, Employee employee){
        RestaurantAdmin userAccount = new RestaurantAdmin(username, password, employee);
        customerList.add(userAccount);
        return userAccount;
    }
}
