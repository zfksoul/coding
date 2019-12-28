package test;

import test.A;

/**
* 
*
* @author zfk
* @date 2019年11月11日 下午9:30:34 
* 
*/
public class B extends A{
    public static void main(String[] args) {
        B b1 = new B();
        B b2 = new B();
        b1.get(b2);
        b1.get();
    }
    public void printA(A ta) {
        //System.out.println(this.a);
        System.out.println(ta.i);
    }
}