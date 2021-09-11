package Assignment;
/**
forward=backward
Madam=madaM
madam=madam
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SecondClass {
    public void classification(int n) {
        int sum=0;
        for (int i = n-1; i>0; i--) {//or for(int i=1;i<n/2;n++) Since the highest divisor excluding the number itself is half the number.
            if (n%i==0) {
                sum+=i;
            }
        }
        if (sum==n) {
            System.out.println("The number "+n+" is Perfect");
        }else if (sum>n) {
            System.out.println("The number "+n+" is Abundant");
        }
        else{
            System.out.println("The number "+n+" is Deficient");
        }
    }
    
    public String drome(String word,int max) {
        String copy=word.substring(0, max);
        StringBuilder sb=new StringBuilder(copy);
        String reversed=sb.reverse().toString();
        if (copy.equalsIgnoreCase(reversed)) {
            return "TRUE";
        } else {
            return "FALSE";
        }
    }
}




public class Group {
    public static void main(String[] args)throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader stdin=new BufferedReader(in);

        String word;
        int max,num;

        SecondClass divisor=new SecondClass();
        System.out.print("Enter a number to be classified:");
        num=Integer.parseInt(stdin.readLine());
        divisor.classification(num);

        SecondClass palindrome=new SecondClass();
        System.out.print("Enter a number a word:");
        word=stdin.readLine();
        System.out.print("Enter maximum number of characters:");
        max=Integer.parseInt(stdin.readLine());
        System.out.println(palindrome.drome(word, max));      
    }
}
