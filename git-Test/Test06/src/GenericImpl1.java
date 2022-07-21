public class GenericImpl1<E> implements GenericInterface {

    //实现泛型接口的方式，
    //1.在测试类创建对象的时候指定数据类型
    //2.在接口实现类中指定数据类型

    @Override
    public void funT(Object o) {
        System.out.println(o);
    }

    @Override
    public String funST(Object o, Object data) {
        return "success";
    }

    //泛型方法
    public E show(E e) {
        return e;
    }
}
