package testsuits;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValid
 * Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed
 * on page
 */
public class LoginTest extends BaseTest {
    String baseURL ="https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseURL);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //Verify the text “PRODUCTS”
        String actualText=driver.findElement(By.xpath("//span[text()='Products']")).getText();
        String expectedText="Products";
        Assert.assertEquals("Products not displayed correctly",expectedText,actualText);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //actual element
        String actualElement = driver.findElement(By.xpath("//span[@class='title']")).getText();
        //expected elemement text
        String expectedElement = "Products";
        //Compare
        Assert.assertEquals("Products Text is verified", expectedElement, actualElement);

        //expected list size
        int expectedListSize = 6;
        //actual list size
        int actualListSize = driver.findElements(By.xpath("//div[@class='inventory_list']/div")).size();
        Assert.assertEquals("size of the product list are verified", expectedListSize, actualListSize);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
    }