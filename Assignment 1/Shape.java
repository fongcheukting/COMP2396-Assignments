import java.awt.Color;
/**
 * The Shape class is used to model general shapes. 
 * 
 * @author Pranav Talwar
 */
public class Shape {
	/**
	 * Color object specifying the color of the shape.
	 */
	public Color color;
	
	/**
     * Boolean value specifying whether the shape is filled or not filled.
     */
	public boolean filled;
	
	/**
     * Double value specifying the orientation (in radians) of the shape in the
	 * screen coordinate system.
     */
	public double theta;
	
	/**
     * Double value specifying the x-coordinate of the center of the shape in the
	 * screen coordinate system.
     */
	public double xc;
	
	/**
     * Double value specifying the y-coordinate of the center of the shape in the
	 * screen coordinate system.
     */
	public double yc;
	
	/**
	 * An array of double values specifying the x-coordinates of the
	 * vertices (in counter clock-wise order) of the shape in its local coordinate system.
     */
	public double[] xlocal;
	
	/**
     * An array of double values specifying the y-coordinates of the
	 * vertices (in counter clock-wise order) of the shape in its local coordinate system.
     */
	public double[] ylocal;
	
	/**
	 * A method for setting the local coordinates of the vertices of a shape. 
	 * A dummy method overridden in the child classes.
	 * 
	 * @param d The value used to specify the dimensions of the shape.
	 */
	public void setVertices(double d) {
	
	}
	
	/**
	 * A method for translating the center of the shape by dx and dy, respectively, 
	 * along the x and y directions of the screen coordinate system.
	 * 
	 * @param dx The value by which center is translated along the x-direction.
	 * @param dy The value by which center is translated along the y-direction.
	 */
	public void translate(double dx, double dy) {
		xc = xc + dx;
		yc = yc + dy;
	}
	
	/**
	 * A method for rotating the shape about its center by an angle.
	 * 
	 * @param dt The value of the angle by which the shape should rotate.
	 */
	public void rotate(double dt) {
		theta = theta + dt;
	}
	
	/**
	 * A method for retrieving the x-coordinates of the vertices in counter 
	 * clock-wise order of the shape in the screen coordinate system 
	 * (rounded to nearest integer).
	 * 
	 * @return X-coordinates of the shape in the screen coordinate system.
	 */
	public int[] getX() {
		int[] newX = new int[xlocal.length];
		for(int i=0;i<xlocal.length;i++)
			
		{
			newX[i] = (int)Math.round(xlocal[i]*Math.cos(theta) - ylocal[i]*Math.sin(theta) + xc);
		}
		return newX;
	}
	
	/**
	 * A method for retrieving the y-coordinates of the vertices in counter 
	 * clock-wise order of the shape in the screen coordinate system 
	 * (rounded to nearest integer).
	 * 
	 * @return Y-coordinates of the shape in the screen coordinate system.
	 */
	public int[] getY() {
		int[] newY = new int[ylocal.length];
		for(int i=0;i<ylocal.length;i++)
		{
			newY[i] = (int)Math.round(xlocal[i]*Math.sin(theta) + ylocal[i]*Math.cos(theta) + yc);
			
		}
		return newY;
	}
}
