

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * covid-sci-discoveries
 *
 * @author Ruben
 * @version 1
 * 
 *
 */

public class CovidSciDiscoveriesTests 
{

	
	private CovidSciDiscoveries csd;
	
	
    /**
     * Teste às colunas da table
     */
	
    @Test
    public void testColumns(){
    	csd = new CovidSciDiscoveries("CovidSciDiscoveries", true, 4,4);
    	int columns = 4;
    	assertEquals(columns, csd.getColumns());
        
    }
    
    /**
     * Teste ao HTML_START
     */
    @Test
    public void testHtmlStart(){
    	csd = new CovidSciDiscoveries("CovidSciDiscoveries", true, 4,4);
    	String s = csd.HTML_START;
    	assertEquals("<html>", s);
        
    }
    
    /**
     * Teste ao HTML_END
     */
    @Test
    public void testHTML_END(){
    	csd = new CovidSciDiscoveries("CovidSciDiscoveries", true, 4,4);
    	String s = csd.HTML_END;
    	assertEquals("</html>", s);
        
    }
    /**
     * Teste ao TABLE_START_BORDER
     */
    @Test
    public void testTABLE_START_BORDER(){
    	csd = new CovidSciDiscoveries("CovidSciDiscoveries", true, 4,4);
    	String s = csd.TABLE_START_BORDER;
    	assertEquals("<table border=\"1\">", s);
        
    }
    /**
     * Teste ao TABLE_START
     */
    @Test
    public void testTABLE_START(){
    	csd = new CovidSciDiscoveries("CovidSciDiscoveries", true, 4,4);
    	String s = csd.TABLE_START;
    	assertEquals("<table>", s);
        
    }
    /**
     * Teste ao TABLE_END
     */
    @Test
    public void testTABLE_END(){
    	csd = new CovidSciDiscoveries("CovidSciDiscoveries", true, 4,4);
    	String s = csd.TABLE_END;
    	assertEquals("</table>", s);
        
    }
    /**
     * Teste ao HEADER_START
     */
    @Test
    public void testHEADER_START(){
    	csd = new CovidSciDiscoveries("CovidSciDiscoveries", true, 4,4);
    	String s = csd.HEADER_START;
    	assertEquals("<th>", s);
        
    }
    /**
     * Teste ao HEADER_END
     */
    @Test
    public void testHEADER_END(){
    	csd = new CovidSciDiscoveries("CovidSciDiscoveries", true, 4,4);
    	String s = csd.HEADER_END;
    	assertEquals("</th>", s);
        
    }
    /**
     * Teste ao ROW_START
     */
    @Test
    public void testROW_START(){
    	csd = new CovidSciDiscoveries("CovidSciDiscoveries", true, 4,4);
    	String s = csd.ROW_START;
    	assertEquals("<tr>", s);
        
    }
    /**
     * Teste ao ROW_END
     */
    @Test
    public void testROW_END(){
    	csd = new CovidSciDiscoveries("CovidSciDiscoveries", true, 4,4);
    	String s = csd.ROW_END;
    	assertEquals("</tr>", s);
        
    }
    /**
     * Teste ao HTML_START
     */
    @Test
    public void testCOLUMN_START(){
    	csd = new CovidSciDiscoveries("CovidSciDiscoveries", true, 4,4);
    	String s = csd.COLUMN_START;
    	assertEquals("<td>", s);
        
    }
    /**
     * Teste ao HTML_START
     */
    @Test
    public void testCOLUMN_END(){
    	csd = new CovidSciDiscoveries("CovidSciDiscoveries", true, 4,4);
    	String s = csd.COLUMN_END;
    	assertEquals("</td>", s);
        
    }
    /**
     * Teste à Table
     */
    @Test
    public void testTable(){
    	csd = new CovidSciDiscoveries("CovidSciDiscoveries", true, 4,4);
    	String s = csd.build();
    	
    	assertEquals(s, s);
        
    }
    
}
