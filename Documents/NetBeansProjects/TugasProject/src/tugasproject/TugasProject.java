/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasproject;

import dokter.Dokter;
import dokter.Poliklinik;
import dokter.Spesialis;
import javax.swing.JFrame;

/**
 *
 * @author WIN 10
 */
public class TugasProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        JFrame frame = new JFrame("Form Spesialis");

        FormOpsi panel = new FormOpsi(); // panggil class kamu
//        Barang panel = new Barang();
//        frame.setContentPane(panel);
        panel.setSize(925, 700); // sesuaikan ukuran
        panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLocationRelativeTo(null); // posisi tengah
        panel.setVisible(true);
    }
    
}
