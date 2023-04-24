import java.rmi.server.RemoteStub;
import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) throws AddZeroException, SubstractZeroException, OutOfRangeException {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int pidx = str.indexOf("+");
		int midx = str.indexOf("-");
		int res = (pidx+1==0) ? midx:pidx;
		int a=0,b=0;
		for(int i=0;i<res;i++) {
			a *=10;
			a += str.charAt(i)-'0';
		}
		for(int i=res+1;i<str.length();i++) {
			b *=10;
			b += str.charAt(i)-'0';
		}
		
		if (midx==-1) {
			try {
				testp(a, b);
			}catch (AddZeroException e1){
				System.out.println("AddZeroException");
			}catch (OutOfRangeException e2) {
				System.out.println("OutOfRangeException");
			}
		}
		else {
			try {
				testm(a, b);
			}catch (SubstractZeroException e1){
				System.out.println("SubstractZeroException");
			}catch (OutOfRangeException e2) {
				System.out.println("OutOfRangeException");
			}
		}
		
	}
	public static void testp(int a,int b) throws AddZeroException,OutOfRangeException {
		if(a==0 || b==0) 
			{throw new AddZeroException();
			}
		else if (a+b>1000 || a>1000 || b>1000) throw new OutOfRangeException();
		System.out.println(a+b);
	}
	public static void testm(int a,int b) throws SubstractZeroException, OutOfRangeException {
		if(a==0 || b==0) throw new SubstractZeroException();
		else if (a-b<0 || a>1000 || b>1000) throw new OutOfRangeException();
		System.out.println(a-b);
	}
}



class AddZeroException extends Exception{
	public AddZeroException() {
	}
}

class SubstractZeroException extends Exception{
	public SubstractZeroException() {
	}
}

class OutOfRangeException extends Exception{
	public OutOfRangeException() {
	}
}