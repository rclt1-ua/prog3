package es.ua.dlsi.prog3.p4.gui;

import java.util.ArrayList;
import java.util.List;

import es.ua.dlsi.prog3.p4.model.Canvas;
import es.ua.dlsi.prog3.p4.model.Circle;
import es.ua.dlsi.prog3.p4.model.Coordinate;
import es.ua.dlsi.prog3.p4.model.Rectangle;
import es.ua.dlsi.prog3.p4.model.Shape2D;
import es.ua.dlsi.prog3.p4.model.Shape2DFactory;

/** 
 * This class is a small program that acts as client code for 
 * es.ua.dlsi.prog3.p4.model.*
 * @author pierre
 * @date 24/10/2022
 **/
public class PaintApp {
	/**
	 * The minimum value for the coordinates of a shape.
	 */
	public static final float MIN_VALOR = -32767.9999f;
	/**
	 * The maximum value for the coordinates of a shape.
	 */
	public static final float MAX_VALOR = 32767.9999f;
	/**
	 * The canvas where the shapes are drawn.
	 */
	private Canvas lienzo;
	/**
	 * The main method of the program.
	 * @param args the command line arguments
	 */
	public void ejecutar() {
		lienzo = new Canvas("Prog 3", 1024.0,768.0);
		List<Circle> circles = new ArrayList<>();
		circles.add(new Circle());
		circles.add(new Circle(new Coordinate(10.0, 20.0), 5.0));
		circles.add(new Circle(new Coordinate(15.0, 25.0), 7.0));
		circles.add(new Circle((Circle)circles.get(2)));
		
		List<Rectangle> rectangles = new ArrayList<>();
		rectangles.add(new Rectangle());
		rectangles.add(new Rectangle(new Coordinate(10.0, 20.0), 0, 5.0, 2.5));
		rectangles.add(new Rectangle(new Coordinate(15.0, 25.0), 0, 7.0, 3.5));
		rectangles.add(new Rectangle((Rectangle)rectangles.get(2)));

		List<Shape2D> shapes = new ArrayList<>();
		Shape2D shape = Shape2DFactory.createShape2D("Circle");
		shape.move(new Coordinate(20.0,30.0));
		shapes.add(shape);
		shape = Shape2DFactory.createShape2D("Rectangle");
		shape.move(new Coordinate(20.0,30.0));
		((Rectangle)shape).rotate(45.0);
		shapes.add(shape);

		for (Shape2D c : circles) 
			lienzo.addShape(c);
		for (Shape2D c : rectangles) 
			lienzo.addShape(c);
		for (Shape2D c : shapes) 
			lienzo.addShape(c);
		
		System.out.println(lienzo.toString());
		System.out.println(circles);
		System.out.println(rectangles);
		System.out.println(shapes);
	}	
	/**
	 * The main method of the program.
	 * @param args the command line arguments
	 */
	public static void main(String args[])  {
		new PaintApp().ejecutar();
	}
}




