package viensp_lab1;

import java.util.Scanner;
import java.util.Random;

public class TwoDimArray {

	public static void main(String[] args) {
		
		Scanner kbd = new Scanner(System.in);
		String input;
		char repeat;
		
		welcome();
		
		do {	
		int ColRowNum = ColumnsRows();
		TwoDArray(ColRowNum);
		System.out.println();
		System.out.println("Repeat (y/n)? ");
		input = kbd.nextLine();
		repeat = input.charAt(0);
		} while (repeat == 'y' || repeat == 'Y');
		
		goodbye();

	}
	
	public static void welcome() {
		System.out.println();
		System.out.println("This is the first lab for the new bootcamp.\n"
				+ "I will figure this out as I go along ");
		
	}
	
	public static void goodbye() {
		System.out.println();
		System.out.println("Here we go again on our own!");
		System.out.println();
	}
	
	public static int ColumnsRows() {
		
		int INT_LO = 1;
		int INT_HI = 10;
		int number;
		
		Scanner kbd = new Scanner(System.in);
		System.out.println();
		System.out.print("How many rows (Something between 1 and 10)?  ");
		number = kbd.nextInt();
		kbd.nextLine();
		System.out.println();
		
		while(!(INT_LO <= number && number <= INT_HI))
		{		
				System.out.println();
				System.out.print("How many rows "
						+ "(Something between 1 and 10)?  ");
				number = kbd.nextInt();
				kbd.nextLine();
				System.out.println();
		}
		
		return number;

	}
	
	public static  void TwoDArray(int ColRowNum) {
		
		
		final int MAX = ColRowNum;
		
		int[][] Array = new int [MAX][MAX];
		int [] RowSums = new int [MAX];
		int[] ColSums = new int [MAX];
		int topToBottom = 0;
		int bottomToTop = 0;
		Random rand = new Random();
		int range = 100;
		int row;
		int col;
		
		for (row = 0; row < ColRowNum; row++)
		{
			System.out.printf("   ");
			for (col = 0; col < ColRowNum; col++)
			{
				Array[row][col] = rand.nextInt(range);
				RowSums[row] += Array[row][col];
				ColSums[col] += Array[row][col];
				System.out.printf("%6s", Array[row][col]);
				
				if (col == row)
				{
					topToBottom += Array[row][col]; 
				}
				else if (col == (ColRowNum-1) - row)
				{
					bottomToTop += Array[row][col];
				}
			}
			System.out.printf(" = %6s", RowSums[row]);
			System.out.println();
			
		}
		
		System.out.print(bottomToTop);
		
		for (row = 0; row < ColRowNum; row ++)
		{
			System.out.printf("%6s", ColSums[row]);
		}
		
		System.out.printf("   %6s", topToBottom);
		
		System.out.println();
		System.out.println("ColSums");
		
		for (col = 0; col < ColRowNum; col++)
		{
			System.out.println(ColSums[col]);
		}
	}
}
