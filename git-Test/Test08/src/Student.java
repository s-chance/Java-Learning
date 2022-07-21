public class Student extends People implements Comparable<Student>  {
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {
    }


    //根据年龄升序排序,自然排序的实现
    public int compareTo(Student o) {
        if (this.age > o.getAge()) {
            return 1;
        } else if (this.age < o.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }
}
