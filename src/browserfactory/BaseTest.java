package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Create the package ‘browserfactory’ and create the
 * class with the name ‘BaseTest’ inside the
 * ‘browserfactory’ package. And write the browser setup
 * code inside the class ‘Base Test’.
 */
public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseURL) {
        driver = new ChromeDriver();                    //Browser
        driver.get(baseURL);                            //Launch
        driver.manage().window().maximize();            //Maximise
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));      //Wait time
    }

    public void closeBrowser() {
        driver.quit();
    }
}
