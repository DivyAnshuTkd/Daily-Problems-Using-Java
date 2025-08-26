import java.util.*;

public class PaintingWithTwoColours 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t > 0) 
        {
            long n = sc.nextLong(); 
            long a = sc.nextLong();
            long b = sc.nextLong();
            
            if (a + b <= n + 1) 
            {
                System.out.println("YES");
            } 
            else
            {
                System.out.println("NO");
            }
            t--;
        }
    }
}