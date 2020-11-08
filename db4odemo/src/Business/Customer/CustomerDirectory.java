/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Employee.Employee;
import Business.UserAccount.UserAccountDirectory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author harold
 */
public class CustomerDirectory {

    private final UserAccountDirectory userAccountDirectory;

    private final List<Customer> entityList = new ArrayList<>();

    public CustomerDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public List<Customer> getEntityList() {
        return entityList;
    }

    public void insert(Customer entity) {
        if (entity == null) {
            return;
        }
        entityList.add(entity);
        userAccountDirectory.insert(entity);
    }

    public int update(Customer customer) {
        if (customer == null) {
            return -1;
        }
        int target = -1;
        for (int i = 0; i < entityList.size(); i++) {
            if (entityList.get(i).getEmployee().getId() == customer.getEmployee().getId()) {
                target = i;
            }
        }
        if (target < 0) {
            System.out.println("Update Customer failed: no such Customer");
            return target;
        }
        entityList.set(target, customer);
        userAccountDirectory.update(customer);
        System.out.println("Update Customer success: " + customer);
        return target;
    }

    public void delete(Customer entity) {
        entityList.remove(entity);
        userAccountDirectory.delete(entity);
        System.out.println("Delete Customer success:" + entity);
    }

    public Customer createEntity(String username, String password, Employee employee) {
        Customer entity = new Customer(username, password, employee);
        insert(entity);
        System.out.println("Create Customer success:" + entity);
        return entity;
    }
}
