import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class CP1_AgendarCitaTest {
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
    @DisplayName("CP1: Agendar cita correctamente")
    void testAgendar() throws InterruptedException {
        sistema.agendarCita("Sookie", "10:00 AM");

        Thread.sleep(2000); // espera a que el HTML actualice

        String resultado = driver.findElement(By.id("mensaje")).getText();
        assertTrue(resultado.contains("Cita creada"), "El mensaje no es el esperado");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}