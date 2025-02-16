 package com.Sudarshan.bank;
import java.sql.*;
import java.util.*;
import com.sudarshan1.db.*;
public class AccountDetial {
	int accNo;
    String name;
    int bal;
    String mobNo;
    String city;
    Scanner sc = new Scanner(System.in);

    void addUser() {
        try {
            System.out.println("Dear user please Enter Your Name:");
            name = sc.nextLine();
            System.out.println("Dear user please Enter Your Account No.:");
            accNo = Integer.parseInt(sc.nextLine());
            System.out.println("Enter mobile no:");
            mobNo = sc.nextLine();
            System.out.println("Enter city:");
            city = sc.nextLine();
            System.out.println("Dear user please Enter Amount:");
            bal = Integer.parseInt(sc.nextLine());
            if (bal < 0) {
                System.out.println("Invalid Balance, assigning balance=0...");
                bal = 0;
            }
            Connection con = ConnectData.dbCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO user (name, accNo, bal, mobNo, city) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setInt(2, accNo);
            ps.setInt(3, bal);
            ps.setString(4, mobNo);
            ps.setString(5, city);
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println(i + " record inserted...");
            } else {
                System.out.println("Failed to insert..");
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    void viewAllUser() {
        try {
            Connection con = ConnectData.dbCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("--------------------------------------");
                System.out.println("Name: " + rs.getString(1));
                System.out.println("Account No: " + rs.getInt(2));
                System.out.println("Balance: " + rs.getInt(3));
                System.out.println("Mobile No: " + rs.getString(4));
                System.out.println("City: " + rs.getString(5));
                System.out.println("--------------------------------------");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void viewUser() {
        try {
            Connection con = ConnectData.dbCon();
            System.out.println("Enter mobile no:");
            mobNo = sc.nextLine();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE mobNo=?");
            ps.setString(1, mobNo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("--------------------------------------");
                System.out.println("Name: " + rs.getString(1));
                System.out.println("Account No: " + rs.getInt(2));
                System.out.println("Balance: " + rs.getInt(3));
                System.out.println("Mobile No: " + rs.getString(4));
                System.out.println("City: " + rs.getString(5));
                System.out.println("--------------------------------------");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	

}
