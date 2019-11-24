package game.backend.DAO;
import java.util.HashMap;
import java.util.List;

/**
 * Interface that will manage all the DB operations
 * like get,save, particular query...
 */

public interface Session <E> {
    void save(Object entity);
    void close();
    //Object get(Class theClass, int ID);
    //void update(Object object);
    //void delete(Object object);
    //List<Object> findAll(Class theClass);
    //List<Object> query(String query, Class theClass, HashMap params);
}
