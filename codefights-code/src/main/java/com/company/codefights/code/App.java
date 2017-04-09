package com.company.codefights.code;

import java.util.Arrays;

/* My solutions to the exercise from CodeFights */

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("aabaa".equalsIgnoreCase(reverse("aabaa")));
        
        int[] iArr = {-23, 4, -3, 8, -12}; //int[] iArr = {3, 6, -2, -5, 7, 3};
        System.out.println("adjacentElementsProduct :" +adjacentElementsProduct(iArr));
       
       System.out.println("Polygon shapeArea :" +shapeArea(4));
       
       int[] statues = {2, 3, 15};
       System.out.println("Required statues:" +makeArrayConsecutive2(statues));
       
       int[] increaingSequence = {1,3,2,1};//{3,1,5,4,8};//{1,3,2};
       System.out.println("almostIncreasingSequence :" +almostIncreasingSequence(increaingSequence));
       
       int[][] matrix = {{0, 1, 1, 2}, {0, 5, 0, 0},{2, 0, 3, 3}};//{{1,1,1},{2,2,2},{3,3,3}};//{{1,1,1},{2,2,2},{3,3,3}};//
       System.out.println("matrixElementsSum : " +matrixElementsSum(matrix));
    }
    
    /*
     * Problem:
     * To check the input string is palindrome or not
     */
    static  String reverse(String inputStr) {
    	
    	/*
    	 * Eg:
    	 * inputStr =
    	 * aabaa;
    	 * 
    	 */
        
        char[] arr = new char[inputStr.length()];
        int pos = 0;
        for (int i=inputStr.length()-1;i>=0;i--){
            arr[pos] = inputStr.charAt(i);
            pos++;
        }
        
        return new String(arr);
    }
   
    /*
     * Problem: 
     * Find max product from adjacent elements in a array and waht are those elements
     */
   static int adjacentElementsProduct(int[] inputArray) {
	   
	   /*
	    * Eg:
	    * inputArray =
	    *  {-23, 4, -3, 8, -12};
	    *   {3, 6, -2, -5, 7, 3}
	    */
	   
	   int maxVal = -100000;
	   int a = 0;
	   int b = 0;
	   for(int i=0;i<inputArray.length-1;i++){
	        int val = inputArray[i] * inputArray[i+1];
	        if (!isPositive(val)){
	        	if (!isPositive(maxVal)) {
	        		if (val > maxVal) {
			            maxVal =val;
			            a = inputArray[i];
			            b = inputArray[i+1];
			        }
	        	}
	        	
	        } else {
	        	if (val > maxVal) {
		            maxVal =val;
		            a = inputArray[i];
		            b = inputArray[i+1];
		        }
	        }
	    }
	   System.out.println("a = " +a);
	   System.out.println("b = " +b);
	   return maxVal;
   }
   
   static boolean isPositive(int val) {
	   return (val>=0) ? true : false;
   }
    
    /*
     * Problem:
     * Below we will define an n-interesting polygon. 
     * Task is to find the area of a polygon for a given n.
     */
    static int shapeArea(int n) {
       if (n == 1) return 1;
       return 4*(n - 1) + shapeArea(n - 1);

 	}
    
    
    /*
     * Problem:
     */
    static int makeArrayConsecutive2(int[] statues) {
 	   int requiredStatues = 0;
 	   Arrays.sort(statues);
 	   for (int i=0;i<statues.length-1;i++) {
 		   requiredStatues += ((statues[i+1] - statues[i]) -1 );
 	   }
 	   return requiredStatues;
    }
    
    /*
     * Problem: 
     */
    static boolean almostIncreasingSequence(int[] sequence) {
    	
    	/*
    	 * Eg:
    	 * increaingSequence = 
    	 * {1,3,2,1};
    	 * {3,1,5,4,8};
    	 * {1,3,2};
    	 */
 	   
 	   for (int erasedIndex = 0; erasedIndex < sequence.length; ++erasedIndex) {
            boolean increasing = true;
            int last = 0,
                    start = 1;

            if (erasedIndex == 0) {
                last = 1;
                start = 2;
            }

            for (int j = start; j < sequence.length; ++j) {
                if (j == erasedIndex) {
                    continue;
                }
                if (sequence[j] <= sequence[last]) {
                    increasing = false;
                    break;
                }
                last = j;
            }

            if (increasing) {
                return true;
            }
        }

        return false;
    }
    
    
    /*
     * Problem:
     * 
     */
    static int matrixElementsSum(int[][] matrix) {
 	   
 	   /* double dimension matrix
 	    * 00 01 02 03
 	    * 10 11 12 13
 	    * 20 21 22 23
 	    * 30 31 32 33
 	    */
 	   
 	   /*
 	    * Eg: inputs
 	    * matrix = 
 	    * {{0, 1, 1, 2},{0, 5, 0, 0},{2, 0, 3, 3}}
 	    * {{1,1,1,0},{0,5,0,1},{2,1,3,10}}
 	    * {{1,1,1},{2,2,2},{3,3,3}}
 	    */
 	   int rows = matrix.length;
 	   int columns = matrix[0].length;
 	   int sum = 0;
 	   for (int j=0;j<columns;j++) {
 		   for(int i=0;i<rows;i++) {
 			   //System.out.println(i+""+j+"="+matrix[i][j]);
 			   if (matrix[i][j] == 0){
 				   break;
 			   } else {
 				   sum += matrix[i][j]; 
 			   }
 		   }
 	   }
 	   
 	   return sum;
    }
}
