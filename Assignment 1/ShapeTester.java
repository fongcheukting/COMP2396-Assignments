import java.awt.Color;
/**
 * The ShapeTester class is used to verify the correctness of 
 * of the implementation of the Shape class.
 * 
 * @author Pranav Talwar
 */
public class ShapeTester {

	/**
	 * A method for demonstrating a Shape object and its instance variables 
	 * and methods.
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		
		//creating a Shape object
		Shape shape = new Shape();
		System.out.println("Object Created");
		System.out.println();
		
		//assigning color to Shape object
		shape.color = new Color(100,0,0);
		System.out.println("Color assigned");
		System.out.println();
		
		//assigning filled to Shape object
		shape.filled = true;
		System.out.println("Shape filled");
		System.out.println();
		
		//assigning theta to Shape object
		shape.theta = 35;
		System.out.println("Theta assigned as: " + shape.theta);
		System.out.println();
		
		//assigning center coordinates to Shape object
		shape.xc = 20;
		shape.yc = 30;
		System.out.println("Local X and Y coordinates are " + shape.xc + " and "+ shape.yc);
		System.out.println();
		
		//calling method to set the Vertices of the Shape object	
		shape.setVertices(100);
		System.out.println("Dummy method setVertices called");
		System.out.println();
		
		//calling method to translate the center of the Shape object	
		shape.translate(100, 50);
		System.out.println("Translate method called");
		System.out.println("New X and Y coordinates are " + shape.xc + " and "+ shape.yc);
		System.out.println();
		
		//calling method to rotate the Shape object
		shape.rotate(20);
		System.out.println("Rotate method called");
		System.out.println("New value of theta is " + shape.theta);
		System.out.println();
		
		//assigning local x and y coordinates
		shape.xlocal = new double[]{1.1, 2.5};
		shape.ylocal = new double[] {3.45, 32.2};
		System.out.println("Assigned arbitrary coordinates to the Shape object");
		System.out.println();
		
		//calling getX() method
		int[] x = new int[shape.xlocal.length];
		x = shape.getX();
		System.out.println("Values from getX() function are as follows:");
		for (int i=0;i<x.length;i++)
		{
			System.out.print(x[i] + " ");
		} //for loop ended
		System.out.println();
		System.out.println();
		
		//calling getY() method
		int[] y = new int[shape.ylocal.length];
		y = shape.getY();
		System.out.println("Values from getX() function are as follows:");
		for (int i=0;i<y.length;i++)
		{
			System.out.print(y[i] + " ");
		}//for loop ended
	}
}
