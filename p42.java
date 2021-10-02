import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class p42 {
	public static void main(String[] args) {
		Vector<String> result;
		int sum = 0;
		Vector<Integer>triangles = new  Vector<Integer>();
		populate_triangle(triangles,50);
		try {
			result = OpenFile("p042_words.txt");
			String str_array[] =  result.elementAt(0).split(",");
			for (int i = 0; i < str_array.length; i++) {
				String newstr = str_array[i].substring(1, str_array[i].length()-1);
				if(check_if_triangle(newstr,triangles))
					sum++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sum);
		
	}
	
	static void populate_triangle(Vector<Integer>triangles,int size)
	{
		for (int i = 1; i < size; i++) {
			triangles.add(i*(i+1)/2);
		}
	}
	
	private static boolean check_if_triangle(String string,Vector<Integer>triangles) {
		int sum = 0;
		for (int i = 0; i < string.length(); i++) {
			sum += (int)string.charAt(i);
			sum -= ((int)'A'-1);
		}
		if(triangles.contains(sum))
			return true;
		return false;
	}


	public static Vector<String> OpenFile(String FileName) throws IOException
	{
		Vector<String> Buffer = new Vector<String>();
		File f_ptr = new File(FileName);
		Scanner input = new Scanner(f_ptr);
		String st ="";
		st = input.nextLine();
		Buffer.add(st);
		while(input.hasNextLine())
		{
			st = input.nextLine();
			Buffer.add(st);
		}
		input.close();
		return Buffer;
	}
}
