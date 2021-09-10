package singleton.test5;

public class Client extends Thread {
    public static void main(String[] args) {
        showCase0();
    }

    private static void showCase0() {
        for(int i = 0; i < 100; i++) {
            new Client().start();
        }
    }

    @Override
    public void run() {
        ThreadedLazySingleton threadedLazySingleton = ThreadedLazySingleton.getInstance();
        threadedLazySingleton.printName();
    }
}
