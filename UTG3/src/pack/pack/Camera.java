/**
 * @author Alex Loff
 * 5/23/24, 7:44 - Loff - moved getImage() in from another class, worked on getImage()
 */

package pack;

import java.awt.Point;
import java.util.ArrayList;

public class Camera extends Point3D {
	
	/**
	 * Big important, converts scene to a 2D image.
	 * @param scene
	 * @return
	 */
	private final double screenWidth = 800;
	private final double screenHeight = 600;
	private final double FOVhrz = Math.PI / 2;
	private final double FOVvert = FOVhrz * (screenHeight/screenWidth);
//	private double FOVvert = FOVhrz * (screenHeight/screenWidth);
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
		
		/**
		 * This for loop works almost perfectly. I believe that the Polygon2Ds are shifted a bit to the left for some reason, but I might just be trippin -Loff
		 */
		String toPrintMathsTestThing = "";
		String toPrintMathsTestThing2 = "";
		for(Polygon3D poly : polys) {
			Polygon2D poly2D = new Polygon2D(poly.getColor());
			for(int i = 0; i < poly.getPoints().size(); i++)
			{
				Point3D point = poly.getPoints().get(i);
				
				// Horizontal stuff
				Point3D refPoint = new Point3D(point.getX(), point.getY(), this.getZ());
//				double x = (-this.getX() + point.getX())/((Math.tan(angleH+Math.PI/2) + point.getY() - this.getY())/Math.tan(angleH)-1) + point.getX();
//				double y = Math.tan(angleH)*(x-this.getX())+this.getY();
//				Point3D pointHrzT = new Point3D(x, y, this.getZ());
//				System.out.println("pointHrzT: " + pointHrzT);
//				double adj = getDistanceBetween(pointHrzT, this);
//				double opp = getDistanceBetween(pointHrzT, refPoint);
//				toPrintMathsTestThing = pointHrzT.toString();	//Test successful
//				toPrintMathsTestThing2 = refPoint.toString();
				
				
				
				Point3D pointRelToCam = new Point3D(point.getX() - this.getX(), point.getY() - this.getY(), point.getZ() - this.getZ());
				double pointAngFromXAxis = Math.atan(pointRelToCam.getY()/pointRelToCam.getX());
				turnLeftRight(0);	//Ensuring angleH is in the interval [0, 2Pi)
				
				double oppAngH = angleH - Math.PI;
				if(oppAngH < 0) {
					oppAngH += 2*Math.PI;
				}
				
				toPrintMathsTestThing2 = angleH + "";
				
				double angleHrzActual = 0;
				if(angleH<Math.PI) {
					if(pointAngFromXAxis < angleH || pointAngFromXAxis > oppAngH) {
						angleHrzActual = -(pointAngFromXAxis - angleH);
					} else {
						angleHrzActual = -(pointAngFromXAxis + (Math.PI*2-angleH));
					}
				} else {
					if(pointAngFromXAxis > angleH || pointAngFromXAxis < oppAngH) {
						angleHrzActual = -(pointAngFromXAxis + (Math.PI*2-angleH));
					} else {
						angleHrzActual = -(pointAngFromXAxis - angleH);
					}
				}
				
				
//				double angleHrzActual = /*negPosH * */ -(pointAngFromXAxis - angleH);
//				double angleHrzActual = negPosH * (angleH - pointAngFromXAxis);
//				double angleHrzActual = negPosH * Math.atan(opp/adj);	//This needs to return negative values sometimes (I'm almost certain this is THE issue) //It was >:)	
				double location2DHrz = (angleHrzActual/FOVhrz) * screenWidth;
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				//Vertical stuff	//Doesn't yet account for angleV, assumes it to be zero -Loff, 11:28 pm, 5/29/24
				//Vertical stuff is (probably) (mostly) functioning correctly -Loff, 12:39 am, 4/30/24 (or at least it's working good enough for now)
				//I'm 50% sure that the uncommented version of refPoint is the correct one -Loff, 11:38 pm, 5/29/24
				//IMPORTANT: pointHrzT was being calculated incorrectly. The commented refPoint could be correct in theory and just using bad info
//				refPoint = new Point3D(pointHrzT.getX(), pointHrzT.getY(), point.getZ());	//The use of pointHrzT is not an error.
				refPoint = new Point3D(point.getX(), point.getY(), this.getZ());	//The use of pointHrzT is not an error.
				
				System.out.println("refPoint: " + refPoint);
//				adj = getDistanceBetween(this, pointHrzT);
				double adj = getDistanceBetween(this, refPoint);
				double opp = getDistanceBetween(refPoint, point);
//				opp = getDistanceBetween(pointHrzT, refPoint);	//Could replace "getDist...)" w/ "Math.abs(point.getZ() - this.getZ()", then not change refPoint (3 lines above) for optimization
				
				double pointAngFromCamVert = Math.atan(pointRelToCam.getZ()/getDistanceBetween(this, refPoint));
				turnUpDown(0);	//Ensuring angleV is in the interval [0, 2Pi)
				double negPosV = pointAngFromCamVert - angleV / Math.abs(pointAngFromCamVert - angleV);	//This line will need to be modified later to check for div by zero cases
				
				double angleVertActual = negPosV * Math.atan(opp/adj);	//this will see same problems as horizontal and only return pos when it sometimes needs neg
//				System.out.println("Math.atan(opp/adj): " + negPosV * Math.atan(opp/adj));
//				System.out.println("opp/adj: " + opp/adj);
				System.out.println(angleVertActual);
				double location2DVert = screenHeight * (angleVertActual/FOVvert);
				
				//Final point
				poly2D.addPoint(new Point((int)location2DHrz, (int)location2DVert));
				
			}
			image.add(poly2D);
			System.out.println("Adding a polygon2D to image in getImage() method of Camera class, Polygon: " + poly2D);
		}
		System.out.println();
		System.out.println("TEST: " + toPrintMathsTestThing);
		System.out.println("TEST: " + toPrintMathsTestThing2);
		System.out.println();
		
		return image;
	}

	private double angleH; //Horizontal
	private double angleV; //Vertical
	private double angleR; //Rotate
	
	public Camera() {
		super(0, 0, 0);
		angleH = 0;
		angleV = 0;
		angleR = 0;
	}
	public Camera(Point3D initialPoint, double angleH, double angleV, double angleR) {
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
		angleH -= angle;
		while(angleH >= Math.PI * 2) {
			angleH -= Math.PI * 2;
		}
		while(angleH < 0) {
			angleH += Math.PI * 2;
		}
	}
	/**
	 * @param angle - Positive angle to turn up, negative to turn down.
	 */
	public void turnUpDown(double angle) {
		angleV += angle;
		while(angleV >= Math.PI * 2) {
			angleV -= Math.PI * 2;
		}
		while(angleV < 0) {
			angleV += Math.PI * 2;
		}
	}
	/**
	 * @param angle - Positive angle to rotate right, negative to rotate left.
	 */
	public void rotate(double angle) {
		angleR -= angle;	//angleR is basically a negative baring in terms of direction and such
		while(angleR >= Math.PI * 2) {
			angleR -= Math.PI * 2;
		}
		while(angleR < 0) {
			angleR += Math.PI * 2;
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



