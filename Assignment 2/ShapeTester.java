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
		
		// creating a Shape object
		Shape shape = new Shape();
		System.out.println("Object Created");
		System.out.println();
		
		// assigning Color to Shape object using setter method
		Color color = new Color(255,0,0);
		shape.setColor(color);
		System.out.println("Color assigned");
		// getting Color of the Shape object using getter method
		System.out.println("Color of the shape is: "+ shape.getColor());
		System.out.println();
		
		
		// assigning filled to Shape object using setter method
		boolean filled = true;
		shape.setFilled(filled);
		System.out.println("Filled assigned");
		// getting Filled of the Shape object using getter method
		System.out.println("Shape filled? "+shape.getFilled());
		System.out.println();
		
		// assigning theta to Shape object using setter method
		double theta  = Math.PI/2;
		shape.setTheta(theta);
		System.out.println("Theta Assigned");
		// getting Theta of the Shape object using getter method
		System.out.println("Theta of the shape is: "+shape.getTheta());
		System.out.println();
		
		// assigning xc to Shape object using setter method
		double xc = 1.3;
		shape.setXc(xc);
		System.out.println("Xc assigned");
		// getting Xc of the Shape object using getter method
		System.out.println("X-coordinate of the shape is: "+shape.getXc());
		System.out.println();
		
		// assigning yc to Shape object using setter method
		double yc = 2.5;
		shape.setYc(yc);
		System.out.println("Yc assigned");
		// getting Yc of the Shape object using getter method
		System.out.println("Y-coordinate of the shape is: "+shape.getYc());
		System.out.println();
		
		// assigning xlocal to Shape object using setter method
		double[] xLocal = new double[] {1.0, 3.5, 4.3};
		shape.setXLocal(xLocal);
		System.out.println("Xlocal assigned");
		//getting xlocal of the Shape object using getter method
		double[] xlocal2 = shape.getXLocal();
		System.out.println("X coordinates of the vertices are: ");
		for(int i=0; i<xlocal2.length;i++)
		{
			System.out.print(xlocal2[i] + " ");
		}
		System.out.println();
		System.out.println();
		
		// assigning ylocal to Shape object using setter method
		double[] yLocal = new double[] {3.0, 6.5, 8.3};
		shape.setYLocal(yLocal);
		System.out.println("Ylocal assigned");
		// getting ylocal of the Shape object using getter method
		double[] ylocal2 = shape.getYLocal();
		System.out.println("Y coordinates of the vertices are: ");
		for(int i=0; i<ylocal2.length;i++)
		{
			System.out.print(ylocal2[i] + " ");
		}
		System.out.println();
		System.out.println();

		//calling method to translate the center of the Shape object	
		shape.translate(100, 50);
		System.out.println("Translate method called");
		System.out.println("New X and Y coordinates are " + shape.getXc()+ " and "+ shape.getYc());
		System.out.println();

		
		//calling method to rotate the Shape object
		shape.rotate(20);
		System.out.println("Rotate method called");
		System.out.println("New value of theta is " + shape.getTheta());
		System.out.println();
			
		//calling getX() method
		int[] x = new int[shape.getXLocal().length];
		x = shape.getX();
		System.out.println("Values from getX() function are as follows:");
		for (int i=0;i<x.length;i++)
		{
			System.out.print(x[i] + " ");
		} //for loop ended
		System.out.println();
		System.out.println();
		
		//calling getY() method
		int[] y = new int[shape.getYLocal().length];
		y = shape.getY();
		System.out.println("Values from getX() function are as follows:");
		for (int i=0;i<y.length;i++)
		{
			System.out.print(y[i] + " ");
		}//for loop ended
		
	}	

}
