package com.datastructure.chapter01;

public class JavaAndPonit {

    //page12:
    //收获总结:
    //1.对象的访问是通过使用指针来实现的
    //2.对象会从实际的存储空间的某个位置开始占据一定数量的存储体
    //3.对象的指针就是一个保存了对象的存储地址的变量,且该地址就是对象在存储空间中的起始地址

    public static void main(String[] args){
        People p1 = new People("kobe", "39");//设实例化对象的地址为address1
        People p2 = p1;  //p2所引用的内容对应的存储地址也为address1
        p2.setName("mamba");//改变地址为address1的name的值
        System.out.println(p1.getName());//由于p1引用的值就是address1地址的值，address1的值改变了，所以p1.getName()就改变了
        System.out.println("p1 = p2? \n"+(p1 == p2));//p1 p2都指向同一块存储地址，地址相同，值相同---true

        People p3 = new People("james","33");
        People p4 = new People("james", "33");
        System.out.println("p3 = p4? \n"+(p3 == p4));  //p3 p4值相同，但是存储的地址不同。 ----false

    }
}
