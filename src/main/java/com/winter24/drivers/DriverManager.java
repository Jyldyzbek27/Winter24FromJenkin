package com.winter24.drivers;
import com.winter24.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver==null){
            switch (ConfigReader.getValue("browser").toLowerCase()){
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "fireFox":
                    //TO do add drivers for firefox
                    break;
                default:
                    throw new IllegalArgumentException("You provided wrong Driver name");
            }
        }
        return driver;
    }

    public static void closeDriver(){
        try{
            if(driver != null) {
                driver.close();
                driver.quit();
                driver = null;
            }
            } catch(Exception e){
                System.err.println("Error while closing driver");

            }
        }
    }

