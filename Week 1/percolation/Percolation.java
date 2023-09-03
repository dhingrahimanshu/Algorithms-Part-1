import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private WeightedQuickUnionUF ob;
    private WeightedQuickUnionUF ob2;
//    private WeightedQuickUnionUF ob2;
    private int [] check;
    private int n;
    private int opensites=0;
    public Percolation(int n){
        if(n<=0){

            throw new IllegalArgumentException();

        }

        this.n = n;
        ob = new WeightedQuickUnionUF((n*n) +2);
        ob2 = new WeightedQuickUnionUF((n*n) +2);
        check = new int[(n*n)+2];

        for(int i =0;i<=n*n;i++){
            check[i]=1;
        }
    }
    public void open(int row , int col){
        int element = (row-1)*n + col;
        if(element<=0 || element>(n*n)){
            throw new IllegalArgumentException();
        }
        if(check[element]==0){
            return;
        }
        check[element]=0;
        opensites++;
        if(col!=1 && isOpen(row , col-1)){
            ob.union(element , element-1);
            ob2.union(element , element-1);
        }
        if(col!=n && isOpen(row , col+1)){
            ob.union(element , element+1);
            ob2.union(element , element+1);
        }
        if(row!=1 && isOpen(row-1 , col)){
            ob.union(element , element-n);
            ob2.union(element , element-n);
        }
        if(row!=n && isOpen(row+1 , col)) {
            ob.union(element, element + n);
            ob2.union(element, element + n);
        }
        if(row==1){
            ob2.union(0 , element);
            ob.union(0 , element);
        }
        if(row==n){
            ob.union(element , (n*n)+1);
        }

    }

    public boolean isOpen(int row, int col){
        int element = (row-1)*n + col;
        if(element<=0 || element>(n*n)){
            throw new IllegalArgumentException();
        }
        return check[element]==0;
    }
    public int numberOfOpenSites(){
        return opensites;
    }
    public boolean isFull(int row ,int col){
        int element = (row-1)*n + col;
        if(element<=0 || element>(n*n)){
            throw new IllegalArgumentException();
        }
//        int temp = ob.find(element);
//        for(int i =1 ;i<=n;i++){
//            if(ob.find(i)==temp){
//                return true;
//            }
//        }
        return (check[element]==0 && ob2.find(0)==ob2.find(element));
    }

    public boolean percolates(){
        return ob.find(0)==ob.find((n*n)+1);
    }


    public static void main(String [] args) {
    }
}
