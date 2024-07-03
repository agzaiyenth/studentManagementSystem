import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Student [] students = new Student[100];
    static int studentCount=0;
    static Scanner sc = new Scanner(System.in);
    public static int menu(){
        System.out.print("""
                \n
                Welcome to the Student Management System!
                
                
                1. Check available seats
                2. Register student (with ID)
                3. Delete student
                4. Find student (with student ID)
                5. Store student details into a file
                6. Load student details from the file to the system
                7. View the list of students based on their names
                Please select one option out of these
                """);
        return sc.nextInt();

    }

    public static void checkAvailableSeats(){
        if (studentCount<100){
            System.out.printf("There are %d available seats in the system.",100-studentCount);
        }
    }

    public static void registerStudent(){
        System.out.print("Enter student ID: ");
        String id = sc.next().toLowerCase();
        System.out.print("Enter student name: ");
        String name = sc.next();
        int [] module_marks=new int[3];
        for (int i=0;i<3;i++){
            System.out.print("Enter module "+(i+1)+" Marks: ");
            module_marks [i] = sc.nextInt();
        }
        Modules modules=new Modules(module_marks);

        students[studentCount] = new Student(id,name,modules);
        studentCount++;
        System.out.println("Student has been registered.");
    }
    public static void deleteStudent(){
        System.out.print("Enter student ID: ");
        String id = sc.next().toLowerCase();
        if (studentCount>0){
            for(int i=0; i<studentCount; i++){
                if (students[i].getId().equals(id)){
                    students[i] = null;
                    studentCount--;
                    System.out.println("Student has been deleted.");
                    return;
                }
            }
            System.out.println("Student has not been registered.");
        }else {
            System.out.println("There are no Students registered in this system to delete..\n");
        }
    }

    public static void findStudent(){
        System.out.print("Enter student ID: ");
        String id = sc.next().toLowerCase();
    }
    public static void storeStudent(){

        try {
            FileWriter myWriter = new FileWriter("StudentData.txt");
            for(int i=0; i<studentCount; i++){
                if (students[i]!=null){
                    myWriter.write(students[i].getId()+" ");
                    myWriter.write(students[i].getName()+" ");
                    Modules mods=students[i].getModule();
                    myWriter.write(mods.getModule_1()+",");
                    myWriter.write(mods.getModule_2()+",");
                    myWriter.write(mods.getModule_3() + "\n");

                    }

                }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");

        }

    }
    public static void loadStudent(){
        try {
            File myObj = new File("StudentData.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String [] dataarray=data.split(" ");
                String [] moduledata=dataarray[2].split(",");
                int [] moduleData=new int[3];
                int c=0;
                for(String i:moduledata){
                    moduleData[c]=Integer.parseInt(i);
                    c++;
                }
                Modules module=new Modules(moduleData);
                students[studentCount]=new Student(dataarray[0],dataarray[1],module);
                studentCount++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");

        }
    }
    public static void viewStudent(){

    }



    public static void main(String[] args) {
        int option=99;
        while(option!=0){
            option=menu();
            switch (option){
                case 1:
                    checkAvailableSeats();
                    break;
                case 2:
                    registerStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    findStudent();
                    break;
                case 5:
                    storeStudent();
                    break;
                case 6:
                    loadStudent();
                    break;
                case 7:
                    System.out.println("Running");
                    viewStudent();
                    System.out.println("Ended");
                    break;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }


}