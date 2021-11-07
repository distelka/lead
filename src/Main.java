import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main 
{	
	public static void main(String[] args)
	{
		boolean brackets = Solution("{{{}}}");
		ArrayList<int[]> peaks = FindPeaks(new int[]{3, 2, 1, 3, 5, 8, 9});
	}

	private static boolean Solution(String input) 
	{
	    int macher = 0;
	    boolean result = false;	   	
	    boolean subtraction = false;
	    
		Map<Character, Integer> bracketsMap = new LinkedHashMap<Character, Integer>();
		bracketsMap.put('{', 0);
		bracketsMap.put('}', 0);
		bracketsMap.put('(', 0);
		bracketsMap.put(')', 0);
		bracketsMap.put('[', 0);
		bracketsMap.put(']', 0);
	    
	    for (char ch : input.toCharArray())
	    {
	    	 if(bracketsMap.containsKey(ch))
	    	 {
	    		 bracketsMap.put(ch, bracketsMap.get(ch) +1);	
	    		 result = true;
	    	 }
		}

	    
	    for(Map.Entry<Character,Integer> entry : bracketsMap.entrySet()) 
	    {
	    	if(!subtraction)
	    	{
	    		macher += entry.getValue();
	    		subtraction = true;
	    	}
	    	else
	    	{
	    		macher -= entry.getValue();
	      		subtraction = false;
	      		
	      		if(macher != 0)
	      		{
	      			result = false;
	      			break;
	      		}
	      	}
    	}
	    System.out.println("Brackets are closed correctly - "+result);
		return result;
	}
	private static ArrayList<int[]> FindPeaks(int[] arr)
	{
		 ArrayList<int[]> resultList = new ArrayList<int[]>();
		 
		 for (int index = 0; index < arr.length; index++)
		 {
			 int left  = (index-1 < 0)? arr[index]-1:arr[index-1];
			 int right = (index+1 >= arr.length)?arr[index]-1:arr[index+1];
			 
			 if(arr[index] > left && arr[index] > right)
			 {
				 resultList.add(new int[]{index,arr[index]});
				 System.out.println("Peak index "+ Integer.toString(index)+", and value "+arr[index]+";");
			 }			 
		 }
		 return resultList;
	}
}
