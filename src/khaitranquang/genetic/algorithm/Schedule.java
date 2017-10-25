package khaitranquang.genetic.algorithm;
/*
 * This is a chromosome.
 */

import java.util.ArrayList;


import khaitranquang.genetic.model.ClassByBit;
import khaitranquang.genetic.model.Data;

public class Schedule {
	private ArrayList<ClassByBit> listClass;
	private boolean isFitnessChanged = true;
	private double fitness = -1;
	private int classNumb = 0;
	private int numbOfConflicts = 0;
	private Data data;
	
	public Data getData() {
		return data;
	}
	public void setData (Data data) {
		this.data = data;
	}
	
	public Schedule(Data data) {
		this.data = data;
		listClass = new ArrayList<ClassByBit>(data.getNumberOfClasses());
	}
	
	public Schedule initialize() {
		int size = data.getNumberOfClasses();
		for (int i = 0; i < size; i++) {
			ClassByBit aClass = new ClassByBit(data);
			listClass.add(aClass);
		}
		return this;
	}
	
	public int getNumbOfConflicts() {
		return this.numbOfConflicts;
	}
	
	public ArrayList<ClassByBit> getListClass () {
		isFitnessChanged = true;
		return listClass;
	}
	
	public double getFitness() {
		if (isFitnessChanged == true) {
			fitness = calculteFitness();
			isFitnessChanged = false;
		}
		return fitness;
	}
	
	private double calculteFitness() {
		numbOfConflicts = 0;
//		for(int i = 0; i < listClass.size(); i++) {
//			int indexRoom = Integer.parseInt(listClass.get(i).getRoomBit(), 2);
//			int seatingCapacity = data.getListRoom().get(indexRoom).getSeatingCapacity();
//			int indexCourse = Integer.parseInt(listClass.get(i).getCourseBit(), 2);
//			int maxNumbOfStudents = data.getListCourse().get(indexCourse).getMaxNumbOfStudents();
//			if (seatingCapacity > maxNumbOfStudents) numbOfConflicts++;
//			
//			for (int j = i+1; j < listClass.size(); j++) {
//				if (listClass.get(i).getMtBit().equals(listClass.get(j).getMtBit())) {
//					if (listClass.get(i).getRoomBit().equals(listClass.get(j).getRoomBit())) numbOfConflicts++;
//					if (listClass.get(i).getInstructorBit().equals(listClass.get(j).getInstructorBit())) numbOfConflicts++;
//				}
//			}
//		}
		listClass.forEach(x ->{
			int indexRoom = Integer.parseInt(x.getRoomBit(), 2);
			int seatingCapacity = data.getListRoom().get(indexRoom).getSeatingCapacity();
			int indexCourse = Integer.parseInt(x.getCourseBit(), 2);
			int maxNumbOfStudents = data.getListCourse().get(indexCourse).getMaxNumbOfStudents();
			if (seatingCapacity > maxNumbOfStudents) numbOfConflicts++;
			
			listClass.stream().filter(y -> listClass.indexOf(y) >= listClass.indexOf(x)).forEach(y -> {
				if (x.getCourseBit().equals(y.getCourseBit())) numbOfConflicts++;
				else if (x.getMtBit().equals(y.getMtBit()) && (!x.getCourseBit().equals(y.getCourseBit()))) {
					if(x.getRoomBit().equals(y.getRoomBit())) numbOfConflicts++;
					if(x.getInstructorBit().equals(y.getInstructorBit())) numbOfConflicts++;
				}
			});
		});
		
		return 1/ (double) (numbOfConflicts + 1);
	}

	@Override
	public String toString() {
		String chromosome = "";
		for (int i = 0; i < listClass.size(); i++) {
			chromosome += listClass.get(i).toString() + " ";
		}
		return chromosome;
	}
}
