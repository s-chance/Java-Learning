package com.entropy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Product product = new Product();
        SaleProxy saleProxy = (SaleProxy) Proxy.newProxyInstance(product.getClass().getClassLoader(), product.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //代理模式
                        //proxy:代理对象 method:代理对象调用的方法 args:传递的实际参数
                        if (method.getName().equals("sale")) {
                            //增强参数
                            double money = (double) args[0];
                            money = money * 0.85;
                            System.out.println("快递运送");
                            //使用真实对象调用方法
                            String invoke = (String) method.invoke(product, money);
                            System.out.println("免快递费");

                            //增强返回值
                            return invoke + "赠品";
                        } else {
                            Object invoke = method.invoke(product, args);
                            return invoke;
                        }
                    }
                });

        //调用方法
        String sale = saleProxy.sale(8000);
        System.out.println(sale);
    }
}
