package com.bargainbenny.flappybird;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFWvidmode;
import org.lwjgl.opengl.GLContext;

import com.bargainbenny.flappybird.input.Input;

public class Main implements Runnable {
	
	private int width = 1280;
	private int height = 720;
	
	private Thread thread;
	private boolean running = false;
	
	private long window;
	
	public void start()
	{
		running = true;
		thread = new Thread(this, "Game");
		thread.start();
	}
	
	private void init()
	{
		if(glfwInit() != GL_TRUE)
		{
			//TODO Handle it
			return;
		}
		
		glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
		window = glfwCreateWindow(width, height, "Owens Flappy Bird", NULL, NULL);
		
		
		if(window == NULL)
		{
			return;
			//TODO: Handle
		}
		
		ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (GLFWvidmode.width(vidmode) - width ) / 2, (GLFWvidmode.height(vidmode) - height ) / 2);
		
		glfwSetKeyCallback(window, new Input());
		
		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
		GLContext.createFromCurrent();
		
		glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		glEnable(GL_DEPTH_TEST);
		System.out.println("Open GL: " + glGetString(GL_VERSION));
		
		
		
	}
	
	public void run()
	{
		init();
		
		while(running)
		{
			update();
			render();
			
			if(glfwWindowShouldClose(window) == GL_TRUE)
			{
				running = false;
			}
		}
	}
	
	private void update()
	{
		glfwPollEvents();
		
	}
	
	private void render()
	{
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glfwSwapBuffers(window);
	}
	
	public static void main(String[] args) {
		
		new Main().start();
	}

}
