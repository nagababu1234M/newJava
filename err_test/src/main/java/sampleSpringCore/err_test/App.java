package sampleSpringCore.err_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//      Car c=new Car();
//      c.drive();
//      Bike b=new Bike();
//      b.drive();
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	
//    	context.vehicle();
//    	Vehicle vc=(Vehicle)context.getBean("vehicle");
//    	vc.drive();
//    	Car car=(Car) context.getBean("car");
//    	car.drive();
//     	Tyre t =(Tyre) context.getBean("tyre");
//     	System.out.println(t);
    	Tyre tr=  (Tyre)context.getBean("tyre");
        System.out.println(tr);
     	Car car=(Car) context.getBean("car");
     	car.drive();
     	
    }
}
