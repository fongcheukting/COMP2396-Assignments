import java.awt.Color;
/**
 * The class shape is the superclass which helps to model the shapes described in the subclass. The instance variables include color, fill-type, orientation, local coordinates and screen coordinates of the vertices of a shape. It also has methods to deduce the screen coordinates of the vertices of the concerned shape.
 * 
 * @author Pranav Talwar
 */
public class Shape {
	
	
	/**
	 * This object implements the Color class present in the "import java.awt.Color" to specify the color of the object.
	 */
	private Color color;
	
	/**
     * Boolean value specifying whether the shape is filled or not filled.
     */
	private boolean filled;
	
	/**
     * Double value specifying the orientation (in radians) of the shape in the
	 * screen coordinate system.
     */
	private double theta;
	
	/**
     * Double value specifying the x-coordinate of the center of the shape in the
	 * screen coordinate system.
     */
	private double xc;
	
	/**
     * Double value specifying the y-coordinate of the center of the shape in the
	 * screen coordinate system.
     */
	private double yc;
	
	/**
	 * An array of double values specifying the x-coordinates of the
	 * vertices (in counter clock-wise order) of the shape in its local coordinate system.
     */
	private double[] xLocal;
	
	/**
     * An array of double values specifying the y-coordinates of the
	 * vertices (in counter clock-wise order) of the shape in its local coordinate system.
     */
	private double[] yLocal;
	
	/**
	 * A getter method for retrieving the color of the shape.
	 * 
	 * @return Returns the private value of the instance variable color
	 * */
	public Color getColor() {
		return color;
	}
	
	/**
	 * A getter method for retrieving the fill-type of the shape.
	 * 
	 * @return Returns the private value of the instance variable filled
	 * */
	public boolean getFilled() {
		return filled;
	}
	
	/**
	 * A getter method for retrieving the orientation (in radians) of the shape in the screen coordinate system.
	 * 
	 * @return Returns the private value of the instance variable theta.
	 * */
	public double getTheta() {
		return theta;
	}
	
	/**
	 * A getter method for retrieving the x-coordinate of the center of the shape in the screen coordinate system.
	 * 
	 * @return Returns the private value of the instance variable xc.
	 * */
	public double getXc() {
		return xc;
	}
	
	/**
	 * A getter method for retrieving the y-coordinate of the center of the shape in the screen coordinate system.
	 * 
	 * @return Returns the private value of the instance variable yc.
	 * */
	public double getYc() {
		return yc;
	}
	
	/**
	 * A getter method for retrieving the x-coordinates of the vertices (in counter clock-wise order) of the shape in its local coordinate system.
	 * 
	 * @return Returns the private value of the instance variable xLocal.
	 * */
	public double[] getXLocal() {
		return xLocal;
	}
	
	/**
	 * A getter method for retrieving the y-coordinates of the vertices (in counter clock-wise order) of the shape in its local coordinate system.
	 * 
	 * @return Returns the private value of the instance variable yLocal.
	 * */
	public double[] getYLocal() {
		return yLocal;
	}
	
	/**
	 * A setter method for setting the color of the shape. 
	 * 
	 * @param color An instance variable which stores the color of the shape and belongs to the Color class.
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * A setter method for setting the fill-type of the shape.
	 * 
	 * @param filled A boolean type instance variable which can either be true or false.
	 */
	public void setFilled(boolean filled)
	{
		this.filled = filled;
	}
	
	/**
	 * A setter method for setting the orientation of the shape.
	 * 
	 * @param theta A double type instance variable which stores the angle of orientation of the shape.
	 */
	public void setTheta(double theta) {
		this.theta = theta;
	}
	
	/**
	 * A setter method for setting the x-coordinate of the center of the shape in the screen coordinate system.
	 * 
	 * @param xc A double type instance variable which stores the value of the x-coordinate of the center of the shape.
	 */
	public void setXc(double xc) {
		this.xc = xc;
	}
	
	/**
	 * A setter method for setting the y-coordinate of the center of the shape in the screen coordinate system.
	 * 
	 * @param yc A double type instance variable which stores the value of the y-coordinate of the center of the shape.
	 */
	public void setYc(double yc) {
		this.yc = yc;
	}
	
	/**
	 * A setter method for setting the x-coordinates of the vertices (in counter clock-wise order) of the shape in its local coordinate system.
	 * 
	 * @param xLocal An array used to store the x-coordinates of the shape in the local coordinates system.
	 */
	public void setXLocal(double[] xLocal) {
		this.xLocal = xLocal;
	}
	
	/**
	 * A setter method for setting the y-coordinates of the vertices (in counter clock-wise order) of the shape in its local coordinate system.
	 * 
	 * @param yLocal An array used to store the y-coordinates of the shape in the local coordinates system.
	 */
	public void setYLocal(double[] yLocal) {
		this.yLocal = yLocal;
	}
	
	/**
	 * A method for translating the center of the shape by dx and dy, respectively, 
	 * along the x and y directions of the screen coordinate system.
	 * 
	 * @param dx The value by which center is translated along the x-direction.
	 * @param dy The value by which center is translated along the y-direction.
	 */
	public void translate(double dx, double dy)
	{
		this.xc = this.xc + dx;
		this.yc = this.xc + dy;
	}
	
	/**
	 * A method for rotating the shape about its center by an angle.
	 * 
	 * @param dt The value of the angle by which the shape should rotate.
	 */
	public void rotate(double dt) {
		this.theta =this.theta + dt;
	}
	
	/**
	 * A method for retrieving the x-coordinates of the vertices in counter 
	 * clock-wise order of the shape in the screen coordinate system 
	 * (rounded to nearest integer).
	 * 
	 * @return X-coordinates of the shape in the screen coordinate system.
	 */
	public int[] getX() {
		int[] newX = new int[this.getXLocal().length];
		for(int i=0;i<getXLocal().length;i++)
			
		{
			newX[i] = (int)(Math.round(this.getXLocal()[i]*Math.cos(this.getTheta()) - this.getYLocal()[i]*Math.sin(this.getTheta()) + this.getXc()));
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
		int[] newY = new int[this.getYLocal().length];
		for(int i=0;i<getYLocal().length;i++)
		{
			newY[i] = (int)Math.round(this.getXLocal()[i]*Math.sin(this.getTheta()) + this.getYLocal()[i]*Math.cos(this.getTheta()) + this.getYc());
			
		}
		return newY;
	}
}
