package game.backend.services;
import game.backend.FormReg;
import game.backend.MangAuthentication;
import game.backend.MangAuthenticationImpl;
import game.backend.User;
import game.backend.FormReg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/authen", description = "Endpoint to Authentucation Service")
@Path("/authent")
public class AuthenticationService {
    public MangAuthenticationImpl tm = new MangAuthenticationImpl();
    public AuthenticationService(){}

    @POST  //OKEY Create a new User
    @ApiOperation(value = "Create a new User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=User.class),
            @ApiResponse(code = 800, message = "Already exist this user",response = FormReg.class),
            @ApiResponse(code = 500, message = "Invalid parameters", response = int.class)


    })

    @Path("/reg")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(FormReg u) {

        if (u.getUsername()==null || u.getPassword()==null || u.getName() == null)  return Response.status(500).entity(u).build();
        User reg = new User(u.getUsername(),u.getPassword(),u.getName());
        int a = tm.addUser(reg);
        if (a == 0){return Response.status(201).entity(u).build();} //return reg
        else{return Response.status(800).entity(u).build();}
    }
    @POST  //OKEY Login User
    @ApiOperation(value = "Login a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=User.class),
            @ApiResponse(code = 800, message = "Already exist this user",response = FormReg.class),
            @ApiResponse(code = 500, message = "Invalid parameters", response = int.class)


    })

    @Path("/log")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logUser(FormReg u) {

        if (u.getUsername()==null || u.getPassword()==null)  return Response.status(500).entity(u).build();
        int a = tm.checkUser(u.getUsername(),u.getPassword());
        if (a == 0){return Response.status(201).entity(u).build();} //return reg
        else{return Response.status(800).entity(u).build();}
    }
}
