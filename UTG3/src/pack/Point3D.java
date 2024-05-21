package pack;

public class Point3D {
	private double x;
	private double y;
	private double z;
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
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
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public void changeX(double x) {
		this.x+=x;
	}
	public void changeY(double y) {
		this.y+=y;
	}
	public void changeZ(double z) {
		this.z+=z;
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
}
