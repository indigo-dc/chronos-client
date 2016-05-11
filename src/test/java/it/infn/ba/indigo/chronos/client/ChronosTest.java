package it.infn.ba.indigo.chronos.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

public class ChronosTest {

  private static final Logger LOG = Logger.getLogger(ChronosTest.class.toString());

  Chronos chronos;

  @Before
  public void setup() throws IOException {
    final Properties properties = new Properties();
    InputStream in = null;
    try {
      in = getClass().getClassLoader().getResourceAsStream("chronos.properties");
      properties.load(in);
    } catch (Exception e) {
      throw new RuntimeException(
          "Failed to load properties file ('chronos.properties') in 'test/resources' folder");
    } finally {
      in.close();
    }

    String endpoint = properties.getProperty("endpoint");
    String username = properties.getProperty("username");
    String password = properties.getProperty("password");
    LOG.info(String.format("Generating Chronos client with parameters: URL=%s, username=%s",
        endpoint, username));
    chronos = ChronosClient.getInstanceWithBasicAuth(endpoint, username, password);

  }

  @Test
  public void getJobs() {
    LOG.info(chronos.getJobs().toString());
  }

}