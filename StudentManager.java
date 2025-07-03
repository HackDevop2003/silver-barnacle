// import java.util.Scanner;
// class Student 
// {
//      int Id;
//      String name;
//      int marks;
// }
// public class crude
// {
//     public static void main(String args[])
//     {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("Add:-1");
//         System.out.println("View:-2");
//         System.out.println("Update:-3");
//         System.out.println("Delete:-4");
//         int n=sc.nextInt();
//         int a=0;
//         switch(n){
//             case 1:
//             {
//             System.out.println("Number of students for add:-");
//             a=sc.nextInt();
//             int i=0;
//             while(i<a){
//                 Student iS = new Student();
//                 iS.Id=sc.nextInt();
//                 iS.name=sc.nextLine();
//                 iS.marks=sc.nextInt();
//                 }
//             }
//             break;
//             case 2:
//             System.out.println("view students:-");
//             {
//             int i=0;
//             while(i<a)
//                 {
//                 Student iS = new Student();
//                 iS.Id=sc.nextInt();
//                 iS.name=sc.nextLine();
//                 iS.marks=sc.nextInt();
//                 System.out.println("Id:-"+iS.Id+"name:-"+iS.name+"marks:-"+iS.marks);
//                 }
//             }
//             break;
//         }
//         sc.close();
//     }
// }
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name, double marks) 
    {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() 
    { 
        return id;
    }
    public String getName() 
    {
         return name;
         }
    public double getMarks()
     {
         return marks;
         }

    public void setName(String name)
     {
         this.name = name;
         }
    public void setMarks(double marks)
     {
         this.marks = marks;
         }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Marks: " + marks;
    }
}

public class StudentManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n---- Student Management Menu ----");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
        
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                default -> System.out.println("Invalid choice!");
            }
            choice++;
        } 
        while (choice<=4);
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Clear newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to show.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.getId() == id) {
                sc.nextLine(); // consume newline
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();
                s.setName(name);
                s.setMarks(marks);
                System.out.println("Student updated.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }
}

