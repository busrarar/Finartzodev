
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class odevim {
    protected WebDriver driver;
    public static String finartz = "https://www.finartz.com/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

        @Test
        public void correctLogin() {
            driver.get(finartz);
            WebElement solutions = driver.findElement(By.linkText("Solutions"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", solutions);

            List<String> anabasliklar = new ArrayList<String>();


            List<WebElement> elements = driver.findElements(By.className("box-title"));
            for(WebElement element : elements) {

                anabasliklar.add(element.getText());
            }
            System.out.println(anabasliklar);

            WebElement blog = driver.findElement(By.xpath("/html/body/div[3]/div[2]/nav/div/div[2]/div/a[6]"));
            JavascriptExecutor executo = (JavascriptExecutor) driver;
            executo.executeScript("arguments[0].click();", blog);

            Set<String> allHandles = driver.getWindowHandles();
            String currentWindowHandle = allHandles.iterator().next();
            allHandles.remove(allHandles.iterator().next());
            String lastHandle = allHandles.iterator().next();
            driver.switchTo().window(lastHandle);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            WebElement search = driver.findElement(By.cssSelector(".svgIcon.svgIcon--search"));
            search.click();

            WebElement searchare = driver.findElement(By.className("js-predictiveSearchInput"));
            searchare.click();
            searchare.sendKeys(anabasliklar.get(1));
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            WebElement makesearch = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[6]/div[1]/div/a[2]"));
            makesearch.click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);








        }

    @After
    public void tearDown() {
        driver.quit();
    }



}
