package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户名中的'.'会忽略掉，用户名中的'+'及之后的字符会忽略掉，求有多少个不同的邮箱地址
 * input:[
 *        "test.email+alex@leetcode.com",
 *        "test.e.mail+bob.cathy@leetcode.com",
 *        "testemail+david@lee.tcode.com"
 *        ]
 * output:2
 */
public class UniqueEmailAddresses {
    public static void main(String[] args){
        String[] emails = {"test.email+alex@leetcode.com",
                           "test.e.mail+bob.cathy@leetcode.com",
                           "testemail+david@lee.tcode.com"};
        UniqueEmailAddresses o = new UniqueEmailAddresses();
        System.out.println(o.myUniqueEmailAddress(emails));
        System.out.println(o.myUniqueEmailAddress1(emails));
    }
    public int myUniqueEmailAddress(String[] emails){
        Set<String> set = new HashSet<String>();
        for (String email : emails){
            int at = email.indexOf("@");
            String domain = email.substring(at);
            StringBuilder name = new StringBuilder();
            char c;
            for (int i = 0; i < at; i++){
                if ((c = email.charAt(i)) == '+') break;
                if (c != '.') name.append(c);
            }
            set.add(name.append(domain).toString());
        }
        return set.size();
    }
    public int myUniqueEmailAddress1(String[] emails){
        Set<String> set = new HashSet<>();
        for (String email : emails){
            int at = email.indexOf('@');
            String domain = email.substring(at);
            StringBuilder name = new StringBuilder();
            char c;
            for (int i = 0; i < at; i++){
                if ((c = email.charAt(i)) == '+') break;
                if (c != '.') name.append(c);
            }
            set.add(name.append(domain).toString());
        }
        return set.size();
    }
}
