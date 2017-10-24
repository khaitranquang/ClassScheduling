package khaitranquang.test;

import khaitranquang.genetic.model.ClassByBit;
import khaitranquang.genetic.model.Data;

public class DemoClassByBit {
	public static void main(String[] args) {
		Data data = new Data();
		ClassByBit classByBit = new ClassByBit(data);
		System.out.println(classByBit.toString());
	}
}
