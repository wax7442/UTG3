/* Creates an acceleeration vector to update the vector
*  update 3/23/2024
*  authors Cater Haas, Kyle Slavic
*/
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
   		return new AccVector(forceX+vector.forceX,forceY+vector.forceY,forceZ+vector.forceZ);
	 }
   
}
