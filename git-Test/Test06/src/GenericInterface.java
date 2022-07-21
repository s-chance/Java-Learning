public interface GenericInterface<E> { //T、E等只是作为一个标识，不一定代表有T、E这些数据类型
    void funT(E e);

    String funST(E e,E data);
}
