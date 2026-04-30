import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class CP2_CampoVacioTest {
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
    @DisplayName("CP2: Registro sin nombre de mascota")
    void testNombreVacio() throws InterruptedException {

        sistema.agendarCita("", "10:00 AM");

        Thread.sleep(2000); // esperar respuesta del HTML

        String resultadoObtenido = driver.findElement(By.id("mensaje")).getText();

        assertEquals("Este campo es obligatorio", resultadoObtenido);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}