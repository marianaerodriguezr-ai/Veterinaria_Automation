import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CP9_MascotaNoPerteneceTest {
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
    @DisplayName("CP9: Mascota no pertenece al propietario")
    void testIntegridadMascota() {

        sistema.validarRelacionPropietario("1254584", "99999");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String alerta = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("mensaje"))
        ).getText();

        assertEquals("La mascota no está asociada al propietario", alerta);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}