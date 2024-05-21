public class Physics
{
  static final double GRAVITY = 9.80665;

  static double calcGrav(Polygon3D polygon)
  {
    return polygon.getMass()*GRAVITY;
  
  
}
