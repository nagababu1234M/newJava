package Inheritence;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class FunctionalInterfaces_all {
	public static void main(String []args) {
		BiPredicate<Integer,String> bipredicate=(number,string)->{
			return number>5 && string.length()>10;
		};
		//predicates one element, bipredicates takes two elements
		System.out.println("Bipredicate "+ bipredicate.test(5,"nagabbau"));
		
		//Bifunction return type should mention
		BiFunction<Integer, String, String> biFunction = (number,str) -> {
			return number + " " + str;
		};
		
		System.out.println(biFunction.apply(15, "in28minutes"));
		
		BiConsumer<Integer, String> biConsumer = (s1,s2) -> {
			System.out.println(s1);
			System.out.println(s2);
		};
		
		biConsumer.accept(25, "in28Minutes");
	}

}
