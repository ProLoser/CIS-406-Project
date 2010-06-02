/*
 * CIS406View.java
 */
package cis406;

import cis406.security.SecurityLog;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The application's main frame.
 */
public class MainView extends FrameView {

    private int activeTabIndex;
    // panels to remove based on security level of logged in user
    final String[] assistantPanels = {"Security"};
    final String[] coordinatorPanels = {"My Account"};
    final String[] adminPanels = {"My Account"};

    public MainView(SingleFrameApplication app, String username, int security_level) {
        super(app);

        initComponents();

        // remove tabs based on user security level
        setupTabs(security_level);

        // add security log entry for login
        SecurityLog.addEntry("User logged in.");

        activeTabIndex = mainTabbedPane.getSelectedIndex();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String) (evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer) (evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });

    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = MainApp.getApplication().getMainFrame();
            aboutBox = new AboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        MainApp.getApplication().show(aboutBox);
    }

    @Action
    public void backupDatabase() {
        jFileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int success = jFileChooser2.showOpenDialog(null);
        if (success == JFileChooser.APPROVE_OPTION) {
            Database.backupDatabase(Database.connect(), jFileChooser2.getSelectedFile().getAbsolutePath());
        }
    }

    @Action
    public void restoreDatabase() {
        int response = JOptionPane.showConfirmDialog(null, "Restoring the database will force this application to restart.  Continue?");
        System.out.println(response);
        if (response == 0) {
            JOptionPane.showMessageDialog(null, "Find and select the internshipdb folder, and then click 'Open'.  It should be inside of the 'INTERNSHIP DB BACKUP' folder created during backup.");
            jFileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int success = jFileChooser2.showOpenDialog(null);
            if (success == JFileChooser.APPROVE_OPTION) {
                try {
                    DriverManager.getConnection("jdbc:derby:internshipsdb;shutdown=true");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                Database.restoreDatabase(jFileChooser2.getSelectedFile().getAbsolutePath());

                JOptionPane.showMessageDialog(null, "Application is shutting down for database restore, please re-open it.");
                System.exit(0);
            }
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        mainToolBar = new javax.swing.JToolBar();
        newButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        mainTabbedPane = new javax.swing.JTabbedPane();
        internshipPanel1 = new cis406.internship.MainPanel();
        contactPanel1 = new cis406.contact.ContactPanel();
        correspondencePanel1 = new cis406.correspondence.CorrespondencePanel();
        securityPanel1 = new cis406.security.SecurityPanel();
        myAccountPanel1 = new cis406.security.MyAccountPanel();
        taskMainPanel1 = new cis406.student.TaskMainPanel();
        mainPanel1 = new cis406.student.MainPanel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        reportMenu = new javax.swing.JMenu();
        internshipSummaryMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        databaseMenu = new javax.swing.JMenu();
        backupMenuItem = new javax.swing.JMenuItem();
        restoreMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        activeViewButtonGroup = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();

        mainPanel.setName("mainPanel"); // NOI18N

        mainToolBar.setFloatable(false);
        mainToolBar.setRollover(true);
        mainToolBar.setName("mainToolBar"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getActionMap(MainView.class, this);
        newButton.setAction(actionMap.get("clickNew")); // NOI18N
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cis406.MainApp.class).getContext().getResourceMap(MainView.class);
        newButton.setIcon(resourceMap.getIcon("NewButton.icon")); // NOI18N
        newButton.setText(resourceMap.getString("NewButton.text")); // NOI18N
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        newButton.setName("NewButton"); // NOI18N
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mainToolBar.add(newButton);

        saveButton.setAction(actionMap.get("clickSave")); // NOI18N
        saveButton.setIcon(resourceMap.getIcon("SaveButton.icon")); // NOI18N
        saveButton.setText(resourceMap.getString("SaveButton.text")); // NOI18N
        saveButton.setFocusable(false);
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        saveButton.setName("SaveButton"); // NOI18N
        saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mainToolBar.add(saveButton);

        loadButton.setAction(actionMap.get("clickLoad")); // NOI18N
        loadButton.setIcon(resourceMap.getIcon("LoadButton.icon")); // NOI18N
        loadButton.setText(resourceMap.getString("LoadButton.text")); // NOI18N
        loadButton.setFocusable(false);
        loadButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        loadButton.setName("LoadButton"); // NOI18N
        loadButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mainToolBar.add(loadButton);

        deleteButton.setAction(actionMap.get("clickDelete")); // NOI18N
        deleteButton.setIcon(resourceMap.getIcon("DeleteButton.icon")); // NOI18N
        deleteButton.setText(resourceMap.getString("DeleteButton.text")); // NOI18N
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        deleteButton.setName("DeleteButton"); // NOI18N
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mainToolBar.add(deleteButton);

        resetButton.setAction(actionMap.get("clickClear")); // NOI18N
        resetButton.setIcon(resourceMap.getIcon("ClearButton.icon")); // NOI18N
        resetButton.setText(resourceMap.getString("ClearButton.text")); // NOI18N
        resetButton.setFocusable(false);
        resetButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        resetButton.setName("ClearButton"); // NOI18N
        resetButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mainToolBar.add(resetButton);

        cancelButton.setAction(actionMap.get("clickCancel")); // NOI18N
        cancelButton.setIcon(resourceMap.getIcon("cancelButton.icon")); // NOI18N
        cancelButton.setText(resourceMap.getString("cancelButton.text")); // NOI18N
        cancelButton.setFocusable(false);
        cancelButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mainToolBar.add(cancelButton);

        mainTabbedPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainTabbedPane.setName("jTabbedPane"); // NOI18N
        mainTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mainTabbedPaneStateChanged(evt);
            }
        });

        internshipPanel1.setName("internshipPanel1"); // NOI18N
        mainTabbedPane.addTab(resourceMap.getString("internshipPanel1.TabConstraints.tabTitle"), internshipPanel1); // NOI18N

        contactPanel1.setName("contactPanel1"); // NOI18N
        mainTabbedPane.addTab(resourceMap.getString("contactPanel1.TabConstraints.tabTitle"), contactPanel1); // NOI18N

        correspondencePanel1.setName("correspondencePanel1"); // NOI18N
        mainTabbedPane.addTab(resourceMap.getString("correspondencePanel1.TabConstraints.tabTitle"), correspondencePanel1); // NOI18N

        securityPanel1.setName("securityPanel1"); // NOI18N
        mainTabbedPane.addTab(resourceMap.getString("securityPanel1.TabConstraints.tabTitle"), securityPanel1); // NOI18N

        myAccountPanel1.setName("myAccountPanel1"); // NOI18N
        mainTabbedPane.addTab(resourceMap.getString("myAccountPanel1.TabConstraints.tabTitle"), myAccountPanel1); // NOI18N

        taskMainPanel1.setName("taskMainPanel1"); // NOI18N
        mainTabbedPane.addTab(resourceMap.getString("taskMainPanel1.TabConstraints.tabTitle"), taskMainPanel1); // NOI18N

        mainPanel1.setName("mainPanel1"); // NOI18N
        mainTabbedPane.addTab(resourceMap.getString("mainPanel1.TabConstraints.tabTitle"), mainPanel1); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(mainToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainTabbedPane.getAccessibleContext().setAccessibleName(resourceMap.getString("jTabbedPane.AccessibleContext.accessibleName")); // NOI18N

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N
        fileMenu.add(jSeparator1);

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        reportMenu.setText(resourceMap.getString("reportMenu.text")); // NOI18N
        reportMenu.setName("reportMenu"); // NOI18N

        internshipSummaryMenuItem.setAction(actionMap.get("printInternshipSummaryReport")); // NOI18N
        internshipSummaryMenuItem.setText(resourceMap.getString("internshipSummaryMenuItem.text")); // NOI18N
        internshipSummaryMenuItem.setName("internshipSummaryMenuItem"); // NOI18N
        reportMenu.add(internshipSummaryMenuItem);

        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        reportMenu.add(jMenuItem1);

        menuBar.add(reportMenu);

        databaseMenu.setText(resourceMap.getString("databaseMenu.text")); // NOI18N
        databaseMenu.setName("databaseMenu"); // NOI18N

        backupMenuItem.setAction(actionMap.get("backupDatabase")); // NOI18N
        backupMenuItem.setText(resourceMap.getString("backupMenuItem.text")); // NOI18N
        backupMenuItem.setName("backupMenuItem"); // NOI18N
        databaseMenu.add(backupMenuItem);

        restoreMenuItem.setAction(actionMap.get("restoreDatabase")); // NOI18N
        restoreMenuItem.setText(resourceMap.getString("restoreMenuItem.text")); // NOI18N
        restoreMenuItem.setName("restoreMenuItem"); // NOI18N
        databaseMenu.add(restoreMenuItem);

        menuBar.add(databaseMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 789, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jDialog1.setName("jDialog1"); // NOI18N

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jFileChooser1.setName("jFileChooser1"); // NOI18N

        jFileChooser2.setName("jFileChooser2"); // NOI18N

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void mainTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mainTabbedPaneStateChanged
        if (activeTabIndex != mainTabbedPane.getSelectedIndex()) {
            if (((PanelInterface) mainTabbedPane.getComponentAt(activeTabIndex)).switchAway()) {
                activeTabIndex = mainTabbedPane.getSelectedIndex();
                ((PanelInterface) mainTabbedPane.getSelectedComponent()).switchTo();
            } else {
                mainTabbedPane.setSelectedIndex(activeTabIndex);
            }
        }
}//GEN-LAST:event_mainTabbedPaneStateChanged

    /**
     * Removes tabs based on security level
     * @param security_level Integer representing security level
     */
    private void setupTabs(int security_level) {
        if (security_level == 1) {
            for (int i = 0; i < coordinatorPanels.length; i++) {
                mainTabbedPane.removeTabAt(mainTabbedPane.indexOfTab(coordinatorPanels[i]));
            }
            databaseMenu.setEnabled(false);
        } else if (security_level == 2) {
            for (int i = 0; i < assistantPanels.length; i++) {
                mainTabbedPane.removeTabAt(mainTabbedPane.indexOfTab(assistantPanels[i]));
            }
            databaseMenu.setEnabled(false);
        } else if (security_level == 0) {
            for (int i = 0; i < adminPanels.length; i++) {
                mainTabbedPane.removeTabAt(mainTabbedPane.indexOfTab(adminPanels[i]));
            }
            databaseMenu.setEnabled(true);
        }
    }

    @Action
    public void clickNew() {
        ((PanelInterface) mainTabbedPane.getSelectedComponent()).clickNew();
    }

    @Action
    public void clickSave() {
        ((PanelInterface) mainTabbedPane.getSelectedComponent()).clickSave();
    }

    @Action
    public void clickLoad() {
        ((PanelInterface) mainTabbedPane.getSelectedComponent()).clickLoad();
    }

    @Action
    public void clickDelete() {
        ((PanelInterface) mainTabbedPane.getSelectedComponent()).clickDelete();
    }

    @Action
    public void clickClear() {
        ((PanelInterface) mainTabbedPane.getSelectedComponent()).clickReset();
    }

    @Action
    public void clickCancel() {
        ((PanelInterface) mainTabbedPane.getSelectedComponent()).clickCancel();
    }

    @Action
    public void printInternshipSummaryReport() {
        cis406.internship.ReportDialog.load();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup activeViewButtonGroup;
    private javax.swing.JMenuItem backupMenuItem;
    private javax.swing.JButton cancelButton;
    private cis406.contact.ContactPanel contactPanel1;
    private cis406.correspondence.CorrespondencePanel correspondencePanel1;
    private javax.swing.JMenu databaseMenu;
    public javax.swing.JButton deleteButton;
    private cis406.internship.MainPanel internshipPanel1;
    private javax.swing.JMenuItem internshipSummaryMenuItem;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    public javax.swing.JButton loadButton;
    private javax.swing.JPanel mainPanel;
    private cis406.student.MainPanel mainPanel1;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JToolBar mainToolBar;
    private javax.swing.JMenuBar menuBar;
    private cis406.security.MyAccountPanel myAccountPanel1;
    public javax.swing.JButton newButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JMenu reportMenu;
    public javax.swing.JButton resetButton;
    private javax.swing.JMenuItem restoreMenuItem;
    public javax.swing.JButton saveButton;
    private cis406.security.SecurityPanel securityPanel1;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private cis406.student.TaskMainPanel taskMainPanel1;
    // End of variables declaration//GEN-END:variables
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private JDialog aboutBox;
}
