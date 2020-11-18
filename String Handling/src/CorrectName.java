import java.util.Scanner;

public class CorrectName {

	public static void main(String[] args) {
		String finalWord="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name:");
		String words=sc.nextLine();
		String[] word=words.split(" ");
		for(String newWord: word)
		finalWord=finalWord+newWord;
		System.out.println(finalWord);
	}

}
