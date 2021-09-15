package singleton.test7;


public class Client extends Thread {

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
        ThreadSafeVolatileLazySingleton threadSafeVolatileLazySingleton = ThreadSafeVolatileLazySingleton.getInstance();
        threadSafeVolatileLazySingleton.printName();
    }
}
