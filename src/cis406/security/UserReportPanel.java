/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SystemSettingsPanel.java
 *
 * Created on May 6, 2010, 7:40:42 PM
 */
package cis406.security;

import cis406.PanelInterface;
import cis406.TableModel;
import cis406.ComboBox;
import cis406.TableColumnAdjuster;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.ResultSet;
import org.jdesktop.application.Action;

/**
 *
 * @author qwerty
 */
public class UserReportPanel extends javax.swing.JPanel implements PanelInterface, Printable {

    /** Creates new form SystemSettingsPanel */
    public UserReportPanel() {
        initComponents();
        TableColumnAdjuster tca = new TableColumnAdjuster(userTable);
        tca.adjustColumns();
    }

    @Action
    public void printTable() {
        PrinterJob pj=PrinterJob.getPrinterJob();
        pj.setPrintable(this);
        pj.printDialog();
        try{ 
            pj.print();
        }catch (Exception PrintException) { System.out.println(PrintException.getMessage()); }
    }

    public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        int fontHeight = g2.getFontMetrics().getHeight();
        int fontDesent = g2.getFontMetrics().getDescent();

        //leave room for page number
        double pageHeight = pageFormat.getImageableHeight() - fontHeight;
        double pageWidth = pageFormat.getImageableWidth();
        double tableWidth = (double) userTable.getColumnModel().getTotalColumnWidth();
        double scale = 1;
        if (tableWidth >= pageWidth) {
            scale = pageWidth / tableWidth;
        }

        double headerHeightOnPage =  userTable.getTableHeader().getHeight() * scale;
        double tableWidthOnPage = tableWidth * scale;

        double oneRowHeight = (userTable.getRowHeight()  + userTable.getRowMargin()) * scale;
        int numRowsOnAPage =  (int) ((pageHeight - headerHeightOnPage) / oneRowHeight);
        double pageHeightForTable = oneRowHeight * numRowsOnAPage;
        int totalNumPages = (int) Math.ceil(((double) userTable.getRowCount()) / numRowsOnAPage);
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
            int numRowsLeft = userTable.getRowCount() - lastRowPrinted;
            g2.setClip(0, (int) (pageHeightForTable * pageIndex), (int) Math.ceil(tableWidthOnPage), (int) Math.ceil(oneRowHeight * numRowsLeft));
        } //else clip to the entire area available.
        else {
            g2.setClip(0, (int) (pageHeightForTable * pageIndex), (int) Math.ceil(tableWidthOnPage), (int) Math.ceil(pageHeightForTable));
        }

        g2.scale(scale, scale);
        userTable.paint(g2);
        g2.scale(1 / scale, 1 / scale);
        g2.translate(0f, pageIndex * pageHeightForTable);
        g2.translate(0f, -headerHeightOnPage);
        g2.setClip(0, 0, (int) Math.ceil(tableWidthOnPage), (int) Math.ceil(headerHeightOnPage));
        g2.scale(scale, scale);
        userTable.getTableHeader().paint(g2);
        //paint header at top

        return Printable.PAGE_EXISTS;
    }

    static public TableModel generateTable() {
        TableModel table = new TableModel(cis406.Database.execute("select * from users"));
        table.addDisplayField("user_name");
        table.addDisplayField("first_name");
        table.addDisplayField("last_name");
        table.addDisplayField("status");
        table.addDisplayField("clearance");
        table.addDisplayField("failed_logon_attempts");
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

    public void clickBrowsing() {
    }

    public void clickEditing() {
    }

    public void switchTo(String actionCommand) {
        userTable.setModel(generateTable());

        TableColumnAdjuster tca = new TableColumnAdjuster(userTable);
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

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();

        setName("Form"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getActionMap(UserReportPanel.class, this);
        jButton1.setAction(actionMap.get("printTable")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getResourceMap(UserReportPanel.class);
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        userTable.setModel(generateTable());
        userTable.setName("userTable"); // NOI18N
        jScrollPane1.setViewportView(userTable);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
