import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

public class CP3_ConflictoHorarioTest {
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
    @DisplayName("CP3: Conflicto de horario (Solapamiento)")
    void testHorarioOcupado() throws InterruptedException {

        sistema.agendarCita("Thabby", "10:30"); // horario ocupado

        Thread.sleep(2000);

        String alerta = driver.findElement(By.id("mensaje")).getText();

        assertTrue(alerta.contains("Horario no disponible"));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}