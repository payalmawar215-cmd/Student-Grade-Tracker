import java.util.ArrayList;
import java.util.Scanner;
public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();
        
        while (numStudents <= 0) {
            System.out.println("Invalid number of students. Please enter a positive number.");
            System.out.print("Enter the number of students: ");
            numStudents = sc.nextInt();
        }
        sc.nextLine(); 

        System.out.print("Enter the number of subjects: ");
        int subjects=sc.nextInt();
        while (subjects <= 0) {
            System.out.println("Invalid number of subjects. Please enter a positive number.");
            System.out.print("Enter the number of subjects: ");
            subjects = sc.nextInt();
        }
         sc.nextLine(); 
         
        String[] subjectNames = new String[subjects];
        for (int i = 0; i < subjectNames.length; i++) {
            System.out.print("Enter subject name " + (i + 1) + ": ");
            subjectNames[i] = sc.nextLine();
        }
        int[][] marks = new int[numStudents][subjects];
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter Student Name:");
            String name = sc.nextLine();
            studentNames.add(name);

            for (int j = 0; j < subjects; j++) {
                System.out.print("Enter marks for " + subjectNames[j] + ": ");
        
                int mark = sc.nextInt();
                while (mark < 0 || mark > 100) {
                    System.out.println("Invalid marks. Please enter marks between 0 and 100.");
                    System.out.print("Enter marks for " + subjectNames[j] + ": ");
                    marks[i][j] = sc.nextInt();
                    mark = marks[i][j];
                }
                marks[i][j] = mark;

            }
            sc.nextLine();
        }

        for(int i=0; i<studentNames.size(); i++){
            System.out.println("==================================");
             System.out.println("Student Name: " + studentNames.get(i));
            int totalMarks = 0;
            int highestMarks = 0;
            int lowestMarks = Integer.MAX_VALUE;
            for(int j=0; j<subjects; j++){
                totalMarks += marks[i][j];
                if(marks[i][j] > highestMarks){
                    highestMarks = marks[i][j];
                }
                if(marks[i][j] < lowestMarks){
                    lowestMarks = marks[i][j];
                }
                System.out.println(subjectNames[j] + ": " + marks[i][j]);
            }
            System.out.println("Total Marks: " + totalMarks);
            double averageMarks=(double) totalMarks/subjects;
            System.out.printf("Average Marks: %.2f%n", averageMarks);
            System.out.println("Highest Marks: " + highestMarks);
            System.out.println("Lowest Marks: " + lowestMarks);
        }
    }
}


        