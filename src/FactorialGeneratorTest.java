import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FactorialGeneratorTest {
    Long value = 2432902008176640000L;
    @org.junit.jupiter.api.Test
    void factorial() {
        long startTime = System.currentTimeMillis();
        long result = FactorialGenerator.factorial(20);
        long totalTimeMs = System.currentTimeMillis() - startTime;
        assertEquals(value, result);
        System.out.println("Time ms: " + totalTimeMs);
    }

    @org.junit.jupiter.api.Test
    void factorial2() {
        long startTime = System.currentTimeMillis();
        long result = FactorialGenerator.factorial2(20);
        long totalTimeMs = System.currentTimeMillis() - startTime;
        assertEquals(value, result);
        System.out.println("Time ms: " + totalTimeMs);
    }

    @org.junit.jupiter.api.Test
    void parallelFactorial()  {
        long startTime = System.currentTimeMillis();
        BigInteger result = FactorialGenerator.parallelFactorial(20);
        long totalTimeMs = System.currentTimeMillis() - startTime;
        assertEquals(value, result.longValue());
        System.out.println("Time ms: " + totalTimeMs);
    }
}