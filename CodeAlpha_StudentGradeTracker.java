import java.util.*;
class Student{
    String name;
    int english,hindi,math,science,social;
Student(String name,int english,int hindi,int math,int science,int social){
    this.name=name;
    this.english=english;
    this.hindi=hindi;
    this.math=math;
    this.science=science;
    this.social=social;
}
//total
int total(){
    return english + hindi + math + science + social;
}
//avg marks
double avgmarks(){
    return total()/5.0;
}
// percentage
double percentage(){
    return (total()/500.0)*100;
}
 String calculategrade(){
    double marks=avgmarks();
    if(marks>=90)
        return " A";
    else if(marks>=75)
        return " B";
    else if(marks>=50)
        return " C";
    else if(marks>=35)
        return " D";
    else 
        return "Fail";
    }
}
class Grade{
    ArrayList<Student> students= new ArrayList<>();
    //add student list
    void addstudent(Scanner sc){
        System.out.print("Enter Student Name:");
        String name=sc.nextLine();
        System.out.print("Enter English Marks:");
        int english=sc.nextInt();
        if(english < 0 || english > 100){
         System.out.println("Invalid marks!");
         return;
             }
        System.out.print("Enter Hindi Marks:");
        int hindi=sc.nextInt();
            if(hindi < 0 || hindi > 100){
            System.out.println("Invalid marks!");
            return;
                }
        System.out.print("Enter Maths Marks:");
        int math=sc.nextInt();
              if(math < 0 || math > 100){
                System.out.println("Invalid marks!");
                return;
                }
        System.out.print("Enter Science Marks:");
        int science=sc.nextInt();
              if(science < 0 || science > 100){
                System.out.println("Invalid marks!");
                return;
                }
        System.out.print("Enter Social Marks:");
        int social=sc.nextInt();
              if(social < 0 ||social> 100){
    System.out.println("Invalid marks!");
    return;
        }
        sc.nextLine();
        Student s=new Student(name,english,hindi,math,science,social);
        students.add(s); 
        System.out.println("Student Added Successfully!..");
    }
    //view report
    void view(){
        if(students.size()==0){
            System.out.println("No Data.....");
            return;
        }
        double sumAvg=0;
        Student highest=students.get(0);
        Student lowest=students.get(0);
        System.out.println("------------Students Report------------");
        System.out.println();
        for(Student s: students){
            double avg =s.avgmarks();
            sumAvg+=avg;
            if(avg>highest.avgmarks()){
                highest = s;
            }
            if(avg<lowest.avgmarks()){
                lowest = s;
            }
            System.out.println("Name: "+s.name);
            System.out.println("English Marks: "+s.english);
            System.out.println("Hindi Marks: "+s.hindi);
            System.out.println("Math Marks: "+s.math);
            System.out.println("Science Marks: "+s.science);
            System.out.println("Social Marks: "+s.social);
            System.out.println("Total Marks: "+s.total()+" /500");
            System.out.println("percentage: "+s.percentage()+"%");
            System.out.println("Grade: "+s.calculategrade());
            System.out.println("-------------------------------");
        }
        double classavg= sumAvg/students.size();
        System.out.println("Class Average:"+classavg);
        System.out.println("Class Topper: "+ highest.name + " | Highest marks: "+highest.avgmarks());
        System.out.println("Class Lowest: "+lowest.name+ " | Lowest marks: "+lowest.avgmarks());
    }
}
public class studentgradetracker {
        public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        Grade track=new Grade();
         System.out.println("Welcome To Student Grade Tracker..");
        while(true){
            System.out.println("1- Add");
            System.out.println("2- View");
            System.out.println("3- Exit");
            System.out.print("Enter choice: ");
            int choice=sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                track.addstudent(sc);
                break;
            case 2:
                track.view();
                break;
            case 3:
                System.out.println("Exiting Program!......");
                sc.close();
                return;
            default:
                System.out.println("Invalid Choice......");
                break;
             }
        }
    }
}