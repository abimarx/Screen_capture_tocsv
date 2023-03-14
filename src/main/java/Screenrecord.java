	import java.text.SimpleDateFormat;
	import java.time.LocalTime;
	import java.util.Calendar;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Screenrecord {
		static String totalcust;
		static String total_cust_dp;
		static String total_abandon;
		public static void main(String[] args) throws Exception
		{
	//open site & select store
			
			String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			System.setProperty("webdriver.chrome.driver","E:\\New folder\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			String s ="http://lunobus.com/dashboard/?storeId=3&userId=1";
			driver.get(s);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			
			/* WebElement dropd=driver.findElement(By.xpath("//select[@id='store']"));
			Select select = new Select(dropd);
			select.selectByVisibleText("Macquarie");
			Thread.sleep(1000);
			 driver.findElement(By.xpath("//button[@class='show']")).click();
			 Thread.sleep(2000);
			 */
			 
	//checking if shift is running
			 
			 LocalTime timenow = LocalTime.now();   
				LocalTime Shift_start = LocalTime.parse( "09:00:00" );
				LocalTime Shift_stop = LocalTime.parse( "10:57:30" );
				LocalTime target = timenow;
				Boolean inshift = ( target.isAfter( Shift_start ) && target.isBefore( Shift_stop ) ) ;
				
				ScreenRecorderUtil.startRecord("main");
		
			if(inshift==true)
			{
				ScreenRecorderUtil.startRecord("main");
				System.out.println("In Shift");
				System.out.println(inshift);
				System.out.println(target);
				while (inshift==true)
													//for(int i = 0; i < 10; i++)
				{
					System.out.println(inshift);
					LocalTime timenownew = LocalTime.now();   
					LocalTime targetnew = timenownew;
					Boolean inshiftnew = ( targetnew.isAfter( Shift_start ) && targetnew.isBefore( Shift_stop ) ) ;
					inshift =inshiftnew;
					System.out.println(targetnew);
					System.out.println(inshift);
					System.out.println(inshiftnew);
					Thread.sleep(2000);
				}
				ScreenRecorderUtil.stopRecord();
			}
			else
			{
				System.out.println("Not In Shift");
			}
			driver.close();
			Thread.sleep(10000);
			//testq.ScreenRecorderUtil.stopRecord();
			System.exit(0);
			

		}
		
	}



