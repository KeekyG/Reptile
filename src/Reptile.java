import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Reptile {

	String url;
	
	public Reptile(String url){
		this.url = url;
	}
	
	public String getContents(){
		String contents = "";
		try {
			URL link = new URL(url);
			URLConnection connection = link.openConnection();
			connection.connect();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while(null != (line = bufferedReader.readLine())){
				contents += line;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("404NOTFOUND");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return contents;
		}
	}
	
	public static void main(String args[]){
		Reptile reptile = new Reptile("https://www.baidu.com/");
		System.out.println(reptile.getContents());
	}
}
