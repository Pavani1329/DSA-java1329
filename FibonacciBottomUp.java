public class FibonacciBottomUp{
    public static void main(String[] args){
        int n=7;
        fibonacciBottomUp(n);
    }
    public static void fibonacciBottomUp(int n){
        if(n<=0){
            return;
        }
    int prev1=0;
    int prev2=1;
    System.out.print(prev1+" ");
    if(n==1){
        return;
    }
    System.out.print(prev2+" ");
    for(int i=2;i<n;i++){
        int current=prev1+prev2;
        System.out.print(current+" ");
        prev1=prev2;
        prev2=current;
    }
}
}