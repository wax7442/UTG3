/**
 * @author Simon Braeger
 * @param Used with a valid display.
 *
 */

package pack;

import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;

import java.awt.Color;
import java.awt.Point;
import java.awt.Window;
import java.util.ArrayList;

public class Renderer {
	
	private int width;
	private int height;
	
    public void init(int width, int height) {
        // Initialize OpenGL
        GL.createCapabilities();
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // Set clear color to black
        this.width = width;
        this.height = height;
    }

    public void render(ArrayList<Polygon2D> list, int width, int height) {
    	
    	// Clear the color buffer
		glClear(GL_COLOR_BUFFER_BIT);
		//GL jargon, I'd reckon? - Loff
		glViewport(0, 0, width, height);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(-1, 1, -1, 1, 1, -1);
        glMatrixMode(GL_MODELVIEW);

    	for(Polygon2D polygon:list)
    	{
    		
        	// Draw polygon
        	float red = polygon.getColor().getRed() / 255.0f;
        	float green = polygon.getColor().getGreen() / 255.0f;
        	float blue = polygon.getColor().getBlue() / 255.0f;
        	glColor3f(red, green, blue);

        	//Get Points Array
        	ArrayList<Point> javaPoints = polygon.getPoints();
        	
        	//Draw the Polygon
        	glBegin(GL_POLYGON);
        	for (Point javaPoint : javaPoints) {
            	// Map Java point to OpenGL coordinates
            	float x = (float) javaPoint.getX() / (float) width  ; // Map x-coordinate
            	float y =  1- (float) -javaPoint.getY() / (float) height -2; // Map y-coordinate

            	glVertex2f(x, y);
        	}
        	glEnd();
    	}
    	

    }
}
