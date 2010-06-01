package cis406.contact;

import cis406.ComboBoxModel;
import cis406.ComboItem;
import cis406.Database;
import java.sql.ResultSet;
import java.awt.Color;
/**
 *
 * @author Mark Lenser
 */
public class EditPanel extends javax.swing.JPanel {

    Contact record = null;

    /** Creates new form AddContact */
    public EditPanel() {
        initComponents();
        //division();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCompanyTitle = new javax.swing.JLabel();
        lblCompany = new javax.swing.JLabel();
        cboCompany = new javax.swing.JComboBox();
        lblIndustryDivision = new javax.swing.JLabel();
        cboIndustry = new javax.swing.JComboBox();
        jSeparator = new javax.swing.JSeparator();
        lblContactTitle = new javax.swing.JLabel();
        lblFName = new javax.swing.JLabel();
        txtFName = new javax.swing.JFormattedTextField();
        lblLName = new javax.swing.JLabel();
        txtLName = new javax.swing.JFormattedTextField();
        lblStreet = new javax.swing.JLabel();
        txtStreet = new javax.swing.JFormattedTextField();
        lblZip = new javax.swing.JLabel();
        txtZip = new javax.swing.JFormattedTextField();
        lblCity = new javax.swing.JLabel();
        txtCity = new javax.swing.JFormattedTextField();
        lblState = new javax.swing.JLabel();
        cboState = new javax.swing.JComboBox();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JFormattedTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JFormattedTextField();
        lblPosition = new javax.swing.JLabel();
        txtPosition = new javax.swing.JFormattedTextField();
        lblCommMethod = new javax.swing.JLabel();
        cboCommMethod = new javax.swing.JComboBox();
        lblNotes = new javax.swing.JLabel();
        scpNotes = new javax.swing.JScrollPane();
        txaNotes = new javax.swing.JTextArea();

        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(681, 400));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getResourceMap(EditPanel.class);
        lblCompanyTitle.setFont(resourceMap.getFont("lblCompanyTitle.font")); // NOI18N
        lblCompanyTitle.setText(resourceMap.getString("lblCompanyTitle.text")); // NOI18N
        lblCompanyTitle.setName("lblCompanyTitle"); // NOI18N

        lblCompany.setText(resourceMap.getString("lblCompany.text")); // NOI18N
        lblCompany.setName("lblCompany"); // NOI18N

