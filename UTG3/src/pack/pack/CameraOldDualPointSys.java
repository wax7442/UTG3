
/**
 * This class exists beause I wanted to save some old Camera class code, this class isn't meant for anything else, don't work on it at all -Loff, 5/26/224, 11:37 am
 */


//DON'T WORK IN THIS CLASS



/**
 * @author Alex Loff
 * 5/23/24, 5:43 - Loff - moved getImage() in from another class, worked on getImage()
 */

package pack;

import java.awt.Point;
import java.util.ArrayList;

public class CameraOldDualPointSys extends Point3D {
	
	/**
	 * Big important, converts scene to a 2D image.
	 * @param scene
	 * @return
	 */
	private double screenWidth = 800;
	private double screenHeight = 600;
	private double FOVhrz = Math.PI/2;
	private double FOVvert = FOVhrz * screenHeight/screenWidth;
	public ArrayList<Polygon2D> getImage(Scene scene) {	//It's exceedingly silly that cam is part of scene, and also requires it as a parameter here
		ArrayList<Polygon2D> image = new ArrayList<Polygon2D>();
		ArrayList<Polygon3D> polys = new ArrayList<Polygon3D>();
		for(Mesh m : scene) {
			polys.addAll(m.getPolygons());
		}
		
		//Sorts polys such that 0 is the closest and .getSize() is the furthest
		for(int i = 0; i < polys.size(); i++)
		{
			double closest = Point3D.getDistanceBetween(polys.get(i).getCenterPoint(), this);
			for(int k = i+1; k < polys.size(); k++)
			{
				if(Point3D.getDistanceBetween(polys.get(i).getCenterPoint(), this) < closest)
				{
					Polygon3D temp = polys.get(i);
					polys.set(i, polys.get(k));
					polys.set(k, temp);
					closest = Point3D.getDistanceBetween(polys.get(i).getCenterPoint(), this);
				}
			}
		}
		
		for(Polygon3D poly : polys) {
			Polygon2D poly2D = new Polygon2D(poly.getColor());
			for(int i = 0; i < poly.getPoints().size(); i++)
			{
				Point3D point1 = poly.getPoints().get(i);
				Point3D point2;
				
				if(i < poly.getPoints().size()-1)
				{
					point2 = poly.getPoints().get(i+1);
				}
				else
				{
					point2 = poly.getPoints().get(0);
				}
				
				//Calculating points used to separate information from the x&y plane and the Z axis (Basically)
				Point3D point2HrzRef = new Point3D(point2.getX(), point1.getY(), point1.getZ());//This is gonna get weird when we do rotation (mayhaps)
				Point3D point2VertRef = new Point3D(point1.getX(), point2.getY(), point2.getZ());
				
				//calculating the size and direction of the vector consisting of p1 and p2
				double a = Point3D.getDistanceBetween(point1, point2HrzRef);
				double b = Point3D.getDistanceBetween(point1, this);
				double c = Point3D.getDistanceBetween(point2HrzRef, this);
				double angleHrzRef = Math.acos(((b*b)+(c*c)-(a*a))/(2*b*c));
				double length2DHrz = angleHrzRef/FOVhrz * screenWidth;
				
				a = Point3D.getDistanceBetween(point1, point2VertRef);
				b = Point3D.getDistanceBetween(point1, this);
				c = Point3D.getDistanceBetween(point2VertRef, this);
				double angleVertRef = Math.acos(((b*b)+(c*c)-(a*a))/(2*b*c));
				double length2DVert = angleVertRef/FOVvert * screenHeight;
				
				//calculating the point at which the line formed by a line directly straight from cam direction and a perpendicular line intersecting point1 intersect (Variable pointT)
				double x = Math.pow(Math.tan(angleH+(Math.PI/2))+point1.getY()-this.getY()/Math.tan(angleH)-1,-1)*(point1.getX()+this.getX())+point1.getX();
				double y = Math.tan(angleH)*(x-this.getX())+this.getY();
				Point3D pointHrzT = new Point3D(x, y, 0);
				
				x = Math.pow(Math.tan(angleV+(Math.PI/2))+point1.getY()-this.getY()/Math.tan(angleV)-1,-1)*(point1.getX()+this.getX())+point1.getX();
				y = Math.tan(angleV)*(x-this.getX())+this.getY();
				Point3D pointVertT = new Point3D(100/*was x*/, -100/*was y*/, 0);
				
				//Calculating the actual (not relative) position of point1 on screen by using pointT
				a = Point3D.getDistanceBetween(point1, pointHrzT);
				b = Point3D.getDistanceBetween(point1, this);
				c = Point3D.getDistanceBetween(pointHrzT, this);
				double angleHrzActual = Math.acos(((b*b)+(c*c)-(a*a))/(2*b*c));
				double location2DHrz = angleHrzActual/FOVhrz * screenWidth;
				
				a = Point3D.getDistanceBetween(point1, pointVertT);
				b = Point3D.getDistanceBetween(point1, this);
				c = Point3D.getDistanceBetween(pointVertT, this);
				double angleVertActual = Math.acos(((b*b)+(c*c)-(a*a))/(2*b*c));
				double location2DVert = angleVertActual/FOVvert * screenHeight;
				
				poly2D.addPoint(new Point((int)location2DHrz, (int)location2DVert));
			}
			image.add(poly2D);
			System.out.println("Adding a polygon2D to image in getImage() method of Camera class, Polygon: " + poly2D);
		}
		
		return image;
	}
	
