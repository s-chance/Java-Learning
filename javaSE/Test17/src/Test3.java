import entity.Person;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Test3 {
    //通过反射获取泛型
    public void test01(Map<String, Person> map, List<Person> list) {
        System.out.println("test01");
    }

    public Map<String, Person> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test3.class.getMethod("test01", Map.class, List.class);
        //getGenericParameterTypes():获得参数类型
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("参数:"+genericParameterType);
            //获取方法里面的参数类型getActualTypeArguments
            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("参数中的泛型:"+actualTypeArgument);
                }
            }
        }

        System.out.println();

        Method method2 = Test3.class.getMethod("test02", null);
        //返回值类型
        Type genericReturnType = method2.getGenericReturnType();

        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("返回值中的泛型:"+actualTypeArgument);
            }
        }
    }
}
