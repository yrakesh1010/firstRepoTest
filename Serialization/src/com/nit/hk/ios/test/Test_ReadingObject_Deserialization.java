package com.nit.hk.ios.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.nit.hk.ios.bean.BankAccount.BankAccount;

import java.io.FileInputStream;
public class Test_ReadingObject_Deserialization {
	public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("accountInfo.ser"));
		BankAccount acc=(BankAccount)ois.readObject();
		System.out.println(acc);
	}
}