	private ArrayList<Polygon3D> getPoly3Ds(Scene scene) {
		return null;
	}

	private double angleH; //Horizontal
	private double angleV; //Vertical
	private double angleR; //Rotate
	
	public CameraOldDualPointSys() {
		super(0, 0, 0);
		angleH = 0;
		angleV = 0;
		angleR = 0;
	}
	public CameraOldDualPointSys(Point3D initialPoint, double angleH, double angleV, double angleR) {
		super(initialPoint.getX(), initialPoint.getY(), initialPoint.getZ());
		this.angleH = angleH;
		this.angleV = angleV;
		this.angleR = angleR;
	}
	
	public double getAngleH() {
		return angleH;
	}
	public double getAngleV() {
		return angleV;
	}
	public double getAngleR() {
		return angleR;
	}
	
	public void updatePosition(Point3D point, double angleH, double angleV, double angleR) {
		setX(point.getX());
		setY(point.getY());
		setZ(point.getZ());
		this.angleH = angleH;
		this.angleV = angleV;
		this.angleR = angleR;
	}
	/**
	 * @param angle - Positive angle to turn right, negative to turn left.
	 */
	public void turnLeftRight(double angle) {
		angleH += angle;
		while(angleH >= 360) {
			angleH -= 360;
		}
		while(angleH < 0) {
			angleH += 360;
		}
	}
	/**
	 * @param angle - Positive angle to turn up, negative to turn down.
	 */
	public void turnUpDown(double angle) {
		angleV += angle;
		while(angleV >= 360) {
			angleV -= 360;
		}
		while(angleV < 0) {
			angleV += 360;
		}
	}
	/**
	 * @param angle - Positive angle to rotate right, negative to rotate left.
	 */
	public void rotate(double angle) {
		angleR += angle;
		while(angleR >= 360) {
			angleR -= 360;
		}
		while(angleR < 0) {
			angleR += 360;
		}
	}
	
	private boolean a, d, w, s;				 //KeyPressed
	private boolean left, right, up, down;	 //KeyPressed
	private boolean rotateLeft, rotateRight; //KeyPressed
	private void moveForward(double angleH, double angleV) {
		changeX(Math.cos(angleH) * Math.cos(angleV));
		changeY(Math.sin(angleH) * Math.cos(angleV));
		changeZ(Math.sin(angleV));
	}
	public void printSpaceAhead() {
		double x = (Math.cos(angleH) * Math.cos(angleV));
		double y = (Math.sin(angleH) * Math.cos(angleV));
		double z = (Math.sin(angleV));
		System.out.println(x + ", " + y + ", " + z);
	}
	//We need to set the key-variables once OpenGL is ready, I can't create a keylistener w/o a swing component
	//Since keylisteners aren't working, most of the applications of moveForward() are untested
	public void refreshCam() {	//Call 60 or something times per second
		if(w) {	//forward
			moveForward(angleH, angleV);
		}
		if(s) { //backward
			moveForward(angleH, angleV + Math.PI); //" + Math.PI" reverses direction
		}
		if(a) { //left (accounts for rotation)
			//gotta change direction 90 deg. (probably just angH, not V, but I'm unsure) Need to account for rotate on a and d press
			moveForward(angleH + Math.PI/4, angleR);
		}
		if(d) { //right (accounts for rotation)
			moveForward(angleH - Math.PI/4, angleR);
		}
		if(rotateLeft) {
			rotate(-1);
		}
		if(rotateRight) {
			rotate(1);
		}
		if(left) {
			turnLeftRight(-1);
		}
		if(right) {
			turnLeftRight(1);
		}
		if(up) {
			turnUpDown(1);
		}
		if(down) {
			turnUpDown(-1);
		}
	}
	
	public String toString() {
		return super.toString() + ", AngleH: " + angleH + ", AngleV: " + angleV + ", AngleR: " + angleR;
	}
}






