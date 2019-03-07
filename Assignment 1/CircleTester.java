import java.awt.Color;
/**
 * The CircleTester class is used to verify the correctness of 
 * of the implementation of the Circle class.
 * 
 * @author Pranav Talwar
 *
 */
public class CircleTester {
	
	/**
	 * A method for demonstrating a Circle object and its instance variables and methods.
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		
		//creating a Circle object
		Circle circle = new Circle();
		System.out.println("Object Created");
		System.out.println();
		
		//assigning color to Circle object
		circle.color = new Color(200,0,0);
		System.out.println("Color assigned");
		System.out.println();
		
		//assigning filled to Circle object
		circle.filled = true;
		System.out.println("Circle filled?" + circle.filled);
		System.out.println();
		
		//assigning theta to Circle object
		circle.theta = Math.PI;
		System.out.println("Theta assigned as: " + circle.theta);
		System.out.println();
		
		//assigning center coordinates to Circle object
		circle.xc = 20;
		circle.yc = 20;
		System.out.println("Local X and Y center coordinates are " + circle.xc + " and "+ circle.yc);
		System.out.println();
		
		//calling method to set the Vertices of the Circle object	
		circle.setVertices(20);
		System.out.println("Local coordinates of vertices have been set");
		System.out.println("X coordinates of vertices are:");
		
		//printing out the Local X-coordinates of the Circle Object 
		for(int i=0;i<circle.xlocal.length;i++)
		{
			System.out.print(circle.xlocal[i] + " ");
		} // for loop ended
		System.out.println();
		System.out.println();
		
		//printing out the Local Y-coordinates of the Circle Object 
		System.out.println("Y coordinates of vertices are:");
		for(int i=0;i<circle.ylocal.length;i++)
		{
			System.out.print(circle.ylocal[i] + " ");
		}// for loop ended
		System.out.println();
		System.out.println();
		
		//calling methods to translate the center of the Circle object
		circle.translate(150, 100);
		System.out.println("Translate method called");
		System.out.println("New X and Y coordinates are " + circle.xc + " and "+ circle.yc);
		System.out.println();
		
		//calling method to rotate the Circle object
		circle.rotate(20);
		System.out.println("Rotate method called");
		System.out.println("New value of theta is " + circle.theta);
		System.out.println();
		
		//calling getX() method
		int[] x = new int[circle.xlocal.length];
		x = circle.getX();
		System.out.println("Values from getX() function are as follows:");
		for (int i=0;i<x.length;i++)
		{
			System.out.print(x[i] + " ");
		}//for loop ended
		System.out.println();
		System.out.println();
		
		//calling getY() method
		int[] y = new int[circle.ylocal.length];
		y = circle.getY();
		System.out.println("Values from getX() function are as follows:");
		for (int i=0;i<y.length;i++)
		{
			System.out.print(y[i] + " ");
		}//for loop ended
	}

}
