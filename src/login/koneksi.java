/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author lutfi
 */
public class koneksi {

        private static java.sql.Connection koneksi;
        
        public static java.sql.Connection getkoneksi() {
            if (koneksi == null){
                try{
                    String url = "jdbc:mysql://localhost:3306/login";
                    String user = "root";
                    String password = "";
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    koneksi = DriverManager.getConnection(url, user, password);
                    System.out.println("Connection Sucssessfully");
                }catch (Exception e){
                    System.out.println("Eror");
                }
                try{koneksi = DriverManager.getConnection("jdbc:mysql://localhost/datamahasiswa","root","");
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Koneksi Database Gagal");
        }
            }
            return koneksi;
        } 
        public static void main(String[] args){
        getkoneksi();
    }
    }
   