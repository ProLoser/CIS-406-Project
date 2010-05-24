/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406;

import javax.swing.JOptionPane;

class SessionThread implements Runnable {

	Thread runner;
	public SessionThread() {
	}
	public SessionThread(String threadName) {
            runner = new Thread(this, threadName);
            runner.start();
	}
	public void run() {
            String[] config = Settings.load();

            try {
                while (true) {
                    if (Win32IdleTime.getIdleTimeMillisWin32() > Integer.parseInt(config[1]) * 60 * 1000) {
                        JOptionPane.showMessageDialog(null, "You have been automatically logged out due to inactivity!");
                        System.exit(0);
                    }
                    Thread.sleep(5 * 1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
	}
}