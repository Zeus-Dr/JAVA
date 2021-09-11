package Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Utilities
{
    public static int [] StringToIntegerArray(String [] array) {
        int size=3;
        int [] arr= new int [size];
        for (int i = 0; i < size; i++) {
            arr[i]=Integer.parseInt(array[i]);
        }
        return arr;
    }

    public static int inRage(int [] marks) {
        int result=0;
        for (int i = 0; i < marks.length; i++) {
            if (!(0<=marks[i] && marks[i]<=100)) {
                result= -1;
            }
        }
        return result;
    }

}

class Student
{
    String surname,firstname,sex;
    int age;
    int [] marks;
//Setters
    void set_surname(String surname)
    {
        this.surname=surname;
    }
    void set_firstname(String firstname)
    {
        this.firstname=firstname;
    }
    void set_sex(String sex)
    {
        this.sex=sex;
    }
    void set_age(int age)
    {
        this.age=age;
    }
    void set_marks(int [] marks)
    {
        this.marks=marks;
    }

//Getters
    String get_name()
    {
        return surname+" "+firstname;
    }
    String get_sex()
    {
        return sex;
    }
    int get_age()
    {
        return age;
    }
    int [] get_marks()
    {
        return marks;
    }

    public double average(int [] marks) {
        double sum=0;
        for (int i = 0; i < marks.length; i++) {
            sum+=marks[i];
        }
        double average=sum/marks.length;
        return average;
    }

    public String passORfail(double average) {
        if (average>50) {
            return "Passed";
        }else
        {
            return "Failed";
        }
    }

}

public class Week2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader stdin=new BufferedReader(in);

        String surname,firstname,sex;
        int age;
        int [] marks;

        List<Student> students= new ArrayList<Student>();
        int i=1;
        while (i<6) {
            try {
                System.out.println(("STUDENT"+i+"!!"));
                Student u=new Student();
    
                System.out.print("Enter Surname:");
                surname=stdin.readLine();
                u.set_surname(surname);
                
                System.out.print("Enter Firstname:");
                firstname=stdin.readLine();
                u.set_firstname(firstname);
    
                System.out.print("Enter Sex:");
                sex=stdin.readLine();
                u.set_sex(sex);
                
                System.out.print("Enter Age:");
                age=Integer.parseInt(stdin.readLine());
                u.set_age(age);
    
                System.out.print("Enter Marks of 3 subjects from 0-100(xx,xx,xx):");
                String [] inp=stdin.readLine().split(",");
                marks=Utilities.StringToIntegerArray(inp);
                if(Utilities.inRage(marks)==-1)
                {
                    System.out.println("Marks out of range, Try Again!!");
                    continue;
                }
                u.set_marks(marks);

                students.add(u);
            } catch (NumberFormatException ex) {
                //TODO: handle exception
                System.out.println("Enter correct data entered!!,Try Again!!");
                continue;   
                         
            }catch(ArrayIndexOutOfBoundsException ex)
            {
                System.out.println("Wrong Array Input, Try Again!!");
                continue;
            } 
            catch (IOException ex) {
                //TODO: handle exception
                System.out.println("Invalid Data!!!");
                continue;
            }
            i+=1;
        }
        String heading = "=========================================================";
        System.out.println(heading);
        System.out.println(String.format("%30s", "RESULTS"));
        System.out.println(heading);

        for (Student student : students) {
            int [] new_marks=student.get_marks();
            double average=student.average(new_marks);
            String PorF=student.passORfail(average);
            System.out.println("Student Name: "+student.get_name());
            System.out.println("Average Mark: "+average);
            System.out.println("Result: "+PorF);
            System.out.println();
        }
    }
}


