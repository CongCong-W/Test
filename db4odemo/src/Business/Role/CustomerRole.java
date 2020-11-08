/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Customer.Customer;
import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import userinterface.CustomerRole.CustomerWorkAreaJPanel;

import javax.swing.JPanel;

/**
 * @author raunak
 */
public class CustomerRole extends Role {

    @Override
    public RoleType getRoleType() {
        return RoleType.Customer;
    }

    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        return new CustomerWorkAreaJPanel(userProcessContainer, business, (Customer) account);
    }
}