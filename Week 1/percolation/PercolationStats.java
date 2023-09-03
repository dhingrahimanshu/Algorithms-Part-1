import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import java.lang.Math;

public class PercolationStats {

    private double [] arr;
    private double t;
    public PercolationStats(int n , int trials){
        if(n<=0 || trials<=0){
            throw new IllegalArgumentException();
        }
        t = trials;
        arr = new double[trials];
        for(int i =0;i<trials;i++){

            Percolation ob = new Percolation(n);
//            double ans=0;
            while(!ob.percolates()){
                while(true){
                    int row = StdRandom.uniformInt(1 , n+1);
                    int col = StdRandom.uniformInt(1 , n+1);
                    if(!ob.isOpen(row , col)){
                        ob.open(row , col);
                        break;
                    }

                }

            }
            double a = ob.numberOfOpenSites();
            double b = n*n;
            arr[i] = a/b;

        }

    }
    public double mean(){
        return StdStats.mean(arr);
    }
    public double stddev(){
        return StdStats.stddev(arr);
    }
    public double confidenceLo(){
        return this.mean()- ((1.96*this.stddev())/Math.sqrt(t));
    }
    public double confidenceHi(){
        return this.mean() + ((1.96*this.stddev())/Math.sqrt(t));
    }


    public static void main(String [] args){
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
//        int n = 200;
//        int trials = 100;
        PercolationStats ob = new PercolationStats(n , trials);
        StdOut.println("mean                    = "+ob.mean());
        StdOut.println("stddev                  = "+ob.stddev());
        StdOut.println("95% confidence interval = ["+ob.confidenceLo() +", "+ ob.confidenceHi()+"]");
    }
}



