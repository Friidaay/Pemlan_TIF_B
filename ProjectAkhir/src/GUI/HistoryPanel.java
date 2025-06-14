/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

/**
 *
 * @author ACER
 */
import Model.Activity;
import Model.DailyEntry;
import Model.Food;
import Model.User;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class HistoryPanel extends JPanel {

    private User currentUser;
    
    public HistoryPanel(User user) {
        this.currentUser = user;
        initComponents();
        lblHistoryOfUser.setText("Riwayat Kalori untuk " + currentUser.getNama());
    }
    
    public void setCurrentUser(User user) {
        this.currentUser = user;
        lblHistoryOfUser.setText("Riwayat Kalori untuk " + currentUser.getNama());
    }
    
    public void loadHistoryData() {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addColumn("Tanggal");
        model.addColumn("Kalori Awal");
        model.addColumn("Total Kalori Akhir");
        model.addColumn("Status Rekap");
        model.addColumn("Detail");

        List<DailyEntry> sortedEntries = new Vector<>(currentUser.getDailyEntries());
        Collections.sort(sortedEntries, Comparator.comparing(DailyEntry::getTanggal).reversed());

        for (DailyEntry entry : sortedEntries) {
            Vector<Object> row = new Vector<>();
            row.add(entry.getTanggal().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            row.add(entry.getKaloriAwal());
            row.add(entry.getTotalKaloriSaatIni());
            row.add(entry.isStatusSelesai() ? "Selesai" : "Belum Selesai");
            row.add("Lihat Detail");
            model.addRow(row);
        }
        tblHistory.setModel(model);

        tblHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tblHistory.rowAtPoint(evt.getPoint());
                int col = tblHistory.columnAtPoint(evt.getPoint());
                if (row >= 0 && col == 4) {
                    displayDailyDetails(sortedEntries.get(row));
                }
            }
        });
    }
    
    private void displayDailyDetails(DailyEntry entry) {
        StringBuilder details = new StringBuilder();
        details.append("Detail Kalori untuk Tanggal: ").append(entry.getTanggal().format(DateTimeFormatter.ofPattern("dd MMMM yyyy"))).append("\n\n");

        details.append("--- Makanan/Minuman ---\n");
        if (entry.getFoodLogs().isEmpty()) {
            details.append("Tidak ada entri makanan.\n");
        } else {
            for (Food food : entry.getFoodLogs()) {
                details.append("- ").append(food.getNamaMakanan())
                       .append(" (Kalori: ").append(food.getKaloriTambahan())
                       .append(", Waktu: ").append(food.getWaktuInput().format(DateTimeFormatter.ofPattern("HH:mm"))).append(")\n");
            }
        }

        details.append("\n--- Aktivitas ---\n");
        if (entry.getActivityLogs().isEmpty()) {
            details.append("Tidak ada entri aktivitas.\n");
        } else {
            for (Activity activity : entry.getActivityLogs()) {
                details.append("- ").append(activity.getNamaAktivitas())
                       .append(" (Terbakar: ").append(activity.getKaloriTerbakar())
                       .append(", Waktu: ").append(activity.getWaktuInput().format(DateTimeFormatter.ofPattern("HH:mm"))).append(")\n");
            }
        }
        JOptionPane.showMessageDialog(this, details.toString(), "Detail Harian", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblHistoryOfUser = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistory = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/document.png"))); // NOI18N
        jLabel1.setText("Riwayat Harian");

        lblHistoryOfUser.setBackground(new java.awt.Color(255, 255, 255));
        lblHistoryOfUser.setForeground(new java.awt.Color(255, 255, 255));
        lblHistoryOfUser.setText("Keterangan");

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        tblHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tanggal", "Kalori Awal", "Total Kalori Akhir", "Status", "Detail"
            }
        ));
        jScrollPane1.setViewportView(tblHistory);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/history.png"))); // NOI18N
        jLabel3.setText("Riwayat Kalori");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHistoryOfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHistoryOfUser)
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHistoryOfUser;
    private javax.swing.JTable tblHistory;
    // End of variables declaration//GEN-END:variables
}
