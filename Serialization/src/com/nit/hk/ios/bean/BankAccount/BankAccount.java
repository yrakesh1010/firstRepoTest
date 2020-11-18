package com.nit.hk.ios.bean.BankAccount;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.Properties;

import com.nit.hk.ios.helper.AccTypeMap;

public class BankAccount implements Comparable<BankAccount>, Serializable {
	
	private static final long serialVersionUID=1L;
	
	private static String bankName;
	private static String branchName;
	private static String ifsc;
	
	private long accNum;
	private String accHName;
	private double balance;
	transient private String username;
	transient private String password;
	private String accType;
	
	static {
		try(
				//BufferedReader br=new BufferedReader(new FileReader("bankdetails.txt"));
				FileReader reader=new FileReader("src/bankdetails.properties");
			){
			Properties bankProperties=new Properties();
			bankProperties.load(reader);
			bankName=bankProperties.getProperty("BANK_NAME");
			branchName=bankProperties.getProperty("BRANCH_NAME");
			ifsc=bankProperties.getProperty("IFSC");
			System.out.println("BA SB is executed");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}//catch
	}//static catch
	
	public BankAccount() {
		System.out.println("BA NPC is executed");
	}
	
	public static String getBankName() {
		return bankName;
	}
	public static String getBranchName() {
		return branchName;
	}
	public static String getIfsc() {
		return ifsc;
	}
	public long getAccNum() {
		return accNum;
	}
	public String getAccHName() {
		return accHName;
	}
	public double getBalance() {
		return balance;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getAccType() {
		return accType;
	}
	public static void setBankName(String bankName) {
		BankAccount.bankName = bankName;
	}
	public static void setBranchName(String branchName) {
		BankAccount.branchName = branchName;
	}
	public static void setIfsc(String ifsc) {
		BankAccount.ifsc = ifsc;
	}
	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}
	public void setAccHName(String accHName) {
		this.accHName = accHName;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	
	@Override
	public int hashCode() {
		return AccTypeMap.getAccTypeID(accType);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BankAccount) {
			BankAccount acc=(BankAccount)obj;
			return this.accType.equals(acc.accType) && this.accNum==acc.accNum;
		}
		return false;
	}
	
	@Override
	public int compareTo(BankAccount acc) {
		int accTypeDiff=AccTypeMap.getAccTypeID(this.accType)-AccTypeMap.getAccTypeID(acc.accType);
		if(accTypeDiff==0) {
			 long accNumDiff = this.accNum-acc.accNum;
			 if(accNumDiff<0) {
				return -1;
			 }
			 else if(accNumDiff>0) {
				 return 1;
			 }
			 else {
				 return 0;
		     }
		}
	return accTypeDiff;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("\nBankName\t:"+bankName);
		sb.append("\nBranchName\t:"+branchName);
		sb.append("\nIFSC\t\t:"+ifsc);
		sb.append("\naccNum\t\t:"+accNum);
		sb.append("\naccHName\t:"+accHName);
		sb.append("\nbalance\t\t:"+balance);
		sb.append("\nusername\t:"+username);
		sb.append("\npassword\t:"+password);
		sb.append("\naccType\t\t:"+accType);
		return sb.toString();		
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		System.out.println("BankAccount.writeObject()");
		oos.defaultWriteObject();
		
		// Encode this value into Base6 
	     String usernameBase64Encoded = Base64.getEncoder().encodeToString(username.getBytes());
	     String passwordBase64Encoded = Base64.getEncoder().encodeToString(password.getBytes());
	     
	     oos.writeUTF(usernameBase64Encoded);
	     oos.writeUTF(passwordBase64Encoded);
	     
	     System.out.println();
	     System.out.println(username  + " --> " + usernameBase64Encoded);
	     System.out.println(password  + " \t--> " + passwordBase64Encoded);
	     System.out.println();
	}
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		System.out.println("BankAccount.readObject()");
		ois.defaultReadObject();
		
		username=ois.readUTF();
	    password=ois.readUTF();
	    
	    //Decode Base64 encoded value
		byte[] byteValueBase64Decodedusrname =Base64.getDecoder().decode(username);
		byte[] byteValueBase64Decodedpwd =Base64.getDecoder().decode(password);
		String usernameBase64Decoded = new String(byteValueBase64Decodedusrname); 
		String passwordBase64Decoded = new String(byteValueBase64Decodedpwd);
		System.out.println();
		System.out.println(username+" ---> "+usernameBase64Decoded);
		System.out.println(password+"\t ---> "+passwordBase64Decoded);
	}
}


