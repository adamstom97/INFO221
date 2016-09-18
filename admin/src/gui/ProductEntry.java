/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.Product;
import gui.helpers.SimpleListModel;
import java.awt.Window;
import javax.swing.JOptionPane;
import dao.DaoException;
import gui.helpers.ValidationHelper;
import dao.ProductDAO;

/**
 * A graphical user interface class for creating and saving a new product to be
 * added to the shop's inventory. When the save button is pressed, the new
 * product is created from the entered information, and passed to the
 * ProductList to be stored.
 *
 * @author adath325
 * @version 3.0
 */
public class ProductEntry extends javax.swing.JDialog {

    ProductDAO list;
    SimpleListModel productsForDisplay = new SimpleListModel();
    Product product = new Product();
    ValidationHelper vHelper = new ValidationHelper();

    /**
     * Creates new form ProductEntry
     *
     * @param parent the parent window that the form is created from
     * @param modal controls whether the form blocks access to its parent
     * @param list the dao class that the system is using
     */
    public ProductEntry(Window parent, boolean modal, ProductDAO list) {
        super(parent);
        setModal(modal);
        this.list = list;

        initComponents();
        boxCategory.setEditable(true);

        productsForDisplay.updateItems(list.getCategoryList());
        boxCategory.setModel(productsForDisplay);

        vHelper.addTypeFormatter(txtID, "#0", Integer.class);
        vHelper.addTypeFormatter(txtPrice, "#0.00", Double.class);
        vHelper.addTypeFormatter(txtQuantity, "#0", Integer.class);
    }

    /**
     * Creates new for ProductEntry to edit an existing product
     *
     * @param parent the parent window that the form is created from
     * @param modal controls whether the form blocks access to its parent
     * @param list the dao class that the system is using
     * @param product the product chosen to be edited
     */
    public ProductEntry(Window parent, boolean modal, ProductDAO list, 
            Product product) {
        this(parent, modal, list);
        this.product = product;

        txtID.setValue(product.getProductID());
        txtName.setText(product.getName());
        txtDescription.setText(product.getDescription());
        txtPrice.setValue(product.getPrice());
        txtQuantity.setValue(product.getQuantity());
        boxCategory.setSelectedItem(product.getCategory());

        txtID.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        pneDescription = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        lblCategory = new javax.swing.JLabel();
        boxCategory = new javax.swing.JComboBox<>();
        lblPrice = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        txtID = new javax.swing.JFormattedTextField();
        txtPrice = new javax.swing.JFormattedTextField();
        txtQuantity = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("entryDialog"); // NOI18N

        lblID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblID.setText("ID:");

        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("Name:");

        txtName.setName("txtName"); // NOI18N

        lblDescription.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDescription.setText("Description:");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        txtDescription.setName("txtDescription"); // NOI18N
        pneDescription.setViewportView(txtDescription);

        lblCategory.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCategory.setText("Category:");

        boxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxCategory.setName("boxCategory"); // NOI18N

        lblPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrice.setText("Price:");

        lblQuantity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQuantity.setText("Quantity in Stock:");

        btnSave.setText("Save");
        btnSave.setName("btnSave"); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.setName("btnCancel"); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Product Entry");

        txtID.setName("txtID"); // NOI18N

        txtPrice.setName("txtPrice"); // NOI18N

        txtQuantity.setName("txtQuantity"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName)
                            .addComponent(pneDescription)
                            .addComponent(boxCategory, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID)
                            .addComponent(txtPrice)
                            .addComponent(txtQuantity))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescription)
                    .addComponent(pneDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategory)
                    .addComponent(boxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantity)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if (txtID.isEditable()) {
                if (list.getProductByID(txtID.getText()) != null) {
                    JOptionPane.showMessageDialog(this, "There is already a "
                            + "product with that ID.", "ID Already Exists",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                product.setProductID((Integer) txtID.getValue());
            }

            product.setName(txtName.getText());
            product.setDescription(txtDescription.getText());
            product.setCategory((String) boxCategory.getSelectedItem());
            product.setPrice((Double) txtPrice.getValue());
            product.setQuantity((Integer) txtQuantity.getValue());

            if (vHelper.isObjectValid(product)) {
                list.addProduct(product);
                dispose();
            }
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "DAO Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCategory;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane pneDescription;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JFormattedTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JFormattedTextField txtPrice;
    private javax.swing.JFormattedTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
