/**
 * @author Simon Braeger
 * @param Size of Screen (Width, Height)
 * @param Title of Screen
 */

package pack;

import java.awt.Color;
import java.awt.Point;
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

    public void loop(ArrayList<Polygon2D> list) {
    	
        Renderer renderer = new Renderer();
        int[] width = new int[1];
        int[] height = new int[1];
        GLFW.glfwGetWindowSize(window, width, height);
        renderer.init(width[0],height[0]);

        // Main loop
        while (!GLFW.glfwWindowShouldClose(window)) {
            // Render
            GLFW.glfwGetWindowSize(window, width, height);
            renderer.render(list,width[0],height[0]);

            // Swap buffers
            GLFW.glfwSwapBuffers(window);

            // Poll for window events
            GLFW.glfwPollEvents();
        }
    }

    public void cleanup() {
        // Terminate GLFW
        GLFW.glfwTerminate();
    }
    
}
