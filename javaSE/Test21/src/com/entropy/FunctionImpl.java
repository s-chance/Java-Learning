package com.entropy;

import java.util.*;

//实现类,实现接口
public class FunctionImpl implements Function {
    //这边的map就相当于临时数据库,程序停止后,数据也会清空
    //之后连接SQL数据库则可以实现数据的长久保存

    //这边使用HashMap存储信息,以学号做为key,以学生信息作为value
    private Map<Integer, Student> map = new HashMap<>();

    //由于只是模拟,未投入生产开发,数据就通过手动输入提供
    private Scanner scanner = new Scanner(System.in);

    //初始化页面模拟,static代码块只会执行一次
    static {
        System.out.println("欢迎使用学生管理系统");
        System.out.println("初始化完成");
        System.out.println();
        System.out.println("可操作选项:");
        System.out.println("1.查询所有学生信息");
        System.out.println("2.添加学生信息");
        System.out.println("3.根据学号查找");
        System.out.println("4.根据名字查找");
        System.out.println("5.根据学号删除");
        System.out.println("6.根据学号修改");
        System.out.println("7.退出系统");
    }

    //退出系统提醒
    public void exit() {
        System.out.println("感谢使用");
    }

    @Override
    public void showAllInfo() {
        //由于学号是唯一的,所以不存在Set集合去重导致数据缺失的问题
        Set<Integer> id = map.keySet();
        if (id.size()==0) {
            System.out.println("还未添加数据");
        }
        Iterator<Integer> iterator = id.iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Student student = map.get(key);
            System.out.println(student);
        }
    }

    @Override
    public boolean addInfo() {
        int id = InputUtils.getInt("请输入学号");

        //判断出现操作失败后,是否要继续操作
        boolean addInfo = true;

        //遍历学生信息查找是否有已经存在的学号
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (id == integer) {
                System.out.println("添加失败,学号重复");
                int choose = InputUtils.getInt("是否继续?\n1.是\n2.否");
                while (choose != 1 && choose != 2) {
                    choose = InputUtils.getInt("是否继续?\n1.是\n2.否");
                }
                switch (choose) {
                    case 1:
                        //选择1 继续操作,回调
                        addInfo = addInfo();
                        break;
                    case 2:
                        //选择2 放弃操作,直接返回false给addInfo()
                        return false;
                }
            }
        }

        //由于使用了回调函数,这边需要再对addInfo进行返回值处理
        while (!addInfo) {
            return false;
        }

        String name = InputUtils.getStr("请输入名字");
        int age = InputUtils.getInt("请输入年龄");
        char sex = InputUtils.getChar("请输入性别(男/女)");

        Student student = new Student(id, name, age, sex);
        map.put(id, student);
        System.out.println("添加成功");
        return true;
    }

    @Override
    public Student searchById(int id) {
        Student student = map.get(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("未找到该学号");

            int choose = InputUtils.getInt("是否继续?\n1.是\n2.否");
            while (choose != 1 && choose != 2) {
                choose = InputUtils.getInt("是否继续?\n1.是\n2.否");
            }
            switch (choose) {
                case 1:
                    //选择1 继续操作
                    searchById();
                    break;
                case 2:
                    //选择2 放弃操作,直接返回null给searchById()
                    return null;
            }

        }
        return student;
    }

    //这边为了方便,使用方法重载在方法内部完成输入,避免在测试类写过多代码
    public Student searchById() {
        int id = InputUtils.getInt("请输入需要查询的学号");
        return searchById(id);
    }

    @Override
    public List<Student> searchByName(String name) {
        List<Student> list = new ArrayList<>();
        Collection<Student> values = map.values();
        Iterator<Student> iterator = values.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equals(name)) {
                list.add(student);
            }
        }
        return list.size()==0?null:list;
    }

    //重载
    public void searchByName() {
        String name = InputUtils.getStr("请输入要查找的名字");
        List<Student> list = searchByName(name);
        if (list == null) {
            System.out.println("未找到该名字");

            int choose = InputUtils.getInt("是否继续?\n1.是\n2.否");
            while (choose != 1 && choose != 2) {
                choose = InputUtils.getInt("是否继续?\n1.是\n2.否");
            }
            switch (choose) {
                case 1:
                    searchByName();
                    break;
                case 2:
                    return;
            }

        } else {
            System.out.println("查询结果:"+list.size()+"条");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

    @Override
    public boolean deleteById(int id) {
        Student remove = map.remove(id);
        return remove==null?false:true;
    }

    public void deleteById() {
        int id = InputUtils.getInt("请输入要删除的学号");
        boolean delete = deleteById(id);
        if (delete) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败,该学号不存在");

            int choose = InputUtils.getInt("是否继续?\n1.是\n2.否");
            while (choose != 1 && choose != 2) {
                choose = InputUtils.getInt("是否继续?\n1.是\n2.否");
            }
            switch (choose) {
                case 1:
                    deleteById();
                    break;
                case 2:
                    return;
            }

        }
    }

    //这边修改业务逻辑:修改信息,学号保持不变
    @Override
    public boolean modifyById(int id) {
        Student student = map.get(id);
        if (student != null) {
//            id = InputUtils.getInt("请输入新的学号");
//            //学号查重
//            Set<Integer> integers = map.keySet();
//            Iterator<Integer> iterator = integers.iterator();
//            while (iterator.hasNext()) {
//                Integer integer = iterator.next();
//                if (id == integer) {
//                    System.out.println("修改失败,学号已存在");
//                    modifyById();
//                }
//            }

            String name = InputUtils.getStr("请输入新的名字");
            int age = InputUtils.getInt("请输入新的年龄");
            char sex = InputUtils.getChar("请输入新的性别");

//            student.setId(id);
            student.setName(name);
            student.setAge(age);
            student.setSex(sex);
        }
        return student==null?false:true;
    }

    public void modifyById() {
        int id = InputUtils.getInt("请输入要修改的学号");
        boolean modify = modifyById(id);
        if (modify) {
            System.out.println("修改成功");
        } else {
            System.out.println("该学生不存在");

            int choose = InputUtils.getInt("是否继续?\n1.是\n2.否");
            while (choose != 1 && choose != 2) {
                choose = InputUtils.getInt("是否继续?\n1.是\n2.否");
            }
            switch (choose) {
                case 1:
                    modifyById();
                    break;
                case 2:
                    return;
            }

        }
    }
}
