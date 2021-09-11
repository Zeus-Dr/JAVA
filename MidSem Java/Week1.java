package Assignment;

import java.util.ArrayList;



class classification
{
    public int Vanilla(Integer [] array){
        int sum=0;
        ArrayList<String> ls=classification.singleton(array);
        for (int i = 1; i < ls.size(); i++) {
            if (!(ls.get(0).equals(ls.get(i)))) {
                sum+=1;
            }
        }
        if (sum>0) {
           return 0;
        } else
        {
            return 1;
        }
    }

    private static ArrayList<String> singleton(Integer [] num) {
        ArrayList <String> new_num=new ArrayList <String>();
        for (Integer integer : num) {
            String []inner=integer.toString().split("");
            for (int i = 0; i < inner.length; i++) 
            {
                new_num.add(inner[i]);
            }
        }
        return new_num;
    }
}

class Isolated
{
    public int result;
    public int isolated(int n) {
        int square=n*n;
        int cube=n*n*n;

        String sqStr=Integer.toString(square);
        String cubStr=Integer.toString(cube);
        for (int i = 0; i < sqStr.length(); i++) {
            String chara=Character.toString(sqStr.charAt(i));
            if (!(cubStr.contains(chara))) {
                result=1;
            }else{
                result=0;
                break;
            }
        }
        return result;
    }
}

public class Week1 {
    public static void main(String[] args) {
        classification vanilla=new classification();
        Integer [] array={1111111,11,1111,111,1};
        System.out.println(vanilla.Vanilla(array));

        Isolated iso=new Isolated();
        System.out.println(iso.isolated(163));
    }
}
