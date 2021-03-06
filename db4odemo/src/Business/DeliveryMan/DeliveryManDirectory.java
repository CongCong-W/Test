/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.DeliveryMan;

import Business.Employee.Employee;
import Business.UserAccount.UserAccountDirectory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author harold
 */
public class DeliveryManDirectory {

    private final UserAccountDirectory userAccountDirectory;

    private final List<DeliveryMan> entityList = new ArrayList<>();

    public DeliveryManDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public List<DeliveryMan> getEntityList() {
        entityList.removeIf(Objects::isNull);
        return entityList;
    }

    public void insert(DeliveryMan entity) {
        if (entity == null) {
            return;
        }
        entityList.add(entity);
        userAccountDirectory.insert(entity);
    }

    public int update(DeliveryMan entity) {
        if (entity == null) {
            return -1;
        }
        int target = -1;
        for (int i = 0; i < entityList.size(); i++) {
            if (entityList.get(i) == null) {
                continue;
            }
            if (entityList.get(i).getEmployee().getId() == entity.getEmployee().getId()) {
                target = i;
            }
        }
        if (target < 0) {
            System.out.println("Update DeliveryMan failed: no such DeliveryMan");
            return target;
        }
        entityList.set(target, entity);
        userAccountDirectory.update(entity);
        System.out.println("Update DeliveryMan success: " + entity);
        return target;
    }

    public void delete(DeliveryMan entity) {
        entityList.remove(entity);
        userAccountDirectory.delete(entity);
        System.out.println("Delete DeliveryMan success:" + entity);
    }

    public DeliveryMan createEntity(String username, String password, Employee employee) {
        DeliveryMan entity = new DeliveryMan(username, password, employee);
        insert(entity);
        System.out.println("Create DeliveryMan success:" + entity);
        return entity;
    }
}
