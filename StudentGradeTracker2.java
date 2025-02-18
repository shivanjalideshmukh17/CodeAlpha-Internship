import java.util.Scanner;
import java.util.Arrays;  

public class StudentGradeTracker2
 {
      public static void main(String[] args) 
      {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[] grades = new int[numStudents];

        for (int i = 0; i < numStudents; i++)
        {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }

        double average = computeAverage(grades);
        int highest = computeHighest(grades);
        int lowest = computeLowest(grades);

        System.out.println("\nStudent Grade List: " + Arrays.toString(grades));
       
        System.out.println("\nStudent Grade Summary:");
        System.out.println("Average Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        scanner.close();
    }

     public static double computeAverage(int[] grades)
    {
        int sum = 0;
        for (int grade : grades) 
        {
            sum += grade;
        }
        return (double) sum / grades.length;
    }

    
    public static int computeHighest(int[] grades)
    {
        int highest = grades[0];
        for (int grade : grades) 
        {
            if (grade > highest) 
            {
                highest = grade;
            }
        }
        return highest;
    }

    
    public static int computeLowest(int[] grades) 
    {
        int lowest = grades[0];
        for (int grade : grades) 
        {
            if (grade < lowest) 
            {
                lowest = grade;
            }
        }
        return lowest;
    }
}
