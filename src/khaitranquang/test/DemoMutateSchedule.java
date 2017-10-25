package khaitranquang.test;

import khaitranquang.genetic.algorithm.GeneticAlgorithm;
import khaitranquang.genetic.algorithm.Schedule;
import khaitranquang.genetic.model.Data;

public class DemoMutateSchedule {
	public static void main(String[] args) {
		Data data = new Data();
//		Schedule schedule = new Schedule(data).initialize();
//		System.out.println(schedule.toString());
//		//System.out.println(schedule.getFitness());
//		
//		GeneticAlgorithm ga = new GeneticAlgorithm(data);
//		Schedule mutateSchedule = ga.mutateSchedule(schedule);
//		System.out.println(mutateSchedule.toString());
		//System.out.println(mutateSchedule.getFitness());
		
		Schedule schedule1 = new Schedule(data).initialize();
		Schedule schedule2 = new Schedule(data).initialize();
		System.out.println(schedule1.toString() +  "    " + schedule1.getFitness());
		System.out.println(schedule2.toString() +  "    " + schedule2.getFitness());
		
		System.out.println("");
		
		GeneticAlgorithm ga = new GeneticAlgorithm(data);
		Schedule crossover = ga.crossoverSchedule(schedule1, schedule2);
		System.out.println(crossover.toString() +  "    " + crossover.getFitness()) ;
	}
}
