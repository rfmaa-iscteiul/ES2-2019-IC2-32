

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * 
 * @author Marcio Jesus, Tiago Sil, Rúben Almeida, Guilherme Almeida, António Godinho, João Ferro 
 * @version 1
 *
 */

public class TestesUnitarios{ 
	private HelloWorld hw;
	
	
	public void testeHelloWorld() throws IOException{
		hw = new HelloWorld();
		String s = hw.print();
		assertEquals("Hello world this is ES group 32!!",s);
	}

}
