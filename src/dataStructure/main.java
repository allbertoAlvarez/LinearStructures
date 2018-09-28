package dataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import TDA.iQueue;

public class main {

	public static void main(String[] args) throws IOException {

//		BufferedReader bf = new BufferedReader(new FileReader("./data/data.txt"));
//		
//		BufferedWriter bfw = new BufferedWriter(new FileWriter("./data/data.txt"));
//		
//		bfw.write("holaaaaaaaa");
//		bfw.close();
//		String cadena;
//		
//		
//		while((cadena = bf.readLine()) != null) {
//			System.out.println(cadena);
//		}
//		bf.close();
//		
		
//		 PriorityQueue<Student> pq = new 
//	             PriorityQueue<Student>(5, new StudentComparator()); 
//	                  
//	                // Invoking a parameterized Student constructor with  
//	                // name and cgpa as the elements of queue 
//	                Student student1 = new Student("Nandini", 3.2); 
//	                  
//	                // Adding a student object containing fields  
//	                // name and cgpa to priority queue  
//	                pq.add(student1); 
//	                Student student2 = new Student("Anmol", 3.6); 
//	                        pq.add(student2);          
//	                Student student3 = new Student("Palak", 4.0); 
//	                        pq.add(student3); 
//	                  
//	                // Printing names of students in priority order,poll() 
//	                // method is used to access the head element of queue 
//	                System.out.println("Students served in their priority order"); 
//	                  
//	                while (!pq.isEmpty()) { 
//	                System.out.println(pq.poll().getName());
//		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
		
	}
}
