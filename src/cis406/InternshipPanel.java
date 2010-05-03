/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InternshipPanel.java
 *
 * Created on Apr 22, 2010, 6:03:34 AM
 */

package cis406;

import org.jdesktop.application.Action;

/**
 *
 * @author Dean Sofer
 */
public class InternshipPanel extends javax.swing.JPanel implements CisPanel {

    /** Creates new form InternshipPanel */
    public InternshipPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        titleLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextarea = new javax.swing.JTextArea();
        postedField = new javax.swing.JFormattedTextField();
        expiresField = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        attachmentField = new javax.swing.JTextField();
        titleField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        attachmentLabel = new javax.swing.JLabel();
        postedLabel = new javax.swing.JLabel();
        expiresLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        companyComboBox = new javax.swing.JComboBox();
        companyLabel = new javax.swing.JLabel();
        quantityField = new javax.swing.JFormattedTextField();

        jFileChooser1.setName("jFileChooser1"); // NOI18N

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getResourceMap(InternshipPanel.class);
        titleLabel.setText(resourceMap.getString("titleLabel.text")); // NOI18N
        titleLabel.setName("titleLabel"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        descriptionTextarea.setColumns(20);
        descriptionTextarea.setRows(5);
        descriptionTextarea.setName("descriptionTextArea"); // NOI18N
        jScrollPane1.setViewportView(descriptionTextarea);

        postedField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        postedField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        postedField.setText(resourceMap.getString("postedFTextField.text")); // NOI18N
        postedField.setName("postedFTextField"); // NOI18N

        expiresField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        expiresField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        expiresField.setText(resourceMap.getString("expiresFTextField.text")); // NOI18N
        expiresField.setName("expiresFTextField"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getActionMap(InternshipPanel.class, this);
        jButton1.setAction(actionMap.get("browse")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        attachmentField.setText(resourceMap.getString("attachmentTextField.text")); // NOI18N
        attachmentField.setEnabled(false);
        attachmentField.setName("attachmentTextField"); // NOI18N

        titleField.setText(resourceMap.getString("titleTextField.text")); // NOI18N
        titleField.setName("titleTextField"); // NOI18N

        descriptionLabel.setText(resourceMap.getString("descriptionLabel.text")); // NOI18N
        descriptionLabel.setName("descriptionLabel"); // NOI18N

        attachmentLabel.setText(resourceMap.getString("attachmentLabel.text")); // NOI18N
        attachmentLabel.setName("attachmentLabel"); // NOI18N

        postedLabel.setText(resourceMap.getString("postedLabel.text")); // NOI18N
        postedLabel.setName("postedLabel"); // NOI18N

        expiresLabel.setText(resourceMap.getString("expiresLabel.text")); // NOI18N
        expiresLabel.setName("expiresLabel"); // NOI18N

        quantityLabel.setText(resourceMap.getString("quantityLabel.text")); // NOI18N
        quantityLabel.setName("quantityLabel"); // NOI18N

        companyComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        companyComboBox.setName("companyComboBox"); // NOI18N

        companyLabel.setText(resourceMap.getString("companyLabel.text")); // NOI18N
        companyLabel.setName("companyLabel"); // NOI18N

        quantityField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        quantityField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantityField.setText(resourceMap.getString("quantityField.text")); // NOI18N
        quantityField.setName("quantityField"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(titleLabel)
                        .addGap(6, 6, 6)
                        .addComponent(titleField, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(quantityLabel)
                                .addComponent(descriptionLabel))
                            .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(attachmentLabel)
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(companyLabel)
                                    .addComponent(postedLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(postedField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                                .addComponent(expiresLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(expiresField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(attachmentField, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(companyComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 351, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(attachmentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attachmentLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expiresField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expiresLabel)
                    .addComponent(postedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postedLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(companyLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(descriptionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(quantityLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Action
    public void browse() {
        int success = jFileChooser1.showOpenDialog(this);
        if (success == jFileChooser1.APPROVE_OPTION) {
            attachmentField.setText(jFileChooser1.getSelectedFile().getAbsolutePath());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField attachmentField;
    private javax.swing.JLabel attachmentLabel;
    private javax.swing.JComboBox companyComboBox;
    private javax.swing.JLabel companyLabel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextArea descriptionTextarea;
    private javax.swing.JFormattedTextField expiresField;
    private javax.swing.JLabel expiresLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField postedField;
    private javax.swing.JLabel postedLabel;
    private javax.swing.JFormattedTextField quantityField;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables


    public void clickNew() {

    }

    public void clickSave() {
        Internship record = new Internship();
        record.setCompany_id(companyComboBox.getSelectedIndex());
        record.setTitle(titleField.getText());
        record.setDescription(descriptionTextarea.getText());
        record.setPost_date(postedField.getText());
        record.setExpiration(expiresField.getText());
        record.setQuantity(Integer.parseInt(quantityField.getText()));
        record.setAttachment(attachmentField.getText());
        record.save();
    }

    public void clickLoad() {

    }

    public void clickDelete() {

    }

    public void clickClear() {
        companyComboBox.setSelectedIndex(0);
        titleField.setText("");
        descriptionTextarea.setText("");
        postedField.setText("mm/dd/yy");
        expiresField.setText("mm/dd/yy");
        quantityField.setText("1");
        attachmentField.setText("");
    }

    public void reset() {

    }

}
