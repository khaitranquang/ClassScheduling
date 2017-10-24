package khaitranquang.test;

import java.util.ArrayList;

import khaitranquang.genetic.algorithm.Schedule;
import khaitranquang.genetic.model.ClassByBit;
import khaitranquang.genetic.model.Data;

public class DemoSchedule {
	public static void main(String[] args) {
		Data data = new Data();
//		//System.out.println(data.getNumberOfClasses());
//		for (int i = 0; i < 1; i++) {
//			ClassByBit classByBit = new ClassByBit(data);
//			System.out.println(classByBit.toString());
//		}
		
		
		
		Schedule schedule = new Schedule(data).initialize();
		//schedule.setData(data);
		khaitranquang.genetic.Schedule schedule2 = new khaitranquang.genetic.Schedule(new khaitranquang.genetic.Data()).initialize();
		System.out.println("Conflict " + schedule.getNumbOfConflicts());
//		ArrayList<ClassByBit> arr = schedule.getListClass();
//		System.out.println(arr.size());
//		System.out.println(schedule.toString());
//		System.out.println("Confict " + schedule.getNumbOfConfilcts());
		System.out.println("Fitness " + schedule.getFitness());
	}
}
