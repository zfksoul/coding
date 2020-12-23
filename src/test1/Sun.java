package test1;

import test.Father;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
* 
*
* @author zfk
* @date 2019年12月8日 上午11:28:35 
* 如果子类和父类不在一个包，则子类可以访问通过组合、传参得到的对象的父类protected成员和属性，
 * 组合、参数的类型只能是子类型，不能是父类型，不能通过父类型直接调用

 */
public class Sun extends Father {

    public static void main(String[] args) {
        Sun s1 = new Sun();
        Sun s2 = new Sun();
        Father f1 = new Father();
        System.out.println("System.out.println(s1.i)---"+s1.i);
        //System.out.println(f1.i); //组合的类型只能是子类型，不能是父类型，不能通过父类型直接调用
        s1.printF(f1);//组合
        s1.printS(s2);
        s1.print();
        s1.get(s2);//可以调用父类的方法访问，继承，传参
        s1.get();//继承
        List<Sun> s = new ArrayList<>();
        f(s);
    }

    public static void f(List<? extends Father> list){

    }

    public void printF(Father f) {
        System.out.println("printF(Father f)--xxx");
        //System.out.println(f.i);   //参数的类型只能是子类型，不能是父类型，不能通过父类型直接调用，传参

    }
    public void printS(Sun s) {
        System.out.println("printS(Sun s)---"+s.i);     //可以访问父类的属性，通过super访问，传参

    }
    public void print() {
        System.out.println("print()---"+this.i);  //可以访问父类的属性，通过super访问

    }
    public <T extends NoSun & F & G > void f(T a) {//用','会歧义，误认为后面的是新的泛型参数，而不是实现的接口
        
    }
}
interface F {
    
}
interface G {
    
}

/**
 * 包外非子类不能访问其他类的protected属性
 */
class NoSun{
    public static void main(String[] args) {
        Sun s1 = new Sun();
        Sun s2 = new Sun();
        Father f1 = new Father();
        //System.out.println(f1.i);
        //System.out.println(s1.i);
        s1.printF(f1);
        s1.printS(s2);

    }

    public void printF(Father f) {
        //System.out.println(this.i);  //不能访问
        //System.out.println(f.i);  //不能访问

    }
    public void printS(Sun s) {
        //System.out.println(this.i);  //不能访问
        //System.out.println(s.i);  //不能访问
    }
    public <T extends NoSun & F & G > void f(T a) {//用','会歧义，误认为后面的是新的泛型参数，而不是实现的接口

    }
}
