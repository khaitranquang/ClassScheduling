package khaitranquang.genetic.algorithm;

import java.util.ArrayList;
import java.util.stream.IntStream;


import khaitranquang.genetic.model.Data;

public class Population {
	private ArrayList<Schedule> listSchedule;
	
	public ArrayList<Schedule> getListSchedule() {
		return this.listSchedule;
	}
	
//	public Population(int size, Data data) {
//		this.listSchedule = new ArrayList<Schedule>(size);
//		// Initialize one schedule
//		Schedule chromosomeTemplate = new Schedule(data).initialize();
//		
//		// Get list Course with the order as the order of chromosomeTemplate
//		String[] listCouserOfTemplate = new String[chromosomeTemplate.getListClass().size()];
//		for (int i = 0; i < chromosomeTemplate.getListClass().size(); i++) {
//			listCouserOfTemplate[i] = chromosomeTemplate.getListClass().get(i).getCourseBit();
//		}
//		
//		// Initialize population and set course for all schedule
//		for (int i = 0; i < size; i++) {
//			Schedule chromosome = new Schedule(data).initialize();
//			for (int j = 0; j < chromosome.getListClass().size(); j++) {
//				chromosome.getListClass().get(j).setCourseBit(listCouserOfTemplate[j]);
//			}
//			this.listSchedule.add(chromosome);
//		}
//	}
	
	public Population (int size, Data data) {
		listSchedule = new ArrayList<Schedule>(size);
		IntStream.range(0, size).forEach(x -> listSchedule.add(new Schedule(data).initialize()));
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
//	@Override
//	public String toString() {
//		return "hihi";
//	}
}
