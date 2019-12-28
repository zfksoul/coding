package test;

/**
* 
*
* @author zfk
* @date 2019年12月8日 上午11:35:52 
* 
*/
public class C {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        D d = new D();
    }
    
}

class D{
    public D() {
        System.out.println("public D()");
    }
}