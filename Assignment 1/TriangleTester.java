import java.awt.Color;
/**
 * The TriangleTester class is used to verify the correctness of 
 * of the implementation of the Triangle class.
 * 
 * @author Pranav Talwar
 */
public class TriangleTester {

	/**
	 * A method for demonstrating a Triangle object and its instance variables and methods.
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		
		//creating a Triangle object
		Triangle triangle = new Triangle();
		System.out.println("Object Created");
		System.out.println();
		
		//assigning color to Triangle object
		triangle.color = new Color(200,120,10);
		System.out.println("Color assigned");
		System.out.println();
		
		//assigning filled to Triangle object
		triangle.filled = true;
		System.out.println("Triangle filled?" + triangle.filled);
		System.out.println();
		
		//assigning theta to Triangle object
		triangle.theta = 75;
		System.out.println("Theta assigned as: " + triangle.theta);
		System.out.println();
		
		//assigning center coordinates to Triangle object
		triangle.xc = 5;
		triangle.yc = 25;
		System.out.println("Local X and Y center coordinates are " + triangle.xc + " and "+ triangle.yc);
		System.out.println();
		
		//calling method to set the Vertices of the Triangle object	
		triangle.setVertices(30);
		System.out.println("Local coordinates of vertices have been set");
		System.out.println();
		
		//printing out the Local X-coordinates of the Triangle Object 
		System.out.println("X coordinates of vertices are:");
		for(int i=0;i<triangle.xlocal.length;i++)
		{
			System.out.print(triangle.xlocal[i] + " ");
		} //for loop ended
		System.out.println();
		System.out.println();
		
		//printing out the Local Y-coordinates of the Triangle Object 
		System.out.println("Y coordinates of vertices are:");
		for(int i=0;i<triangle.ylocal.length;i++)
		{
			System.out.print(triangle.ylocal[i] + " ");
		}//for loop ended
		System.out.println();
		System.out.println();
		
		//calling methods to translate the center of the Triangle object
		triangle.translate(15, 4);
		System.out.println("Translate method called");
		System.out.println("New X and Y coordinates are " + triangle.xc + " and "+ triangle.yc);
		System.out.println();
		
		//calling method to rotate the Triangle object
		triangle.rotate(30);
		System.out.println("Rotate method called");
		System.out.println("New value of theta is " + triangle.theta);
		System.out.println();
		
		//calling getX() method
		int[] x = new int[triangle.xlocal.length];
		x = triangle.getX();
		System.out.println("Values from getX() function are as follows:");
		for (int i=0;i<x.length;i++)
		{
			System.out.print(x[i] + " ");
		}//for loop ended
		System.out.println();
		System.out.println();
		
		//calling getY() method
		int[] y = new int[triangle.ylocal.length];
		y = triangle.getY();
		System.out.println("Values from getX() function are as follows:");
		for (int i=0;i<y.length;i++)
		{
			System.out.print(y[i] + " ");
		} // for loop ended

	}

}
