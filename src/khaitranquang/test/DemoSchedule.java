package khaitranquang.test;

import java.util.ArrayList;

import khaitranquang.genetic.algorithm.Schedule;
import khaitranquang.genetic.model.Data;

public class DemoSchedule {
	public static void main(String[] args) {
		Data data = new Data();

		
		
		
		Schedule schedule = new Schedule(data).initialize();
		//schedule.setData(data);
		//khaitranquang.genetic.Schedule schedule2 = new khaitranquang.genetic.Schedule(new khaitranquang.genetic.Data()).initialize();
		System.out.println("Conflict " + schedule.getNumbOfConflicts());
		System.out.println("Fitness " + schedule.getFitness());
		
		
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		arr.add(0);
//		arr.add(1);
//		arr.add(2);
//		arr.add(3);
//		arr.add(4);
//		arr.add(5);
//		
//		arr.get
	}
}
