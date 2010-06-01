package cis406.security;

import cis406.PanelInterface;
import cis406.TableModel;
import cis406.ComboBoxModel;
import cis406.TableColumnAdjuster;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import org.jdesktop.application.Action;

public class SecurityLogPanel extends javax.swing.JPanel implements PanelInterface, Printable {

    /** Creates new form SystemSettingsPanel */
    public SecurityLogPanel() {
        initComponents();
        TableColumnAdjuster tca = new TableColumnAdjuster(logTable);
        tca.adjustColumns();
    }

    @Action
    public void showAllUsers() {
        logTable.setModel(generateTable());
        TableColumnAdjuster tca = new TableColumnAdjuster(logTable);
        tca.adjustColumns();
    }

    @Action
    public void printTable() {
        PrinterJob pj=PrinterJob.getPrinterJob();
        pj.setPrintable(this);
        if (pj.printDialog()){
            try{
                pj.print();
            }catch (Exception PrintException) { System.out.println(PrintException.getMessage()); }
        }
    }

    public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        int fontHeight = g2.getFontMetrics().getHeight();
        int fontDesent = g2.getFontMetrics().getDescent();

        //leave room for page number
        double pageHeight = pageFormat.getImageableHeight() - fontHeight;
        double pageWidth = pageFormat.getImageableWidth();
        double tableWidth = (double) logTable.getColumnModel().getTotalColumnWidth();
        double scale = 1;
        if (tableWidth >= pageWidth) {
            scale = pageWidth / tableWidth;
        }

        double headerHeightOnPage =  logTable.getTableHeader().getHeight() * scale;
        double tableWidthOnPage = tableWidth * scale;

        double oneRowHeight = (logTable.getRowHeight()  + logTable.getRowMargin()) * scale;
        int numRowsOnAPage =  (int) ((pageHeight - headerHeightOnPage) / oneRowHeight);
        double pageHeightForTable = oneRowHeight * numRowsOnAPage;
        int totalNumPages = (int) Math.ceil(((double) logTable.getRowCount()) / numRowsOnAPage);
        if (pageIndex >= totalNumPages) {
            return Printable.NO_SUCH_PAGE;
        }

        g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        //bottom center
        g2.drawString("Page: " + (pageIndex + 1), (int) pageWidth / 2 - 35, (int) (pageHeight + fontHeight - fontDesent));

        g2.translate(0f, headerHeightOnPage);
        g2.translate(0f, -pageIndex * pageHeightForTable);

        //If this piece of the table is smaller
        //than the size available,
        //clip to the appropriate bounds.
        if (pageIndex + 1 == totalNumPages) {
            int lastRowPrinted = numRowsOnAPage * pageIndex;
            int numRowsLeft = logTable.getRowCount() - lastRowPrinted;
            g2.setClip(0, (int) (pageHeightForTable * pageIndex), (int) Math.ceil(tableWidthOnPage), (int) Math.ceil(oneRowHeight * numRowsLeft));
        } //else clip to the entire area available.
        else {
            g2.setClip(0, (int) (pageHeightForTable * pageIndex), (int) Math.ceil(tableWidthOnPage), (int) Math.ceil(pageHeightForTable));
        }

        g2.scale(scale, scale);
        logTable.paint(g2);
        g2.scale(1 / scale, 1 / scale);
        g2.translate(0f, pageIndex * pageHeightForTable);
        g2.translate(0f, -headerHeightOnPage);
        g2.setClip(0, 0, (int) Math.ceil(tableWidthOnPage), (int) Math.ceil(headerHeightOnPage));
        g2.scale(scale, scale);
        logTable.getTableHeader().paint(g2);
        //paint header at top

        return Printable.PAGE_EXISTS;
    }

    static public TableModel generateTable() {
        TableModel table = new TableModel("user_log");
        table.addDisplayField("user_name");
        table.addDisplayField("date");
        table.addDisplayField("time");
        table.addDisplayField("description");
        return table.parseData();
    }

    public TableModel generateTableForUser(String username) {
        ResultSet rs = cis406.Database.execute("select * from user_log where user_name = '" + ddlUsers.getSelectedItem().toString() + "'");
        TableModel table = new TableModel(rs);
        table.addDisplayField("user_name");
        table.addDisplayField("date");
        table.addDisplayField("time");
        table.addDisplayField("description");
        return table.parseData();
    }

    public void clickNew() {
    }

    public void clickSave() {
    }

    public void clickLoad() {
    }

    public void clickDelete() {
    }

    public void clickReset() {
    }

    public void clickCancel() {
    }

    public void switchTo() {
        logTable.setModel(generateTable());

        TableColumnAdjuster tca = new TableColumnAdjuster(logTable);
        tca.adjustColumns();
    }

    public Boolean switchAway() {
        return true;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ddlUsers = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnViewAllUsers = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        logTable = new javax.swing.JTable();

        setName("Form"); // NOI18N

        ddlUsers.setModel(new ComboBoxModel("users", "user_name"));
        ddlUsers.setName("ddlUsers"); // NOI18N
        ddlUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddlUsersActionPerformed(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getResourceMap(SecurityLogPanel.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getActionMap(SecurityLogPanel.class, this);
        btnViewAllUsers.setAction(actionMap.get("showAllUsers")); // NOI18N
        btnViewAllUsers.setText(resourceMap.getString("btnViewAllUsers.text")); // NOI18N
        btnViewAllUsers.setName("btnViewAllUsers"); // NOI18N

        jButton1.setAction(actionMap.get("printTable")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        logTable.setModel(generateTable());
        logTable.setName("logTable"); // NOI18N
        jScrollPane1.setViewportView(logTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnViewAllUsers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ddlUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewAllUsers)
                    .addComponent(ddlUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ddlUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddlUsersActionPerformed
        logTable.setModel(generateTableForUser(cis406.MainApp.loginResult[1]));
        TableColumnAdjuster tca = new TableColumnAdjuster(logTable);
        tca.adjustColumns();
    }//GEN-LAST:event_ddlUsersActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnViewAllUsers;
    private javax.swing.JComboBox ddlUsers;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable logTable;
    // End of variables declaration//GEN-END:variables
}
