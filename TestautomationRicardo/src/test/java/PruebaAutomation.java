import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PruebaAutomation {
	// DECLARACION DE VARIABLES
	private WebDriver driver;
	
	By Registro = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a");
	By Nombre = By.name("firstName");
	By Apeido = By.name("lastName");
	By Celular = By.name("phone");
	By Correo = By.id("userName");
	By Direccion1 = By.name("address1");
	By Direccion2 = By.name("address2");
	By Ciudad = By.name("city");
	By Estado = By.name("state");
	By CodgioPostal = By.name("postalCode");
	By Pais = By.name("country");
	By NombreLogin = By.id("email");
	By Contrase�a1 = By.name("password");
	By Contrase�a2 = By.name("confirmPassword");
	By Submit = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[18]/td/input");
	By EtiquetaHTML = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b");
	
	@Before
	public void setUp() {
		
		//INICIAR NAVEGADOR
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/ChromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");	
	}
	@Test
	public void RegistroUsuario() throws InterruptedException {
		
		String Titulo1 = "Welcome: Mercury Tours";
		String Titulo2 = driver.getTitle();
		String TEXTO;
		WebElement Etiqueta;
		WebElement Etiqueta2;
				
		//VALIDACION DE PAGINA CORRECTA
		if (Titulo2.contentEquals(Titulo1)) {
			System.out.println( "Se Ingreso correctamente a la pagina") ;
		}
		else{
			System.out.println( "No se pudo Ingreso correctamente a la pagina") ;
			driver.quit();
		}	
		
		//ESPERA PAGINA CARGADA
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Etiqueta= wait.until(ExpectedConditions.visibilityOfElementLocated(Registro));
		Etiqueta.click();
		
		//INFORMACION		
		driver.findElement(Nombre).sendKeys("Ricardo");
		driver.findElement(Apeido).sendKeys("Ovalles");		
		driver.findElement(Celular).sendKeys("6671452381");		
		driver.findElement(Correo).sendKeys("riicardo.ovalles@gmail.com");		
		driver.findElement(Direccion1).sendKeys("Tulipan 870");		
		driver.findElement(Direccion2).sendKeys("Ciudad de los ni�os");		
		driver.findElement(Ciudad).sendKeys("Zapopan");		
		driver.findElement(Estado).sendKeys("Jalisco");		
		driver.findElement(CodgioPostal).sendKeys("45040");		
		Select dropdown = new Select(driver.findElement(Pais));
		dropdown.selectByValue("132");
		driver.findElement(NombreLogin).sendKeys("Ricardo");		
		driver.findElement(Contrase�a1).sendKeys("prueba123");		
		driver.findElement(Contrase�a2).sendKeys("prueba123");		
		driver.findElement(Submit).click();
		
		//ESPERA LA PAGINA FINAL
		Etiqueta2= wait.until(ExpectedConditions.visibilityOfElementLocated(EtiquetaHTML));
		
		//VALIDACION DE TEXTO
		TEXTO = driver.findElement(EtiquetaHTML).getText();
		if(driver.getPageSource().contains(TEXTO)){
			System.out.println(TEXTO+" Es Correcto");
		}
		else
			System.out.println("El texto no se encontro");
		}
	@After
	public void tearDown() {
		driver.quit();
	}
}
