package game.backend;

import game.backend.models.User;
import org.junit.Test;

public class MangAuthenticationTest {
    MangAuthentication mauth;

    @Test
    public void testAddUser() {
        mauth = new MangAuthenticationImpl();
        mauth.addUser(new User("Alberto20", "1234", "Alb"));
    }

    @Test
    public void testGetUser() {
        mauth = new MangAuthenticationImpl();
        User aux = new User();
        aux.setID(3);

       // User user = mauth.addGet(new User());
       // user.get

    }
}
