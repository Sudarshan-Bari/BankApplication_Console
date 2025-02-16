package com.Sudarshan.bank;

import java.util.Scanner;



public class Mian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			// TODO Auto-generated method stub
			AmountWithdraw obj= new AmountWithdraw();
			int choice;
			Scanner sc= new Scanner (System.in);
			System.out.println("--------- WELCOME TO DREAM BANK ----------");
			System.out.println();
			while(true)
			{
				System.out.println("************************");
				System.out.println("1.Add User");
				System.out.println("2.Deposite Amount");
				System.out.println("3.Withdraw Ammount");
				System.out.println("4.View User Selected");
				System.out.println("5.View All User ");
				System.out.println("6.Exit");
				System.out.println("************************");
				System.out.println("Enter your choice");
				choice=sc.nextInt();
				switch(choice){
				case 1:
					obj.addUser();
					break;
				case 2:
					obj.deposite();
					break;
				case 3:
					obj.withdraw();
					break;
				case 4:
					obj.viewUser();
					break;
				case 5:
					obj.viewAllUser();
				case 6:
					System.exit(0);
					break;
				default:
					System.out.println("Enter valid choice");
				}
			}
			}
			catch(Exception ex){
				System.out.println(ex);
				ex.printStackTrace(System.out);
			}
		System.out.println("------------ THANK YOU ------------");
		}


	}


