
import static org.junit.Assert.*;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Timer;
import java.util.TimerTask;



/**
 * @author Guilherme
 *
 */
public class MonitoringTool {

	// WebDriver instance
	public static WebDriver driver = null;
	int secundsPassed = 0;
	
	Timer myTimer = new Timer();
	TimerTask task = new TimerTask() {
		
		public void run() {
			secundsPassed++;
			//System.out.println("Seconds passed:" + secundsPassed);
		}
	};
	
	public void start() {
		myTimer.scheduleAtFixedRate(task,10000,7200000); // 7200000ms corresponde a 2hora, 10000 corresponde a 1sec apos o start
	}

	public static void main(String[] args) throws InterruptedException {
		/*
		 * This method executes all the class´s methods 
		 * 
		 */
		
		//isto ira monitorizar de 2 em 2horas
//		MonitoringTool monitor2hours = new MonitoringTool();
//		monitor2hours.start();

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		// Initialize browser
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		if (testWordpresslogin()) {
			System.out.println("Test Wordpress Login: Passed");

			Thread.sleep(2000);
			driver.navigate().to("http://localhost/wordpress");
			System.out.println("Entramos no Website!");
		} else {
			System.out.println("Test Wordpress Login: Failed");
			sendEmailLogin();
		}
		Thread.sleep(5000);

		if (testWordpressRepository()) {
			System.out.println("Test Wordpress Repository: Failed");

			sendEmailRepository();
			System.out.println("NOT FOUND Website!");
			Thread.sleep(2000);

		} else {
			System.out.println("Test Wordpress Repository: Passed");

		}
		Thread.sleep(5000);

		if (testWordpressForms()) {
			System.out.println("Test Wordpress Forms: Failed");
			sendEmailForms();
			System.out.println("NOT FOUND Website!");
			Thread.sleep(2000);

		} else {
			System.out.println("Test Wordpress Forms: Passed");

		}
//		Thread.sleep(2000);
//		if (testMetricsPage()) {
//			System.out.println("Test Metrics Site Login: Passed");
//
//		} else {
//			System.out.println("Test Metrics Site Login: Failed");
//			sendEmailLogin();
//		}
//        // Close the browser and WebDriver
//        driver.close();
//        driver.quit();
	}

	static boolean testWordpresslogin() {
		/*
		 * This method faz um teste ao login do wordpress
		 * 
		 */

		try {
			// Open the wordpress site
			driver.navigate().to("http://localhost/wordpress/wp-admin");

			// Type in the username
			driver.findElement(By.id("user_login")).sendKeys("guilhermee");

			// Type in the password
			driver.findElement(By.id("user_pass")).sendKeys("ZLniRzUTYesiElkhH2");

			// Click the Submit button
			driver.findElement(By.id("wp-submit")).click();

			// Wait a little bit (4000 milliseconds)
			Thread.sleep(4000);

			// Check whether the h1 equals “Dashboard”
			if (driver.findElement(By.tagName("h1")).getText().equals("Dashboard")) {
				return true;
			} else {
				return false;
			}

			// If anything goes wrong, return false.
		} catch (final Exception e) {
			System.out.println(e.getClass().toString());
			return false;
		}
	}

	static boolean testWordpressRepository() {
		/*
		 * This method faz um teste aos repositorios do site wordpress
		 * 
		 */

		try {
			// Open the wordpress site, menu repository

			driver.navigate().to("http://localhost/wordpress/repository");

			// Check whether the h1 equals “UPS! NÃO FOI POSSÍVEL ENCONTRAR ESSA PÁGINA.”
			if (driver.findElement(By.xpath("//*[@id=\"main\"]/section/header/h1")).getText()
					.equals("UPS! NÃO FOI POSSÍVEL ENCONTRAR ESSA PÁGINA.")) {
				System.out.println("ERRO ENVIAR EMAIL AO ADMIN");
				return true;
			} else {
				System.out.println("Temos menu repositorio");
				return false;
			}

			// If anything goes wrong, return false.
		} catch (final Exception e) {
			System.out.println(e.getClass().toString());
			return false;
		}

	}

