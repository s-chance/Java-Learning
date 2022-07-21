public class GenericImpl2 implements GenericInterface<Integer> {

    //实现泛型接口的方式，
    //1.在测试类创建对象的时候指定数据类型
    //2.在接口实现类中指定数据类型


    @Override
    public void funT(Integer integer) {
        System.out.println(integer);
    }

    @Override
    public String funST(Integer integer, Integer data) {
        return "Integer";
    }
}
