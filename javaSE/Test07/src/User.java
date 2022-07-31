import java.util.Objects;

public class User implements Action,Comparable {
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private int age;

    @Override
    public void run() {

    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof User) {
            User user = (User)o;
            //return this.name.compareTo(user.name);//根据姓名排序，从小到大
            //return -this.name.compareTo(user.name);//从大到小排序

            //将age也考虑到排序中
            int compare = this.name.compareTo(user.name);

            if (compare != 0) {
                return compare;  //姓名不同，直接返回
            } else {
                return Integer.compare(this.age,user.age); //姓名相同，比较age
            }
        } else {
            throw new RuntimeException("can't cast");
        }

    }
}
