package com.codealpha;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineQuizPlatform{
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
	
		System.out.println("Welcome to Online Quiz Platform!");
		System.out.print("Enter your username:");
		String username=scanner.nextLine();
		System.out.print("Enter your password:");
		String password=scanner.nextLine();
		
		if(authenticateUser(username,password)) {
			System.out.println("Login successful.Starting quiz...");
			startQuiz();
		}
		else {
			System.out.println("Invalid username or password.Exiting...");
		}
	}
	
	private static boolean authenticateUser(String username, String password) {
		return username.equals("admin") && password.equals("password");
	}

	private static void startQuiz() {
		Quiz quiz=new Quiz("Java Basics");
		
		Question question1=new Question("What is the capital of France?",List.of("London","Paris","Berlin","Rome"),1);
		Question question2=new Question("What is 2+2?",List.of("3","4","5","6"),1);
		Question question3=new Question("What is the powerhouse of the cell?",List.of("Mitochondria","Ribosome","Nucleus","Golgi apparatus"),0);
		
		quiz.addQuestion(question1);
		quiz.addQuestion(question2);
		quiz.addQuestion(question3);
		
		quiz.startQuiz();
	}
}

class Quiz{
	private String title;
	private List<Question>questions;
	
	public Quiz(String title) {
		this.title=title;
		questions=new ArrayList<>();
	}
	
	public void addQuestion(Question question) {
		questions.add(question);
	}
	
	public void startQuiz() {
		int score=0;
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Welcome to the "+title+" Quiz!");
		for(Question question:questions) {
			System.out.println(question.getQuestion());
			System.out.println("Options:");
			for(int i=0;i<question.getOptions().size();i++) {
				System.out.println((i+1)+"."+question.getOptions().get(i));
			}
			
			System.out.print("Your answer:");
				int userAnswer=scanner.nextInt();
				if(question.isCorrect(userAnswer-1)) {
					System.out.println("Correct!");
					score++;
				}
				else {
					System.out.println("Incorrect!");
				}
				System.out.println();
		}
		System.out.println("Quiz completed!Your score:"+score+"/"+questions.size());
	}
	}

class Question{
	private String question;
	private List<String>options;
	private int correctAnswerIndex;
	
	public Question(String question,List<String>options,int correctAnswerIndex) {
		this.question=question;
		this.options=options;
		this.correctAnswerIndex=correctAnswerIndex;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public List<String>getOptions(){
		return options;
	}
	
	public boolean isCorrect(int userAnswer) {
		return userAnswer==correctAnswerIndex;
	}
}