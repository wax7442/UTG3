/**
 * @author Alex Loff
 * 5/23/24 - Loff - Added an empty constructor that sets coordinate to (0, 0, 0).
 */

package pack;

public class Point3D {
	
//	public static void main(String args[]) {	//Old test, successful -Loff
//		Point3D p1 = new Point3D();
//		Point3D p2 = new Point3D(1, 1, 1);
//		System.out.println(getDistanceBetween(p1, p2));
//	}
	
	private double x;
	private double y;
	private double z;
	
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Point3D() {
		x = 0;
		y = 0;
		x = 0;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getZ() {
		return z;
	}
	
	public void changeCoordinates(double x, double y, double z) {
		this.x += x;
		this.y += y;
		this.z += z;
	}
	public void changeX(double x) {
		this.x += x;
	}
	public void changeY(double y) {
		this.y += y;
	}
	public void changeZ(double z) {
		this.z += z;
	}
	
	public void setCoordinates(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void setZ(double z) {
		this.z = z;
	}
	
	public String toString() {
		return "X: " + x + ", Y: " + y + ", Z: " + z;
	}
	
	/**
	 * Returns the distance between p1 and p2
	 * @return
	 */
	public static double getDistanceBetween(Point3D p1, Point3D p2) {
		return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2) + Math.pow(p1.getZ() - p2.getZ(), 2));
	}
	
}













