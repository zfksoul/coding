package test;

public class TestThread {
    String s = "abc";
    public static void main(String[] args){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("run()");
                DThread d = new DThread();
            }
        };
        Thread t1 = new Thread(r, "a");
        Thread t2 = new Thread(r, "b");
        t1.start();
        t2.start();
    }
}

class DThread{

    static {
        if (true){
            System.out.println("DThread static{}");
            while (true){

            }

        }
    }
    {
        System.out.println("DThread {}");
    }
}
