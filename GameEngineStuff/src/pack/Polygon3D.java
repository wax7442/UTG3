package pack;

import java.awt.Color;
//import java.awt.Point;
import java.util.ArrayList;

public class Polygon3D {
	
	
	private ArrayList<Point3D> points;

	private Color color = Color.white;
	
	public Polygon3D(Point[] points) {
		this.points = new ArrayList<Point3D>();
		for(Point3D p:points)
		{
			this.points.add(p);
		}
	}
	
	public Polygon3D(Point[] points, Color color) {
		this.points = new ArrayList<Point3D>();
		for(Point3D p:points)
		{
			this.points.add(p);
		}
		setColor(color);
	}
	

	public void addPoint(Point3D p)
	{
		points.add(p); 
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
