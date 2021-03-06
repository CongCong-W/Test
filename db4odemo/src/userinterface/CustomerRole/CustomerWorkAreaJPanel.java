

package userinterface.CustomerRole;


import Business.Customer.Customer;
import userinterface.RestaurantAdminRole.*;
import Business.EcoSystem;

import javax.swing.JPanel;
import java.awt.CardLayout;

/**
 *
 * @author  raunak
 */
public class CustomerWorkAreaJPanel extends javax.swing.JPanel {
    
    JPanel container;
    EcoSystem system;
    Customer customer;
    
    /** Creates new form AdminWorkAreaJPanel */
    public CustomerWorkAreaJPanel(JPanel container, EcoSystem system, Customer customer) {
        initComponents();
        this.container = container;
        this.customer = customer;
        this.system = system;
        valueLabel.setText(customer.getEmployee().getName());
    }

    public static void show(JPanel container, EcoSystem system, Customer customer) {
        CustomerWorkAreaJPanel customerWorkAreaJPanel = new CustomerWorkAreaJPanel(container, system, customer);
        container.add("CustomerWorkAreaJPanel", customerWorkAreaJPanel);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);
    }


    /**
     * Makes the component visible or invisible.
     * Overrides <code>Component.setVisible</code>.
     *
     * @param aFlag true to make the component visible; false to
     *              make it invisible
     *
     * @beaninfo attribute: visualUpdate true
     */
    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        valueLabel.setText(customer.getEmployee().getName());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnMngMenu = new javax.swing.JButton();
        btnMngOrder = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("My Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        btnMngMenu.setText("View Orders");
        btnMngMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngMenuActionPerformed(evt);
            }
        });
        add(btnMngMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 180, -1));

        btnMngOrder.setText("View Menu");
        btnMngOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngOrderActionPerformed(evt);
            }
        });
        add(btnMngOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 180, -1));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Customer:");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 120, 30));

        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnMngMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngMenuActionPerformed
        CustomerOrderJPanel.show(container, system, customer);
    }//GEN-LAST:event_btnMngMenuActionPerformed

    private void btnMngOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngOrderActionPerformed
        CustomerMenuJPanel.show(container, system, customer);
    }//GEN-LAST:event_btnMngOrderActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMngMenu;
    private javax.swing.JButton btnMngOrder;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
    
}
