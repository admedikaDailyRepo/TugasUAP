/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;


public class USERID {
    private static String id_kasir; 
    private static String nm_kasir;
    
    public static void setUserLogin(String id, String nama) {
        id_kasir = id;
        nm_kasir = nama;
    }
    // Method buat ngambil ID di form Nota
    public static String getUserLogin() {
        return id_kasir;
    }
    public static String getNamaLogin() {
        return nm_kasir;
    }
}
