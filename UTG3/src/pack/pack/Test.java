/**
 * @author Simon Braeger
 * 5/23/5:29 - Loff - changed a bunch of stuff, including creating and filling a Scene.
 */

package pack;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Test { // basic class for testing out the engine. Very basic.

	public static void main(String[] args) throws InterruptedException {
//    	ArrayList<Polygon2D> image = new ArrayList<Polygon2D>();
//    	
//    	Point[] points1 = {new Point(0,0),new Point(0,500),new Point(250, 750),new Point(500,500), new Point(500,0)};
//    	
//    	image.add(new Polygon2D(points1, Color.cyan));
//    	Point[] points2 = {new Point(200,0),new Point(200,200),new Point(300,200),new Point(300,0)};
//    	
//    	image.add(new Polygon2D(points2, Color.black));
		
    	Scene scene = new Scene(new Camera(new Point3D(), Math.PI/4, 0, 0));
    	scene.add(
    		new Mesh(
    			new Polygon3D[] {
    				new Polygon3D(new Point3D[] {new Point3D(300, 200, 200), new Point3D(300, 400, 200), new Point3D(600, 400, 200), new Point3D(600, 200, 200)}, Color.red), 
    				new Polygon3D(new Point3D[] {new Point3D(300, 200, 200), new Point3D(300, 400, 200), new Point3D(300, 400, 500), new Point3D(300, 200, 500)}, Color.orange), 
//    				new Polygon3D(new Point3D[] {new Point3D(600, 400, 200), new Point3D(600, 200, 200), new Point3D(600, 200, 500), new Point3D(600, 400, 500)}, Color.white), 
    				new Polygon3D(new Point3D[] {new Point3D(300, 200, 200), new Point3D(600, 200, 200), new Point3D(600, 200, 500), new Point3D(300, 200, 500)}, Color.pink), 
//    				new Polygon3D(new Point3D[] {new Point3D(300, 400, 200), new Point3D(600, 400, 200), new Point3D(600, 400, 500), new Point3D(300, 400, 500)}, Color.yellow), 
//    				new Polygon3D(new Point3D[] {new Point3D(300, 400, 500), new Point3D(300, 200, 500), new Point3D(600, 200, 500), new Point3D(600, 400, 500)}, Color.green)
    					/**new Polygon3D(new Point3D[] {
    								    // Front face of the house
    								    new Point3D(100, 100, 100), new Point3D(100, 300, 100), new Point3D(300, 300, 100), new Point3D(300, 100, 100)
    								}, Color.gray),
    								new Polygon3D(new Point3D[] {
    								    // Left face of the house
    								    new Point3D(100, 100, 100), new Point3D(100, 100, 300), new Point3D(100, 300, 300), new Point3D(100, 300, 100)
    								}, Color.blue),
    								new Polygon3D(new Point3D[] {
    								    // Right face of the house
    								    new Point3D(300, 100, 100), new Point3D(300, 300, 100), new Point3D(300, 300, 300), new Point3D(300, 100, 300)
    								}, Color.blue),
    								new Polygon3D(new Point3D[] {
    								    // Back face of the house
    								    new Point3D(100, 100, 300), new Point3D(300, 100, 300), new Point3D(300, 300, 300), new Point3D(100, 300, 300)
    								}, Color.gray),
    								new Polygon3D(new Point3D[] {
    								    // Bottom face of the house
    								    new Point3D(100, 100, 100), new Point3D(300, 100, 100), new Point3D(300, 100, 300), new Point3D(100, 100, 300)
    								}, Color.cyan),
    								new Polygon3D(new Point3D[] {
    								    // Top face of the house
    								    new Point3D(100, 300, 100), new Point3D(300, 300, 100), new Point3D(300, 300, 300), new Point3D(100, 300, 300)
    								}, Color.cyan),

    								// Roof of the house (pyramid)
    								new Polygon3D(new Point3D[] {
    								    // Front-left roof
    								    new Point3D(100, 100, 300), new Point3D(300, 100, 300), new Point3D(200, 200, 400)
    								}, Color.pink),
    								new Polygon3D(new Point3D[] {
    								    // Back-left roof
    								    new Point3D(100, 100, 300), new Point3D(100, 300, 300), new Point3D(200, 200, 400)
    								}, Color.orange),
    								new Polygon3D(new Point3D[] {
    								    // Front-right roof
    								    new Point3D(300, 100, 300), new Point3D(300, 300, 300), new Point3D(200, 200, 400)
    								}, Color.pink),
    								new Polygon3D(new Point3D[] {
    								    // Back-right roof
    								    new Point3D(100, 300, 300), new Point3D(300, 300, 300), new Point3D(200, 200, 400)
    								}, Color.orange),

    								// Door of the house (rectangle)
    								new Polygon3D(new Point3D[] {
    								    // Door on the front face
    								    new Point3D(180, 100, 100), new Point3D(220, 100, 100), new Point3D(220, 100, 200), new Point3D(180, 100, 200)
    								}, Color.magenta) */


    			}
    		)
    	);
    	
		ArrayList<Polygon2D> image = scene.getActiveCamera().getImage(scene);
		System.out.println(image.get(0));
		
//		scene.getActiveCamera().printSpaceAhead();
		
		Display display = new Display();
		display.init(800, 600, "UTG3");	//Why don't we put the code of this method in the constructor? -Loff
		display.loop(scene);
    }

}
