package test;

public class UserDao extends BaseDao<User> {
    public static void main(String[] args){
        new UserDao();
    }
}
class User{
    int name;
    int age;
}