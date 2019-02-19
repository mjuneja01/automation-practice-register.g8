import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class NegativeRegisterWhenCityIsMissing {

    @Test
    public void negativeRegister() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", RegistrationConstants.LOCATION_OF_CHROMEDRIVER);
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;

        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);

        driver.manage().window().maximize();

        driver.get("http://www.automationpractice.com/");

        Thread.sleep(3000);

        //click on Sign In link
        WebElement signInButton = driver.findElement(By.xpath("//a[contains(text(), \"Sign in\")]"));
        signInButton.click();

        Thread.sleep(3000);

        //Enter Email Address in Email Address textbox
        WebElement emailAddressTextBox = driver.findElement(By.id("email_create"));
        emailAddressTextBox.sendKeys(String.format("randomemail%d@gmail.com", rand_int1));

        Thread.sleep(3000);

        //Click on Create an Account button
        WebElement createAnAccountButton = driver.findElement(By.xpath("//button[@id=\"SubmitCreate\"]//span"));
        createAnAccountButton.click();

        Thread.sleep(3000);

        //Enter FirstName
        WebElement firstName=driver.findElement(By.id("customer_firstname"));
        firstName.sendKeys("TestFirstName");

        Thread.sleep(3000);

        //Enter LastName
        WebElement lastName=driver.findElement(By.id("customer_lastname"));
        lastName.sendKeys("TestLastName");

        Thread.sleep(3000);

        //Enter Password
        WebElement passwordTextBox=driver.findElement(By.id("passwd"));
        passwordTextBox.sendKeys("test@123");

        Thread.sleep(3000);

        //Enter Address
        WebElement address=driver.findElement(By.id("address1"));
        address.sendKeys("Raccoon Run");

        Thread.sleep(3000);

        //Select State from the state dropdown
        Select state= new Select(driver.findElement(By.id("id_state")));
        state.selectByVisibleText("Alaska");

        Thread.sleep(3000);

        //Enter Zip
        WebElement zip=driver.findElement(By.id("postcode"));
        zip.sendKeys("77033");

        Thread.sleep(3000);

        //Enter Mobile Phone
        WebElement mobilePhone=driver.findElement(By.id("phone_mobile"));
        mobilePhone.sendKeys("8765432143");

        Thread.sleep(3000);

        //click on Register button
        WebElement registerButton = driver.findElement(By.xpath("//button[@id = \"submitAccount\"]//span"));
        registerButton.click();

        Thread.sleep(3000);

        //Verify that registration failed and it is still on the same page.
        String url = driver.getCurrentUrl();
        System.out.println("url : " + url);
        Assert.assertTrue(url.contains("controller=authentication"));
        driver.quit();


           }

}
