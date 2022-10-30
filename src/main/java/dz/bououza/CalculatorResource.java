package dz.bououza;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

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

    @Inject
    HazelcastInstance hazelcastClient;

    @GET
    @Path("sum")
    @Produces(MediaType.TEXT_PLAIN)
    public String sum(@QueryParam("a") Integer a, @QueryParam("b") Integer b) {
        IMap<String,String> cache=hazelcastClient.getMap("operations-result-cache");
        String result = cache.getOrDefault(a+"+"+b,String.valueOf(calculatorService.sum(a,b)));
        cache.putIfAbsent(a+"+"+b,result);
        return result;
    }
    @GET
    @Path("minus")
    @Produces(MediaType.TEXT_PLAIN)
    public String minus(@QueryParam("a") Integer a, @QueryParam("b") Integer b){
        return String.valueOf(calculatorService.minus(a,b));
    }
}