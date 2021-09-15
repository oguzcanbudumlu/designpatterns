package singleton.test7;

/**
 * In order to provide thread-safety, we need to
 * make sure that getInstance methods is called
 * by one instance at one point.
 */
public class ThreadSafeVolatileLazySingleton {
    /** volatile guarantees that the variable has nothing
     * to do with cache structure and also double-check locking
     * problem can be tackled with volatile keyword
     */
    private static ThreadSafeVolatileLazySingleton threadSafeVolatileLazySingleton;

    private static int count;
    private String name;

    private ThreadSafeVolatileLazySingleton() {
        count++;
        name = "ThreadedLazySingleton" + count;
    }

    public static ThreadSafeVolatileLazySingleton getInstance() {
        /**
         * synchronized keyword can be applied to method level but
         * it is better to hold the scope of synchronized small
         * */
        synchronized (ThreadSafeVolatileLazySingleton.class) {
            if(threadSafeVolatileLazySingleton == null) {
                System.out.println("threadSafeLazySingleton is null when the count is " + count + " and it will be created");
                threadSafeVolatileLazySingleton = new ThreadSafeVolatileLazySingleton();
            }
        }
        return threadSafeVolatileLazySingleton;
    }

    public static ThreadSafeVolatileLazySingleton getInstanceWithBetterPerformance() {
        if(threadSafeVolatileLazySingleton == null) {
            synchronized (ThreadSafeVolatileLazySingleton.class) {
                if(threadSafeVolatileLazySingleton == null) {
                    threadSafeVolatileLazySingleton = new ThreadSafeVolatileLazySingleton();
                }
            }
        }
        return threadSafeVolatileLazySingleton;
    }

    public void printName() {
        System.out.println(this.name);
    }

    public static ThreadSafeVolatileLazySingleton getStatic() {
        return threadSafeVolatileLazySingleton;
    }

    @Override
    public String toString() {
        return name;
    }
}
