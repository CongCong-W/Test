/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Employee.Employee;
import Business.Role.CustomerRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author harold
 */
public class Customer extends UserAccount {

    public Customer() {
        super();
        this.setRole(new CustomerRole());
    }

    public Customer(String username, String password, Employee employee) {
        super();
        this.setUsername(username);
        this.setPassword(password);
        this.setEmployee(employee);
        this.setRole(new CustomerRole());
    }
}
