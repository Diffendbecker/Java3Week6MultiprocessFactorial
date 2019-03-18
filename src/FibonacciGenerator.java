public class FibonacciGenerator  extends Thread {

    private long pos;
    private long result;

    public FibonacciGenerator(long pos) {
        this.pos = pos;
    }

    public void run() {
        if( pos <= 2 )
            result = 1;
        else {
            try {
                FibonacciGenerator f1 = new FibonacciGenerator(pos-1);
                FibonacciGenerator f2 = new FibonacciGenerator(pos-2);
                f1.start();
                f2.start();
                f1.join();
                f2.join();
                result = f1.result + f2.result;
            }
            catch(InterruptedException ex) { }
        }
    }

    //public static long getFibRecursive(long pos){
    //    if (pos <= 1){
    //        return pos;
    //    }
    //    return getFibRecursive(pos-1) + getFibRecursive(pos-2);
    //}

    public static long FibonacciGenerator(long pos) throws Exception {
        long finalResult = 0;
        try {
        FibonacciGenerator f = new FibonacciGenerator(pos);
        f.start();
        f.join();
        finalResult = f.result;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return finalResult;
    }
}
