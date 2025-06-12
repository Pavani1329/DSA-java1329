public class FibonacciNumber{
    public static int fibonacci(int n){
        if(n<=1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
public static void main(String[] args){
    int n=7;
    //int result=fibonacci(n);
   // System.out.println(result);
    for (int i=0;i<=n;i++) {
        System.out.println(fibonacci(i));
    }
 } 
}