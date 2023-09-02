import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String [] args){
    
        double i =1;
        String ans =  "";
        while(!StdIn.isEmpty()){
            String temp = StdIn.readString();
            double p = 1/i;
            if(StdRandom.bernoulli(p)){
                ans = temp;
            }
            i++;
        }
        StdOut.println(ans);
    }
}
