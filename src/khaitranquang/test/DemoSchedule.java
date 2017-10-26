package khaitranquang.test;

import java.util.ArrayList;

import khaitranquang.genetic.algorithm.Population;
import khaitranquang.genetic.algorithm.Schedule;
import khaitranquang.genetic.model.ClassByBit;
import khaitranquang.genetic.model.Data;

public class DemoSchedule {
	public static void main(String[] args) {
		Data data = new Data();

		
		
		
//		Schedule schedule = new Schedule(data).initialize();
//		System.out.println(schedule.toString());
//		String[] listCouserOfTemplate = new String[schedule.getListClass().size()];
//		for (int i = 0; i < schedule.getListClass().size(); i++) {
//			listCouserOfTemplate[i] = schedule.getListClass().get(i).getCourseBit();
//		}
//		for (int i =0; i < listCouserOfTemplate.length; i++) {
//			System.out.println(listCouserOfTemplate[i]);
//		}
//		
//		ArrayList<Schedule> listSchedule = new ArrayList<Schedule>();
//
//		Schedule copySchedule = new Schedule(data).initialize();
//		System.out.println(copySchedule.toString());
//		for (int i = 0; i < copySchedule.getListClass().size(); i++) {
//			copySchedule.getListClass().get(i).setCourseBit(listCouserOfTemplate[i]);
//		}
//		System.out.println(copySchedule.toString());
//	
//		
//		for (int i = 0; i < 4; i++) {
//			Schedule chromosome = new Schedule(data).initialize();
//			for (int j = 0; j < chromosome.getListClass().size(); j++) {
//				chromosome.getListClass().get(j).setCourseBit(listCouserOfTemplate[j]);
//			}
//			//System.out.println(chromosome.toString());
//			listSchedule.add(chromosome);
//		}
//		System.out.println("-----------------------");
//		for (int i = 0; i < 4; i++) {
//			System.out.println(listSchedule.get(i).toString());
//		}
//		
		
		System.out.println("-----------------------");
		Population population = new Population(4, data);
		for (int i = 0; i < 4; i++) {
			System.out.println(population.getListSchedule().get(i).toString());
		}
		
	}
	
//	public static Schedule copyCourse(Schedule chromosome, String[] listCouserOfTemplate) {
//		
//		return chromosome;
//	}
}
