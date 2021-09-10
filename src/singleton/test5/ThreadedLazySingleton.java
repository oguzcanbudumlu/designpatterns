package singleton.test5;

/**
 * In order to provide thread-safety, we need to
 * make sure that getInstance methods is called
 * by one instance at one point.
 */
public class ThreadedLazySingleton {
    private static ThreadedLazySingleton threadedLazySingleton;

    private static int count;
    private String name;

    private ThreadedLazySingleton() {
        count++;
        name = "ThreadedLazySingleton" + count;
    }

    public static ThreadedLazySingleton getInstance() {
        if(threadedLazySingleton == null) {
            System.out.println("threadedLazySingleton is null when the count is " + count + " and it will be created");
            threadedLazySingleton = new ThreadedLazySingleton();
        }
        return threadedLazySingleton;
    }

    public void printName() {
        System.out.println(this.name);
    }

    public static ThreadedLazySingleton getStatic() {
        return threadedLazySingleton;
    }

    @Override
    public String toString() {
        return name;
    }
}
