package test;

/**
* 
*
* @author zfk
* @date 2019年11月11日 下午9:25:50 
* 
*/
public class A {

    protected int i = 12;
    public int j = 13;
   
    protected void get(A a) {
        System.out.println(a.i);
    }
    protected void set(int x) {
        this.i = x;
    }
    protected void get() {
        System.out.println(this.i);
    }

}
