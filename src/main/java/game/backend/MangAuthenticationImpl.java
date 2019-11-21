package game.backend;

import com.sun.org.apache.xml.internal.utils.StringComparable;

public class MangAuthenticationImpl implements MangAuthentication {

    public int addUser(User u) {
        //We make the querry to the DB
        return 0;
    }


    public int checkUser(String u, String p) {
        //We check the user in the DB
        if((u.equals("Alb"))&&(p.equals("123"))) {
            return 0;
        }
        else
            return 1;
    }
}
