package test;

public class BaseDao<T> {
    public BaseDao(){
        System.out.println("this.getClass():"+this.getClass());
        System.out.println("this.getClass().getGenericSuperclass():"
                +this.getClass().getGenericSuperclass());
        System.out.println("this.getClass().getGenericSuperclass().getClass():"
                +this.getClass().getGenericSuperclass().getClass());
    }

}
