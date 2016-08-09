/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import dao.ProductDB;
import domain.Product;
import gui.helpers.SimpleListModel;
import javax.swing.JOptionPane;

/**
 * A graphical user interface class for displaying all the products offered for
 * sale at the shop. The products are taken from the list stored in ProductList.
 * 
 * @author adath325
 * @version 1.0
 */
public class ProductDisplay extends javax.swing.JDialog {
    ProductDB list = new ProductDB();
    SimpleListModel productsForDisplay = new SimpleListModel();
    SimpleListModel categoriesForDisplay = new SimpleListModel();
    
    /**
     * Creates new form ProductDisplay
     * 
     * @param parent the jFrame that the form is created from
     * @param modal  controls whether the form blocks access to its parent
     */
    public ProductDisplay(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
               
        productsForDisplay.updateItems(list.getProductList());
        lstDisplay.setModel(productsForDisplay);  
        
        categoriesForDisplay.updateItems(list.getCategoryList());
        boxCategoryFilter.setModel(categoriesForDisplay);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pneDisplay = new javax.swing.JScrollPane();
        lstDisplay = new javax.swing.JList<>();
        btnExit = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblSearchID = new javax.swing.JLabel();
        lblCategoryFilter = new javax.swing.JLabel();
        txtSearchID = new javax.swing.JTextField();
        btnSearchID = new javax.swing.JButton();
        boxCategoryFilter = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pneDisplay.setViewportView(lstDisplay);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblSearchID.setText("Search by ID:");

        lblCategoryFilter.setText("Category Filter:");

        btnSearchID.setText("Search");
        btnSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchIDActionPerformed(evt);
            }
        });

        boxCategoryFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxCategoryFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCategoryFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pneDisplay)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCategoryFilter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSearchID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearchID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearchID))
                            .addComponent(boxCategoryFilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearchID)
                    .addComponent(txtSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoryFilter)
                    .addComponent(boxCategoryFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pneDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (lstDisplay.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a product to "
                    + "delete.", "No Product Selected",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            int result = JOptionPane.showConfirmDialog(this, "Are you sure you "
                    + "want to delete this product?");
            if (result == JOptionPane.YES_OPTION) {
                list.deleteProduct(lstDisplay.getSelectedValue());
                productsForDisplay.updateItems(list.getProductList());
                lstDisplay.setModel(productsForDisplay);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (lstDisplay.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a product to "
                    + "edit.", "No Product Selected",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            ProductEntry edit = new ProductEntry(this, true, 
                    lstDisplay.getSelectedValue());
            edit.setLocationRelativeTo(null);
            edit.setVisible(true);
            productsForDisplay.updateItems(list.getProductList());
            lstDisplay.setModel(productsForDisplay);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchIDActionPerformed
        if (txtSearchID.getText().isEmpty()) {
            productsForDisplay.updateItems(list.getProductList());
            lstDisplay.setModel(productsForDisplay);
            enableButtons();
        } else if (list.getProductByID(txtSearchID.getText()) == null) {
            productsForDisplay.updateItems("There is no product with that ID.");
            lstDisplay.setModel(productsForDisplay);
            btnEdit.setEnabled(false);
            btnDelete.setEnabled(false);
        } else {
            productsForDisplay.updateItems(list.getProductByID(txtSearchID.getText()));
            lstDisplay.setModel(productsForDisplay);
            enableButtons();
        }
    }//GEN-LAST:event_btnSearchIDActionPerformed

    private void boxCategoryFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCategoryFilterActionPerformed
        if (boxCategoryFilter.getSelectedItem() != null){
            productsForDisplay.updateItems(list.getProductsByCategory( 
                    boxCategoryFilter.getSelectedItem().toString()));
            lstDisplay.setModel(productsForDisplay);
            enableButtons();
        }           
    }
    
    private void enableButtons() {
        btnEdit.setEnabled(true);
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_boxCategoryFilterActionPerformed

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("Convert2Lambda")
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | 
                javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductDisplay.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ProductDisplay dialog = new ProductDisplay(
                        new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCategoryFilter;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearchID;
    private javax.swing.JLabel lblCategoryFilter;
    private javax.swing.JLabel lblSearchID;
    private javax.swing.JList<Product> lstDisplay;
    private javax.swing.JScrollPane pneDisplay;
    private javax.swing.JTextField txtSearchID;
    // End of variables declaration//GEN-END:variables
}
