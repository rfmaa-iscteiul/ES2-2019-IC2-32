import static org.junit.Assert.*;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.w3c.dom.events.EventException;



public class TestesUnitarios {
	
	private MonitoringTool mo;
	
	
	@Test
	public void testMonitor() throws IOException, EventException, IllegalFormatException {
		mo= new MonitoringTool();
		mo.testWordpresslogin();
		mo.sendEmailLogin();
		mo.testWordpressRepository();
		mo.sendEmailRepository();
		mo.testWordpressForms();
		mo.sendEmailForms();
		mo.testMetricsPage();
	}
	
//	@Test
//	public void testWpLogin() throws IOException {
//		mo= new MonitoringTool();
//		boolean valor = mo.testWordpresslogin();
//		By.tagName("h1")).getText().equals("Dashboard"
//		assertTrue(valor);
//		}
//		
//
//		
		
		
		
		
		
		
		
		
		
	
	
	










}