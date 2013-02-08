import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;
 

public class RunStenSaxPase
{
  
  
  public static void main(String[] args) throws Exception
  {
	Server server = new Server();
	
    String webappDirLocation = "src/main/webapp/";
 
	Connector connector = new SelectChannelConnector();
    connector.setPort(Integer.valueOf(System.getenv("PORT")));
    connector.setHost("0.0.0.0");
    server.addConnector(connector);

    WebAppContext vWac = new WebAppContext();
    //vWac.setDefaultsDescriptor("src/main/webapp/WEB-INF/webdefault.xml");
    vWac.setContextPath("/");
    vWac.setWar("src/main/webapp/");
    server.setHandler(vWac);
    
    server.start();
    server.join();
  }

