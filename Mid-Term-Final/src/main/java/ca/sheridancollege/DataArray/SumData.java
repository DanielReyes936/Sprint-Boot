package ca.sheridancollege.DataArray;

import java.io.Serializable;

import lombok.NoArgsConstructor;
@NoArgsConstructor
public class SumData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4234096738089099556L;

	
	int sum;
	public SumData(int sum2) {
		sum = sum2;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}

}


























/*
public int array[][] ;
private int uservalue; 
private int sum;


 public void setValues(	int value1, int value2,int userx,int usery,
int usern,int array[][],int uservalue,int sum) {
	 this.value1=value1;
		this.value2=value2;
		this.userx=userx;
		this.usery=usery;
		this.usern=usern;
		this.array=array ;
		this.uservalue=uservalue; 
		 this.sum=sum;
	
 }

//We generate an array
public int[][] ArrayGenerate(){

	
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
			
						System.out.println("------------------------------"); 	
            		//If the user chooses an odd row
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
            		System.out.println("\n------------------------------"); 
          			System.out.println("\nThe sum is :" +this.sum);					// Result of the sum of the selected values
            		
          				
          				return array;
		}


@Override
public String toString() {
	return "DataArray [array=" + Arrays.toString(array) + "]";
}

public DataArray() {
	// TODO Auto-generated constructor stub
}

*/