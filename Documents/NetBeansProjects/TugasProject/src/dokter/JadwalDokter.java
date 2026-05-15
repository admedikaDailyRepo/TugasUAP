/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author Acer
 */
public class JadwalDokter extends javax.swing.JFrame implements ActionListener {

    private final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    List<String> jenisSpesialis;
    List<String> jenisDokter;
    List<String> jenisPoliklinik;
    /**
     * Creates new form DokterPoli
     */
    public JadwalDokter() {
        initComponents();
        jenisSpesialis = new ArrayList<>();
        jenisDokter = new ArrayList<>();
        jenisPoliklinik = new ArrayList<>();
        aktif();
        kosong();
        datatable();
       
    }
    
    protected void aktif(){}
    
    
    protected void datatable(){
        Object[] Baris = {"ID", "Dokter", "Poli", "Spesialis", "Status", "Hari", "Jam Masuk", "Jam Keluar","Max Quota", "Durasi(Menit)/Pasien"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem = txtcari.getText();

        try {
//            String sql = "SELECT * FROM dokter_poli where id like '%" + cariitem + "%' order by id asc";
            String sql = "SELECT " +
//               "dp.*, " +
               "dp.id, " +
               "d.nama, " +
               "p.nama, " +
               "s.nama, " +
               "dp.status, " +
               "dj.hari, " +
               "dj.jam_masuk, " +
               "dj.jam_keluar, " +
               "dj.max_quota, " +
               "dj.slot_duration_menit " +
               "FROM dokter_poli dp " +
               "JOIN dokter d ON dp.dokter_id = d.id " +
               "JOIN spesialis s ON dp.spesialis_id = s.id " +
               "JOIN poliklinik p ON dp.poli_id = p.id " +
               "JOIN dokter_jadwal dj ON dp.id = dj.dokter_poli_id";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);

            while (hasil.next()){
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                    hasil.getString(7),
                    hasil.getString(8),
                    hasil.getString(9),
                    hasil.getString(10)
                });
            }

