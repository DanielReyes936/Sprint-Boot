package ca.sheridancollege.DataArray;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataArray {
	
	private int array[][];
	private int sum=0;
	private int newList[]= new int [0];
	int userx;
	int usery;
	int usern;
	
	
	public DataArray(DataUser duser) {
		
		int userx=duser.getUserx();
		int usery=duser.getUsery();
		int usern = duser.getUsern();
	int value1= duser.getValue1();
	int value2=duser.getValue2();
	CalculateResult(userx,usery,value1,value2,usern);
		
	}


	private void CalculateResult(int userx2, int usery2, int value1, int value2, int usern2) {
		
		
		int array [][]  = new int [value1][value2] ;
		
		for (int x=0; x < array.length; x++) {
			
			  for (int y=0; y < array[x].length; y++) {
				  
				  array[x][y] = (int) (Math.random()*50+1);
				  //we generate random numbers to fill the matrix	
				  
				  //Printing the matrix in the console
				  
			
				
				  System.out.print(" | ");System.out.print (array[x][y]); System.out.print(" | ");
				  }
			  
	              		System.out.println(); 
	              		
							}
		
		if (userx-usern<0||usery-usern<0) {
				
			  for (int x=0; x <=userx+usern; x++) {
				 
    			  for (int y=0; y <=usery+usern; y++) {
    				
    				// We discriminate the numbers that we do not need
					if( x!=userx-usern&&x!=userx+usern&&y!=usery-usern&&y!=usery+usern) {
						array [x][y]=0;}            					
					    					
						if (array [x][y]!=0) {
							
							this.sum+= array [x][y];      //We make a sum of each value in the N selected
				        				  
				System.out.print(" | ");System.out.print (array[x][y]); System.out.print(" | ");} //console printing of the values and the sum.
						 
						 
			}
    	}
	}
		//If the user chooses an odd row
			  else if (userx+usern>=value1||usery+usern>=value2) {
			
			  for (int x=userx-usern; x <array.length; x++) {
			
    			  for (int y=usery-usern; y <array.length; y++) {
    				  
    				// We discriminate the numbers that we do not need
					if( x!=userx-usern&&x!=userx+usern&&y!=usery-usern&&y!=usery+usern) {
						array [x][y]=0;}            					
					    					
						if (array [x][y]!=0) {
							
							this.sum+= array [x][y];      //We make a sum of each value in the N selected
				        				  
				System.out.print(" | ");System.out.print (array[x][y]); System.out.print(" | ");} //console printing of the values and the sum.
			
					
						
			}
  	}
	}
		
		//If the user chooses an even row
		  else 
			  for (int x=userx-usern; x <=userx+usern; x++) {
				
				  for (int y=usery-usern; y <=userx+usern; y++) {
					 	
				// We discriminate the numbers that we do not need
					  
			if( x!=userx-usern&&x!=userx+usern&&y!=usery-usern&&y!=usery+usern) {
					array [x][y]=0;}            					
				    					
					if (array [x][y]!=0) {
						
						this.sum+= array [x][y];		                                    //We make a sum of each value in the N selected
			        				  
			System.out.print(" | ");System.out.print (array[x][y]); System.out.print(" | "); }                //console printing of the values and the sum.
		
					
		}
			  }
		new SumData(sum);
	}

}
