import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class LoginNavigationTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void navigatePIM() throws InterruptedException {
        driver.findElement(By.linkText("PIM")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void logoutTest() throws InterruptedException {
        driver.findElement(By.className("oxd-userdropdown-tab")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Logout")).click();
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}