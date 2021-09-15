package singleton.test6;


/**
 * I thought that the performance with double null check would improve but it did not.
 * Because each thread has its own cache, even if it initializes the singleton object,
 * it does not seem from other threads.
 * https://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
 */
public class ClientWithBetterPerformance extends Thread {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            new Client().start();
        }
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000.0 + " s" );
    }

    @Override
    public void run() {
        ThreadSafeLazySingleton threadSafeLazySingleton = ThreadSafeLazySingleton.getInstanceWithBetterPerformance();
        threadSafeLazySingleton.printName();
    }
}
