package com.sudarshan1.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectData {
	public static Connection con=null;
	public static Connection dbCon(){
		try{
				if(con==null){
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmy","root","");
				System.out.println("Connection Established...!!!");
	}
}
catch(Exception ex){
	ex.printStackTrace();
}
return con;
}

}
