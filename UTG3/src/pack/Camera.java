package pack;

import java.util.ArrayList;

public class Camera extends Point3D {
	
	public ArrayList<Polygon2D> render(Scene scene) {
		
		
		return null;
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





