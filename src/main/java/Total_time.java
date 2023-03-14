import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.PrintStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Total_time 
{
	public static void main(String[] args) throws Exception
	{
		
		/* System.setProperty("webdriver.chrome.driver","E:\\New folder\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String s ="http://lunobus.com/dashboard/?storeId=3&userId=1";
		driver.get(s);
		driver.manage().window().maximize();
		String totaltime = driver.findElement(By.xpath("(//div[@class='topWidgetCenter'])[1]")).getText();
		String qt = driver.findElement(By.xpath("(//div[@class='topWidgetCenter'])[1]")).getText();
		String wt = driver.findElement(By.xpath("(//div[@class='topWidgetCenter'])[1]")).getText();
		String ot = driver.findElement(By.xpath("(//div[@class='topWidgetCenter'])[1]")).getText();*/
		
		String qt="01:01";
		String ot="01:01";
		String wt="01:01";
		
		int add =addTime(qt,ot,wt);
		int dash_total =10;
		System.out.println(add);
		
		if (dash_total==10)
				{

					System.out.println("true");
				}
		else
		{
			System.out.println("false");
		}
	}

	public static int addTime(String a, String b,String c)

	{

		int minSum = 0;
		int hourSum = 0;

		int hour1= Integer.parseInt(a.substring(0,2));
		int hour2= Integer.parseInt(b.substring(0,2));
		int hour3= Integer.parseInt(c.substring(0,2));
		int min1= Integer.parseInt(a.substring(3,5));
		int min2= Integer.parseInt(b.substring(3,5));
		int min3= Integer.parseInt(c.substring(3,5));
		minSum = min1 + min2 + min3;
		if(minSum>59)
		{
			hourSum+=1;
			minSum%=60;
		}

		hourSum = hourSum + hour1 + hour2+ hour3;

		System.out.println(hourSum+" Min "+minSum+" Sec");
		int sum = Integer.valueOf(String.valueOf(hourSum)+ String.valueOf(minSum));
		return sum;
		
		
	}


	
}