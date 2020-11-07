/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeliveryMan;

import Business.Employee.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harold
 */
public class DeliveryManDirectory {

    private final List<DeliveryMan> entityList = new ArrayList<>();

    public List<DeliveryMan> getEntityList() {
        return entityList;
    }

    public void add(DeliveryMan entity){
        entityList.add(entity);
    }

    public DeliveryMan createEntity(String username, String password, Employee employee){
        DeliveryMan userAccount = new DeliveryMan(username, password, employee);
        entityList.add(userAccount);
        return userAccount;
    }
}
