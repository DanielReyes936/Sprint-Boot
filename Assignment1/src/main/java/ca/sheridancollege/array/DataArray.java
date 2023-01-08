package ca.sheridancollege.array;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data

public class DataArray implements Serializable {	
	
	private static final long serialVersionUID = 6243619419649493452L;
	
	//Definition of our variables
	
	private int value1;
	private int value2;
	private int userx;
	private int usery;
	private int usern;
	private int array[][] ;
	private int uservalue; 
	private int sum;
	
	 
	
	//We generate an array
	public int [][] ArrayGenerate(){
		
		int array [][]  = new int [value1][value2] ;
		
		
		for (int x=0; x < array.length; x++) {
			
			  for (int y=0; y < array[x].length; y++) {
				  array[x][y] = (int) (Math.random()*99+1);	 //we generate random numbers to fill the matrix	
				  
				  //Printing the matrix in the console
				  
				  System.out.print(" | ");System.out.print (array[x][y]); System.out.print(" | ");
				  }
			  
	              		System.out.println(); 
							}
		
						this.uservalue=array[userx][usery];  //Definition of the value chosen by the user
	                  
	                  System.out.println("---------"); 
	                  
	                  System.out.println("The number chosen by the user is : "+ uservalue); //console printing of the value chosen by the user
	                  
	                  System.out.println("---------"); 
	                  
	                  //Calculation of the sum of numbers surrounding the number chosen by the user.
	                             
                System.out.println("The values x :"+ userx );
                		System.out.println("The values y :"+ usery);
                		
                		//If the user chooses an odd row
                		if (usern%2!=0) {
          					
                			  for (int x=1; x <array.length-1; x++) {
                        			
                      			  for (int y=1; y <array.length-1; y++) {
                  				
                      				// We discriminate the numbers that we do not need
                  					if( x!=userx-usern&&x!=userx+usern&&y!=usery-usern&&y!=usery+usern) {
                  						array [x][y]=0;}            					
                  					    					
                  						if (array [x][y]!=0) {
                  							
                  							this.sum+= array [x][y];      //We make a sum of each value in the N selected
                  				        				  
                  				System.out.print(" | ");System.out.print (array[x][y]); System.out.print(" | "); //console printing of the values and the sum.
                  				}
                  			}
                    	}
                	}
                		
                		//If the user chooses an even row
              			  else 
              				  for (int x=0; x <array.length; x++) {
                  			   			
              					  for (int y=0; y <array.length; y++) {
              				
                  				// We discriminate the numbers that we do not need
              					if( x!=userx-usern&&x!=userx+usern&&y!=usery-usern&&y!=usery+usern) {
              						array [x][y]=0;}            					
              					    					
              						if (array [x][y]!=0) {
              							
              							this.sum+= array [x][y];		//We make a sum of each value in the N selected
              				        				  
              				System.out.print(" | ");System.out.print (array[x][y]); System.out.print(" | ");		//console printing of the values and the sum.
              				}
              			}
                	}
              			System.out.print ("The sum is :" +sum);					// Result of the sum of the selected values
                		
            		 						
              				return array;
			}
	
						
	public DataArray() {
		
	}
	
 }	


	
	
	
	

