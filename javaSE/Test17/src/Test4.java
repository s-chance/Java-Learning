import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Test4 {
    //先简单了解一下注解

    //反射操作注解
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class person = Class.forName("Teacher");

        //通过反射获取注解
        Annotation[] annotations = person.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation); //@TableData(value=db_teacher)
        }

        //获取注解value的值
        //getAnnotation(.class) ：获得指定的注解
        TableData annotation = (TableData) person.getAnnotation(TableData.class);
        String value = annotation.value();
        System.out.println(value); //db_teacher

        System.out.println();

        //获取类指定的注解@FieldData
        Field name = person.getDeclaredField("name");
        FieldData fieldData = name.getAnnotation(FieldData.class);
        System.out.println(fieldData.columnName());
        System.out.println(fieldData.type());
        System.out.println(fieldData.len());
    }
}


@TableData("db_teacher")
class Teacher {
    @FieldData(columnName = "db_id", type = "int", len = 10)
    private int id;
    @FieldData(columnName = "db_age", type = "int", len = 10)
    private int age;
    @FieldData(columnName = "db_name", type = "varchar", len = 255)
    private String name;

    public Teacher() {
    }

    public Teacher(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableData {
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldData {
    String columnName(); //列名
    String type(); //类型
    int len(); //长度
}

