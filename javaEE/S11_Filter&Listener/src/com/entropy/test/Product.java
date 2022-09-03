package com.entropy.test;

public class Product implements SaleProxy {
    @Override
    public String sale(double money) {
        System.out.println("售价:"+money);
        return "新产品";
    }

    @Override
    public void show() {
        System.out.println("产品展示");
    }
}
