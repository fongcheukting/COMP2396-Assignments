import java.awt.Color;
/**
 * The RegularPolygonTester class is used to verify the correctness of 
 * of the implementation of the RegularPolygon class.
 * 
 * @author Pranav Talwar
 */
public class RegularPolygonTester {
	
	/**
	 * A method for demonstrating a RegularPolygon object and its instance variables
	 * and methods.
	 * 
	 * @param args Unused
	 */
	public static void main(String[] args) {
		
		// creating a RegularPolygon object using constructor 3
		RegularPolygon RP3= new RegularPolygon();
		System.out.println("Object Created");
		// getting the Radius and Number of Sides of the RegularPolygon using the getter methods
		System.out.println("Number of sides: " +RP3.getNumOfSides());
		System.out.println("Radius: " + RP3.getRadius());
		System.out.println();
		
		// creating a RegularPolygon object using constructor 2
		RegularPolygon RP2= new RegularPolygon(7);
		System.out.println("Object Created");
		// getting the Radius and Number of Sides of the RegularPolygon using the getter methods
		System.out.println("Number of sides: " +RP2.getNumOfSides());
		System.out.println("Radius: " + RP2.getRadius());
		System.out.println();
		
		// creating a RegularPolygon object using constructor 3
		RegularPolygon RP = new RegularPolygon(4,5);
		System.out.println("Object Created");
		// getting the Radius and Number of Sides of the RegularPolygon using the getter methods
		System.out.println("Number of sides: " +RP.getNumOfSides());
		System.out.println("Radius: " + RP.getRadius());
		System.out.println();
		
		// assigning Color to RP object using setter method
		Color color = new Color(255,0,0);
		RP.setColor(color);
		System.out.println("Color assigned");
		// getting Color of the RegularPolygon object using getter method
		System.out.println("Color of the RegularPolygon is: "+ RP.getColor());
		System.out.println();
		
		// assigning filled to RegularPolygon object using setter method
		boolean filled = true;
		RP.setFilled(filled);
		System.out.println("Filled assigned");
		// getting Filled of the RegularPolygon object using getter method
		System.out.println("Regular Polygon filled? "+RP.getFilled());
		System.out.println();
		
		// assigning theta to Shape object using setter method
		double theta  = Math.PI/2;
		RP.setTheta(theta);
		System.out.println("Theta Assigned");
		// getting Theta of the RegularPolygon object using getter method
		System.out.println("Theta of the Regular Polygon is: "+RP.getTheta());
		System.out.println();
		
		// assigning xc to RegularPolygon object using setter method
		double xc = 1.3;
		RP.setXc(xc);
		System.out.println("Xc assigned");
		// getting Xc of the RegularPolygon object using getter method
		System.out.println("X-coordinate of the Regular Polygon is: "+RP.getXc());
		System.out.println();
				
		// assigning yc to RegularPolygon object using setter method
		double yc = 2.5;
		RP.setYc(yc);
		System.out.println("Yc assigned");
		// getting Yc of the RegularPolygon object using getter method
		System.out.println("Y-coordinate of the Regular Polygon is: "+RP.getYc());
		System.out.println();
		
		
		//calling method to translate the center of the Regular Polygon object	
		RP.translate(100, 50);
		System.out.println("Translate method called");
		System.out.println("New X and Y coordinates are " + RP.getXc()+ " and "+ RP.getYc());
		System.out.println();

		
		//calling method to rotate the Regular Polygon object
		RP.rotate(20);
		System.out.println("Rotate method called");
		System.out.println("New value of theta is " + RP.getTheta());
		System.out.println();
		
		// assigning numOfSides to RegularPolygon object using setter method
		int numOfSides = 3;
		RP.setNumOfSides(numOfSides);
		System.out.println("Number of sides assigned");
		// getting numofSides of the RegularPolygon object using getter method
		System.out.println("Number of sides of the Regular Polygon is: "+RP.getNumOfSides());
		System.out.println();
		
		// assigning numOfSides to RegularPolygon object using setter method
		double r= 5.3;
		RP.setRadius(r);;
		System.out.println("Radius assigned");
		// getting Radius of the RegularPolygon object using getter method
		System.out.println("Radius of the Regular Polygon is: "+RP.getRadius());
		System.out.println();
		
		// checking if point is contained within the Regular Polygon
		double x = 4.3;
		double y = 5.4;
		System.out.println("Calling contains method");
		System.out.println("The point is inside the Regular polygon? " + RP.contains(x, y));
		System.out.println();
		
		// assigning ylocal to Regular Polygon object using setter method
		double[] yLocal = new double[] {3.0, 6.5, 8.3};
		RP.setYLocal(yLocal);
		System.out.println("Ylocal assigned");
		// getting ylocal of the Shape object using getter method
		double[] ylocal2 = RP.getYLocal();
		System.out.println("Y coordinates of the vertices are: ");
		for(int i=0; i<ylocal2.length;i++)
		{
			System.out.print(ylocal2[i] + " ");
		}
		System.out.println();
		System.out.println();
		
		// assigning xlocal to Regular Polygon object using setter method
		double[] xLocal = new double[] {3.0, 6.5, 8.3};
		RP.setXLocal(xLocal);
		System.out.println("Ylocal assigned");
		// getting xlocal of the Shape object using getter method
		double[] xlocal2 = RP.getYLocal();
		System.out.println("Y coordinates of the vertices are: ");
		for(int i=0; i<xlocal2.length;i++)
		{
			System.out.print(xlocal2[i] + " ");
		}
		System.out.println();
		System.out.println();
		
		// calling getX and getY to print the vertices in screen coordinates
		for(int i = 0; i < RP.getX().length; i++)
		{
			System.out.println("Co-ordinates: of vertices "+ i + " is "+ RP.getX()[i] + "," + RP.getY()[i]);
		}
		System.out.println();
		
		
	}
	

}
