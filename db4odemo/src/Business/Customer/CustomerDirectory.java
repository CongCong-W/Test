/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Employee.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harold
 */
public class CustomerDirectory {

    private final List<Customer> entityList = new ArrayList<>();

    public List<Customer> getEntityList() {
        return entityList;
    }

    public void add(Customer entity){
        entityList.add(entity);
    }

    public Customer createEntity(String username, String password, Employee employee){
        Customer userAccount = new Customer(username, password, employee);
        entityList.add(userAccount);
        return userAccount;
    }
}
