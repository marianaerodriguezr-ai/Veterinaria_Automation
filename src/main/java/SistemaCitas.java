import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SistemaCitas {
    WebDriver driver;

    public SistemaCitas(WebDriver driver) {
        this.driver = driver;
    }

    public void agendarCita(String mascota, String hora) {
        driver.findElement(By.id("nombre_mascota")).clear();
        driver.findElement(By.id("nombre_mascota")).sendKeys(mascota);

        driver.findElement(By.id("hora")).clear();
        driver.findElement(By.id("hora")).sendKeys(hora);

        driver.findElement(By.id("btn-guardar")).click();
    }

    public void intentarAccesoURL(String urlAjena) {
        driver.get(urlAjena);
    }

    public void validarRelacionPropietario(String cedula, String idMascota) {
        driver.findElement(By.id("cedula_propietario")).sendKeys(cedula);
        driver.findElement(By.id("id_mascota")).sendKeys(idMascota);
        driver.findElement(By.id("btn-validar")).click();
    }

    public String obtenerMensajeSistema(String idElemento) {
        try {
            return driver.findElement(By.id(idElemento)).getText();
        } catch (Exception e) {
            return "Elemento no encontrado";
        }
    }
}