package SpiceJet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class spiceJet {
    static WebDriver driver;

    public static void launchWebsite(String url){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\H P\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
    }

    public static void selectDepartureCity(String city) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText(city)).click();
    }

    public static void selectArivalCity(String city) throws InterruptedException {
        driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTXT")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText(city)).click();
        Thread.sleep(2000);
    }

    public static void selectDepartureDate(String date) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("custom_date_picker_id_1")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText(date)).click();
    }

    public static void selectCurrency() throws InterruptedException {
        Thread.sleep(1000);
//        driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency")).click();
        WebElement dropDownElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListCurrency"));

        Select dropDown = new Select(dropDownElement);

        dropDown.selectByVisibleText("BDT");
    }

    public static void searchFlight() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit")).click();
    }

    public static void main(String[] args) throws InterruptedException {
        launchWebsite("https://book.spicejet.com/search.aspx");
        selectDepartureCity("Chennai (MAA)");
        selectArivalCity("Delhi (DEL)");
        selectDepartureDate("20");
        selectCurrency();
        searchFlight();
    }
}
