package singleton.test6;

/**
 * In order to provide thread-safety, we need to
 * make sure that getInstance methods is called
 * by one instance at one point.
 */
public class ThreadSafeLazySingleton {
    private static ThreadSafeLazySingleton threadSafeLazySingleton;

    private static int count;
    private String name;

    private ThreadSafeLazySingleton() {
        count++;
        name = "ThreadedLazySingleton" + count;
    }

    public static ThreadSafeLazySingleton getInstance() {
        /**
         * synchronized keyword can be applied to method level but
         * it is better to hold the scope of synchronized small
         * */
        synchronized (ThreadSafeLazySingleton.class) {
            if(threadSafeLazySingleton == null) {
                System.out.println("threadSafeLazySingleton is null when the count is " + count + " and it will be created");
                threadSafeLazySingleton = new ThreadSafeLazySingleton();
            }
        }
        return threadSafeLazySingleton;
    }

    public static ThreadSafeLazySingleton getInstanceWithBetterPerformance() {
        if(threadSafeLazySingleton == null) {
            synchronized (ThreadSafeLazySingleton.class) {
                if(threadSafeLazySingleton == null) {
                    threadSafeLazySingleton = new ThreadSafeLazySingleton();
                }
            }
        }
        return threadSafeLazySingleton;
    }

    public void printName() {
        System.out.println(this.name);
    }

    public static ThreadSafeLazySingleton getStatic() {
        return threadSafeLazySingleton;
    }

    @Override
    public String toString() {
        return name;
    }
}
