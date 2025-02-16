package com.Sudarshan.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.sudarshan1.db.ConnectData;

public class AmountWithdraw extends AmountDeposite {
	void withdraw(){
		try{
		System.out.println("Enter Account No:");
		accNo=sc.nextInt();
		System.out.println("Enter amount you want to withdraw");
		int amount;
		Scanner sc= new Scanner (System.in);
		amount=sc.nextInt();
		if(amount<=bal && amount>=0){
			bal=bal-amount;
			System.out.println("Dear User:");
			Connection con= ConnectData.dbCon();
			PreparedStatement ps=con.prepareStatement("update user set bal=bal-? where accNo=? ");
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
			System.out.println("Please enter valid info");
		}
		}
		catch(Exception ex){
			System.out.println(ex);
			
		}
	}
}
