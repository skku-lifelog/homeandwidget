import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Reverse {
	public static void main(String[] args) throws IOException {
		InputStream fis = new FileInputStream("C:\\Users\\patri\\OneDrive\\바탕 화면\\input.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\patri\\OneDrive\\바탕 화면\\output.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		
		ArrayList<String> arr = new ArrayList<>();
		String frag;
		while((frag=br.readLine())!=null) {
			arr.add(frag);
		}
		
		for(int i=arr.size()-1;i>=0;i--) {
			bw.write(arr.get(i));
			if(i>0)	bw.newLine();
		}
		bw.flush();
		bw.close();osw.close();fos.close();
		fis.close();isr.close();br.close();
		
	}
}
