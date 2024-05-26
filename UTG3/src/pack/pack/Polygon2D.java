/**
 * @author Simon Braeger
 * @description A class to define a polygon, composed of three points and a color
 * 5/23/24, 5:35 - Loff - Added constructors that initialize Polygon2D without any points. Defined color in constructors instead of the line it's declared on. Added a toString() method.
 */

package pack;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Polygon2D {
	
	private ArrayList<Point> points;
	private Color color;
	
	public Polygon2D(Point[] points) {
		this.points = new ArrayList<Point>();
		for(Point p:points)
		{
			this.points.add(p);
		}
		setColor(Color.white);
	}
	public Polygon2D(Point[] points, Color color) {
		this.points = new ArrayList<Point>();
		for(Point p:points)
		{
			this.points.add(p);
		}
		setColor(color);
	}
	public Polygon2D() {
		points = new ArrayList<Point>();
		setColor(Color.white);
	}
	public Polygon2D(Color color) {
		points = new ArrayList<Point>();
		setColor(color);
	}
	

	public void addPoint(Point p)
	{
		points.add(p); 
	}
	

	public ArrayList<Point> getPoints()
	{
		return points;

	}
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public String toString() {
		return "" + points;
	}

}