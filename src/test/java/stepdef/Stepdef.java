package stepdef;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Stepdef {

	WebDriver driver;
	
	@Given("^login to practice url$")
	public void login_to_practice_url()
	{
		System.setProperty("webdriver.chrome.driver","E:/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
	}
	
	@Given("^landed on homepage$")
	public void landed_on_homepage()
	{
		System.out.println("landed on home page");
	}
	
	@When("^u will see radio button$")
	public void u_will_see_radio_button()
	{
		WebElement firstradio=driver.findElement(By.cssSelector("input[value='radio1']"));
	Boolean	radio1statusdisp=firstradio.isDisplayed();
	System.out.println(radio1statusdisp);
	Boolean	radio1statusselec=firstradio.isSelected();
	System.out.println(radio1statusselec);
	Boolean radio1statusenab=firstradio.isEnabled();
	System.out.println(radio1statusenab);
	}
	
	@Then("^click on radio button$")
	public void click_on_radio_button()
	{
		WebElement firstradio=driver.findElement(By.cssSelector("input[value='radio1']"));
		firstradio.click();
	}
	@Given("click on auto suggesstion text box")
	public void click_on_auto_suggesstion_text_box()
	{
		WebElement autosugbox=driver.findElement(By.xpath("//input[@id='autocomplete']"));
		autosugbox.click();
	}
	@When("enter just ind")
	public void enter_just_ind()
	{
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind");
	}
	@Then("select india from auto suggesstion")
	public void select_india_from_auto_suggesstion() throws InterruptedException
	{
		Thread.sleep(3000);
	List<WebElement> countries=driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']"));	
	
	System.out.println(countries.size());
	
	for (int i=0;i<countries.size();i++)
	{
		if(countries.get(i).getText().equals("India"))
		{
			countries.get(i).click();
			break;
		}
	}
	}
	 @Given("^click on dropdown$")
	    public void click_on_dropdown() throws Throwable {
		 
		 Select drpdwn=new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
		 drpdwn.selectByVisibleText("Option1");
		 
	        
	    }

	    @When("^ select any value from dropdown$")
	    public void select_any_value_from_dropdown() throws Throwable {
	        
	    	System.out.println("dropdown selected");
	    }

	    @Then("^click on that value$")
	    public void click_on_that_value() throws Throwable {
	        
	    	System.out.println("drpdown sellection done");
	    }
	    @Given("^click on checkbox$")
	    public void click_on_checkbox() throws Throwable {
	     WebElement chkbox= driver.findElement(By.xpath("//input[@id='checkBoxOption1']")); 
	     Boolean chkdis=chkbox.isDisplayed();
	     System.out.println(chkdis);
	    Boolean chkenb=chkbox.isEnabled();
	    System.out.println(chkenb);
	    Boolean chksel=chkbox.isSelected();
	    System.out.println(chksel);
	    chkbox.click();
	    Thread.sleep(5000);
	   
	    Boolean agnchksel=chkbox.isSelected();
	    System.out.println(agnchksel);
	    
	    
	    }

	    @When("^apply isdiplayed,isenabled,isselected$")
	    public void apply_isdiplayedisenabledisselected() throws Throwable {
	    	System.out.println("chk box selected");     
	    }
	    @Given("^click on child window link$")
	    public void click_on_child_window_link() throws Throwable {
	        
	    driver.findElement(By.xpath("//button[@id='openwindow']")).click();
	    Set<String> AllWindowId=driver.getWindowHandles();
	   Iterator<String>  itr=AllWindowId.iterator();
	   
	   String MainChildWInID=itr.next();
	   String ChildWindow=itr.next();
	   
	   driver.switchTo().window(ChildWindow);
	   String ChildWintitile=driver.getTitle();
	   System.out.println(ChildWintitile);
	   Assert.assertEquals("QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy", ChildWintitile);
	    }

	    @When("^chld window will get opened$")
	    public void chld_window_will_get_opened() throws Throwable {
	        
	    	System.out.println("child window handleing");
	    }

	    @Then("^move to child window and verify$")
	    public void move_to_child_window_and_verify()  {
	        
	    	System.out.println("child window handleing done ");
	    }
	    @Given("^click on open tab link$")
	    public void click_on_open_tab_link()  {
	       driver.findElement(By.xpath("//a[@id='opentab']")).click();
	       Set<String> TabHandleId=driver.getWindowHandles();
	       Iterator<String> tabitr=TabHandleId.iterator();
	     String  MainWindow=tabitr.next();
	     String  ChildWindow=tabitr.next();
	     driver.switchTo().window(ChildWindow);
	     String tabtite=driver.getTitle();
	     System.out.println(tabtite);
	     Assert.assertEquals("Rahul Shetty Academy", tabtite);
	     driver.findElement(By.xpath("//a[text()='Courses']")).click();
	    }

	    @And("^verify title of new page$")
	    public void verify_title_of_new_page()  {
	    	System.out.println("tab ");
	    }

	    @And("^click on courses$")
	    public void click_on_courses()  {
	    	System.out.println("tab handling ");
	    }
	    @Given("enter text and click on alert")
	   public void  enter_text_and_click_on_alert()
	   {
	    	driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys("deepak");
	    	driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
	   }
	    @And("then extract data from alert")
	    public void then_extract_data_from_alert() throws InterruptedException
	    {
	    	Thread.sleep(2000);
	    	String alettext=driver.switchTo().alert().getText();
	    	System.out.println(alettext);
	    }
	    @And("click on ok")
public void click_on_ok() throws InterruptedException
{
	    	Thread.sleep(2000);
	    	driver.switchTo().alert().accept();
	    	
	    	}
	    @And("click on confirm button and then cancel button")
	    public void click_on_confirm_button_and_then_cancel_button() throws InterruptedException
	    {
	    	driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys("deepak");
	    	driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
	    	Thread.sleep(2000);
	    	String alettext=driver.switchTo().alert().getText();
	    	System.out.println(alettext);
	    	Thread.sleep(2000);
	    	driver.switchTo().alert().dismiss();
	    }
	    
	    @Given("click on mousehover")
	    public void click_on_mousehover() throws InterruptedException
	    {
	    	driver.manage().window().maximize();
	    	Thread.sleep(10000);
	    	 JavascriptExecutor js = (JavascriptExecutor) driver;
	    	 js.executeScript("window.scrollBy(0,1000)");
	    	WebElement mousehovbutton=driver.findElement(By.xpath("//div[@class='mouse-hover']"));
	    	Actions a =new Actions(driver);
	    	
	    	a.moveToElement(mousehovbutton).build().perform();
	    	
	    	Thread.sleep(5000);
	    	driver.findElement(By.xpath("//a[text()='Reload']")).click();;
	    	
	    }
	    
	    @And("select reload option")  
	    public void select_reload_option()
	    {
	    
	    
	    }
	    @Given("access all elements of webtable")
	    public void access_all_elements_of_webtable()
	    {
	    	 
	    	String header1=driver.findElement(By.xpath("//table/tbody/tr/th[1]")).getText();
	    	String header2=driver.findElement(By.xpath("//table/tbody/tr/th[2]")).getText();
	    	String header3=driver.findElement(By.xpath("//table/tbody/tr/th[3]")).getText();
	    	System.out.printf("First Name"+header1 + "last"+header2 +"thrd"+ header3);
	    	//output will be =First NameInstructorlastCoursethrdPrice 
	    }
	    @And("rows column header") 
	    public void rows_column_header()
	    {
	    	String alltabval=driver.findElement(By.xpath("//table/tbody/tr")).getText();
	    	System.out.println(alltabval);
	    	//output will be =Instructor Course Price
	    	String firstrow=driver.findElement(By.xpath("//table/tbody/tr[1]")).getText();
	    	System.out.println(firstrow);
	    	//Instructor Course Price
	    	
	    	String firstrow1=driver.findElement(By.xpath("//table/tbody/tr[2]")).getText();
	    	System.out.println(firstrow1);
	    	//Rahul Shetty Selenium Webdriver with Java Basics + Advanced + Interview Guide 30
	    	List<WebElement> alldata=driver.findElements(By.xpath("//table/tbody/tr"));
	    	int noofelem=alldata.size();
	    	System.out.println(noofelem);
	    	for (int i=0;i<noofelem;i++)
	    	{
	    		String all=alldata.get(i).getText();
	    		System.out.println(all);
	    	}
	    
	    }
	    //it will fetch all the rows of table
	    @Given("enter text in field")
	    public void enter_text_in_field() throws InterruptedException
	    {
	    	driver.findElement(By.xpath("//input[@name='show-hide']")).sendKeys("deepak");;
	    	//input[@name='enter-name']
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath("//input[@value='Hide']")).click();
	    	Thread.sleep(3000);
	    Boolean	hide=driver.findElement(By.xpath("//input[@name='show-hide']")).isDisplayed();
	    System.out.println(hide);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@value='Show']")).click();
	    Boolean	hide1=driver.findElement(By.xpath("//input[@name='show-hide']")).isDisplayed();
	    System.out.println(hide1);
	    	
	    }
	    @And("then click on hide and show button")
	    public void then_click_on_hide_and_show_button()
	    {}
	    
	    @Given("identify i frame")
	    public void identify_i_frame()
	    {
	    	driver.switchTo().frame("iframe-name");
	    	driver.findElement(By.xpath("//a[text()='Courses']")).click();
	    }
	    @And("then click on mentorship")
	    public void then_click_on_mentorship()
	    {}
}

