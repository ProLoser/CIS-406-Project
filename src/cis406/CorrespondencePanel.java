package cis406;
/**
 *
 * @author Mark Lenser
 */
public class CorrespondencePanel extends javax.swing.JPanel implements CisPanel {

    /** Creates new form CorrespondencePanel */
    public CorrespondencePanel() {
        initComponents();
        txtDate.setText(DateUtils.now());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblContact = new javax.swing.JLabel();
        cboContact = new javax.swing.JComboBox();
        lblType = new javax.swing.JLabel();
        cboType = new javax.swing.JComboBox();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JFormattedTextField();
        lblNotes = new javax.swing.JLabel();
        scpNotes = new javax.swing.JScrollPane();
        txaNotes = new javax.swing.JTextArea();

        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getResourceMap(CorrespondencePanel.class);
        lblContact.setText(resourceMap.getString("lblContact.text")); // NOI18N
        lblContact.setName("lblContact"); // NOI18N

        cboContact.setModel(new CisComboBox("contact", "last_name"));
        cboContact.setName("cboContact"); // NOI18N

        lblType.setText(resourceMap.getString("lblType.text")); // NOI18N
        lblType.setName("lblType"); // NOI18N

        cboType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Face to Face", "Email", "Phone", "Letter" }));
        cboType.setName("cboType"); // NOI18N

        lblDate.setText(resourceMap.getString("lblDate.text")); // NOI18N
        lblDate.setName("lblDate"); // NOI18N

        txtDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDate.setText(resourceMap.getString("txtDate.text")); // NOI18N
        txtDate.setName("txtDate"); // NOI18N

        lblNotes.setText(resourceMap.getString("lblNotes.text")); // NOI18N
        lblNotes.setName("lblNotes"); // NOI18N

        scpNotes.setName("scpNotes"); // NOI18N

        txaNotes.setColumns(20);
        txaNotes.setRows(5);
        txaNotes.setName("txaNotes"); // NOI18N
        scpNotes.setViewportView(txaNotes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblContact))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblType))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDate))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNotes)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboContact, javax.swing.GroupLayout.Alignment.LEADING, 0, 260, Short.MAX_VALUE)
                    .addComponent(cboType, javax.swing.GroupLayout.Alignment.LEADING, 0, 260, Short.MAX_VALUE)
                    .addComponent(scpNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContact)
                    .addComponent(cboContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblType))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDate))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNotes)
                    .addComponent(scpNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboContact;
    private javax.swing.JComboBox cboType;
    private javax.swing.JLabel lblContact;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblNotes;
    private javax.swing.JLabel lblType;
    private javax.swing.JScrollPane scpNotes;
    private javax.swing.JTextArea txaNotes;
    private javax.swing.JFormattedTextField txtDate;
    // End of variables declaration//GEN-END:variables

    public void clickNew() {
    }
    public void clickSave() {
        Correspondence record = new Correspondence();
        record.setContact_id(cboContact.getSelectedIndex());
        record.setType(cboType.getSelectedIndex());
        record.setDate(txtDate.getText());
        record.setNotes(txaNotes.getText());
        record.save();
    }
    public void clickLoad() {
    }
    public void clickDelete() {
    }
    public void clickClear() {
        txtDate.setText("mm/dd/yy");
        cboType.setSelectedIndex(0);
        txaNotes.setText("");
        cboContact.setSelectedIndex(0);
    }
    public void clickCancel() {
    }
    public void clickEditing() {
    }
    public void clickBrowsing() {
    }
    public void switchTo(String actionCommand) {
        cboContact.setModel(new CisComboBox("contact", "last_name"));
    }
    public void switchAway() {
    }
}
