//import java.awt.*;
import java.util.*;

public class NQueens {
	public static void main(String[] args){
		int n;
		char algorithm;
		Random rand = new Random();
		
		if(args.length > 1){
			n=Integer.parseInt(args[0]);
			algorithm=args[1].charAt(0);
			
			if (n < 4){
				System.out.print("No solution available for n.");
			} else {
				int a[] = {2,0,3,1};
				Chessboard c = new Chessboard(n);
				int h = c.getHeuristic();
				//c.printBoard();
				
				// Hillclimb Algorithm
				if(algorithm=='h'){
					c.HillClimb();
					if (c.getHeuristic()> 0){
						System.out.println("Local Minimum reached.");	
					} else {
						System.out.println("Solution found!");
					}
				}
				// Random Restart Algorithm
				else if(algorithm=='r'){
					long startTime=System.nanoTime();
					int r = 0;
					while(h > 0){
						c = new Chessboard(n);
						c.HillClimb();
						h = c.getHeuristic();
						r++;
					}
					long endTime=System.nanoTime();
					System.out.println("Solution found!");
					System.out.println("Number of restarts: "+r);
					System.out.println("Time Taken: "+(endTime-startTime)/1000000 + " Milliseconds.");
					c.printBoard();
				}
				// Simulated Annealing Algorithm
				else if(algorithm=='a'){
					
				}
				// Genetic Algorithm
				else if(algorithm=='g'){
					
				}
				
				else if (algorithm=='p'){
					//List l = c.getList();
					System.out.println("Heuristic: " + h);
					c.printBoard();
				}
				
				// Test Algorithm
				
				else if (algorithm=='t'){
					long startTime=System.nanoTime();
					int r=0;
					while(h > 0){
						c = new Chessboard(n);
						h = c.getHeuristic();
						r++;
					}
					
					long endTime=System.nanoTime();
					System.out.println("Solution found!");
					System.out.println("Number of restarts: "+r);
					System.out.println("Time Taken: "+(endTime-startTime)/1000000 + " Milliseconds.");
					c.printBoard();
				}
				
				else {
					System.err.print("Invalid input");
				}
			}
		}
		else {
			System.out.println("Execute the program using the syntax java nqueens (number n) (char algorithm) ");
			System.out.println("Hillclimb = h, genetic = g, annealing = a, random restart = r");
		}
	}
}