package application;

import entities.Student;

import java.util.*;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Student> setStudent = new HashSet<>();

        List<Character> courses = new ArrayList<>();

        courses.add('A');
        courses.add('B');
        courses.add('C');

        int studentNumber;
        int studentCode;
        for(int i = 0; i < courses.toArray().length; i++){
            System.out.print("How many students for course " + courses.get(i) + "?");
            studentNumber = sc.nextInt();

            for (int j = 1; j <= studentNumber; j++){
                System.out.print(j + "º Student: ");
                studentCode = sc.nextInt();
                setStudent.add(new Student(studentCode));
            }
        }

        System.out.println("Total students: " + setStudent.size());

        sc.close();
    }
}