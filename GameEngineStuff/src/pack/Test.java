package pack;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Test { // basic class for testing out the engine. Very basic.

	public static void main(String[] args) {
    	ArrayList<Polygon2D> list = new ArrayList<Polygon2D>();
    	
    	Point[] points1 = {new Point(0,0),new Point(0,500),new Point(250, 750),new Point(500,500), new Point(500,0)};
    	
    	list.add(new Polygon2D(points1, Color.cyan));
    	Point[] points2 = {new Point(200,0),new Point(200,200),new Point(300,200),new Point(300,0)};
    	
    	list.add(new Polygon2D(points2, Color.black));

    	
        Display display = new Display();
        display.init(800,600,"UTG3");
        display.loop(list);
        display.cleanup();
    }

}
