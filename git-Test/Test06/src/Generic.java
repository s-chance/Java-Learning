public class Generic<T> { // <T>泛型的标志性格式，T代表一个数据类型：如Boolean，Integer...
    private T t;

    public Generic() {
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Generic(T t) {
        this.t = t;
    }
}
