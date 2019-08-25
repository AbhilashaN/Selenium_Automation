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

public class Automate3 {
	static WebElement logo, categ, tv, spkr, spkr2,name,price;
	static String url, wd, wd1, wd2;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:/Users/hp 1/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 120);
		logo = driver.findElement(By.xpath("//a[@aria-label='Amazon']"));
		logo.click();
		url = driver.getCurrentUrl();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		//wd = driver.getWindowHandle();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Category')]/..")));
		categ = driver.findElement(By.xpath("//span[contains(text(),'Category')]/.."));
		act.moveToElement(categ).perform();
		tv = driver.findElement(By.xpath("//span[contains(text(),'TV, Appliances, Electronics')]"));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[contains(text(),'TV, Appliances, Electronics')]")));
		act.moveToElement(tv).perform();
		spkr = driver.findElement(By.xpath("//span[text()='Speakers']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Speakers']")));
		act.moveToElement(spkr).click().perform();
		Thread.sleep(5000);
		spkr2 = driver.findElement(By.xpath("((//h1[contains(text(),'Top deals in Speakers')]/..//following-sibling::div)[3]//a[@id='dealImage'])[2]/div/div/div/following-sibling::div"));
		wait.until(ExpectedConditions.elementToBeClickable(spkr2));
		spkr2.click();
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> itr = wh.iterator();
		wd1 = itr.next();
		wd2 = itr.next();
		//System.out.println(wd);
//		System.out.println(wd1);
//		System.out.println(wd2);
		driver.switchTo().window(wd2);
		name = driver.findElement(By.xpath("//span[@id='productTitle']"));
		price = driver.findElement(By.xpath("(//td[contains(text(),'Deal Price:')]/..//span)[1]"));
		System.out.println(name.getText());
		System.out.println(price.getText());
		driver.close();
		driver.switchTo().window(wd1);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@aria-label='Amazon']")));
//		logo.click();
//		System.out.println(url.equalsIgnoreCase(driver.getCurrentUrl()));

	}

}
