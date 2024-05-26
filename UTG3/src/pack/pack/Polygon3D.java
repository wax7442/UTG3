/**
 * 5/23/24 1:15pm - Loff - wrote getCenterPoint()
 */

package pack;

import java.awt.Color;
//import java.awt.Point;
import java.util.ArrayList;

public class Polygon3D {
	
	
	private ArrayList<Point3D> points;

	private Color color;
	
	/**
	 * Precondition: all Point3Ds in points must be coplanar.
	 * Precondition: the points must be ordered such that drawing lines in a connect-the-dots fashion will create a single closed figure
	 * @param points
	 */
	public Polygon3D(Point3D[] points) {
		//copies parameter ArrayList into this.points
		this.points = new ArrayList<Point3D>();
		for(Point3D p : points)
		{
			this.points.add(p);
		}
		 setColor(Color.white);
	}
	
	/**
	 * Precondition: all Point3Ds in points must be coplanar.
	 * Precondition: the points must be ordered such that drawing lines in a connect-the-dots fashion will create a single closed figure
	 * @param points
	 */
	public Polygon3D(Point3D[] points, Color color) {
		this.points = new ArrayList<Point3D>();
		for(Point3D p:points)
		{
			this.points.add(p);
		}
		setColor(color);
	}
	
	/**
	 * Points in points ArrayList must be in an order as outlined in the Constructor preconditions
	 * @param p
	 * @param order
	 */
	public void addPoint(Point3D p, int order)
	{
		points.add(order, p); 
	}
	
	public Point3D getCenterPoint() {
		double avgX = 0; double avgY = 0; double avgZ = 0;
		for(Point3D p : points) {
			avgX += p.getX(); avgY += p.getY(); avgZ += p.getZ();
		}
		return new Point3D(avgX, avgY, avgZ);
	}

	public ArrayList<Point3D> getPoints()
	{
		return points;

	}
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	

}