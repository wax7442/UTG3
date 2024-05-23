/* Gives a general outline of how vectors can interact
*  update 5/23/2024
*  authors Carter Haas, Kyle Slavik
*/
public abstract class Physics
{
  static final double GRAVITY = 9.80665;
  static final AccVector GVECTOR = new AccVector (0,0,GRAVITY*-1);
  
  public Vector applyAccel(Vector vector,AccVector accVector)
  {
  	return new Vector(vector.getForceX+accVector.getForceX,vector.getForceY+accVector.getForceY,vector.getForceZ+accVector.getForceZ);
  }
}
