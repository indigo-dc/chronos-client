package it.infn.ba.indigo.chronos.client.model.v1;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import it.infn.ba.indigo.chronos.client.ChronosClient;
import it.infn.ba.indigo.chronos.client.utils.ChronosException;

public class TokenAuthJobTest extends BaseJobTest {

	  @Before
	  public void setup() throws IOException {
		    final Properties properties = new Properties();
		    InputStream in = getClass().getResourceAsStream("application.properties");
		    properties.load(in);

		    chronos =
		        ChronosClient.getInstanceWithTokenAuth(properties.getProperty("tokenAuthJobTest.endpoint"),
		            properties.getProperty("tokenAuthJobTest.token"));
		  }
	  
	  
	  @Test
	  public void run() throws ChronosException {
		  System.out.println("Running test with token auth");
		  flow();	  
	  }

}
