package test;

import test.Father;

/**
* 
*
* @author zfk
* @date 2019年11月11日 下午9:30:34
 * 如果子类和父类在一个包，则子类可以访问通过继承、组合、传参得到的对象的父类protected成员和属性，
 * 参数类型包括父类型和子类型
* 
*/
public class Sun extends Father{
    public static void main(String[] args) {
        Sun s1 = new Sun();
        Sun s2 = new Sun();
        s1.get(s2);
        s1.get();
        Father f1 = new Father();
        System.out.println(s1.i);
        System.out.println(f1.i);
        s1.printF(f1);
        s1.printS(s2);
    }

    public void printF(Father f) {
        System.out.println(f.i);   //通过父类型直接调用

    }
    public void printS(Sun s) {
        System.out.println(s.i);     //

    }
    public void print() {
        System.out.println(this.i);  //可以访问父类的属性，通过super访问

    }
}