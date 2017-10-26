package khaitranquang.genetic.algorithm;

import java.util.ArrayList;

import khaitranquang.genetic.model.ClassByBit;
import khaitranquang.genetic.model.Course;
import khaitranquang.genetic.model.Data;
import khaitranquang.genetic.model.Department;

public class Main {
	public static final int POPULATION_SIZE = 9;
	public static final double MUTATION_RATE = 0.1;
	public static final double CROSSOVER_RATE = 0.9;
	public static final int TOURNAMENT_SELECTION_SIZE = 3;
	public static final int NUMB_OF_ELITE_SCHUDELES = 1;
	private int scheduleNumb = 0;
	private int classNumb = 1;
	private Data data;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.data = new Data();
		int generationNumber = 0;
		main.printAvailableData();
		
		System.out.println("> Generation # " + generationNumber);
		System.out.print("Schedule # |   ");
		System.out.print("        Classes [dept, class, room, instructor, meeting-time]  ");
		System.out.println("       |  Fitness  | Conflicts");
		System.out.print("-----------------------------------------------------");
		System.out.println("--------------------------------------------------------");
		
		GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(main.data);
		Population population = new Population (Main.POPULATION_SIZE, main.data).sortByFitness();
		population.getListSchedule().forEach(schedule -> {
			System.out.println("     " + main.scheduleNumb++ + "     | " + schedule.toString() + "  |  " +
							   String.format("%.5f", schedule.getFitness()) + "  |   " + schedule.getNumbOfConflicts());
		});
		
		
		
		main.printScheduleAsTable(population.getListSchedule().get(0), generationNumber);
		
		main.classNumb = 1;
		while (population.getListSchedule().get(0).getFitness() != 1.0) {
			System.out.println("> Generation # " + ++generationNumber);
			System.out.print("Schedule # |   ");
			System.out.print("        Classes [dept, class, room, instructor, meeting-time]  ");
			System.out.println("       |  Fitness  | Conflicts");
			System.out.print("-----------------------------------------------------");
			System.out.println("--------------------------------------------------------");
			
			population = geneticAlgorithm.evolve(population).sortByFitness();
			main.scheduleNumb = 0;
			population.getListSchedule().forEach(schedule -> {
				System.out.println("     " + main.scheduleNumb++ + "     | " + schedule.toString() + "  |  " +
								   String.format("%.5f", schedule.getFitness()) + "  |   " + schedule.getNumbOfConflicts());
			});
			
			main.printScheduleAsTable(population.getListSchedule().get(0), generationNumber);
			main.classNumb = 1;
		}
//		
	}
	
	private void printScheduleAsTable (Schedule schedule, int generation) {
		ArrayList<ClassByBit> listClass = schedule.getListClass();
		System.out.print("\n  ");
		System.out.println("Class # | Dept | Course (number, max # of students) | Room (Capacity) |     Instructor (ID)     | Meeting Time (ID) ");
		System.out.print("  ");
		System.out.print("------------------------------------------------------");
		System.out.println("---------------------------------------------------------------");
		
		listClass.forEach(aClass -> {
			int indexOfRoom = Integer.parseInt(aClass.getRoomBit(), 2);
			int indexOfCourse = Integer.parseInt(aClass.getCourseBit(), 2);
			int indexOfInstructor = Integer.parseInt(aClass.getInstructorBit(), 2);
			int indexOfMT = Integer.parseInt(aClass.getMtBit(), 2);
			String deptName = "";
			/* Find index of Department that have this course */
			for (int i = 0; i < data.getListDept().size(); i++) {
				Course course = data.getListCourse().get(indexOfCourse);
				Department dept = data.getListDept().get(i);
				for (int j = 0; j < dept.getListCourse().size(); j++) {
					if (dept.getListCourse().get(j).equals(course)) deptName = dept.getDeptName();
					
				}
			}
			
			System.out.print("   ");
			System.out.print(String.format("  %1$02d  ", classNumb) + " | ");
			System.out.print(String.format("%1$4s", deptName) + " |  ");
			System.out.print(String.format("%1$21s", data.getListCourse().get(indexOfCourse).getCourseName() + 
                    " ("  + data.getListCourse().get(indexOfCourse).getMaxNumbOfStudents()) + ")            | ");
			System.out.print(String.format("%1$10s", data.getListRoom().get(indexOfRoom).getRoomId() + " (" +
                    data.getListRoom().get(indexOfRoom).getSeatingCapacity()) + ")     | ");
			System.out.print(String.format("%1$15s", data.getListInstructor().get(indexOfInstructor).getInstructorName() + 
                    " (" + data.getListInstructor().get(indexOfInstructor).getInstructorId() + ")") + "  | ");
			System.out.println(data.getListMT().get(indexOfMT).getTime() + 
			           " (" + data.getListMT().get(indexOfMT).getMtId() + ")");
			
			classNumb++;
		});
		
		if (schedule.getFitness() == 1) {
			System.out.println("> Solution Found in " + (generation + 1) + " generations");
		}
		System.out.print("---------------------------------------------------------");
		System.out.println("------------------------------------------------------");
	}
	
	
	
	
	
	
	
	
	private void printAvailableData() {
		System.out.println("Available Department ==>");
		data.getListDept().forEach(x -> System.out.println("Name: " + x.getDeptName() + ", course: " + x.getListCourse()));
		
		System.out.println("\nAvailable Courses ==>");
		data.getListCourse().forEach(x -> System.out.println("course #: " + x.getCourseId() + ", name: " + x.getCourseName() + 
				", max # of students: " + x.getMaxNumbOfStudents() + ", instructor: " + x.getListInstructor()));
		
		System.out.println("\nAvailable Rooms ==>");
		data.getListRoom().forEach(x -> System.out.println("Room #: " + x.getRoomId() + ", Name of room: " +
		        x.getRoomName() + ", seating capacity: " + x.getSeatingCapacity()));
		
		System.out.println("\nAvailable Instructors ==>");
		data.getListInstructor().forEach(x -> System.out.println("id: " + x.getInstructorId() + ", name: " + x.getInstructorName()));
		
		System.out.println("\nAvailable Meeting Times ==>");
		data.getListMT().forEach(x -> System.out.println("id: " + x.getMtId() + ", Meeting Time: " + x.getTime()));
		
		System.out.print("-------------------------------------------------------");
		System.out.println("------------------------------------------------------");
	}
}
