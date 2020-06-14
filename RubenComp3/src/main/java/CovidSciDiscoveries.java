import java.io.File;
import java.io.FileInputStream;

import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import pl.edu.icm.cermine.ContentExtractor;
import pl.edu.icm.cermine.metadata.model.DateType;
import pl.edu.icm.cermine.metadata.model.DocumentAuthor;

/**
 * covid-sci-discoveries
 *
 * @author Ruben
 * @version 1
 * 
 * Utilizado código de criação de HTML table seguinte:
 * https://gist.github.com/2sbsbsb/2951464
 *
 */

public class CovidSciDiscoveries {

	private int columns;
	private final StringBuilder table = new StringBuilder();
	public static String HTML_START = "<html>";
	public static String HTML_END = "</html>";
	public static String TABLE_START_BORDER = "<table border=\"1\">";
	public static String TABLE_START = "<table>";
	public static String TABLE_END = "</table>";
	public static String HEADER_START = "<th>";
	public static String HEADER_END = "</th>";
	public static String ROW_START = "<tr>";
	public static String ROW_END = "</tr>";
	public static String COLUMN_START = "<td>";
	public static String COLUMN_END = "</td>";

	/**
	 * @param header
	 * @param border
	 * @param rows
	 * @param columns
	 */
	public CovidSciDiscoveries(String header, boolean border, int rows, int columns) {
		this.columns = columns;
		if (header != null) {
			table.append("<b>");
			table.append(header);
			table.append("</b>");
		}
		table.append(HTML_START);
		table.append(border ? TABLE_START_BORDER : TABLE_START);
		table.append(TABLE_END);
		table.append(HTML_END);
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public StringBuilder getTable() {
		return table;
	}

	public static String getHTML_START() {
		return HTML_START;
	}

	public static String getHTML_END() {
		return HTML_END;
	}

	public static String getTABLE_START_BORDER() {
		return TABLE_START_BORDER;
	}

	public static String getTABLE_START() {
		return TABLE_START;
	}

	public static String getTABLE_END() {
		return TABLE_END;
	}

	public static String getHEADER_START() {
		return HEADER_START;
	}

	public static String getHEADER_END() {
		return HEADER_END;
	}

	public static String getROW_START() {
		return ROW_START;
	}

	public static String getROW_END() {
		return ROW_END;
	}

	public static String getCOLUMN_START() {
		return COLUMN_START;
	}

	public static String getCOLUMN_END() {
		return COLUMN_END;
	}

	/**
	 * @param values
	 */
	public void addTableHeader(String... values) {
		if (values.length != columns) {
			System.out.println("Error column lenth");
		} else {
			int lastIndex = table.lastIndexOf(TABLE_END);
			if (lastIndex > 0) {
				StringBuilder sb = new StringBuilder();
				sb.append(ROW_START);
				for (String value : values) {
					sb.append(HEADER_START);
					sb.append(value);
					sb.append(HEADER_END);
				}
				sb.append(ROW_END);
				table.insert(lastIndex, sb.toString());
			}
		}
	}

	/**
	 * @param values
	 */
	public void addRowValues(String... values) {
		if (values.length != columns) {
			System.out.println("Error column lenth");
		} else {
			int lastIndex = table.lastIndexOf(ROW_END);
			if (lastIndex > 0) {
				int index = lastIndex + ROW_END.length();
				StringBuilder sb = new StringBuilder();
				sb.append(ROW_START);
				for (String value : values) {
					sb.append(COLUMN_START);
					sb.append(value);
					sb.append(COLUMN_END);
				}
				sb.append(ROW_END);
				table.insert(index, sb.toString());
			}
		}
	}

	/**
	 * @return
	 */
	public String build() {
		return table.toString();
	}

	
	/**
	 * Utilizado o Cermine para extração dos metadados dos PDFs:
	 * https://github.com/CeON/CERMINE
	 * Usado como depêndencia no POM.xml
	 * 
	 * Código exemplo de metodo de extração
	 * ContentExtractor extractor = new ContentExtractor();
	 * InputStream inputStream = new FileInputStream("path/to/pdf/file");
     * extractor.setPDF(inputStream);
	 * Element result = extractor.getContentAsNLM();
	 * 
	 * 
	 *É necessário mudar o diretorio que contem os pdfs que queremos ler
	 *É criado um tabela com linhas iguais ao numero de documentos e com 4 colunas:
	 *Title , Journal, Year, Authors
	 *O title vai conter uma hiperligação para o diretório onde estão os PDfs e ao clicar vai abrir numa nova janela o pdf correspondente
	 *
	 *Há a opção de gerar o ficheiro .html ou fazer um print do código HTML com a tabela pretendida
	 *
	 */
	public static void main(String[] args) {

		try {
			// Mudar o path do repositório
			File diretorio = new File(
					"C:\\Users\\r_fma\\Desktop\\ESII-complemento\\Covid-Scientific-Discoveries-Repository");
			int count = 0;
			
			if(count <= diretorio.listFiles().length) {
				String headline = "Covid Scientific Discoveries".toUpperCase();
				CovidSciDiscoveries htmlBuilder = new CovidSciDiscoveries(headline, true, count, 4);
				htmlBuilder.addTableHeader("Title", "Journal", "Year", "Authors");
			for (File file : diretorio.listFiles()) {
				ContentExtractor extractor = new ContentExtractor();
				InputStream inputStream = new FileInputStream(file);
				extractor.setPDF(inputStream);
				String name = "";
				String title = extractor.getMetadata().getTitle();
				String journal = extractor.getMetadata().getJournal();
				String year = extractor.getMetadata().getDate(DateType.PUBLISHED).getYear();
				for (DocumentAuthor a : extractor.getMetadata().getAuthors()) {
					name = name + " - " + a.getName() + " - ";
				}
				String hyperlink = file.getAbsolutePath();
				htmlBuilder.addRowValues("<a href="+ hyperlink +">"+ title + "</a>", journal, year, name);
				count++;
				}
			String table = htmlBuilder.build();
//			File newHtmlFile = new File("C:\\Users\\r_fma\\Desktop\\comp3.html");
//			FileUtils.writeStringToFile(newHtmlFile, table);
			System.out.println(table);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
