package Inheritence;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Course{
	private String category;
	private int reviewScore;
	private int noOfStudents;
	private String name;
	
	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	@Override
	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}
	
}

public class CourcesCustomeClass {

	public static void main(String args[]) {
		List<Course> course=List.of(
				new Course("Spring","framework",98,20000),
				new Course("spring Boot","framework",92,18500),
				new Course("Microservices","Microservices",85,19200),
				new Course("Fullstack","Fullstack",79,20000),
				new Course("Aws","Cloud",100,17898),
				new Course("Azure","Cloud",92,28999),
				new Course("Docker","Cloud",90,22000),
				new Course("Kubernates","Cloud",82,24200),
				new Course("React","UI",82,16000),
				new Course("java","Backend",98,10500),
				new Course("Angular","UI",100,19789),
				new Course("Node","Backend",79,20000)
				);
		
//		course.stream().filter(x->x.getReviewScore()==98).forEach(System.out::println);
      // using comparator to sort the students values by using comparator.comparing 
		Comparator<Course> ComparingByNofStudentsIncreasing=
				Comparator.comparing(Course::getNoOfStudents);
		System.out.println(course.stream()
				.sorted(ComparingByNofStudentsIncreasing)
				.collect(Collectors.toList()));
		//output [java:10500:98, React:16000:82, Aws:17898:100, spring Boot:18500:92, Microservices:19200:85, Angular:19789:100, Spring:20000:98, Fullstack:20000:79, Node:20000:79, Docker:22000:90, Kubernates:24200:82, Azure:28999:92]

		//display nofstudens by decresing order
		Comparator<Course> ComparingByNofStudentsDecreasing=Comparator
				.comparing(Course::getNoOfStudents)
				.reversed();
		System.out.println(course.stream()
		.sorted(ComparingByNofStudentsDecreasing)
		.collect(Collectors.toList()));
		//output [Azure:28999:92, Kubernates:24200:82, Docker:22000:90, Spring:20000:98, Fullstack:20000:79, Node:20000:79, Angular:19789:100, Microservices:19200:85, spring Boot:18500:92, Aws:17898:100, React:16000:82, java:10500:98]
	
		//Display number of studets decresingorder
		//but when equl values of Nofstudents then comparing reviewScores
		Comparator<Course> ComparingByNofStudentsAndNofreviews=Comparator
				.comparingInt(Course::getNoOfStudents)
				 .thenComparing(Course::getReviewScore)
				  .reversed();
		
		System.out.println(course.stream()
				.sorted(ComparingByNofStudentsAndNofreviews)
				.limit(2)
				.skip(1)
				.collect(Collectors.toList()));
		//output [Azure:28999:92, Kubernates:24200:82, Docker:22000:90, Spring:20000:98, Fullstack:20000:79, Node:20000:79, Angular:19789:100, Microservices:19200:85, spring Boot:18500:92, Aws:17898:100, React:16000:82, java:10500:98]

		//Get Limit of 2 only
		System.out.println(course.stream()
				.sorted(ComparingByNofStudentsAndNofreviews)
				.limit(2)
				.collect(Collectors.toList()));
		//output [Azure:28999:92, Kubernates:24200:82]
		
		//Skip first  2 elements 
				System.out.println(course.stream()
						.sorted(ComparingByNofStudentsAndNofreviews)
						.skip(2)
						.collect(Collectors.toList()));
		//output [Docker:22000:90, Spring:20000:98, Fullstack:20000:79, Node:20000:79, Angular:19789:100, Microservices:19200:85, spring Boot:18500:92, Aws:17898:100, React:16000:82, java:10500:98]

		//Skip first  2 elements and get only 3 elemts
				System.out.println(course.stream()
						.sorted(ComparingByNofStudentsAndNofreviews)
						.skip(2)
						.limit(3)
						.collect(Collectors.toList()));
		//output [Docker:22000:90, Spring:20000:98, Fullstack:20000:79]
				


	   //Skip first  2 elements and get only 3 elemts
		 System.out.println(course.stream()
//			.filter(x->x.getReviewScore()>110)
			.max(ComparingByNofStudentsAndNofreviews)
			.orElse(new Course("Spring","framework",98,20000)));
		 
       //get the sum of nofstudents
		 System.out.println(course.stream()
					.filter(x->x.getReviewScore()>=90)
					.mapToInt(Course::getNoOfStudents)
					.sum());//137686
		 System.out.println(course.stream()
					.filter(x->x.getReviewScore()>=95)
					.mapToInt(Course::getNoOfStudents)
					.average());//OptionalDouble[17046.75]
		 System.out.println(course.stream()
					.filter(x->x.getReviewScore()>=90)
					.mapToInt(Course::getNoOfStudents)
					.max());//OptionalInt[28999]
		 System.out.println(course.stream()
					.filter(x->x.getReviewScore()>=90)
					.mapToInt(Course::getNoOfStudents)
					.count());//7
		 //using group by
		 System.out.println(course.stream()
					.collect(Collectors.groupingBy(Course::getCategory)));
		 //output {Backend=[java:10500:98, Node:20000:79], framework=[Spring:20000:98, spring Boot:18500:92], UI=[React:16000:82, Angular:19789:100], Cloud=[Aws:17898:100, Azure:28999:92, Docker:22000:90, Kubernates:24200:82], Fullstack=[Fullstack:20000:79], Microservices=[Microservices:19200:85]}
		 
		 // group with count nof category items 
		 System.out.println(course.stream()
					.collect(Collectors.groupingBy(Course::getCategory,
							Collectors.counting())));
		 //output {Backend=2, framework=2, UI=2, Cloud=4, Fullstack=1, Microservices=1}
        
		 // get the group by catagory with only max reviews score
		 System.out.println(course.stream()
					.collect(Collectors.groupingBy(Course::getCategory,
					Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		 //out put {Backend=Optional[java:10500:98], framework=Optional[Spring:20000:98], UI=Optional[Angular:19789:100], Cloud=Optional[Aws:17898:100], Fullstack=Optional[Fullstack:20000:79], Microservices=Optional[Microservices:19200:85]}
		 
		 //groupby catogiry with name of the courses
		 System.out.println(course.stream()
					.collect(Collectors.groupingBy(Course::getCategory,
					 Collectors.mapping(Course::getName, Collectors.toList()))));
		//output {Backend=[java, Node], framework=[Spring, spring Boot], UI=[React, Angular], Cloud=[Aws, Azure, Docker, Kubernates], Fullstack=[Fullstack], Microservices=[Microservices]}
	
		 //second largest elemet
		 System.out.println(course.stream()
					.collect(Collectors.groupingBy(Course::getCategory,
					 Collectors.mapping(Course::getName, Collectors.toList()))));
		 
	}

	
}
