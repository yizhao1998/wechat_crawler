import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Chrome_Downloads\\chromedriver_win32\\chromedriver.exe");// chromedriver�����ַ
		WebDriver driver = new ChromeDriver(); // �½�һ��WebDriver �Ķ��󣬵���new ����FirefoxDriver������
		String url = "target_url";//please feed here with target url get by fiddler
		driver.get(url);// ��ָ������վ
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// driver.get("www.baidu.com");
		// driver.findElement(By.id("kw")).sendKeys(new String[]
		// {"hello"});//�ҵ�kwԪ�ص�id��Ȼ������hello
		// driver.findElement(By.id("su")).click(); //�����Ť
		WebElement we = driver.findElement(By.className("weui_msg_card_list"));
		List<WebElement> al = new ArrayList<WebElement>();
		List<WebElement> time = new ArrayList<WebElement>();
		time = we.findElements(By.className("weui_msg_card_hd"));
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//    	driver.findElement(By.className("loadmore")).sendKeys(Keys.DOWN);
		System.out.println(time.size());
		System.out.println(time.get(time.size() - 1).getText());
		for(int i=0;i<12;i++) {
			Thread.sleep(1000);
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		}
		al = driver.findElements(By.className("js_appmsg"));
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i).getAttribute("hrefs"));
		}
//		try {
//			/**
//			 * WebDriver�Դ���һ�����ܵȴ��ķ����� dr.manage().timeouts().implicitlyWait(arg0, arg1����
//			 * Arg0���ȴ���ʱ�䳤�ȣ�int ���� �� Arg1���ȴ�ʱ��ĵ�λ TimeUnit.SECONDS һ��������Ϊ��λ��
//			 */
//			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		/**
		 * dr.quit()��dr.close()�������˳������,�򵥵�˵һ�����ߵ����𣺵�һ��close��
		 * ������˶��ҳ���ǹز��ɾ��ģ���ֻ�رյ�ǰ��һ��ҳ�档�ڶ���quit��
		 * ���˳�������Webdriver���еĴ��ڣ��˵ķǳ��ɾ��������Ƽ�ʹ��quit��Ϊһ��case�˳��ķ�����
		 */
		// driver.quit();//�˳������
	}
}