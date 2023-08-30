package Inheritence;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BehaverioalParametearization {
	public static void main(String args[]) {
		List<Integer> li= List.of(1,2,5,6,2,5,9,7);
		
		//basic examples
		Function<Integer, Integer> exampleMapMethod = x->x*x;
		//passing data(li), function as a perameter. 
		//i.e passing behavior of the function x->x*x
		List<Integer> outputOfMaps=functionBeha(li,exampleMapMethod);
		System.out.println(outputOfMaps);
		
		
		Predicate<Integer> PredicatorForEach = x->x%2==0;
		List<Integer> outputOfFilter=mapAndRefactor(li, PredicatorForEach);
		System.out.println(outputOfFilter);
	}



	private static List<Integer> mapAndRefactor(List<Integer> li, Predicate<Integer> PredicatorForloop) {
		return li.stream().filter(PredicatorForloop).collect(Collectors.toList());
	}
		
	

	private static List<Integer> functionBeha(List<Integer> li, Function<Integer, Integer> exampleMapMethod) {
		return li.stream().map(exampleMapMethod).collect(Collectors.toList());
	}
	

}
