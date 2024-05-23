import java.util.Scanner;
import java.io.File;

private String pointX, pointY, pointZ;
private double x, y, z;
private int lastIndex;
private File file;
private String vertex;
private ArrayList <Point3D> vertexList;

private Scanner input;

public class PointGenerator
  {
    public PointGenerator (File impFile)
    {
      
      file = new File (impFile.getAbsolutePath());
      input = new Scanner (file);
      vertex ="";
      while (input.hasNextLine())
        {
          if(input.nextLine().substringOf(0,2).equals("v "))
          {
            vertex = input.nextLine().substringOf(3);
              
            lastIndex = vertex.indexOf(" ");
            pointX = vertex.substringOf("0, lastIndex+1);
            x = Double.valueOf(pointX);
            vertex = vertex.substringOf(lastIndex+1);
            lastIndex = vertex.indexOf(" ");
            pointY = vertex.substringOf("0, lastIndex+1);
            y = Double.valueOf(pointY);
            vertex = vertex.substringOf(lastIndex+1);
            pointZ = Double.valueOf(vertex);
            vertexList.add(new Point3D (x, y, z);
          }
        }
    }
  }
//No IDEA if this works even close to how I want it to, but I'm about done for the day...
