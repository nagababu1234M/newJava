package sampleSpringCore.err_test;

import org.springframework.stereotype.Component;

@Component
public class Tyre {

//	public Tyre(String brand) {
//		super();
//		this.brand = brand;
//	}

	private String brand;

	@Override
	public String toString() {
		return "Tyre is running";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
