import static org.junit.jupiter.api.Assertions.*;

class FibonacciGeneratorTest {

    @org.junit.jupiter.api.Test
    void getFib() throws Exception {
        var result = FibonacciGenerator.FibonacciGenerator(6);
        assertEquals(8, result);
    }
}