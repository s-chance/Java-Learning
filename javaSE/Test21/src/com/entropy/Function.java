package com.entropy;

import java.util.List;

//功能接口,这边理论上不写也能实现基本功能
//但正式开发中一定要写上,这是一种行业规范,也便于代码的维护更新
//根据功能的不同,决定一个方法是否需要返回值?需要什么类型的返回值?以及需要提供什么参数?
public interface Function {
    //遍历所有学生信息,这边由于简单化,直接在方法内部遍历输出信息,不返回值
    //实际上大项目对业务操作还会专门创建类来进行处理
    public void showAllInfo();
    //添加学生信息,返回值表示是否处理成功,删除和修改同理
    public boolean addInfo();
    //根据学号查找,学号唯一,返回一个Student对象即可
    public Student searchById(int id);
    //根据名字查找,名字可能重名,返回Student的list集合
    public List<Student> searchByName(String name);
    //根据学号删除
    public boolean deleteById(int id);
    //根据学号修改
    public boolean modifyById(int id);
}
