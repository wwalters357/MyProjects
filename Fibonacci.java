import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {

    static BigInteger[] fib;
    public static void setUp(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter which fibonacci number you want: ");
        int n = input.nextInt();
        fib = new BigInteger[n + 1];
        System.out.print("\n" + Fastest_Fibonacci(n));
    }

    //static Map<Integer, BigInteger> fibonacci = new HashMap<>();
    public static BigInteger Fast_Fibonacci(int n){ // O(n)
        fib[1] = BigInteger.valueOf(1);
        fib[2] = BigInteger.valueOf(1);
        for(int i = 3; i <= n; i++){
            fib[i] = fib[i-1].add(fib[i-2]);
        }
        return fib[n];
    }

    public static int Slow_Fibonacci(int n){ // O(1.6^n)
        if(n <= 2)
            return 1;
        else
            return Slow_Fibonacci(n-1) + Slow_Fibonacci(n-2);
    }

    public static BigInteger Fastest_Fibonacci(int n){ // O(logn)
        if(n == 0)
            return BigInteger.valueOf(0);
        else if(n <= 2)
            return (fib[n] = BigInteger.valueOf(1));
        else if(fib[n] != null)
            return fib[n];
        int k = (n % 2) == 1 ? (n + 1) / 2 : n / 2;
        fib[n] = (n % 2) == 1 ? (Fastest_Fibonacci(k).multiply(Fastest_Fibonacci(k)).add(
                Fastest_Fibonacci(k - 1).multiply(Fastest_Fibonacci(k - 1)))) :
                (BigInteger.valueOf(2).multiply(Fastest_Fibonacci(k - 1)).add(Fastest_Fibonacci(k)).multiply(Fastest_Fibonacci(k)));
        return fib[n];
    }
}
