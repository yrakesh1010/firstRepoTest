package com.nit.hk.ios.test;
import java.io.*;

import com.nit.hk.ios.bean.BankAccount.*;;
public class Test_WritingObject_Serialization {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		BankAccount acc1=new BankAccount();
		System.out.println(acc1);
		
		acc1.setBankName("ICICI");
		acc1.setBranchName("SRNagar");
		acc1.setBankName("IC987SR");
		acc1.setAccNum(1234);
		acc1.setAccHName("HK");
		acc1.setBalance(10000);
		acc1.setUsername("hari");
		acc1.setPassword("nit");
		acc1.setAccType("savings");
		System.out.println(acc1);
		
		//Serialization starts
		System.out.println("\nSerialization started");
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("accountInfo.ser"));
		oos.writeObject(acc1);
		System.out.println("Serialization End");
		System.out.println("acc object state is saved in file sucessfully");
		
	}

}
