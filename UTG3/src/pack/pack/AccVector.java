/* Creates an acceleeration vector to update the vector
*  update 3/23/2024
*  authors Cater Haas, Kyle Slavic
*/
package pack;

public class AccVector extends Vector
{
	public AccVector()
	{
		super();
	}
	public AccVector(double forceX, double forceY, double forceZ)
	{
   		super(forceX,forceY,forceZ);
	}
   
	public AccVector resultant(AccVector vector)
	{
   		return new AccVector(getForceX()+vector.getForceX(),getForceY()+vector.getForceY(),getForceZ()+vector.getForceZ());
	}
   
}
