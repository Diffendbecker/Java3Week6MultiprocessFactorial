import java.math.BigInteger;
import java.util.stream.IntStream;

public class FactorialGenerator {
    //Linear. O(n)
    public static long factorial(long n)
    {
        if (n == 0)
            return 1;

        return n*factorial(n-1);
    }

    //Linear. O(n)
    static long factorial2(long n)
    {
        if (n == 0)
            return 1;

        long v = 1;
        long i;
        for (i=2; i<=n; i++)
            v *= i;
        return v;
    }

    static BigInteger parallelFactorial(int n)
    {
        if (n < 2)
            return BigInteger.ONE;
        return IntStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply, BigInteger::multiply);
    }
}
