package test1;

/**
* 
*
* @author zfk
* @date 2019年12月12日 下午9:18:43 
* 
*/
public class Parcel2 {
    class Contents {
        private int i = 11;

        public int value() { return i; }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() { return label; }
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        Parcel2 q = new Parcel2();
        Parcel2.Contents c2 = q.contents();
        Parcel2.Destination d2 = q.to("Borneo");
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");
        Parcel2 q = new Parcel2();
        // Defining references to inner classes:
        Parcel2.Contents c = q.contents();
        Parcel2.Destination d = q.to("Borneo");
        Contents c2 = q.contents();
        Destination d2 = q.to("Borneo");
    }
}
class P{
    static class PP{}
    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");
        Parcel2 q = new Parcel2();
        // Defining references to inner classes:
        Parcel2.Contents c = q.contents();
        Parcel2.Destination d = q.to("Borneo");
        P p1 = new P();
        P.PP p3 = new P.PP();
    }
}
