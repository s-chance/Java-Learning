public class Host {

    public void feed(Pet p) {
        //instanceof关键字,判断一个类是否为目标类的父类,保证父类转子类的安全性
        if(p instanceof Dog) {
            Dog dog = (Dog) p;
            dog.df(10);
        } else if(p instanceof Cat) {
            Cat cat = (Cat)p;
            cat.cf(20);
        }
        //通过这种方式就可以调用子类的特有的方法,可以减少代码量,不过注意使用instanceof来保证转换的安全性
    }
}
