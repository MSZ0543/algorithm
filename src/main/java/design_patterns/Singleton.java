package design_patterns;

/**
 * @program: algorithm
 * @description: 安全单例 双检锁
 * @author: szm
 * @create: 2020-01-19 15:47
 **/
public class Singleton {
    private static volatile Singleton singleton;

    private Singleton(){}

    public Singleton getSingelton(){
        if(singleton == null) {
            synchronized (Singleton.class) {
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
