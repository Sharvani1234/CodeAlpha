package com.codealpha;

import java.util.Scanner;

public class TravelPlanner{
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Welcome to the Travel Itinerary Planner!");
		
		System.out.print("Enter your destination:");
		String destination=scanner.nextLine();
		
		System.out.print("Enter the departure date(YYYY-MM-DD):");
		String departureDate=scanner.nextLine();
		
		System.out.print("Enter the return date(YYYY-MM-DD):");
		String returnDate=scanner.nextLine();
		
		System.out.print("Enter your budget:");
		double budget=scanner.nextDouble();
		
		System.out.println("\n---Your Travel Itinerary---");
		System.out.println("Destination:"+destination);
		System.out.println("Departure Date:"+departureDate);
		System.out.println("Return Date:"+returnDate);
		System.out.println("Budget:$"+budget);
		
		String weatherInfo=getWeatherInfo(destination,departureDate,returnDate);
		System.out.println("\nWeather Information:");
		System.out.println(weatherInfo);
		
		String mapInfo=getMapInfo(destination);
		System.out.println("\nMap Information:");
		System.out.println("mapInfo:https://www.google.com/maps/place/");
		
		double remainingBudget=calculateRemainingBudget(budget);
		System.out.println("\nRemaining Budget:$"+remainingBudget);
		
		scanner.close();
	}
	
	private static String getWeatherInfo(String destination,String departureDate,String returnDate) {
		String weatherInfo="Weather for "+destination+" from "+departureDate+" to "+returnDate+":\n";
		weatherInfo+=departureDate+":Sunny,25\u00B0C\n";
		weatherInfo+=returnDate+":Partly cloudy,28\u00B0C\n";
		return weatherInfo;
	}
	
	private static String getMapInfo(String destination) {
		return "Map information for "+destination+": https://www.google.com/maps/place/ "+destination;
	}
	
	private static double calculateRemainingBudget(double budget) {
		return budget-500;
	}
}