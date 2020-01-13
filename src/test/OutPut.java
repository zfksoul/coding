package test;

import java.util.ArrayList;
import java.util.List;

public class OutPut {
    public static void main(String[] args){
        List<People> list = new ArrayList<>();
        list.add(new People(1));
        list.add(new People(1));
        list.add(new People(1));
        System.out.println(list);
    }

    @Override
    public String toString() {
        return "OutPut{}"+super.toString();
    }
}
class People{
    String name;
    int age;
    public People(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'+super.toString();
    }
}