	static boolean testWordpressForms() {
		/*
		 * This method faz um teste ao formularios do site wordpress
		 * 
		 */

		try {
			// Open the wordpress site, menu forms

			driver.navigate().to("http://localhost/wordpress/forms");

			// Check whether the h1 equals “UPS! NÃO FOI POSSÍVEL ENCONTRAR ESSA PÁGINA.”
			if (driver.findElement(By.xpath("//*[@id=\"main\"]/section/header/h1")).getText()
					.equals("UPS! NÃO FOI POSSÍVEL ENCONTRAR ESSA PÁGINA.")) {
				System.out.println("ERRO ENVIAR EMAIL AO ADMIN");
				return true;
			} else {
				System.out.println("Temos menu Forms");
				return false;
			}

			// If anything goes wrong, return false.
		} catch (final Exception e) {
			System.out.println(e.getClass().toString());
			return false;
		}

	}

	// Tem problema na funçao click, nao avança
	static boolean testMetricsPage() {
		/*
		 * This method faz um teste ao site auxiliar de Record metrics of availability
		 * and uptime
		 * 
		 */

		try {

			// Open given URL to Record metrics of availability and uptime
			// driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "T");

			driver.navigate().to("https://uptimerobot.com/login");

			// Type in the username
			driver.findElement(By.id("userEmail")).sendKeys("gacaa@iscte-iul.pt");

			// Type in the password
			driver.findElement(By.id("userPassword")).sendKeys("robot2020");

			// Click the Submit button
			driver.findElement(By.id("loginUserForm")).click();
			// Click the Submit button
			// driver.findElement(By.linkText("Login"));

			// If anything goes wrong, return false.
			if (driver.findElement(By.tagName("h1")).getText().equals("Dashboard")) {
				return true;
			} else {
				return false;
			}
		} catch (final Exception e) {
			System.out.println(e.getClass().toString());
			return false;
		}

	}

	// metodo para envio de email referente a falha de login para admin
	public static void sendEmailLogin() {
		/*
		 * This method faz envio de Email para o administrador em caso de falha no teste
		 * de login
		 * 
		 */

		Properties props = new Properties();

		/** Parâmetros de conexão com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// autenticaçao pelo gmail com login,password
				return new PasswordAuthentication("reportr22@gmail.com", "reportmonitoring2020");
			}
		});

		/** Ativa Debug para sessão */
		// session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("reportr22@gmail.com"));
			// Remetente

			Address[] toUser = InternetAddress.parse("reportr22@gmail.com");

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("REPORT ALERT!!!");// Assunto
			message.setText("Deteção de uma falha no login!");

			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Email enviado!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	// metodo para envio de email referente a falha de repositorio para admin
	public static void sendEmailRepository() {
		/*
		 * This method faz envio de Email para o administrador em caso de falha no teste
		 * de repositorio
		 * 
		 */

		Properties props = new Properties();

		/** Parâmetros de conexão com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// autenticaçao pelo gmail com login,password
				return new PasswordAuthentication("reportr22@gmail.com", "reportmonitoring2020");
			}
		});

		/** Ativa Debug para sessão */
		// session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("reportr22@gmail.com"));
			// Remetente

			Address[] toUser = InternetAddress.parse("reportr22@gmail.com");

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("REPORT ALERT!!!");// Assunto
			message.setText("Deteção de uma falha no repositorio do wordpress!");

			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Email enviado!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	// metodo para envio de email referente a falha de forms para admin
	public static void sendEmailForms() {
		/*
		 * This method faz envio de Email para o administrador em caso de falha no teste
		 * de forms
		 * 
		 */
		Properties props = new Properties();

		/** Parâmetros de conexão com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// autenticaçao pelo gmail com login,password
				return new PasswordAuthentication("reportr22@gmail.com", "reportmonitoring2020");
			}
		});

		/** Ativa Debug para sessão */
		// session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("reportr22@gmail.com"));
			// Remetente

			Address[] toUser = InternetAddress.parse("reportr22@gmail.com");

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("REPORT ALERT!!!");// Assunto
			message.setText("Deteção de uma falha forms do wordpress!");

			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Email enviado!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
