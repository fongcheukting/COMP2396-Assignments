/**
 * The Triangle class is used to model triangles. It is a subclass of the Shape class. 
 * 
 * @author Pranav Talwar
 */
public class Triangle extends Shape{
	
	/**
	 * A method for setting the local coordinates of the 3 vertices of a standard triangle. Overrides the method in the parent class.
	 * 
	 * @param d Specifies the distance from the center of the triangle to any of its vertices.
	 */
	public void setVertices(double d) {
		xlocal = new double[] {d, -d*Math.cos(Math.PI/3), -d*Math.cos(Math.PI/3)};
		ylocal = new double[] {0, -d*Math.sin(Math.PI/3), d*Math.sin(Math.PI/3)};
	}

}
