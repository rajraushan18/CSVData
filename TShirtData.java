package tshirtfinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class TShirtData{
	
	ArrayList<TShirtgetset> allData = new ArrayList<TShirtgetset>();
	ArrayList<String> res;
	public void SearchData(File f,String color, String size, String gender) throws FileNotFoundException
	{
		
		Scanner fileRead = new Scanner(f);
		
		while(fileRead.hasNext()) 
		{
			String ln = fileRead.nextLine().toString();
			
			if(!ln.isEmpty()) {
				
				StringTokenizer st = new StringTokenizer(ln,"|");
				
				res = new ArrayList<String>();
				while(st.hasMoreTokens()) {
					res.add(st.nextToken());
				}
				
				if(res.get(2).equals(color) && res.get(4).equals(size) && res.get(3).equals(gender)) {
					TShirtgetset tsFind = new TShirtgetset(res.get(0),res.get(1),res.get(2),res.get(3),res.get(4),
												Float.parseFloat(res.get(5)),Float.parseFloat(res.get(6)),res.get(7));
					
						allData.add(tsFind);
					}
				}
			}
		fileRead.close();
	}
	public void viewComparision(int outprf) {
		if(outprf == 1)
		{
			Comparator<TShirtgetset> c1 = (TShirtgetset m1, TShirtgetset m2)-> (int)(m1.getPrice() - m2.getPrice());
			Collections.sort(allData,c1);
		}
		else if(outprf == 2)
		{
			Comparator<TShirtgetset> c2 = (TShirtgetset m1, TShirtgetset m2)-> (int)(m1.getRate() - m2.getRate());
			Collections.sort(allData,c2);
		}
		else if(outprf == 3)
		{
			Comparator<TShirtgetset> c3 = (TShirtgetset m1, TShirtgetset m2)->
			(int)(m1.getPrice() - m2.getPrice()) - (int)(m1.getRate() - m2.getRate());
			Collections.sort(allData, c3);
		}
		else
		{
			System.out.println("\n Wrong Choice !! Please Give the Correct Choice.");
			return;
		}
			
		Show display = new Show();
		display.display(allData);
				
	}
}
	
