/**
 * @author Simon Braeger
 * @description A class to define a polygon, composed of three points and a color
 */

package pack;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Polygon2D {
	
	
	private ArrayList<Point> points;

	private Color color = Color.white;
	
	public Polygon2D(Point[] points) {
		this.points = new ArrayList<Point>();
		for(Point p:points)
		{
			this.points.add(p);
		}
	}
	
	public Polygon2D(Point[] points, Color color) {
		this.points = new ArrayList<Point>();
		for(Point p:points)
		{
			this.points.add(p);
		}
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
	

}
