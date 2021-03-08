package Sync;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import static testMethods.udemy.driver;
public class waitMethods {
    public static void implicit(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public static void explicit( String id,int time){
        WebDriverWait wb = new WebDriverWait(driver,time);
        wb.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

    }
    public static void hover(String id){
        Actions act = new Actions(driver);
        Action actii = act.moveToElement(driver.findElement(By.id(id))).build();
        actii.perform();
    }
}
