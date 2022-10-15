package dz.bououza;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/calculator")
public class CalculatorResource {

    @Inject
    CalculatorService calculatorService;

    @GET
    @Path("sum")
    @Produces(MediaType.TEXT_PLAIN)
    public String sum(@QueryParam("a") Integer a, @QueryParam("b") Integer b) {
        return String.valueOf(calculatorService.sum(a,b));
    }
}