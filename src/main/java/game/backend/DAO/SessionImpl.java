package game.backend.DAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SessionImpl implements Session {

    private final Connection conn;

    private Logger logger = Logger.getLogger(SessionImpl.class);

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }


    public void save(Object entity) {
        String insertQuery = QueryHelper.createQueryINSERT(entity);

        logger.debug("insertQuery "+ insertQuery);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            pstm.setObject(1, 0);
            int i = 2;
            Object value = null;
            for (String field: ObjectHelper.getFields(entity)) {
                if (!field.equals("ID")) {
                    value = ObjectHelper.getter(entity, field);
                    logger.debug("i: "+i+" field "+field+" value "+value);
                    pstm.setObject(i++, value);
                }
            }

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void close() {

    }
}
