package tshirtfinder;

import java.io.File;
import java.util.*;


public class Runner {


	public static void main(String[] args) throws Exception{
		
		Scanner scan = new Scanner(System.in);
		System.out.print("\n ------------------- Enter all the details -------------------\n");
		
		System.out.print("\n Enter the T-Shirt Color : ");
		String color = scan.next();
		
		System.out.print("\n Enter the T-Shirt Size : ");
		String size = scan.next();
		
		System.out.print("\n Enter the Gender(M/F) : ");
		String gender = scan.next();
		
		System.out.print("\n Press 1 - Sort by Price"
							+ "\n Press 2 - Sort by Rating"
							+ "\n Press 3 - Sort by Both Price & Rating \n");
		System.out.print("\n Enter the Output Preference : ");
		int outprf = scan.nextInt();
		
		
		//read all the csv files
		
		TShirtData tsdata = new TShirtData();
		File mainFile = new File("src\\main\\resources"); 
		//System.out.println(mainFile);
		
		File[] tshirtFile = mainFile.listFiles();
		
		//System.out.println(tshirtFile);
		
		if(tshirtFile !=null) {
			
			for(File f:tshirtFile) {
				tsdata.SearchData(f, color, size, gender);
			}
		}
		
		tsdata.viewComparision(outprf);
		
		
		scan.close();
	}
}
