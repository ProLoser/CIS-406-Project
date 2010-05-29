/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
 *
 * @author Dean
 */
public class Printer implements Printable {

    private String header = "";
    private String footer = "";
    private String content = "";
    private int[] pageBreaks;  // array of page break line positions.

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * Used to print a simple string
     * @param content
     * @return Boolean success
     */
    public Boolean print(String content) {
        PrinterJob job = PrinterJob.getPrinterJob(); //Get the printer's job list
        job.setPrintable(this); //We print with this class (btnPrintAction, which implements Printable)
        if (job.printDialog() == true) { //If we clicked OK in the print dialog
            try {
                job.print();
                return true;
            } catch (PrinterException ex) {
                //It did not work (PrinterException thrown), so add any error handling routines.
                System.out.println("Failed to print");
                return false;
            }
        }
        return false;
    }

    /**
     * Internal function for printing String content
     * @param gx
     * @param pf
     * @param page
     * @return
     * @throws PrinterException
     */
    public int print(Graphics gx, PageFormat pf, int page) throws PrinterException {
        if (page > 0) {
            return NO_SUCH_PAGE;
        } //Only one page
        Graphics2D g = (Graphics2D) gx; //Cast to Graphics2D object
        g.translate(pf.getImageableX(), pf.getImageableY()); //Match origins to imageable area
        g.drawString(content, 0, 0); //Print Hello World at offset (100, 100)
        return PAGE_EXISTS; //Page exists (offsets start at zero!)
    }

    /**
     * Interal function for printing multiple lines using String[] textLines
     * @param g
     * @param pf
     * @param pageIndex
     * @return
     * @throws PrinterException
    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {

        Font font = new Font("Serif", Font.PLAIN, 10);
        FontMetrics metrics = g.getFontMetrics(font);
        int lineHeight = metrics.getHeight();

        if (pageBreaks == null) {
            initTextLines();
            int linesPerPage = (int) (pf.getImageableHeight() / lineHeight);
            int numBreaks = (textLines.length - 1) / linesPerPage;
            pageBreaks = new int[numBreaks];
            for (int b = 0; b < numBreaks; b++) {
                pageBreaks[b] = (b + 1) * linesPerPage;
            }
        }

        if (pageIndex > pageBreaks.length) {
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         * Since we are drawing text we
         /
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        /* Draw each line that is on this page.
         * Increment 'y' position by lineHeight for each line.
         /
        int y = 0;
        int start = (pageIndex == 0) ? 0 : pageBreaks[pageIndex - 1];
        int end = (pageIndex == pageBreaks.length)
                ? textLines.length : pageBreaks[pageIndex];
        for (int line = start; line < end; line++) {
            y += lineHeight;
            g.drawString(textLines[line], 0, y);
        }

        /* tell the caller that this page is part of the printed document /
        return PAGE_EXISTS;
    }
    */
}