            tblplgn.setModel(tabmode);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }
    }
    
    protected void kosong(){
        txtid.setText("");
        chkActive.setEnabled(false);
        chkActive.setSelected(true);
        
        jenisSpesialis.clear();
        jenisDokter.clear();
        jenisPoliklinik.clear();
                
        try {
            String sql = "SELECT * FROM spesialis";
            Statement stat = conn.createStatement();
            ResultSet hasilDokter = stat.executeQuery(sql);
            while (hasilDokter.next()){
                String strValue = hasilDokter.getString(2);
                System.out.println("strValue : " + strValue);
                jenisSpesialis.add(strValue);
            }
            cmbSpecialis.setModel(new javax.swing.DefaultComboBoxModel<>(
                jenisSpesialis.toArray(new String[0])
            ));
        
        } catch (SQLException e) {
            System.out.print("strValue : " + e);
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }

        try {
            String sql = "SELECT * FROM dokter";
            Statement stat = conn.createStatement();
            ResultSet hasilDokter = stat.executeQuery(sql);
            while (hasilDokter.next()){
                String strValue = hasilDokter.getString(2);
                jenisDokter.add(strValue);
            }
            cmbDokter.setModel(new javax.swing.DefaultComboBoxModel<>(
                jenisDokter.toArray(new String[0])
            ));
        } catch (SQLException e) {
            System.out.print("strValue : " + e);
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }
        
        try {
            String sql = "SELECT * FROM poliklinik";
            Statement stat = conn.createStatement();
            ResultSet hasilDokter = stat.executeQuery(sql);
            while (hasilDokter.next()){
                String strValue = hasilDokter.getString(2);
                jenisPoliklinik.add(strValue);
            }
            cmbPoli.setModel(new javax.swing.DefaultComboBoxModel<>(
                jenisPoliklinik.toArray(new String[0])
            ));
        } catch (SQLException e) {
            System.out.print("strValue : " + e);
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }
    }

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbDokter = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbSpecialis = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbPoli = new javax.swing.JComboBox<>();
        bsimpan = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bbatal = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblplgn = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        chkActive = new javax.swing.JCheckBox();
        chkSenin = new javax.swing.JCheckBox();
        chkSelasa = new javax.swing.JCheckBox();
        chkRabu = new javax.swing.JCheckBox();
        chkKamis = new javax.swing.JCheckBox();
        chkJumat = new javax.swing.JCheckBox();
        chkMinggu = new javax.swing.JCheckBox();
        chkSabtu = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        txtJamMasuk = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtJamKeluar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMaxQuota = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDurationPasien = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbDokter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Dokter :");

        jLabel2.setText("Spesialis :");

        cmbSpecialis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Poli :");

        cmbPoli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bbatal.setText("Batal");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        bubah.setText("Ubah");
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
            }
        });

        tblplgn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblplgn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblplgnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblplgn);

        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        txtid.setEditable(false);
        txtid.setEnabled(false);

        jLabel4.setText("ID");

        chkActive.setSelected(true);
        chkActive.setText("Status Aktif");

        chkSenin.setText("Senin");
        chkSenin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSeninActionPerformed(evt);
            }
        });

        chkSelasa.setText("Selasa");
        chkSelasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSelasaActionPerformed(evt);
            }
        });

        chkRabu.setText("Rabu");
        chkRabu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkRabuActionPerformed(evt);
            }
        });

        chkKamis.setText("Kamis");
        chkKamis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkKamisActionPerformed(evt);
            }
        });

        chkJumat.setText("Jumat");
        chkJumat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkJumatActionPerformed(evt);
            }
        });

        chkMinggu.setText("Minggu");
        chkMinggu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMingguActionPerformed(evt);
            }
        });

        chkSabtu.setText("Sabtu");
        chkSabtu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSabtuActionPerformed(evt);
            }
        });

        jLabel5.setText("Hari Praktik");

        jLabel6.setText("Jam Praktik");

        jLabel7.setText("-");

        txtMaxQuota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaxQuotaActionPerformed(evt);
            }
        });

        jLabel8.setText("Maksimal Kuota : ");

        txtDurationPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDurationPasienActionPerformed(evt);
            }
        });

        jLabel9.setText("Durasi Per Pasien : ");

        jLabel10.setText("/Menit");

        jLabel11.setText("Format (HH:mm:ss)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bcari))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bsimpan)
                                .addGap(2, 2, 2)
                                .addComponent(bubah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bhapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bbatal))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkSenin)
                                    .addComponent(chkJumat))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkSabtu)
                                    .addComponent(chkSelasa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkMinggu)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chkRabu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(chkKamis))))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbPoli, 0, 149, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                                            .addComponent(jLabel4))
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cmbSpecialis, javax.swing.GroupLayout.Alignment.LEADING, 0, 149, Short.MAX_VALUE)
                                            .addComponent(cmbDokter, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtid, javax.swing.GroupLayout.Alignment.LEADING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chkActive))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtJamMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaxQuota, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDurationPasien, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtJamKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSpecialis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPoli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkActive))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkSenin)
                    .addComponent(chkSelasa)
                    .addComponent(chkRabu)
                    .addComponent(chkKamis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkJumat)
                    .addComponent(chkMinggu)
                    .addComponent(chkSabtu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJamKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtJamMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaxQuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDurationPasien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan)
                    .addComponent(bhapus)
                    .addComponent(bbatal)
                    .addComponent(bubah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String sql = "insert into dokter_poli (dokter_id, poli_id, spesialis_id, status) values (?,?,?,?)";
        try{
            PreparedStatement stat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            String getSelectedDocter = cmbDokter.getSelectedItem().toString();
            String getSelectedPoli = cmbPoli.getSelectedItem().toString();
            String getSelectedSpes = cmbSpecialis.getSelectedItem().toString();
            int getDokterId;
            int getPoliId;
            int getSpecialisId;
            try {
                String sql2 = "SELECT * FROM dokter";
                Statement stat2 = conn.createStatement();
                ResultSet resSet = stat2.executeQuery(sql2);
                while (resSet.next()){
                    String strValue = resSet.getString(2);
                    if (getSelectedDocter.equals(strValue)) {
                        getDokterId = resSet.getInt(1);
                        stat.setInt(1, getDokterId);
                        break;
                    }
                }  
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
            }
            
            try {
                String sql2 = "SELECT * FROM poliklinik";
                Statement stat2 = conn.createStatement();
                ResultSet resSet = stat2.executeQuery(sql2);
                while (resSet.next()){
                    String strValue = resSet.getString(2);
                    if (getSelectedPoli.equals(strValue)) {
                        getPoliId = resSet.getInt(1);
                        stat.setInt(2, getPoliId);
                        break;
                    }
                }  
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
            }
                       
            try {
                String sql2 = "SELECT * FROM spesialis";
                Statement stat2 = conn.createStatement();
                ResultSet resSet = stat2.executeQuery(sql2);
                while (resSet.next()){
                    String strValue = resSet.getString(2);
                    if (getSelectedSpes.equals(strValue)) {
                        getSpecialisId = resSet.getInt(1);
                        stat.setInt(3, getSpecialisId);
                        break;
                    }
                }  
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
            }
            
            stat.setInt(4, chkActive.isSelected() ? 1 : 0);
            stat.executeUpdate();
            
            ResultSet rs = stat.getGeneratedKeys();

            if (rs.next()) {
                int idBaru = rs.getInt(1);
                java.sql.Time timeMasuk = java.sql.Time.valueOf(txtJamMasuk.getText());
                java.sql.Time timeKeluar = java.sql.Time.valueOf(txtJamKeluar.getText());

                String maxQuota = txtMaxQuota.getText();
                String durationPasien = txtDurationPasien.getText();
                List<JCheckBox> listCheckbox = Arrays.asList(
                    chkSenin,
                    chkSelasa,
                    chkRabu,
                    chkKamis,
                    chkJumat,
                    chkSabtu,
                    chkMinggu
                );
                for (JCheckBox cb : listCheckbox) {
                    if (cb.isSelected()) {
                        String sql2 = "insert into dokter_jadwal (dokter_poli_id , hari,jam_masuk, jam_keluar, max_quota, slot_duration_menit, is_active) values (?,?,?,?,?,?,?)";
                        PreparedStatement stat2 = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
                        stat2.setInt(1, idBaru);
                        stat2.setString(2, cb.getText());
                        stat2.setTime(3, timeMasuk);
                        stat2.setTime(4, timeKeluar);
                        stat2.setInt(5, Integer.parseInt(maxQuota));
                        stat2.setInt(6, Integer.parseInt(durationPasien));
                        stat2.setInt(7, 1);
                        stat2.executeUpdate();
                    }
                }

            }
            
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
            kosong();
            txtid.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
        }
        datatable();
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        try{
            String sqlDJ = "delete from dokter_jadwal where dokter_poli_id ='"+txtid.getText()+"'";
            PreparedStatement stat2 = conn.prepareStatement(sqlDJ);
            stat2.executeUpdate();
            kosong();
            txtid.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }
        
        try{
            String sqlDP = "delete from dokter_poli where id ='"+txtid.getText()+"'";
            PreparedStatement stat2 = conn.prepareStatement(sqlDP);
            stat2.executeUpdate();
            kosong();
            txtid.requestFocus();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bbatalActionPerformed

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        // TODO add your handling code here:
        int idLama = Integer.parseInt(txtid.getText());
        try{
            String sql = "update dokter_poli set dokter_id = ?, poli_id = ?, spesialis_id = ?, status =? where id = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            String getSelectedDocter = cmbDokter.getSelectedItem().toString();
            String getSelectedPoli = cmbPoli.getSelectedItem().toString();
            String getSelectedSpes = cmbSpecialis.getSelectedItem().toString();
            int getDokterId;
            int getPoliId;
            int getSpecialisId;
            try {
                String sql2 = "SELECT * FROM dokter";
                Statement stat2 = conn.createStatement();
                ResultSet resSet = stat2.executeQuery(sql2);
                while (resSet.next()){
                    String strValue = resSet.getString(2);
                    if (getSelectedDocter.equals(strValue)) {
                        getDokterId = resSet.getInt(1);
                        stat.setInt(1, getDokterId);
                        break;
                    }
                }  
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
            }
            
            try {
                String sql2 = "SELECT * FROM poliklinik";
                Statement stat2 = conn.createStatement();
                ResultSet resSet = stat2.executeQuery(sql2);
                while (resSet.next()){
                    String strValue = resSet.getString(2);
                    if (getSelectedPoli.equals(strValue)) {
                        getPoliId = resSet.getInt(1);
                        stat.setInt(2, getPoliId);
                        break;
                    }
                }  
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
            }
                       
            try {
                String sql2 = "SELECT * FROM spesialis";
                Statement stat2 = conn.createStatement();
                ResultSet resSet = stat2.executeQuery(sql2);
                while (resSet.next()){
                    String strValue = resSet.getString(2);
                    if (getSelectedSpes.equals(strValue)) {
                        getSpecialisId = resSet.getInt(1);
                        stat.setInt(3, getSpecialisId);
                        break;
                    }
                }  
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
            }
            
            stat.setInt(4, chkActive.isSelected() ? 1 : 0);
            stat.setInt(5, idLama);
            stat.executeUpdate();  
        } catch(Exception e) {
           JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
        }
        
        try{
            String sqlDJ = "delete from dokter_jadwal where dokter_poli_id ='"+txtid.getText()+"'";
            PreparedStatement stat2 = conn.prepareStatement(sqlDJ);
            stat2.executeUpdate();
            kosong();
            txtid.requestFocus();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal dihapus"+e);
        }

        try {
            java.sql.Time timeMasuk = java.sql.Time.valueOf(txtJamMasuk.getText());
            java.sql.Time timeKeluar = java.sql.Time.valueOf(txtJamKeluar.getText());

            String maxQuota = txtMaxQuota.getText();
            String durationPasien = txtDurationPasien.getText();
            List<JCheckBox> listCheckbox = Arrays.asList(
                chkSenin,
                chkSelasa,
                chkRabu,
                chkKamis,
                chkJumat,
                chkSabtu,
                chkMinggu
            );
            for (JCheckBox cb : listCheckbox) {
                if (cb.isSelected()) {
                    String sql2 = "insert into dokter_jadwal (dokter_poli_id , hari,jam_masuk, jam_keluar, max_quota, slot_duration_menit, is_active) values (?,?,?,?,?,?,?)";
                    PreparedStatement stat2 = conn.prepareStatement(sql2);
                    stat2.setInt(1, idLama);
                    stat2.setString(2, cb.getText());
                    stat2.setTime(3, timeMasuk);
                    stat2.setTime(4, timeKeluar);
                    stat2.setInt(5, Integer.parseInt(maxQuota));
                    stat2.setInt(6, Integer.parseInt(durationPasien));
                    stat2.setInt(7, 1);
                    stat2.executeUpdate();
                }
            }
        } catch(Exception e) {
           JOptionPane.showMessageDialog(null, "data gagal disimpan"+e);
        }
        datatable();
    }//GEN-LAST:event_bubahActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bcariActionPerformed

    private void tblplgnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblplgnMouseClicked
        int bar = tblplgn.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();

        String e = tabmode.getValueAt(bar, 6).toString();
        String f = tabmode.getValueAt(bar, 7).toString();
        String g = tabmode.getValueAt(bar, 8).toString();
        String h = tabmode.getValueAt(bar, 9).toString();
        
        txtJamMasuk.setText(e);
        txtJamKeluar.setText(f);
        txtMaxQuota.setText(g);
        txtDurationPasien.setText(h);
        
        txtid.setText(a);
        List<String> hasil = new ArrayList<>();
        hasil.add(a);

        try {
            jenisDokter.clear();
            String sql = "SELECT * FROM dokter";
            Statement stat = conn.createStatement();
            ResultSet hasilDokter = stat.executeQuery(sql);
            jenisDokter.add(b);
            while (hasilDokter.next()){
                String strValue = hasilDokter.getString(2);
                if (!strValue.contains(b)) {
                    jenisDokter.add(strValue);
                }
            }
            cmbDokter.setModel(new javax.swing.DefaultComboBoxModel<>(
                jenisDokter.toArray(new String[0])
            ));
        } catch (SQLException ex) {
            System.out.print("strValue : " + ex);
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }

        try {
            jenisPoliklinik.clear();
            String sql = "SELECT * FROM poliklinik";
            Statement stat = conn.createStatement();
            ResultSet hasilDokter = stat.executeQuery(sql);
            jenisPoliklinik.add(c);
            while (hasilDokter.next()){
            // equals
                String strValue = hasilDokter.getString(2);
                if (!strValue.contains(c)) {
                    jenisPoliklinik.add(strValue);
                }
            }
            cmbPoli.setModel(new javax.swing.DefaultComboBoxModel<>(
                jenisPoliklinik.toArray(new String[0])
            ));
        } catch (SQLException ex) {
            System.out.print("strValue : " + ex);
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }
        
        try {
            jenisSpesialis.clear();
            String sql = "SELECT * FROM spesialis";
            Statement stat = conn.createStatement();
            ResultSet hasilDokter = stat.executeQuery(sql);
            jenisSpesialis.add(d);
            while (hasilDokter.next()){
                String strValue = hasilDokter.getString(2);
                if (!strValue.contains(d)) {
                    jenisSpesialis.add(strValue);
                }
            }
            cmbSpecialis.setModel(new javax.swing.DefaultComboBoxModel<>(
                jenisSpesialis.toArray(new String[0])
            ));

        } catch (SQLException ex) {
            System.out.print("strValue : " + ex);
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }
        
        List<JCheckBox> listCheckbox = Arrays.asList(
            chkSenin,
            chkSelasa,
            chkRabu,
            chkKamis,
            chkJumat,
            chkSabtu,
            chkMinggu
        );
        
        try {
            String sql = "SELECT * FROM dokter_jadwal "
                       + "WHERE dokter_poli_id = ? "
                       + "AND jam_masuk = ? "
                       + "AND jam_keluar = ?";

            PreparedStatement stat = conn.prepareStatement(sql);
            java.sql.Time jamMasuk = java.sql.Time.valueOf(e);
            java.sql.Time jamKeluar = java.sql.Time.valueOf(f);
            
            stat.setInt(1, Integer.parseInt(txtid.getText()));
            stat.setTime(2, jamMasuk);
            stat.setTime(3, jamKeluar);

            ResultSet rs = stat.executeQuery();
            while (rs.next()){
                String strValue = rs.getString(3);
                for (JCheckBox cb : listCheckbox) {
                    if (cb.getText().equals(strValue)) {
                        cb.setSelected(true);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.print("strValue : " + ex);
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" + e);
        }
        
        // dokter_jadwal
        
        chkActive.setEnabled(true);
    }//GEN-LAST:event_tblplgnMouseClicked

    private void chkSeninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSeninActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkSeninActionPerformed

    private void chkSelasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSelasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkSelasaActionPerformed

    private void chkRabuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRabuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkRabuActionPerformed

    private void chkKamisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkKamisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkKamisActionPerformed

    private void chkJumatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkJumatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkJumatActionPerformed

    private void chkMingguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMingguActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkMingguActionPerformed

    private void chkSabtuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSabtuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkSabtuActionPerformed

    private void txtMaxQuotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaxQuotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaxQuotaActionPerformed

    private void txtDurationPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDurationPasienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDurationPasienActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JadwalDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JadwalDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JadwalDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JadwalDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JadwalDokter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.JCheckBox chkActive;
    private javax.swing.JCheckBox chkJumat;
    private javax.swing.JCheckBox chkKamis;
    private javax.swing.JCheckBox chkMinggu;
    private javax.swing.JCheckBox chkRabu;
    private javax.swing.JCheckBox chkSabtu;
    private javax.swing.JCheckBox chkSelasa;
    private javax.swing.JCheckBox chkSenin;
    private javax.swing.JComboBox<String> cmbDokter;
    private javax.swing.JComboBox<String> cmbPoli;
    private javax.swing.JComboBox<String> cmbSpecialis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblplgn;
    private javax.swing.JTextField txtDurationPasien;
    private javax.swing.JTextField txtJamKeluar;
    private javax.swing.JTextField txtJamMasuk;
    private javax.swing.JTextField txtMaxQuota;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
