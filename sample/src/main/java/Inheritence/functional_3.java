package Inheritence;

import java.util.List;
import java.util.function.Predicate;

public class functional_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> li=List.of(2,6,9,29,43,18,5,26);
		//Predicate<Integer> evenPredicate = x->x%2==0;
		FiletrAndPrint(li, x->x%2==0);
		
		//Predicate< Integer> oddPredicate = x->x%2!=0;
		FiletrAndPrint(li, x->x%2!=0);
		//passing bussiness logic as a parameters 
	}

	private static void FiletrAndPrint(List<Integer> li, Predicate<Integer> predicate) {
		li.stream() 
		.filter(predicate)
		.forEach(System.out::println);
	}

}
