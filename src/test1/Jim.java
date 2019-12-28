package test1;

/**
* 
*
* @author zfk
* @date 2019年12月10日 下午8:28:04 
* 
*/
public class Jim implements Jim1, Jim2 {
    @Override
    public void jim() {
        //System.out.println(Jim1.super);
        Jim2.super.jim();
        System.out.println(super.getClass());
        System.out.println(this.getClass());
    }

    public static void main(String[] args) {
        new Jim().jim();
    }
}
interface Jim1 {
    default void jim() {
        System.out.println("Jim1::jim");
    }
}

interface Jim2 {
    default void jim() {
        System.out.println("Jim2::jim");
    }
}
