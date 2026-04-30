import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class CP6_AccesoNoAutorizadoTest {
    WebDriver driver;
    SistemaCitas sistema;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("file:///C:/Users/Maria/Downloads/Veterinaria_Automation/index.html");

        sistema = new SistemaCitas(driver);
    }

    @Test
    @DisplayName("CP6: Acceso no autorizado a citas ajenas")
    void testAccesoSeguridad() throws InterruptedException {

        // Simulamos clic en botón de acceso
        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);

        String mensaje = driver.findElement(By.id("mensaje")).getText();

        assertEquals("Acceso denegado", mensaje);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}