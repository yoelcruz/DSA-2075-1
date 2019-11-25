package game.backend;
import game.backend.*;
import game.backend.DAO.FactorySession;
import game.backend.DAO.Session;
import game.backend.models.User;
import java.sql.Connection;


public class MangAuthenticationImpl implements MangAuthentication {

    public int addUser(User u) {
        //We make the querry to the DB
        Session session = null;
        int employeeID = 0;
        try {
            session = FactorySession.openSession();
            session.save(u);
        }
        catch (Exception e) {
            // LOG
            return 1;
        }
        finally {
            session.close();
        }
        return 0;
    }

    private static String createQuerySELECT2(Object entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE username = ?");

        return sb.toString();
    }

    public int checkUser(String u, String p) {


        String theQuery = createQuerySELECT2(new User());

        //We check the user in the DB
        if((u.equals("Alb"))&&(p.equals("123"))) {
            return 0;
        }
        else
            return 1;
    }
}

