
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.opencsv.CSVWriter;

public class Scrap_foh {
	static String totalcust;
	static String total_cust_dp;
	static String total_abandon;
	static String total_abandon_dp;
	static String thruput;
	static String thruput_dp;
	static String Queue_time;
	static String Order_time;
	static String Wait_time;
	static String Total_time;
	static String tp_9am;
	static String tp_12pm;
	static String tp_2pm;
	static String tp_5pm;
	static String tp_8pm;
	static String tp_am;
	static String tp_pm;
	
	
	public static void main(String[] args) throws Exception
	{
//open site & select store
		
		String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.setProperty("webdriver.chrome.driver","E:\\New folder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String s ="http://lunobus.com/dashboard/?storeId=3&userId=1";
		driver.get(s);
		driver.manage().window().maximize();
		Thread.sleep(15000);

		 
//checking if shift is running
		 
		 LocalTime timenow = LocalTime.now();   
			LocalTime Shift_start = LocalTime.parse( "09:00:00" );
			LocalTime Shift_stop = LocalTime.parse( "16:57:10" );
			LocalTime target = timenow;
			Boolean inshift = ( target.isAfter( Shift_start ) && target.isBefore( Shift_stop ) ) ;
			
	
		if(inshift==true)
		{
			System.out.println("In Shift");
			CSVWriter write =new CSVWriter(new FileWriter("testdata/"+time+".csv"));
			String title[]= {"TimeStamp","Total Customers","Total_cust_daypart","Thruput","Thruput_dp","Total Abandon","Total_abandon_dp","Queue_time","Order_time","Wait_time","Total_time","tp_9am","tp_12pm","tp_2pm","tp_5pm","tp_8pm","tp_am","tp_pm"};//title row
			write.writeNext(title);
			System.out.println(inshift);
			System.out.println(target);
			while (inshift==true)
												//for(int i = 0; i < 10; i++)
			{
//grab values and create csv file with filename as currentime & write new row every 30 seconds
				
				totalcust = driver.findElement(By.xpath("(//div[@class='topWidgetCenter'])[1]")).getText();
				total_cust_dp = driver.findElement(By.xpath("(//span[@class='topWidgetBottomRight'])[1]")).getText();
				total_abandon = driver.findElement(By.xpath("(//div[@class='topWidgetCenter'])[3]")).getText();
				total_abandon_dp = driver.findElement(By.xpath("(//span[@class='topWidgetBottomRight'])[2]")).getText();
				thruput = driver.findElement(By.xpath("(//div[@class='topWidgetCenter'])[2]")).getText();
				thruput_dp = driver.findElement(By.xpath("(//span[@class='topWidgetBottomRight'])[3]")).getText();
				
				Queue_time = driver.findElement(By.cssSelector("#root > div > div.MuiContainer-root.MuiContainer-maxWidthFalse.MuiContainer-disableGutters.css-8s4k1c > div > div.MuiGrid-root.MuiGrid-container.MuiGrid-item.MuiGrid-spacing-xs-1.MuiGrid-direction-xs-column.MuiGrid-grid-sm-12.MuiGrid-grid-md-9.css-1stigex > div:nth-child(2) > div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-md-7.MuiGrid-grid-lg-7.css-7es2lf > div > div.timesWidgetBody > div > svg > g:nth-child(2) > text:nth-child(6)")).getText();
				
				Wait_time = driver.findElement(By.cssSelector("#root > div > div.MuiContainer-root.MuiContainer-maxWidthFalse.MuiContainer-disableGutters.css-8s4k1c > div > div.MuiGrid-root.MuiGrid-container.MuiGrid-item.MuiGrid-spacing-xs-1.MuiGrid-direction-xs-column.MuiGrid-grid-sm-12.MuiGrid-grid-md-9.css-1stigex > div:nth-child(2) > div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-md-7.MuiGrid-grid-lg-7.css-7es2lf > div > div.timesWidgetBody > div > svg > g:nth-child(4) > text:nth-child(6)")).getText();
				
				Order_time = driver.findElement(By.cssSelector("#root > div > div.MuiContainer-root.MuiContainer-maxWidthFalse.MuiContainer-disableGutters.css-8s4k1c > div > div.MuiGrid-root.MuiGrid-container.MuiGrid-item.MuiGrid-spacing-xs-1.MuiGrid-direction-xs-column.MuiGrid-grid-sm-12.MuiGrid-grid-md-9.css-1stigex > div:nth-child(2) > div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-md-7.MuiGrid-grid-lg-7.css-7es2lf > div > div.timesWidgetBody > div > svg > g:nth-child(3) > text:nth-child(6)")).getText();
				Total_time = driver.findElement(By.cssSelector("#root > div > div.MuiContainer-root.MuiContainer-maxWidthFalse.MuiContainer-disableGutters.css-8s4k1c > div > div.MuiGrid-root.MuiGrid-container.MuiGrid-item.MuiGrid-spacing-xs-1.MuiGrid-direction-xs-column.MuiGrid-grid-sm-12.MuiGrid-grid-md-9.css-1stigex > div:nth-child(2) > div.MuiGrid-root.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-md-2.MuiGrid-grid-lg-2.css-cyoinv > div > div.verticalWidgetBody > div > svg > g > g:nth-child(4) > text")).getText();
				tp_9am = driver.findElement(By.xpath("(//span[@class='badge'])[1]")).getText();
				tp_12pm = driver.findElement(By.xpath("(//span[@class='badge'])[2]")).getText();
				tp_2pm = driver.findElement(By.xpath("(//span[@class='badge'])[3]")).getText();
				tp_5pm = driver.findElement(By.xpath("(//span[@class='badge'])[4]")).getText();
				tp_8pm = driver.findElement(By.xpath("(//span[@class='badge'])[5]")).getText();
				tp_am = driver.findElement(By.xpath("(//span[@class='badge'])[6]")).getText();
				tp_pm = driver.findElement(By.xpath("(//span[@class='badge'])[7]")).getText();
				
				
				String[] row= new String[18];
				String timenew = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
				row[0] =timenew;
				row[1] =totalcust;
				row[2]=total_cust_dp;
				row[3]=thruput;
				row[4]=total_abandon_dp;
				row[5]=total_abandon;
				row[6]=thruput_dp;
				row[7]=Queue_time;
				row[8]=Order_time;
				row[9]=Wait_time;
				row[10]=Total_time;
				row[11]=tp_9am;
				row[12]=tp_12pm;
				row[13]=tp_2pm;
				row[14]=tp_5pm;
				row[15]=tp_8pm;
				row[16]=tp_am;
				row[17]=tp_pm;

				write.writeNext(row);
				write.flush();
				Thread.sleep(5000);
				System.out.println("New Row added moneeewww !!");
				LocalTime timenownew = LocalTime.now();   
				LocalTime targetnew = timenownew;
				Boolean inshiftnew = ( targetnew.isAfter( Shift_start ) && targetnew.isBefore( Shift_stop ) ) ;
				inshift =inshiftnew;
				System.out.println("current time is "+targetnew);
				System.out.println(" inshift is "+inshift);
			}
			System.out.println("CSV Created.Filename : "+time+".csv");

		}
		else
		{
			System.out.println("Not In Shift");
		}
		driver.close();
		System.exit(0);
		

	}
	
}

