import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automate4 {
		static public WebElement categ,cloth,shirt,red,product,cart;
		static String wd1,wd2;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:/Users/hp 1/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Category')]/..")));
		categ = driver.findElement(By.xpath("//span[contains(text(),'Category')]/.."));
		act.moveToElement(categ).perform();
		cloth = driver.findElement(By.xpath("//span[@aria-label='Men']/span"));
		act.moveToElement(cloth).perform();;
		shirt = driver.findElement(By.xpath("//span[contains(text(),'T-shirts & Polos')]"));
		act.moveToElement(shirt).click().perform();
		red = driver.findElement(By.xpath("//span[contains(text(),'Reds')]/.."));
		wait.until(ExpectedConditions.elementToBeClickable(red));
		red.click();
		product = driver.findElement(By.xpath("//span[contains(text(),\"Tinted Men's Cotton Polo T-Shirt\")]"));
		product.click();
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> itr = wh.iterator();
		wd1 = itr.next();
		wd2 = itr.next();
		driver.switchTo().window(wd2);
		cart = driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
		wait.until(ExpectedConditions.elementToBeClickable(cart));
		act.moveToElement(cart).click().perform();

		
	}

}
