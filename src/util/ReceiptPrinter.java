package PosSystem.util;

import java.awt.*;
import java.awt.print.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

public class ReceiptPrinter implements Printable {

    private JTable table;
    private String receiptType;
    private String shopName = "Shop and Save";
    private String footer = "Thank you for shopping!";
    private String address = "Main Market, Hyderabad, Pakistan";
    private String dateAndTime;
    // 58mm printer safe width
    private static final int LINE_WIDTH = 32;
    private static final int NAME_WIDTH = 18; // product name width

    public ReceiptPrinter(JTable table, String receiptType, String dateAndTime) {
        this.table = table;
        this.receiptType = receiptType;
        this.dateAndTime = dateAndTime;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        if (pageIndex > 0) return NO_SUCH_PAGE;

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        g.setFont(new Font("Monospaced", Font.PLAIN, 8));

        int y = 20;

        // ===== Header =====
        g.drawString("=".repeat(LINE_WIDTH), 0, y);
        y += 15;
        g.drawString(centerText(shopName, LINE_WIDTH), 0, y);
        y += 15;
        g.drawString(centerText(receiptType, LINE_WIDTH), 0, y);
        y += 15;
        g.drawString(centerText(dateAndTime, LINE_WIDTH), 0, y);
        y += 15;
        g.drawString("=".repeat(LINE_WIDTH), 0, y);
        y += 15;

        g.drawString(String.format("%-18s %4s %7s", "Item", "Qty", "Total"), 0, y);
        y += 10;
        g.drawString("-".repeat(LINE_WIDTH), 0, y);
        y += 12;

        double grandTotal = 0;

        // ===== Items =====
        for (int i = 0; i < table.getRowCount(); i++) {
            String name = table.getValueAt(i, 0).toString().trim();
            int qty = Integer.parseInt(table.getValueAt(i, 1).toString());
            double price = Double.parseDouble(table.getValueAt(i, 2).toString());
            double total = qty * price;
            grandTotal += total;

            // Wrap item name safely
            List<String> wrappedLines = wrapTextByWord(name, NAME_WIDTH);

            // First line
            g.drawString(String.format("%-18s %4d %7.2f",
                    wrappedLines.get(0), qty, total), 0, y);
            y += 12;

            // Extra lines for wrapped text
            for (int j = 1; j < wrappedLines.size(); j++) {
                g.drawString("  " + wrappedLines.get(j), 0, y);
                y += 12;
            }

            // Second line showing price formula
            g.drawString(String.format("   x %.2f each", price), 0, y);
            y += 15;
        }

        // ===== Footer =====
        g.drawString("-".repeat(LINE_WIDTH), 0, y);
        y += 15;
        g.drawString(String.format("%-18s %11.2f", "Grand Total:", grandTotal), 0, y);
        y += 20;
        g.drawString("=".repeat(LINE_WIDTH), 0, y);
        y += 15;
        g.drawString(centerText(footer, LINE_WIDTH), 0, y);
        y += 15;

        // ===== Address Line =====
        g.drawString(centerText(address, LINE_WIDTH), 0, y);
        y += 10;

        return PAGE_EXISTS;
    }

    // ===== Helpers =====
    private String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(Math.max(0, padding)) + text;
    }

    private List<String> wrapTextByWord(String text, int maxWidth) {
        List<String> lines = new ArrayList<>();
        String[] words = text.split(" ");
        StringBuilder line = new StringBuilder();

        for (String word : words) {
            if (line.length() + word.length() + 1 > maxWidth) {
                lines.add(line.toString());
                line = new StringBuilder(word);
            } else {
                if (line.length() > 0) line.append(" ");
                line.append(word);
            }
        }
        if (line.length() > 0) lines.add(line.toString());
        return lines;
    }
}
