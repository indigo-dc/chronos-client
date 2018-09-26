package it.infn.ba.indigo.chronos.client.model.v1;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import it.infn.ba.indigo.chronos.client.ChronosClient;
import it.infn.ba.indigo.chronos.client.utils.ChronosException;

public class GpuJobTest extends BaseJobTest {

	@Override
	public void createJob(String name) throws ChronosException {
	    Job job = new Job();
	    job.setSchedule("R/2016-05-12T17:20:00Z/PT24H");
	    job.setName(name);
	    job.setOwner("junit");
	    job.setEpsilon("PT15M");
	    Container container = new Container();
	    container.setType("MESOS");
	    container.setImage("libmesos/ubuntu");
	    container.setForcePullImage(true);
	    job.setContainer(container);
	    job.setCpus(0.5);
	    job.setMem(512.0);
	    job.setGpus(1);
	    job.setCommand("echo hi; sleep 10; echo bye;");
	    System.out.println(job.toString());
	    chronos.createJob(job);
	  }
	
	
	@Before
	public void setup() throws IOException {
	    final Properties properties = new Properties();
	    InputStream in = getClass().getResourceAsStream("application.properties");
	    properties.load(in);

	    chronos =
	        ChronosClient.getInstanceWithBasicAuth(properties.getProperty("gpuJobTest.endpoint"),
	            properties.getProperty("gpuJobTest.username"), properties.getProperty("gpuJobTest.password"));
	  }
	  
	  
	  @Test
	  public void run() throws ChronosException {
		  System.out.println("Running test with GPU job");
		  flow();	  
	  }

}