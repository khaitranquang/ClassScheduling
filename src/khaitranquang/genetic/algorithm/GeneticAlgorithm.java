package khaitranquang.genetic.algorithm;

import java.util.ArrayList;

import khaitranquang.genetic.model.ClassByBit;
import khaitranquang.genetic.model.Data;

public class GeneticAlgorithm {
	private Data data;
	
	public GeneticAlgorithm(Data data) {
		this.data = data;
	}
	
	/* Evolve */
	public Population evolve (Population population) {
		return mutatePopulation(crossoverPopulation(population));
	}
	
	/* -----------------------Crossover population -------------------------------*/
	Population crossoverPopulation (Population population) {
		Population crossoverPopulation = new Population (population.getListSchedule().size(), data);
		
		/* Reproduction */
		for (int i = 0; i < Main.NUMB_OF_ELITE_SCHUDELES; i++) {
			crossoverPopulation.getListSchedule().set(i, population.getListSchedule().get(i));
		}
		/* Crossover */
		for (int i = Main.NUMB_OF_ELITE_SCHUDELES; i < population.getListSchedule().size(); i++) {
			if (Main.CROSSOVER_RATE > Math.random()) {
				Schedule schedule1 = selectTournamentPopulation(population).sortByFitness().getListSchedule().get(0);
				Schedule schedule2 = selectTournamentPopulation(population).sortByFitness().getListSchedule().get(0);
				crossoverPopulation.getListSchedule().set(i, crossoverSchedule(schedule1, schedule2));
			}
			else {
				crossoverPopulation.getListSchedule().set(i, population.getListSchedule().get(i));
			}
		}
	
		return crossoverPopulation;
	}
	
	public Schedule crossoverSchedule(Schedule schedule1, Schedule schedule2) {
		Schedule crossoverSchedule = new Schedule(data).initialize();
		for (int i = 0; i < crossoverSchedule.getListClass().size(); i++) {
			if (Math.random() > 0.5) crossoverSchedule.getListClass().set(i, schedule1.getListClass().get(i));
			else crossoverSchedule.getListClass().set(i, schedule2.getListClass().get(i));
		}
		return crossoverSchedule;
	}
	
//	public Schedule crossoverSchedule(Schedule schedule1, Schedule schedule2) {
//		Schedule crossoverSchedule = new Schedule(data).initialize();
//		int randomPoint = (int) (Math.random() * (schedule1.getListClass().size() - 1));
//		for (int i = 0; i <= randomPoint; i++) {
//			crossoverSchedule.getListClass().set(i, schedule1.getListClass().get(i));
//		}
//		for (int i = randomPoint + 1; i < crossoverSchedule.getListClass().size(); i++) {
//			crossoverSchedule.getListClass().set(i, schedule2.getListClass().get(i));
//		}
//		
//		return crossoverSchedule;
//	}
	
	Population selectTournamentPopulation (Population population) {
		Population tournamentPopulation = new Population(Main.TOURNAMENT_SELECTION_SIZE, data);
		for (int i = 0; i < Main.TOURNAMENT_SELECTION_SIZE; i++) {
			tournamentPopulation.getListSchedule().set(i, 
									population.getListSchedule().get((int) (Math.random() * population.getListSchedule().size())));
		}
		return tournamentPopulation;
	}
	
	/*------------------------------- Mutating Population ---------------------------*/
	Population mutatePopulation (Population population) {
		Population mutatePopulation = new Population(population.getListSchedule().size(), data);
		ArrayList<Schedule> listSchedule = mutatePopulation.getListSchedule();
		
		/* Reproduction */
		for (int i = 0; i < Main.NUMB_OF_ELITE_SCHUDELES; i++) {
			listSchedule.set(i, population.getListSchedule().get(i));
		}
		/* Mutating */
		for (int i = Main.NUMB_OF_ELITE_SCHUDELES; i < population.getListSchedule().size(); i++) {
//			if (Main.MUTATION_RATE > Math.random()) {
//				listSchedule.set(i, mutateSchedule(population.getListSchedule().get(i)));
//			}
//			else {
//				listSchedule.set(i, population.getListSchedule().get(i));
//			}
			listSchedule.set(i, mutateSchedule(population.getListSchedule().get(i)));
		}
		return mutatePopulation;
	}
	
	Schedule mutateSchedule (Schedule mutateSchedule) {
		Schedule schedule = new Schedule(data).initialize();
		
		for (int i = 0; i < mutateSchedule.getListClass().size(); i++) {
			if (Main.MUTATION_RATE > Math.random()) mutateSchedule.getListClass().set(i, schedule.getListClass().get(i));
		}
		return mutateSchedule;
	}
//	public Schedule mutateSchedule (Schedule mutateSchedule) {
//		int numbOfClass = mutateSchedule.getListClass().size();
//		/* Get a random class */
//		int randomIndexClass   = (int) (Math.random() * numbOfClass);
//		ClassByBit randomClass = mutateSchedule.getListClass().get(randomIndexClass);
//		/* Get random property from randomClass (having 4 properties are: Room, Course, Instructor, Meeting Time )*/
//		int randomIndexProperty = (int) (Math.random() * 4);
//		String mutateStr = "";
//		if (randomIndexProperty == 0) mutateStr = randomClass.getRoomBit();
//		else if (randomIndexProperty == 1) mutateStr = randomClass.getCourseBit();
//		else if (randomIndexProperty == 2) mutateStr = randomClass.getInstructorBit();
//		else if (randomIndexProperty == 3) mutateStr = randomClass.getMtBit();
//		/* Inverting one randomly chosen bit from mutateStr */
//		String newStr = changeOneBitProperty(randomIndexProperty, mutateStr, data);
//		/* Re-Install class */
//		if (randomIndexProperty == 0) randomClass.setRoomBit(newStr);
//		else if (randomIndexProperty == 1) randomClass.setCourseBit(newStr);
//		else if (randomIndexProperty == 2) randomClass.setInstructorBit(newStr);
//		else if (randomIndexProperty == 3) randomClass.setMtBit(newStr);
//		
//		return mutateSchedule;
//	}
	
	/* Change one bit from a random property */
	private String changeOneBitProperty(int indexProperty, String mutateStr, Data data) {
		String newStr = "";
		int randomBit = (int) (Math.random() * mutateStr.length());
		if (mutateStr.charAt(randomBit) == '0') newStr = mutateStr.substring(0, randomBit) + "1" + mutateStr.substring(randomBit + 1);
		else if (mutateStr.charAt(randomBit) == '1') newStr = mutateStr.substring(0, randomBit) + "0" + mutateStr.substring(randomBit + 1);
		
		int newIndexOfProperty = Integer.parseInt(newStr, 2);
		if (indexProperty == 0) {
			int sizeOfListRoom = data.getListRoom().size();
			if (newIndexOfProperty >= sizeOfListRoom) return changeOneBitProperty(indexProperty, mutateStr, data);
		}
		else if (indexProperty == 1) {
			int sizeOfListCourse = data.getListCourse().size();
			if (newIndexOfProperty >= sizeOfListCourse) return changeOneBitProperty(indexProperty, mutateStr, data);
		}
		else if (indexProperty == 2) {
			int sizeOfListInstructor = data.getListInstructor().size();
			if (newIndexOfProperty >= sizeOfListInstructor) return changeOneBitProperty(indexProperty, mutateStr, data);
		}
		else if (indexProperty == 3) {
			int sizeOfListMT = data.getListMT().size();
			if (newIndexOfProperty >= sizeOfListMT) return changeOneBitProperty(indexProperty, mutateStr, data);
		}
		return newStr;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
