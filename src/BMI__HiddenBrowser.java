import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BMI__HiddenBrowser {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Selenium/Drivers/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless",  "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);


        driver.get("https://atidcollege.co.il/Xamples/bmi/");
        WebElement weight = driver.findElement(By.id("weight"));
        WebElement height = driver.findElement(By.name("height"));
        weight.sendKeys("160");
//        Thread.sleep(1000);
        height.sendKeys("220");
//        Thread.sleep(1000);
        driver.findElement(By.id("calculate_data")).click();
//        Thread.sleep(2000);

        System.out.println("Your BMI: "+driver.findElement(By.id("bmi_result")).getAttribute("value"));
        System.out.println("It Means: "+driver.findElement(By.id("bmi_means")).getAttribute("value"));

        driver.quit();
    }
}
