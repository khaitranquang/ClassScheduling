package khaitranquang.genetic.algorithm;

import java.util.ArrayList;

import khaitranquang.genetic.model.Data;

public class Population {
	private ArrayList<Schedule> listSchedule;
	
	public ArrayList<Schedule> getListSchedule() {
		return this.listSchedule;
	}
	
	public Population(int size, Data data) {
		listSchedule = new ArrayList<Schedule>(size);
		for (int i = 0; i < size; i++) {
			Schedule chromosome = new Schedule(data).initialize();
			listSchedule.add(chromosome);
		}
	}
	
	public Population sortByFitness() {
		listSchedule.sort((schedule1, schedule2) -> {
			int returnValue = 0;
			if (schedule1.getFitness() > schedule2.getFitness()) returnValue = -1;
			else if (schedule1.getFitness() < schedule2.getFitness()) returnValue = 1;
			return returnValue;
		});
		return this;
	}
}
