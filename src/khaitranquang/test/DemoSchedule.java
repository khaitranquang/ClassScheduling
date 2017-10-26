package khaitranquang.test;

import java.util.ArrayList;

import khaitranquang.genetic.algorithm.GeneticAlgorithm;
import khaitranquang.genetic.algorithm.Population;
import khaitranquang.genetic.algorithm.Schedule;
import khaitranquang.genetic.model.ClassByBit;
import khaitranquang.genetic.model.Data;

public class DemoSchedule {
	public static void main(String[] args) {
		Data data = new Data();

		GeneticAlgorithm ga = new GeneticAlgorithm(data);
		Schedule schedule = new Schedule(data).initialize();
		System.out.println("Ban dau:  " + schedule.toString());
		
		schedule = ga.mutateSchedule(schedule);
		System.out.println("Dot bien: " + schedule.toString());
		
	}
	

}
