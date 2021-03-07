import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class udemy {
    public static  WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:/Sri Ganesh/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://40.76.4.240:9095/AppzillonAdmin/");
        driver.manage().window().maximize();
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("Admin__Login__userId")).sendKeys("admin");
        driver.findElement(By.id("Admin__Login__pswd")).sendKeys("admin");
        driver.findElement(By.id("Admin__Login__element_button_1")).click();
        Thread.sleep(5000);
        Actions act = new Actions(driver);
        Action actii = act.moveToElement(driver.findElement(By.id("Admin__Landing__ct_mnu_2_Bank Parameters_li"))).build();
        actii.perform();
        driver.findElement(By.id("Admin__Landing__ct_mnu_2_Staff Maintenance_li")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("Admin__StaffMaintenanceQuery__userId")).sendKeys("sri");;
        driver.findElement(By.id("Admin__StaffMaintenanceQuery__SearchButton")).click();
        driver.findElement(By.xpath("(//tbody/tr/td/a)[1]")).click();
        driver.findElement(By.id("Admin__StaffMaintenanceDetail__Unlock")).click();
        driver.findElement(By.id("Admin__StaffMaintenanceEdit__o__tbAsmiUser__DATEOFBIRTH")).click();
        Thread.sleep(3000);
        // System.out.println(driver.findElement(By.cssSelector(".mbsc-cal-year")).getText().equals("2001"));
        dateSelect();
        driver.findElement(By.id("Admin__StaffMaintenanceDetail__Cancel")).click();

    }

    private static void dateSelect() throws InterruptedException {
        //driver.switchTo().frame(driver.findElement(By.className("mbsc-fr-popup mbsc-ltr mbsc-fr-has-hdr")));
        while(!driver.findElement(By.cssSelector(".mbsc-cal-year")).getText().equals("1999")){
            driver.findElement(By.xpath("//div[@aria-label='Previous Year']")).click();
            Thread.sleep(1000);
        }
        while(!driver.findElement(By.cssSelector(".mbsc-cal-month")).getText().equals("Sep")){
            driver.findElement(By.xpath("//div[@aria-label='Next Month']")).click();
            Thread.sleep(1000);
        }
        List<WebElement> day = driver.findElements(By.cssSelector(".mbsc-cal-day-fg"));
        Iterator<WebElement> date = day.iterator();
        while(date.hasNext()){
            WebElement e = date.next();
            if(e.getText().equals("13")){
                e.click();
                break;
            }
        }

    }
}
