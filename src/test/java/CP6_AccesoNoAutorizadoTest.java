import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CP6_AccesoNoAutorizadoTest {
    WebDriver driver;
    SistemaCitas sistema;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("file://" + System.getProperty("user.dir") + "/index.html");

        sistema = new SistemaCitas(driver);
    }

    @Test
    @DisplayName("CP6: Acceso no autorizado a citas ajenas")
    void testAccesoSeguridad() {

        driver.findElement(By.id("btn-acceso")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String mensaje = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("mensaje"))
        ).getText();

        assertEquals("Acceso denegado", mensaje);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}