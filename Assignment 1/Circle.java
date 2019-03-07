/**
 * The Circle class is used to model circles. It is a subclass of the Shape class. 
 * 
 * @author Pranav Talwar
 */
public class Circle extends Shape{
	
	/**
	 * A method for setting the local coordinates of the upper left and 
	 * lower right vertices of an axis-aligned bounding box of a standard circle. Overrides the method in the parent class.
	 * 
	 * @param d Specifies the radius of the circle.
	 */
	public void setVertices(double d)
	{
		xlocal = new double[]{-d, d};
		ylocal = new double[]{-d, d};
	}
	
	/**
	 * A method for retrieving the x-coordinates of the upper left and 
	 * lower right vertices of an axis-aligned bounding box of the circle.
	 * Overrides the method in the parent class.
	 * 
	 * @return X-coordinates of the upper left and lower right vertices of an 
	 * axis-aligned bounding box of the circle in the screen coordinate system. 
	 */
	public int[] getX()
	{
		int[] newX = new int[xlocal.length];
		for(int i=0;i<xlocal.length;i++)
		{
			newX[i] = (int)(xlocal[i] + xc);
		}
		return newX;
	}
	
	/**
	 * A method for retrieving the y-coordinates of the upper left and 
	 * lower right vertices of an axis-aligned bounding box of the circle.
	 * Overrides the method in the parent class.
	 * 
	 * @return Y-coordinates of the upper left and lower right vertices of an 
	 * axis-aligned bounding box of the circle in the screen coordinate system. 
	 */
	public int[] getY()
	{
		int[] newY = new int[ylocal.length];
		for(int i=0;i<ylocal.length;i++)
		{
			newY[i] = (int)(ylocal[i] + yc);
		}
		return newY;
	}
	

}
