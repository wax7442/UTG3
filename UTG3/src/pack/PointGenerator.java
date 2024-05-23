import java.util.Scanner;
import java.io.File;

private double x;
private double y;
private double z;
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
          
          }
        }
          
