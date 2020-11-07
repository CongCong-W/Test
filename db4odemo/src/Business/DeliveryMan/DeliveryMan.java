/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeliveryMan;

import Business.Employee.Employee;
import Business.Role.DeliverManRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author harold
 */
public class DeliveryMan extends UserAccount {

    public DeliveryMan() {
        super();
        this.setRole(new DeliverManRole());
    }

    public DeliveryMan(String username, String password, Employee employee) {
        super();
        this.setUsername(username);
        this.setPassword(password);
        this.setEmployee(employee);
        this.setRole(new DeliverManRole());
    }
}
