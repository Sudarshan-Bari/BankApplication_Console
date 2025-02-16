package com.Sudarshan.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.sudarshan1.db.ConnectData;

public class AmountDeposite extends AccountDetial{
	void deposite(){
		try{
		int amount;
		System.out.println("Enter Account No:");
		accNo=Integer.parseInt(sc.nextLine());
		System.out.println("Enter amount you want to deposite:");
		Scanner sc= new Scanner (System.in);
		amount=Integer.parseInt(sc.nextLine());
		if (amount>0){
			bal=bal+amount;
			System.out.println("Dear User:");
			Connection con= ConnectData.dbCon();
			PreparedStatement ps=con.prepareStatement("update user set bal=bal+? where accNo=? ");
			ps.setInt(1,amount);
			ps.setInt(2,accNo);
			int i= ps.executeUpdate();
			if(i>0){
				System.out.println(i+"record inserted...");
			}
			else{
				System.out.println(i+"record not inserted...");
			}
		}
		else{
			System.out.println("Enter amount more than zero");
		}}
		catch (Exception ex){
			System.err.println(ex);
			
		}
			
		
	}

}
