package pack;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PointGenerator
{
	private String pointX;
	private String pointY;
	private String pointZ;
	private double x, y, z;
	private int lastIndex;
	private File file;
	private String vertex;
	private ArrayList<Point3D> vertexList;

	private Scanner input;


    public PointGenerator (File impFile) throws FileNotFoundException
    {
      
      file = new File (impFile.getAbsolutePath());
      input = new Scanner (file);
      vertex ="";
      while (input.hasNextLine())
      {
          if(input.nextLine().substring(0,2).equals("v "))
          {
	          vertex = input.nextLine().substring(3);
	          
	          lastIndex = vertex.indexOf(" ");
	          pointX = vertex.substring(0, lastIndex+1);
	          x = Double.valueOf(pointX);
	          vertex = vertex.substring(lastIndex+1);
	          lastIndex = vertex.indexOf(" ");
	          pointY = vertex.substring(0, lastIndex+1);
	          y = Double.valueOf(pointY);
	          vertex = vertex.substring(lastIndex+1);
	          z = Double.valueOf(vertex);
	          vertexList.add(new Point3D (x, y, z));
          }
      }
    }

	public static void main(String[] args) throws FileNotFoundException
	{
	    File myFile = new File ("C:\\Users\\carte\\Documents\\cat.txt");
	    PointGenerator pg = new PointGenerator(myFile);
	    
	    for(Point3D point: pg.vertexList)
	    {
	        System.out.println(point);
	    }
	}
}