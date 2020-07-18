package test;

/**
* 
*
* @author zfk
* @date 2019年11月11日 下午9:25:50 
* 
*/
public class Father {

    protected int i = 12;
    public int j = 13;
    String s = "abc";
   
    protected void get(Father a) {
        System.out.println(a.i);
    }
    protected void set(int x) {
        this.i = x;
    }
    protected void get() {
        System.out.println(this.i);
    }

}
