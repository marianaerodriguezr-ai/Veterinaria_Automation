# 🐾 Automatización de Pruebas - Sistema de Citas Veterinarias

## 📌 Descripción
Este proyecto implementa la automatización de pruebas funcionales para un sistema de gestión de citas veterinarias, utilizando Selenium WebDriver y JUnit.

El objetivo es validar el comportamiento del sistema mediante la ejecución de scripts automatizados que simulan acciones del usuario sobre una interfaz web.

---

## 🛠️ Tecnologías utilizadas

- Java
- JUnit 5
- Selenium WebDriver
- HTML (interfaz simulada)

---

## 📂 Estructura del proyecto

index.html
pom.xml
README.md

evidencias/

src/
 ├── main/java/
 │   └── SistemaCitas.java
 └── test/java/
     ├── CP1_AgendarCitaTest.java
     ├── CP2_CampoVacioTest.java
     ├── CP3_ConflictoHorarioTest.java
     ├── CP6_AccesoNoAutorizadoTest.java
     └── CP9_MascotaNoPerteneceTest.java
---

## ▶️ Cómo ejecutar el proyecto

1. Clonar o descargar el repositorio
2. Abrir el proyecto en Visual Studio Code, IntelliJ o Eclipse
3. Asegurarse de tener instalado:
   - Java
   - Google Chrome
   
   ### 🔧 Configuración adicional

Es necesario contar con Google Chrome instalado.

El ChromeDriver no se incluye en el repositorio para mantenerlo liviano y compatible con diferentes entornos. 

Para ejecutar las pruebas, se debe descargar el ChromeDriver correspondiente a la versión de Chrome desde el sitio oficial y configurarlo en el sistema.

4. Ejecutar los tests desde la carpeta `src/test/java`

---

## 🧪 Casos de prueba automatizados

| ID  | Escenario                              | Resultado esperado                  |
|-----|----------------------------------------|------------------------------------|
| CP1 | Agendar cita correctamente             | Cita creada exitosamente           |
| CP2 | Campo nombre vacío                     | Este campo es obligatorio          |
| CP3 | Conflicto de horario                   | Horario no disponible              |
| CP6 | Acceso no autorizado                   | Acceso denegado                    |
| CP9 | Mascota no pertenece al propietario    | Error de validación                |

---

## 📸 Evidencias

Las evidencias de ejecución se encuentran en la carpeta `evidencias`, donde se muestran los resultados de cada caso de prueba.

---

## 📌 Consideraciones

- El sistema utiliza un archivo HTML local como interfaz simulada.
- Se implementaron rutas dinámicas para garantizar la portabilidad del proyecto.
- Las pruebas utilizan esperas explícitas para mejorar la estabilidad.

---

## 🎯 Conclusión

La automatización de pruebas permitió validar de manera eficiente el comportamiento del sistema, asegurando la correcta ejecución de las funcionalidades principales.

El uso de Selenium y JUnit facilitó la detección de errores, mejoró la repetibilidad de las pruebas y fortaleció la calidad del software.

---

## 👩‍💻 Autor

Mariana Rodríguez
William Peralta