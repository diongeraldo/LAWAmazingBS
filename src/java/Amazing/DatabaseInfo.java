/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazing;

import com.mysql.jdbc.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dion Geraldo
 */
public class DatabaseInfo {
    
    // Inisialisasi variabel yang diperlukan untuk koneksi DB
    public static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql:://localhost/books";
    public static final String DATABASE_USERNAME = "root";
    public static final String DATABASE_PASSWORD = "";
    
    // Inisialisasi variabel untuk mengontrol koneksi ke DB
    private Connection con = null;
    private Statement state = null;
    
    // Membuat method untuk melakukan koneksi ke database openConnection
    private void openConnection(){
        try {
            // Inisialisasi database driver
            Class.forName(DATABASE_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            state = (Statement) con.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            
        }
        
    }
    
    // Membuat method untuk menutup atau meyudahi koneksi ke database
    private void closeConnection(){
        // Cek apakah statement bernilai null atau tidak
        // Jika tidak null, ia akan menutup koneksi dimulai dr statementnya
        if(state != null){
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // Cek apakah variabel connection yang ada bernilai null atau tidak
        // Jika tidak null, maka koneksi akan langsung ditutup
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    // Method untuk mengambil semua buku yang ada di database dan di class buku
    // Akan mengembalikan sebuah ArrayList of buku yang berisi semua informasi yang
    // terkait dengan buku tersebut
    public ArrayList<Buku> getAllBooks(){
        // Membuat variabel untuk query yang akan dijalankan oleh DB
        String query = "SELECT * FROM buku;";
        
        // Inisialisasi ArrayList of buku untuk menyimpan data buku dari DB
        ArrayList<Buku> bookarray = new ArrayList<Buku>();
        
        try {
            // Mulai dengan openconnection
            openConnection();
            
            //Memasukkan hasil encarian query ke dalam sebuah set
            ResultSet resSet = state.executeQuery(query);
            
            // Iterasi untuk mengambil tiap elemen yang ada di set hasil, kemudian membuat sebuah objek
            // buku baru yang nantinya akan disimpan ke dalam ArrayList of buku
            while (resSet.next()){
                
                Buku b = new Buku(resSet.getInt("id"), resSet.getString("judul"), resSet.getString("pengarang"), resSet.getString("tahunterbit"), resSet.getString("jenis"));
                bookarray.add(b);
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInfo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnection();
        }
        return bookarray;
    }
    
    public int Update(String que){
        int res = 0;

        try {
            openConnection();
            res = state.executeUpdate(que);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    // Method untuk melakukan fungsi login atau masuk ek dalam suatu layanan
    public boolean login(String userName, String password){
        boolean in = false;
        String query = "SELECT COUNT(*) FROM akun WHERE username = '" + userName + "' AND password = '" + password + "';";
        
        try {
            openConnection();
            
            ResultSet res = state.executeQuery(query);
            while(res.next()){
                in = res.getInt(1) == 1? true : false;
            }
        } catch (Exception e) {
            
        } finally{
            closeConnection();
        }
        return in;
    }
}
