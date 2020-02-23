package design_patterns;

import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description: 静态代理模式
 * @author: szm
 * @create: 2020-02-22 20:40
 **/
public interface  ProxyPattern {
    void say();
}

// 目标对象
class ProxyPatternImpl implements  ProxyPattern{

    // 目标对象接口
    @Override
    public void say() {
        System.out.println("这是目标对象接口方法");
    }

    @Test
    public void test() {
        ProxyPatternImpl p = new ProxyPatternImpl();
        Proxy proxy = new Proxy(p);
        proxy.say();
    }
}

// 代理对象
class Proxy implements ProxyPattern{

    private ProxyPattern target;

    Proxy(ProxyPattern target) {
        this.target = target;
    }

    // 代理对象接口
    @Override
    public void say() {
        System.out.println("这是代理类前置方法");
        target.say();
        System.out.println("这是代理类后置方法");
    }
}
