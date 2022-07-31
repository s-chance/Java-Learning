package com.entropy;


//测试类,也是项目的启动类
public class Test {
    public static void main(String[] args) {
        //优先执行FunctionImpl的static代码块 初始化并展示操作选项
        //这边偷懒直接使用实现类的实例
        FunctionImpl function = new FunctionImpl();
        while (true) {
            int choose = InputUtils.getInt("请选择对应操作的序号");
            switch (choose) {
                case 1:
                    function.showAllInfo();
                    break;
                case 2:
                    function.addInfo();
                    break;
                case 3:
                    function.searchById();
                    break;
                case 4:
                    function.searchByName();
                    break;
                case 5:
                    function.deleteById();
                    break;
                case 6:
                    function.modifyById();
                    break;
                case 7:
                    function.exit();
                    return;
            }
        }
    }
}
