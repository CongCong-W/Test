/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Restaurant.Restaurant;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;

import userinterface.DeliveryManRole.DeliveryManWorkAreaJPanel;

/**
 * @author harold
 */
public class DeliverManRole extends Role {

    @Override
    public RoleType getRoleType() {
        return RoleType.DeliveryMan;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        //To change body of generated methods, choose Tools | Templates.
        return new DeliveryManWorkAreaJPanel(userProcessContainer,account,business);
    }
}