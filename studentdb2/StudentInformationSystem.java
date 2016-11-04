/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kyn Mark N. Trongcao
 */

import java.io.*;
import java.util.*;

public class StudentInformationSystem {
    private static List<Student> students = new ArrayList<Student>();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        loadContents("C:\\Users\\Kyn Mark N. Trongcao\\Desktop\\db.ser");
        
        int option;
        boolean exit = false;

        while(!exit) {
            System.out.println("1. Register");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Save");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = sc.nextInt();
            System.out.println();

            if(option == 1) {
                try {
                    register();
                } catch(StudentNumberAlreadyExistsException ex) {
                    System.out.println(ex.getInfo());
                }
            } else if(option == 2) {
                search();
            } else if(option == 3) {
                delete();
            } else if(option == 4) {
                save();
            } else {
                exit = true;
            }
            System.out.println("========================================");
        }
        System.out.println("Bye!");
    }

    public static void loadContents(String inputFile) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try {
            File fin = new File(inputFile);
            if (fin.length() == 0) {
                
            } else {
                fis = new FileInputStream(fin);
                ois = new ObjectInputStream(fis);
                students = (ArrayList<Student>) ois.readObject();
                ois.close();
                fis.close();              
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void register() throws StudentNumberAlreadyExistsException {
        sc.nextLine();
        System.out.print("Student Number: ");
	String studentNumber = sc.nextLine();
        
	for(Student isko : students) {
            if(isko.getStudentNumber().equals(studentNumber)) {
		throw new StudentNumberAlreadyExistsException(studentNumber);
            }
	}

        System.out.print("First Name: ");
	String firstName = sc.nextLine();

        System.out.print("Middle Initial: ");
	char middleInitial = sc.next().charAt(0);

        sc.nextLine();
	System.out.print("Last Name: ");
        String lastName = sc.nextLine();

	System.out.print("Program: ");
        String course = sc.nextLine();

        System.out.print("Year Level: ");
	int yearLevel = sc.nextInt();
        sc.nextLine();

        System.out.print("Crush Name: ");
        String crushName = sc.nextLine();
                
        System.out.print("Favorite Subject: ");
        String subject = sc.nextLine();
                
        System.out.print("Favorite Subject Description: ");
        String subjectDescription = sc.nextLine();
                
	Student isko = new Student(studentNumber, firstName, middleInitial, lastName, course, yearLevel, crushName, new Course(subject, subjectDescription));
	students.add(isko);
	System.out.println("Student added!");
    }

    public static void search() {
        System.out.print("Search Student: ");
        String studentNumber = sc.next();
        Student retrievedStudent = null;

        for(Student isko : students) {
            if(isko.getStudentNumber().equals(studentNumber)) {
                retrievedStudent = isko;
                break;
            }
        }
        System.out.println(retrievedStudent);
    }

    public static void delete() {
        System.out.print("Delete Student: ");
        String studentNumber = sc.next();
        
        for(Student isko : students) {
            if(isko.getStudentNumber().equals(studentNumber)) {
                students.remove(isko);
                break;                    
            }
        }
        System.out.println("Student " + studentNumber + " deleted!");
    }

    public static void save() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            File fout = new File("C:\\Users\\Kyn Mark N. Trongcao\\Desktop\\db.ser");
            fos = new FileOutputStream(fout);
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(students);
            
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Saved.");
    }
}
