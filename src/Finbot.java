import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Finbot {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Selenium/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://nis.finbot.co.il/hs-admin/");
        driver.findElement(By.name("user_email")).sendKeys("dakota@nhcpa.co.il");
        driver.findElement(By.name("user_password")).sendKeys("4321");
        driver.findElement(By.name("btn_login")).click();
        Thread.sleep(2000);

        if (driver.getCurrentUrl().equals("https://nis.finbot.co.il/hs-admin/dashboard.php")) {
            driver.findElement(By.cssSelector("a[href*='list-invoice-selected.php?comp_type=1,2']")).click();
            Thread.sleep(2000);

            WebElement dropListMenael = driver.findElement(By.id("example1_manager"));
            Select dropValue = new Select(dropListMenael);
            dropValue.selectByValue("דקוטה");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@id=\"example1\"]/thead/tr/th[10]")).click();
            System.out.println(driver.findElement(By.className("dataTables_info")).getText());
            Thread.sleep(2000);

            driver.findElement(By.cssSelector("a[href*='outcome_details.php?listing_id=356697&statuses=a:1:{i:0;i:3;}&comp_type=1']")).click();
            Thread.sleep(5000);
            driver.quit();
        }
        else {
            driver.findElement(By.className("swal2-actions")).findElement(By.tagName("button")).click();
            System.out.println("Wrong UserName or UserPassword.");
            Thread.sleep(1000);
            driver.quit();
        }
    }
}

