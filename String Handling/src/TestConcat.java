import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.RandomAccess;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class TestConcat implements RandomAccess {

	public static void main(String[] args) {
		String s1="abc";
		String s2="a"+"b"+"c";
		String s3="a".concat("b").concat("c");
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		
		
		//AbstractCollection<Object> 
        //abs = new LinkedHashSet<Object>(); 
		TreeSet abs=new TreeSet();
		abs.add(null);
		//abs.add(null);
		abs.add(10);
		abs.add(12);
		abs.add(13);
		System.out.println(abs);
		
	}

}
