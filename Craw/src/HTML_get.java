import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HTML_get {
	public static ArrayList<String> read(File source) throws Exception { 
		FileReader m=new FileReader(source);
		BufferedReader reader=new BufferedReader(m);
		ArrayList<String> al = new ArrayList<String>();
		while(true) {
			String nextline=reader.readLine();
			if(nextline==null) break;
			al.add(nextline);
		}
		reader.close();
		return al;
	}
 
	public static void main(String[] args){	
		try {
			ArrayList<String> al = read(new File("F:\\Code\\java\\workspace\\Demo\\src\\total_url.txt"));
//			System.out.println(al.get(0));
			System.setProperty("webdriver.chrome.driver", "D:\\Chrome_Downloads\\chromedriver_win32\\chromedriver.exe");// chromedriver�����ַ
			WebDriver driver = new ChromeDriver(); // �½�һ��WebDriver �Ķ��󣬵���new ����FirefoxDriver������
			//List<WebElement> time = new ArrayList<WebElement>();
			for(int i=0;i<al.size();i++) {
				driver.get(al.get(i));
			    //WebElement we = driver.findElement(By.className("rich_media_content"));
				//time = we.findElements(By.tagName("span"));
				String name = "D:\\Ariticle_html\\article"+(i+1)+".html";
				File f = new File(name);
				OutputStreamWriter writerStream = new OutputStreamWriter(new FileOutputStream(name),"utf-8");
	            BufferedWriter bw = new BufferedWriter(writerStream);
//	            for(int j=0;j<time.size();j++) {
//	            	bw.write(time.get(j).getText());
//	            	bw.newLine();
//	            }
	            bw.write(driver.getPageSource());
	            bw.close();
			}
//			time = we.findElements(By.tagName("span"));
//            String name = "D:\\test_article.txt";
//            OutputStreamWriter writerStream = new OutputStreamWriter(new FileOutputStream(name),"utf-8");
//            BufferedWriter bw = new BufferedWriter(writerStream);
//            for(int j=0;j<time.size();j++) {
//            	System.out.println(time.get(j).getText());
//            	bw.write(time.get(j).getText());
//            	bw.newLine();
//            }
//            bw.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
