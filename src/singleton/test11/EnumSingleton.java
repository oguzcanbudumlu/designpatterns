package singleton.test11;

import java.io.Serializable;

public enum  EnumSingleton implements Serializable {
    SINGLETON; // just one object of enumeration

    /**
     * `private` is redundant.
     */
    private EnumSingleton() {
//        String methodName =  new Object() {}.getClass().getEnclosingMethod().getName();
        System.out.println("in " + "EnumSingleton");
    }

    public static EnumSingleton getInstance() {
        return SINGLETON;
    }
}
