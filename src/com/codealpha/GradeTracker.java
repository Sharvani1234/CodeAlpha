package com.codealpha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GradeTracker{
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		ArrayList<Integer>grades=new ArrayList<>();
		
		System.out.println("Enter grades for students(enter -1 to finish):");
		
		int grade;
		do {
			System.out.print("Enter grade(-1 to finish):");
			grade=scanner.nextInt();
			if(grade!=-1) {
				grades.add(grade);
			}
		}
		while(grade!=-1);
		
		double average=calculateAverage(grades);
		
		int highest=findHighestGrade(grades);
		int lowest=findLowestGrade(grades);
		
		System.out.println("Average Grade:"+average);
		System.out.println("Highest Grade:"+highest);
		System.out.println("Lowest Grade:"+lowest);
	}
	
	public static double calculateAverage(ArrayList<Integer>grades) {
		int sum=0;
		for(int grade:grades) {
			sum+=grade;
		}
		return(double)sum/grades.size();
	}
	
	public static int findHighestGrade(ArrayList<Integer>grades) {
		return Collections.max(grades);
	}
	
	public static int findLowestGrade(ArrayList<Integer>grades) {
		return Collections.min(grades);
	}
}