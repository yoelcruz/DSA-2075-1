package game.backend.services;

import game.backend.models.User;
import game.backend.UsersManager;
import game.backend.UsersManagerImp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/users", description = "Endpoint to User Service")
@Path("/users")
public class UsersService {

    private UsersManager um;

    public UsersService() {
        this.um = new UsersManagerImp().getInstance();
        if (um.size()==0) {
            this.um.addUser("yooel", "1234", "yoel");
            this.um.addUser("albeeerto", "1234", "alberto");
            this.um.addUser("daaani", "1234", "dani");
            this.um.addUser("jooona", "1234", "jona");
            this.um.addObjetWithNameUser("yoel","espada",1, 5);
            this.um.addObjetWithNameUser("alberto","cofre",0, 0);
            this.um.addObjetWithNameUser("dani","escudo",5, 1);
            this.um.addObjetWithNameUser("jona","escudo",5, 1);
        }
    }

    @GET
    @ApiOperation(value = "get all usuarios", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
    })
    @Path("/sortedAlphabetically")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {

        List<User> users = this.um.usersSortedAlphabetically();

        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(users) {
        };
        return Response.status(201).entity(entity).build();
    }

  /*  @POST
    @ApiOperation(value = "Create a new Usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Usuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUsuario(User user) {

        if (user.getId()==null)  return Response.status(500).entity(usuario).build();
        this.um.addUsuario(usuario);
        return Response.status(201).entity(usuario).build();
    }

    @PUT
    @ApiOperation(value = "Update a Usuario with the id that you write", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateUsuarioById(Usuario usuario) {

        Usuario u = this.um.updateUsuarioById(usuario);

        if (u == null) return Response.status(404).build();

        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "Get a Usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "Usuario not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarioById(@PathParam("id") String id) {
        Usuario u = this.um.getUsuarioById(id);
        if (u == null) return Response.status(404).build();
        else  return Response.status(201).entity(u).build();
    }

    @GET
    @ApiOperation(value = "Get Objeto de un usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Usuario not found")
    })
    @Path("/{id}/objetos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjetoDeUnUsuario(@PathParam("id") String id) {
        Usuario u = this.um.getUsuarioById(id);
        if (u == null) return Response.status(404).build();
        else {
            List<Objeto> objetos = u.getObjetos();
            GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objetos) {};
            return Response.status(201).entity(entity).build();
        }
    }


    @POST
    @ApiOperation(value = "Crear un objeto", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer="List"),
            @ApiResponse(code = 404, message = "Usuario not found"),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/{id}/objetos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearObjeto(@PathParam("id") String id, Objeto objeto) {

        Usuario u = this.um.getUsuarioById(id);
        if (u == null) return Response.status(404).build();
        else  {
            u.addObjeto(objeto.getName(),objeto.getCantidad());
            return Response.status(201).entity(objeto).build();
        }
    }*/
}
