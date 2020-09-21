package test2;

public class Out {
    private int i = 0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    class Inner1 {
        public void add(){
            i++;
        }
    }
    class Inner2 {
        public void add(){
            i++;
        }
    }
    public static void main(String[] args){
        Out o = new Out();
        Out o1 = new Out();
        Inner1 in11 = o.new Inner1();
        Inner1 in12 = o.new Inner1();
        Inner2 in3 = o1.new Inner2();
        //System.out.println(o.getI());
        in11.add();
        System.out.println(o.getI());
        in12.add();
        System.out.println(o.getI());
        in3.add();
        System.out.println(o1.getI());
    }
}
