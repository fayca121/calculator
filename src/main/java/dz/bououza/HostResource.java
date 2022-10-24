package dz.bououza;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Path("server")
public class HostResource {

    @GET
    @Path("host")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHostName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }

    @GET
    @Path("ip")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIpAddress() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }
}