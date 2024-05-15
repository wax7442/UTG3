/**
 * @author Simon Braeger
 * @description A class to define a polygon, composed of three points and a color
 */

package pack;

import java.awt.Color;
import java.awt.Point;

public class Polygon2D {
	
	private Point p1;
	private Point p2;
	private Point p3;

	private Color color = Color.white;
	
	public Polygon2D(Point p1, Point p2, Point p3) {
		this.setP1(p1);
		this.setP2(p2);
		this.setP3(p3);
	}
	
	public Polygon2D(Point p1, Point p2, Point p3, Color color) {
		this.setP1(p1);
		this.setP2(p2);
		this.setP3(p3);
		this.setColor(color);
	}

	
	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public Point getP3() {
		return p3;
	}

	public void setP3(Point p3) {
		this.p3 = p3;
	}

	public Point[] getPoints()
	{
		Point[] points = new Point[3];
		points[0] = p1;
		points[1] = p2;
		points[2] = p3;
		return points;

	}
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	

}
