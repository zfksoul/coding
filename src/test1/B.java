package test1;

import test.A;

/**
* 
*
* @author zfk
* @date 2019年12月8日 上午11:28:35 
* 
*/
public class B extends A {

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.i);
        
    }
    public void printa(B a) {
        System.out.println(this.i);  //可以访问父类的属性，通过super访问
        System.out.println(a.i);  //不能访问参数传过来的父类对象的属性
        
    }
    public <T extends H & F & G > void f(T a) {//用','会歧义，误认为后面的是新的泛型参数，而不是实现的接口
        
    }
}
interface F {
    
}
interface G {
    
}
class H{
    
}
