/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;

import Business.UserAccount.UserAccount;
import userinterface.RestaurantAdminRole.RestaurantAdminWorkAreaJPanel;

import javax.swing.JPanel;

/**
 * @author raunak
 */
public class RestaurantAdminRole extends Role {

    @Override
    public RoleType getRoleType() {
        return RoleType.RestaurantAdmin;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        return new RestaurantAdminWorkAreaJPanel(userProcessContainer, (Business.Restaurant.Restaurant) account, business);
    }
}