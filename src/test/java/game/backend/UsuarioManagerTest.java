package game.backend;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsuarioManagerTest {

    MangUser usuarioManager = null;

    @Before
    public void setUp()  {
        usuarioManager = new MangUserImp();

        usuarioManager.addUser("1", "yoel", "cruz torres");
        usuarioManager.addUser("2", "jose", "ruiz ortega");
        usuarioManager.addUser("3", "manuel", "torres castillo");
        usuarioManager.addUser("4", "laura", "jimenez lopez");
    }

    @Test
    public void addUsuario() {
        Assert.assertEquals("ProductManager addProduct", 4, usuarioManager.size());
    }

}
