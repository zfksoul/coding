package test2;

import java.util.ArrayList;
import java.util.List;

public class A {
    static {
        System.out.println("static A");
    }
    public static void main(String[] args){
        B b = null;
        System.out.println("a");
        System.out.println("B.a="+B.a);

        List<Integer> integer = new ArrayList<>();
        fn(integer, new Object());

    }
    public static void fn(List list, Object o){

    }
}
class B{
    static int a = 11;
    static C c1 = null;
    static {
        System.out.println("static B");
    }
    public B(){
        System.out.println("B()");
        C c = new C();
    }
}
class C {
    static int c1 = 1;
    static {
        System.out.println("static  c");
    }
    public C(){
        System.out.println("C()");
    }

}