        cboCompany.setEditable(true);
        cboCompany.setModel(new cis406.ComboBoxModel("company", "name"));
        cboCompany.setName("cboCompany"); // NOI18N
        cboCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCompanyActionPerformed(evt);
            }
        });

        lblIndustryDivision.setText(resourceMap.getString("lblIndustryDivision.text")); // NOI18N
        lblIndustryDivision.setName("lblIndustryDivision"); // NOI18N

        cboIndustry.setEditable(true);
        cboIndustry.setModel(new cis406.ComboBoxModel("industry", "industry_name"));
        cboIndustry.setName("cboIndustry"); // NOI18N

        jSeparator.setName("jSeparator"); // NOI18N

        lblContactTitle.setFont(resourceMap.getFont("lblContactTitle.font")); // NOI18N
        lblContactTitle.setText(resourceMap.getString("lblContactTitle.text")); // NOI18N
        lblContactTitle.setName("lblContactTitle"); // NOI18N

        lblFName.setText(resourceMap.getString("lblFName.text")); // NOI18N
        lblFName.setName("lblFName"); // NOI18N

        txtFName.setText(resourceMap.getString("txtFName.text")); // NOI18N
        txtFName.setName("txtFName"); // NOI18N

        lblLName.setText(resourceMap.getString("lblLName.text")); // NOI18N
        lblLName.setName("lblLName"); // NOI18N

        txtLName.setText(resourceMap.getString("txtLName.text")); // NOI18N
        txtLName.setName("txtLName"); // NOI18N

        lblStreet.setText(resourceMap.getString("lblStreet.text")); // NOI18N
        lblStreet.setName("lblStreet"); // NOI18N

        txtStreet.setText(resourceMap.getString("txtStreet.text")); // NOI18N
        txtStreet.setName("txtStreet"); // NOI18N

        lblZip.setText(resourceMap.getString("lblZip.text")); // NOI18N
        lblZip.setName("lblZip"); // NOI18N

        try {
            txtZip.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtZip.setName("txtZip"); // NOI18N
        txtZip.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtZipFocusLost(evt);
            }
        });

        lblCity.setText(resourceMap.getString("lblCity.text")); // NOI18N
        lblCity.setName("lblCity"); // NOI18N

        txtCity.setText(resourceMap.getString("txtCity.text")); // NOI18N
        txtCity.setName("txtCity"); // NOI18N

        lblState.setText(resourceMap.getString("lblState.text")); // NOI18N
        lblState.setName("lblState"); // NOI18N

        cboState.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));
        cboState.setName("cboState"); // NOI18N

        lblEmail.setText(resourceMap.getString("lblEmail.text")); // NOI18N
        lblEmail.setName("lblEmail"); // NOI18N

        txtEmail.setText(resourceMap.getString("txtEmail.text")); // NOI18N
        txtEmail.setName("txtEmail"); // NOI18N

        lblPhone.setText(resourceMap.getString("lblPhone.text")); // NOI18N
        lblPhone.setName("lblPhone"); // NOI18N

        try {
            txtPhone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(###) ###-#### x ********")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPhone.setText(resourceMap.getString("txtPhone.text")); // NOI18N
        txtPhone.setName("txtPhone"); // NOI18N
        txtPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhoneFocusLost(evt);
            }
        });

        lblPosition.setText(resourceMap.getString("lblPosition.text")); // NOI18N
        lblPosition.setName("lblPosition"); // NOI18N

        txtPosition.setText(resourceMap.getString("txtPosition.text")); // NOI18N
        txtPosition.setName("txtPosition"); // NOI18N

        lblCommMethod.setText(resourceMap.getString("lblCommMethod.text")); // NOI18N
        lblCommMethod.setName("lblCommMethod"); // NOI18N

        cboCommMethod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Email", "Phone" }));
        cboCommMethod.setName("cboCommMethod"); // NOI18N

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCompanyTitle)
                    .addComponent(lblContactTitle)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblCompany)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblIndustryDivision)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cboIndustry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCity)
                            .addComponent(lblState)
                            .addComponent(lblPhone)
                            .addComponent(lblStreet)
                            .addComponent(lblZip)
                            .addComponent(lblFName)
                            .addComponent(lblEmail)
                            .addComponent(lblPosition)
                            .addComponent(lblCommMethod)
                            .addComponent(lblNotes))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboCommMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboState, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scpNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblLName)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtStreet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                                .addComponent(txtEmail)
                                                .addComponent(txtPosition, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                                .addComponent(txtCity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                                            .addGap(81, 81, 81))))
                                .addGap(45, 45, 45)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCompanyTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompany)
                    .addComponent(cboCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIndustryDivision)
                    .addComponent(cboIndustry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblContactTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFName)
                    .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLName)
                    .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStreet)
                    .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblZip)
                    .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCity)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblState)
                    .addComponent(cboState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosition)
                    .addComponent(txtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCommMethod)
                    .addComponent(cboCommMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNotes)
                    .addComponent(scpNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCompanyActionPerformed
        division();
}//GEN-LAST:event_cboCompanyActionPerformed

    private void txtZipFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtZipFocusLost
        String city = "";
        String state = "";
        String zipfield = txtZip.getText();
        Database db = new Database("Zip");
        db.and("ZIP", zipfield);
        try {
            ResultSet rs = db.select();
            while (rs.next()) {
                city = rs.getString("CITY");
                state = rs.getString("STATE");
            }
        } catch (Exception e) {
            System.out.println("Could not execute query");
            System.out.println(e.getMessage());
        }
        txtCity.setText(city);
        cboState.setSelectedItem(state);
    }//GEN-LAST:event_txtZipFocusLost

    private void txtPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhoneFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneFocusLost

    public void division() {
        String company = cboCompany.getSelectedItem().toString();

        if (company.equalsIgnoreCase("Cal Poly Pomona") ) {
            lblIndustryDivision.setText("Division:");
        } else {
            lblIndustryDivision.setText("Industry:");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboCommMethod;
    private javax.swing.JComboBox cboCompany;
    private javax.swing.JComboBox cboIndustry;
    private javax.swing.JComboBox cboState;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblCommMethod;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblCompanyTitle;
    private javax.swing.JLabel lblContactTitle;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblIndustryDivision;
    private javax.swing.JLabel lblLName;
    private javax.swing.JLabel lblNotes;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblState;
    private javax.swing.JLabel lblStreet;
    private javax.swing.JLabel lblZip;
    private javax.swing.JScrollPane scpNotes;
    private javax.swing.JTextArea txaNotes;
    private javax.swing.JFormattedTextField txtCity;
    private javax.swing.JFormattedTextField txtEmail;
    private javax.swing.JFormattedTextField txtFName;
    private javax.swing.JFormattedTextField txtLName;
    private javax.swing.JFormattedTextField txtPhone;
    private javax.swing.JFormattedTextField txtPosition;
    private javax.swing.JFormattedTextField txtStreet;
    private javax.swing.JFormattedTextField txtZip;
    // End of variables declaration//GEN-END:variables

    public void newContact() {
        record = new Contact();
        reset();
    }
    public boolean save() {
        Boolean success = true;

        Contact record = new Contact();
        // Saves the Industry if it's a new entry
        if (cboIndustry.getSelectedIndex() == -1) {
            Industry indust = new Industry(cboIndustry.getSelectedItem().toString());
            record.setIndustry_id(indust.save());
        } else {
            record.setIndustry_id(((ComboItem) cboIndustry.getSelectedItem()).id);
        }
        // Saves the Company if it's a new entry
        if (cboCompany.getSelectedIndex() == -1) {
            Company comp = new Company(cboCompany.getSelectedItem().toString());
            record.setCompany_id(comp.save());
        } else {
            record.setCompany_id(((ComboItem) cboCompany.getSelectedItem()).id);
        }
        
        String phonestr = (String)txtPhone.getText();
        String phone = phonestr.replaceAll( "\\D", "" );

        if (!record.setFname(txtFName.getText())) {
            lblFName.setForeground(Color.RED);
            success = false;
        } else {
            lblFName.setForeground(Color.BLACK);
        }
        if (!record.setLname(txtLName.getText())) {
            lblLName.setForeground(Color.RED);
            success = false;
        } else {
            lblLName.setForeground(Color.BLACK);
        }
        if (!record.setStreet(txtStreet.getText())) {
            lblStreet.setForeground(Color.RED);
            success = false;
        } else {
            lblStreet.setForeground(Color.BLACK);
        }
        if (!record.setZip((String)txtZip.getValue())) {
            lblZip.setForeground(Color.RED);
            success = false;
        } else {
            lblZip.setForeground(Color.BLACK);
        }
        if (!record.setCity(txtCity.getText())) {
            lblCity.setForeground(Color.RED);
            success = false;
        } else {
            lblCity.setForeground(Color.BLACK);
        }
        record.setState(cboState.getSelectedItem().toString());

        if (!record.setEmail(txtEmail.getText())) {
            lblEmail.setForeground(Color.RED);
            success = false;
        } else {
            lblEmail.setForeground(Color.BLACK);
        }
        if (!record.setPhone(phone)) {
            lblPhone.setForeground(Color.RED);
            success = false;
        } else {
            lblPhone.setForeground(Color.BLACK);
        }
        record.setPosition(txtPosition.getText());
        record.setComm_method(cboCommMethod.getSelectedIndex());
        record.setDescription(txaNotes.getText());
        record.save();

        cboCompany.setModel(new cis406.ComboBoxModel("company", "name"));
        cboIndustry.setModel(new cis406.ComboBoxModel("industry", "industry_name"));
        return success;
    }
    public void load(int id) {
        Contact data = new Contact(id);

        ((ComboBoxModel)cboCompany.getModel()).setSelectedId(data.getCompany_id());
        ((ComboBoxModel)cboIndustry.getModel()).setSelectedId(data.getIndustry_id());
        txtFName.setText(data.getFname());
        txtLName.setText(data.getLname());
        txtStreet.setText(data.getStreet());
        txtZip.setText(Integer.toString(data.getZip()));
        txtCity.setText(data.getCity());
        cboState.setSelectedItem(data.getState());
        txtEmail.setText(data.getEmail());
        txtPhone.setText(Integer.toString(data.getPhone()));
        txtPosition.setText(data.getPosition());
        txaNotes.setText(data.getDescription());
    }
    public void reset() {
        cboCompany.setSelectedIndex(0);
        cboIndustry.setSelectedIndex(0);
        txtFName.setText(null);
        txtLName.setText(null);
        txtStreet.setText(null);
        txtZip.setValue(null);
        txtCity.setText(null);
        cboState.setSelectedIndex(0);
        txtEmail.setText(null);
        txtPhone.setValue(null);
        txtPosition.setText(null);
        cboCommMethod.setSelectedIndex(0);
        txaNotes.setText(null);
    }
}