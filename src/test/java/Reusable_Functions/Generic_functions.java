package Reusable_Functions;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Generic_functions {
	public static AppiumDriver driver;
	//public static IOSDriver<MobileElement> driver;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell,f;
	public static XSSFRow row;
	public static String CellData,path;
	public static int iter; 
	public static int col;
	public static WebElement mob;
	static File file = new File("config/config.properties");
	static Properties prop = new Properties();

	/* Launch the application and provide desired capabilities of connected device.Also give the URL of the Appium server*/
	public static void app_launch() throws IOException {
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		prop.load(fileInput);
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        capabilities.setCapability(MobileCapabilityType.UDID, getUDID());
        capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, getBundleId());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"14.4");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver(url,capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	/* Function will fetch the device name from the config.properties file*/
	public static String getToken() {
		 path= prop.getProperty("Token");
		if(path!=null) return path ;
		else throw new RuntimeException ("Token is not specified in the Config.properties");
	}

	/* Function will fetch the device UDID from the config.properties file*/
	public static String getUDID() {
		String udid= prop.getProperty("udid");
		if(udid!=null) return udid ;
		else throw new RuntimeException ("udid is not specified in the Config.properties");
	}

	/* Function will fetch the platform version from the config.properties file*/
	public static String getBundleId() {
		path= prop.getProperty("app_bundleid");
		if(path!=null) return path ;
		else throw new RuntimeException ("Bundle Id is not specified in the Config.properties");
	}

	/* Refresh function to refresh the current page opened  */
	public static void page_refresh() {
		driver.navigate().refresh();
	}

	/* To wait the browser till the time passed to this function */
	public static void page_wait(int time) {
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.MILLISECONDS);
	}

	/* Reading Excel file path  from config.properties   */
	public static String getFilepath() {
		String filepath= prop.getProperty("Filepath");
		if(filepath!=null) return filepath ;
		else throw new RuntimeException ("Filepath is not specified in the Config.properties");
	}

	/*To get directory path of screenshots folder*/
	public static String getDir() {
		String dirpath= prop.getProperty("Dirpath");
		if(dirpath!=null) return dirpath ;
		else throw new RuntimeException ("user Dir is not specified in the Config.properties");
	}	

	/* To find object locator value of a particular fieldname passing to this function by loading */
	public static String OR_reader(String fieldname) throws IOException {	
//		Reader reader = Files.newBufferedReader(Paths.get(getFilepath()),Charset.forName("ISO-8859-1"));
		Reader reader=new BufferedReader(new InputStreamReader(new FileInputStream(getFilepath()),"utf-8"));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		for (CSVRecord csvRecord : csvParser) {
			String name = csvRecord.get(0);
			String val = csvRecord.get(2);
			if(name.equalsIgnoreCase(fieldname))
			{
				return val;
			}
        }
		return null;		
	}

	/* To read test data value of a particular fieldname passing to this function from csv file */
	public static String td_reader(String fieldname) throws IOException {	
//		Reader reader = Files.newBufferedReader(Paths.get(getcsv()));
		Reader reader=new BufferedReader(new InputStreamReader(new FileInputStream(getcsv()),"utf-8"));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		for (CSVRecord csvRecord : csvParser) {
			String name = csvRecord.get(0);
			String val = csvRecord.get(1);
			if(name.equalsIgnoreCase(fieldname))
			{
				return val;
			}
        }
		return null;		
	}
	
	
	/* To read test data value of a particular fieldname using index  where its values are seperated with a comma within cell in excel sheet  */
	public static String td_reader(String fieldname,int index) throws IOException {	
//		Reader reader = Files.newBufferedReader(Paths.get(getcsv()));
		Reader reader=new BufferedReader(new InputStreamReader(new FileInputStream(getcsv()),"utf-8"));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		for (CSVRecord csvRecord : csvParser) {
			String name = csvRecord.get(0);
			String val = csvRecord.get(1);
			if(name.equalsIgnoreCase(fieldname))
			{
				String[] values = val.split(",");
				return values[index];
			}
        }
		return null;		
	}

	/* Reading Doctor's report file path  from config.properties   */
	public static String getcsv() {
		 path= prop.getProperty("Test_csv");
		if(path!=null) return path ;
		else throw new RuntimeException (" csv path is not specified in the Config.properties");
	}	

	/*To get test data iteration value from config.properties file*/
	public static int Dataiter() {            
		iter=Integer.parseInt(prop.getProperty("Data_iteration"));
		return iter;		
	}

	/* Click operation for a particular fieldname that is passing to this function through finding locator value of fieldname using OR_reader function*/
	public static void click(String fieldname) throws IOException {
		driver.findElement(By.xpath(OR_reader( fieldname))).click();
	}
	
	/* To go back to the previous page */
	public static void page_back(){
		driver.navigate().back();
	}
	
	/*close the application*/
	public static void close() {
		driver.closeApp();
	}
	/*Function to clear the value in a particular field*/
	 public static void field_clear(String fieldname) throws IOException {
		mob = driver.findElement(By.xpath(OR_reader( fieldname)));
		mob.clear();
		 }
	 
	 /*  Taking Screenshot of failed test cases  */
		public static  void takeScreenShot(String fileName) throws Exception {
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(image, "png", new File(getDir()+fileName+".png")); 	
		}
		
		/*Login to mpowered health */
		public static void app_login(int index_user,int index_pwd) throws Exception {
			if (driver.findElement(By.xpath(OR_reader("login_phone_number"))).isDisplayed()) {
				try {
					page_explicit_wait("login_phone_number");
					click("login_phone_number");
					page_wait(3000);
					driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number", index_user));
					page_wait(3000);
					click("login_password");
					driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password", index_pwd));
					click("login");
				} catch (Exception e) {
					e.printStackTrace();
					takeScreenShot("app_login");
				}
			}
		}
			/* Waits till the element is clickable */
			public static void page_explicit_wait(String fieldname) throws Exception {
				WebDriverWait wait=new WebDriverWait(driver, TimeUnit.MILLISECONDS.toSeconds(10000));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR_reader(fieldname))));
			}

	
			}
	
