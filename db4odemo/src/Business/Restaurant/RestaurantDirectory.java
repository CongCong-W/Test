/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Employee.Employee;
import Business.UserAccount.UserAccountDirectory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author harold
 */
public class RestaurantDirectory {

    private final UserAccountDirectory userAccountDirectory;

    private final List<Restaurant> entityList = new ArrayList<>();

    public RestaurantDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public List<Restaurant> getEntityList() {
        return entityList;
    }

    public void insert(Restaurant entity) {
        if (entity == null) {
            return;
        }
        entityList.add(entity);
        userAccountDirectory.insert(entity);
    }

    public int update(Restaurant entity) {
        if (entity == null) {
            return -1;
        }
        int target = -1;
        for (int i = 0; i < entityList.size(); i++) {
            if (entityList.get(i).getEmployee().getId() == entity.getEmployee().getId()) {
                target = i;
            }
        }
        if (target < 0) {
            System.out.println("Update RestaurantAdmin failed: no such RestaurantAdmin");
            return target;
        }
        entityList.set(target, entity);
        userAccountDirectory.update(entity);
        System.out.println("Update RestaurantAdmin success: " + entity);
        return target;
    }

    public void delete(Restaurant entity) {
        entityList.remove(entity);
        userAccountDirectory.delete(entity);
        System.out.println("Delete RestaurantAdmin success:" + entity);
    }

    public Restaurant createEntity(String username, String password, Employee employee) {
        Restaurant entity = new Restaurant(username, password, employee);
        insert(entity);
        System.out.println("Create RestaurantAdmin success:" + entity);
        return entity;
    }
}
