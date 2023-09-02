class dsu{
    int n;
    int []par;
    int [] size;
    public dsu(int n){
        this.n = n;
        this.par = new int[n+1];
        this.size = new int[n+1];
        for(int i =1;i<=n;i++){
            par[i]=i;
            size[i]=1;
        }
    }
    public void union(int a , int b){
        a = get(a); b = get(b);
        if(size[a]>size[b]){
            a = a^b;
            b = a^b;
            a = a^b;
        }
        par[a]=b;
        size[b]+=size[a];
    }
    public int get(int a){
        return par[a]=(a==par[a]?a:get(par[a]));
    }
    public boolean get2(int a , int b){ // checks whether a and b belongs to the same group or not
        a = get(a); b = get(b);
        return a==b;
    }


}
