import java.util.Scanner;
class LargestNumber{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter numbers:");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int largest;
        if(a>b&&b>c)
        largest=a;
        else if(b>c)
        largest=b;
        else
        largest=c;
        System.out.println("Largest number is:"+largest);
    }
}