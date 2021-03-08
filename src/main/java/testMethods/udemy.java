package testMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


import java.util.List;
import java.util.concurrent.TimeUnit;
import static Sync.waitMethods.*;


public class udemy {
    public static  WebDriver driver;
    public  static  JavascriptExecutor js ;
    public static void main(String[] args)  {
        try {
        System.setProperty("webdriver.chrome.driver","/home/i-exceed.com/sriganesh.d/Downloads/Driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://40.76.4.240:9095/AppzillonAdmin/");
        implicit();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
//        driver.findElement(By.id("details-button")).click();
//        driver.findElement(By.id("proceed-link")).click();
        //Thread.sleep(3000);

        driver.findElement(By.id("Admin__Login__userId")).sendKeys("admin");
        driver.findElement(By.id("Admin__Login__pswd")).sendKeys("admin");
        explicit("Admin__Login__element_button_1",5);
        driver.findElement(By.id("Admin__Login__element_button_1")).click();

        explicit("Admin__Landing__ct_mnu_2_Bank Parameters_li",8);
        hover("Admin__Landing__ct_mnu_2_Bank Parameters_li");
        explicit("Admin__Landing__ct_mnu_2_Staff Maintenance_li",2);
        driver.findElement(By.id("Admin__Landing__ct_mnu_2_Staff Maintenance_li")).click();

        driver.findElement(By.id("Admin__StaffMaintenanceQuery__userId")).sendKeys("sri");
        driver.findElement(By.id("Admin__StaffMaintenanceQuery__SearchButton")).click();
        driver.findElement(By.xpath("(//tbody/tr/td/a)[1]")).click();
        driver.findElement(By.id("Admin__StaffMaintenanceDetail__Unlock")).click();
        driver.findElement(By.id("Admin__StaffMaintenanceEdit__o__tbAsmiUser__DATEOFBIRTH")).click();
       // Thread.sleep(3000);
        // System.out.println(driver.findElement(By.cssSelector(".mbsc-cal-year")).getText().equals("2001"));

            dateSelect();
            Thread.sleep(2000);
            driver.findElement(By.id("Admin__StaffMaintenanceDetail__Cancel")).click();

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            System.out.println("I am alted");
            driver.quit();
        }

    }

    private static void dateSelect() throws InterruptedException {
        while(!driver.findElement(By.cssSelector(".mbsc-cal-year")).getText().equals("1999")){
            driver.findElement(By.xpath("//div[@aria-label='Previous Year']")).click();
            Thread.sleep(500);
        }
        while(!driver.findElement(By.cssSelector(".mbsc-cal-month")).getText().equals("Sep")){
            driver.findElement(By.xpath("//div[@aria-label='Next Month']")).click();
            Thread.sleep(500);
        }
        List<WebElement> day = driver.findElements(By.cssSelector(".mbsc-cal-day-fg"));
        for (WebElement e : day) {
            if (e.getText().equals("13")) {
                e.click();
                break;
            }
        }

    }
}
