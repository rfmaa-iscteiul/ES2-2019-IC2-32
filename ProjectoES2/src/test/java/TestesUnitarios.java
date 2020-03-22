
import static org.junit.jupiter.api.Assertions.*;


import java.io.IOException;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Marcio Jesus, Tiago Sil, Rúben Almeida, Guilherme Almeida, António Godinho, João Ferro 
 * @version 1
 *
 */

public class TestesUnitarios{ 
	private HelloWorld hw;
	
	
	 @Test
	 public void teste() throws IOException{
		 HelloWorld wd = new HelloWorld();
		 String s = wd.print();
		 assertEquals("Hello world this is ES group 32!!", s);
		 
	 }
	@Test
	public void testeHelloWorld() throws IOException{
		hw = new HelloWorld();
		String s = hw.print();
		assertEquals("Hello world this is ES group 32!!",s);
	}
}
