/**
 * @author Simon Braeger
 * @param Size of Screen (Width, Height)
 * @param Title of Screen
 * 5/23/24, 5:26 - Loff - Made into thread and added call to cleanUp() at the end of Loop method
 */

package pack;

import java.util.ArrayList;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;

public class Display {
    private long window;

    public void init(int x, int y, String name) {
        // Initialize GLFW
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Configure GLFW
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);
       
        // Create the window
        window = GLFW.glfwCreateWindow(x, y, name, 0, 0);
        if (window == 0) {
            throw new IllegalStateException("Failed to create the GLFW window");
        }

        // Center the window
        GLFWVidMode vidMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(window, (vidMode.width() - 800) / 2, (vidMode.height() - 600) / 2);

        // Make the OpenGL context current
        GLFW.glfwMakeContextCurrent(window);
        GLFW.glfwShowWindow(window);
    }

    public void loop(Scene scene) throws InterruptedException {
    	ArrayList<Polygon2D> list = scene.getActiveCamera().getImage(scene);
        Renderer renderer = new Renderer();
        int[] width = new int[1];
        int[] height = new int[1];
        GLFW.glfwGetWindowSize(window, width, height);
        System.out.println("Renderer window size: " + width[0] + ", " + height[0]);
        renderer.init(width[0],height[0]);
        
        // Main loop
        while (!GLFW.glfwWindowShouldClose(window)) {
        	
        	//Next 3 lines are for testing purposes
        	list = scene.getActiveCamera().getImage(scene);
        	scene.getActiveCamera().turnLeftRight(Math.PI*2 / 365);
        	Thread.sleep(20);
        	
            // Render
            GLFW.glfwGetWindowSize(window, width, height);
            renderer.render(list,width[0],height[0]);

            // Swap buffers
            GLFW.glfwSwapBuffers(window);

            // Poll for window events
            GLFW.glfwPollEvents();
        }
        this.cleanup();	//I moved this line here from Test, it should be here I reckon - Loff
    }

    public void cleanup() {
        // Terminate GLFW
        GLFW.glfwTerminate();
    }
}
