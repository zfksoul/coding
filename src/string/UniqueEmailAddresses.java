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
        System.out.print(o.myUniqueEmailAddress(emails));
    }
    public int myUniqueEmailAddress(String[] emails){
        Set<String> set = new HashSet<String>();
        for (String email : emails){
            int at = email.indexOf("@");
            String name = "";
            for (int i = 0; i < at; i++){
                if (email.charAt(i) == '+') break;
                if (email.charAt(i) != '.') name += email.charAt(i);
            }
            String domain = email.substring(at+1);
            //set.add(name.append("@").append(domain).toString());
            set.add(name+"@"+domain);
        }
        return set.size();
    }
}
