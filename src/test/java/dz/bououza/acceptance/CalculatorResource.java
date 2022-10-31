package dz.bououza.acceptance;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey="calculator-api")
public interface CalculatorResource {
    @GET
    @Path("sum")
    @Produces(MediaType.TEXT_PLAIN)
    String sum(@QueryParam("a") Integer a, @QueryParam("b") Integer b);
}
