/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Employee.Employee;
import Business.Role.RestaurantAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author harold
 */
public class RestaurantAdmin extends UserAccount {

    public RestaurantAdmin() {
        super();
        this.setRole(new RestaurantAdminRole());
    }

    public RestaurantAdmin(String username, String password, Employee employee) {
        super();
        this.setUsername(username);
        this.setPassword(password);
        this.setEmployee(employee);
        this.setRole(new RestaurantAdminRole());
    }
}