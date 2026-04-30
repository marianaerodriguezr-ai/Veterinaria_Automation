import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class CP9_MascotaNoPerteneceTest {
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
    @DisplayName("CP9: Mascota no pertenece al propietario")
    void testIntegridadMascota() throws InterruptedException {

        sistema.validarRelacionPropietario("1254584", "99999");

        Thread.sleep(2000);

        String alerta = driver.findElement(By.id("mensaje")).getText();

        assertEquals("La mascota no está asociada al propietario", alerta);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}