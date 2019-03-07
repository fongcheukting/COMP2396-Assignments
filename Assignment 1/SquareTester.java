import java.awt.Color;
/**
 * The SquareTester class is used to verify the correctness of 
 * of the implementation of the Square class.
 * 
 * @author Pranav Talwar
 */
public class SquareTester {

	/**
	 * A method for demonstrating a Square object and its instance variables and methods.
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		
		//creating a Square object
		Square square = new Square();
		System.out.println("Object Created!");
		System.out.println();
		
		//assigning color to Square object
		square.color = new Color(20,30,10);
		System.out.println("Color assigned");
		System.out.println();
		
		//assigning filled to Square object
		square.filled = true;
		System.out.println("Square filled?" + square.filled);
		System.out.println();
		
		//assigning theta to Square object
		square.theta = 60;
		System.out.println("Theta assigned as: " + square.theta);
		System.out.println();
		
		//assigning center coordinates to Square object
		square.xc = 24;
		square.yc = 19;
		System.out.println("Local X and Y coordinates are " + square.xc + " and "+ square.yc);
		System.out.println();
		
		//calling method to set the Vertices of the Square object	
		square.setVertices(20);
		System.out.println("Local coordinates of vertices have been set");
		System.out.println();
		
		//printing out the Local X-coordinates of the Square Object
		System.out.println("X coordinates of vertices are:");
		for(int i=0;i<square.xlocal.length;i++)
		{
			System.out.print(square.xlocal[i] + " ");
		}//for loop ended
		System.out.println();
		System.out.println();
		
		//printing out the Local Y-coordinates of the Square Object 
		System.out.println("Y coordinates of vertices are:");
		for(int i=0;i<square.ylocal.length;i++)
		{
			System.out.print(square.ylocal[i] + " ");
		}//for loop ended
		System.out.println();
		System.out.println();
		
		//calling methods to translate the center of the Square object
		square.translate(25, 10);
		System.out.println("Translate method called");
		System.out.println("New X and Y coordinates are " + square.xc + " and "+ square.yc);
		System.out.println();
		
		//calling method to rotate the Square object
		square.rotate(30);
		System.out.println("Rotate method called");
		System.out.println("New value of theta is " + square.theta);
		System.out.println();
		
		//calling getX() method
		int[] x = new int[square.xlocal.length];
		x = square.getX();
		System.out.println("Values from getX() function are as follows:");
		for (int i=0;i<x.length;i++)
		{
			System.out.print(x[i] + " ");
		}//for loop ended
		System.out.println();
		System.out.println();
		
		//calling getY() method
		int[] y = new int[square.ylocal.length];
		y = square.getY();
		System.out.println("Values from getX() function are as follows:");
		for (int i=0;i<y.length;i++)
		{
			System.out.print(y[i] + " ");
		}//for loop ended
		
	}
	
}
