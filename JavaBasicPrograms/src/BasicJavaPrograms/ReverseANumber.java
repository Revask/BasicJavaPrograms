package BasicJavaPrograms;

public class ReverseANumber {
public static void main(String[] args) {
	int n = 123450;
	StringBuilder sb = new StringBuilder(String.valueOf(n));
	System.out.println("Given number " + n);
	System.out.println("Reverse number " + sb.reverse());
	n = Integer.parseInt(sb.toString());
	System.out.println("Given number reversed + 10 " + (n+10));
}
}
