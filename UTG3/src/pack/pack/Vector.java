/* Creates vectors to be applied to the points
*  updated 5/23/2024
*  authors Carter Haas, Kyle Slavic
*/
package pack;

public class Vector
  {
    private double fX,fY,fZ;
    
    public Vector()
    {
      fX = 0;
      fY = 0;
      fZ = 0;
    }

    public Vector(double forceX, double forceY, double forceZ)
    {
      fX = forceX;
      fY = forceY;
      fZ = forceZ;
    }

    //"constructs" a vector based on a scalar with two angles 
    public void angleVec(double scalar, double yaw, double pitch)
    {
	    fX = scalar*Math.cos(pitch)*Math.cos(yaw);
      fY = scalar*Math.sin(pitch);
      fZ = scalar*Math.sin(pitch)*Math.sin(yaw);
    }

    
    public double getForceX()
    {
   	 return fX;
    }
    
    public double getForceY()
    {
    	return fY;
    }
    
    public double getForceZ()
    {
    	return fZ;
    }
    
    public void applyVector(Point3D point)
    {
    	point.changeCoordinates(fX,fY,fZ);
    }

    public Vector resultant(Vector other)
    {
  	double x = this.fX+other.fX;
  	double y = this.fY+other.fY;
    double z = this.fZ+other.fZ;
  	return new Vector (x,y,z);
    }
    
    public Vector applyAccel(AccVector accVector)
   {
  	return new Vector(fX+accVector.getForceX(),fY+accVector.getForceY(),fZ+accVector.getForceZ());
   }

    public String toString()
    {
      return "X: " + fX + ", Y: " + fY + ", Z: " + fZ;
    }

  }