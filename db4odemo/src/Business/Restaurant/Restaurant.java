/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Employee.Employee;
import Business.Role.RestaurantAdminRole;
import Business.UserAccount.UserAccount;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harold
 */
public class Restaurant extends UserAccount {

    private List<MenuItem> menuItems = new ArrayList<>();

    public Restaurant() {
        super();
        this.setRole(new RestaurantAdminRole());
    }

    public Restaurant(String username, String password, Employee employee) {
        super();
        this.setUsername(username);
        this.setPassword(password);
        this.setEmployee(employee);
        this.setRole(new RestaurantAdminRole());
    }

    public List<MenuItem> getMenuItems() {
        if (menuItems == null) {
            menuItems = new ArrayList<>();
        }
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return getEmployee().getName();
    }
}