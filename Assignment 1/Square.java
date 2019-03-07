/**
 * The Square class is used to model squares. It is a subclass of the Shape class.
 * 
 * @author Pranav Talwar
 */
public class Square extends Shape {
	
	/**
	 * A method for setting the local coordinates of the 4 vertices of a standard square. Overrides the method in the parent class.
	 * 
	 * @param d Specifies half the length of the side of the square.
	 */
	public void setVertices(double d) {
		xlocal = new double[]{d, d, -d, -d};
		ylocal = new double[]{d, -d, -d, d};
	}

}
