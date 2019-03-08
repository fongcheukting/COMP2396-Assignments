import java.awt.Color;
public class RegularPolygon extends Shape{
	
	/*
	 * Integer value specifying the number of sides of a regular n-sided polygon.
	 */
	private int numOfSides;
	
	/*
	 * Double value specifying the radius of a regular n-sided polygon.
	 */
	private double radius;
	
	/**
	 * A constructor for building a regular n-sided polygon with a radius of r.
	 * 
	 * @param n The parameter n specifies the number of sides of the polygon.
	 * @param r The parameter r specifies the radius of the polygon.
	 */
	public RegularPolygon(int n, double r)
	{
		if(n<3){
			this.numOfSides = 3; 	
		}
		else{
			this.numOfSides = n;
		}
		if(r<0){
			this.radius = 0;
		}
		else{
			this.radius = r;
		}
		this.setVertices();
		
	}
	
	
	/**
	 * A constructor for building a regular n-sided polygon with a radius of 1.0.
	 * 
	 * @param n The parameter n specifies the number of sides of the polygon.
	 */
	public RegularPolygon(int n)
	{
		if(n<3){
			this.numOfSides = 3; 	
		}
		else{
			this.numOfSides = n;
		}
		this.radius = 1.0;
		
		this.setVertices();
	}
	
	/**
	 * A constructor for building a regular 3-sided polygon with a radius of 1.0.
	 * 
	 */
	public RegularPolygon()
	{
		numOfSides = 3;
		radius = 1.0;
		this.setVertices();
	}
	
	/**
	 * A getter method for getting the number of sides of the polygon.
	 * 
	 * @return Returns a private instance variable numOfSides which contains the number of sides of the polygon.
	 */
	public int getNumOfSides()
	{
		return this.numOfSides;
	}
	
	/**
	 * A getter method for getting the radius of the polygon.
	 * 
	 * @return Returns a private instance variable radius which contains the radius of the polygon.
	 */
	public double getRadius(){
		return this.radius;
	}
	
	/**
	 * A setter method for setting the number of sides of the regular n-sided polygon. 
	 * This method also resets the local coordinates of the vertices of the regular n-sided polygon.
	 * 
	 * @param n The parameter n specifies the number of sides of the polygon.
	 */
	public void setNumOfSides(int n)
	{
		if(n<3){
			this.numOfSides = 3;
		}
		else{
			this.numOfSides = n;
		}
		this.setVertices();
	}
	
	/**
	 * A setter method for setting the radius of the regular n-sided polygon. 
	 * This method also resets the local coordinates of the vertices of the regular n-sided polygon.
	 * 
	 * @param n The parameter n specifies the number of sides of the polygon.
	 */
	public void setRadius(double r)
	{
		if(r<0){
			this.radius = 0;
		}
		
		else {
			this.radius = r;
		}
		this.setVertices();
	}
	
	/*
	 * A method for setting the local coordinates of the vertices of the regular n-sided polygon based on its number of sides and radius.
	 */
	private void setVertices() {
		double alpha;
		double theta = (2*Math.PI)/this.getNumOfSides();
		if(this.numOfSides%2==0)
		{
			alpha = Math.PI/this.getNumOfSides();
		}
		else {
			alpha = 0;
		}
		double [] xcoord = new double[this.getNumOfSides()];
		double [] ycoord = new double[this.getNumOfSides()];
		for(int i=0;i<this.getNumOfSides();i++)
		{
			xcoord[i] = (this.getRadius())*Math.cos(alpha - i*theta);
			ycoord[i] = (this.getRadius())*Math.sin(alpha - i*theta);
		}
		setXLocal(xcoord);
		setYLocal(ycoord);
	}
	
	/**
	 * A method for determining if a point (x, y) in the screen coordinate system is contained by the regular n-sided polygon.
	 * 
	 * @param x The parameter x specifies the x-coordinate of the point that we want to check if it lies inside the polygon.
	 * @param y The parameter y specifies the y-coordinate of the point that we want to check if it lies inside the polygon.
	 * @return Returns true or false if the point lies inside the polygon or not.
	 */
	public boolean contains(double x, double y)
	{
		double [] x_temporary = getXLocal();
		double x_minimum = 0;
		
		double local_x = (x - this.getXc())*Math.cos(-this.getTheta()) - (y - this.getYc())*Math.sin(-this.getTheta()); // converting screencoordinates into local coordinates
		double local_y = (x - this.getXc())*Math.sin(-this.getTheta()) + (y - this.getYc())*Math.cos(-this.getTheta());
		double new_x = local_x;
		
		for(int i = 1; i < numOfSides; i++)
		{	
			if(x_temporary[i] <= x_minimum)
			{
				x_minimum  = x_temporary[i];
			}
		}
		
		for(int i = 1; i <= numOfSides; i++)	
		{
			if(new_x < x_minimum)
			{
				return false;
			}
			
			new_x = local_x*Math.cos(2*i*Math.PI/this.getNumOfSides()) - local_y*Math.sin(2*i*Math.PI/this.getNumOfSides());
		}
		
		return true;
	}
}
