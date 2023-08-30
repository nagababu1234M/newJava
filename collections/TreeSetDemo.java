import java.util.*;
public class TreeSetDemo{
	public static void main(String args[]) {
	TreeSet t = new TreeSet();
    t.add(5);
    t.add(8);
    t.add(10);
    t.add(2);
    t.add(3);
    t.add(0);
    //t.add("a") getting error bcs trees set is not hetrogenious.strictly follow the type
    System.out.print(t);

	}
}