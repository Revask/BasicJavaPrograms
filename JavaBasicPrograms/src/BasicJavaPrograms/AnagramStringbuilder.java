package BasicJavaPrograms;

public class AnagramStringbuilder {

	public static void main(String[] args) {
		
		StringBuilder sb1 = new StringBuilder("listen");
		StringBuilder sb2 = new StringBuilder("silent");
		boolean isAnagram = true;
		for(int i=0;i<sb1.length();i++)
		{
			String c = String.valueOf(sb1.charAt(i));
			
			int check = sb2.indexOf(c);
			if (check == -1)
			{
				isAnagram = false;
				break;
			}
			
		}
		if(isAnagram)
			System.out.println(sb1.toString()+ " "+ sb2.toString()+" " + " string are anagram");
		else
			System.out.println("Given string are not anagram");
	}

}
