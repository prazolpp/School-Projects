

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.*;


public class DrawingCanvas extends JPanel {//is JPanel subclass that Manipulates the shapes array 
	//drawing canvas includes a panel and the toolbar

	private ShapeModel shapeModel; //array of shapes for drawingCanvas
	
	
	/*the method below is a Constructor. It sets the size of the window called DrawingCanvas through Dimension's constructor
	  It also sets border to be etched border, sets background color to be yellow.  Then we create a shapemodel object
	  which is an array of shapes. 
	*
	*
	*
	*/
	public DrawingCanvas(){
		this.setPreferredSize(new Dimension(800,600));
		this.setBorder(BorderFactory.createEtchedBorder());
		this.setBackground(Color.yellow);
		shapeModel = new ShapeModel();//creates a new object of shape model, and it creates a new arraylist to store
										//the shape objects
		}
	
	//In the method below, we draw the components based on the shapes?? Not exactly sure where it is used in the program though. 
	public void paintComponent(Graphics g) {
	
		super.paintComponent(g);
		Iterator<Shape> it = shapeModel.iterator();
		while(it.hasNext()) {
			Shape shape = (Shape)it.next();//it.next() returns object type. So we need to cast 
			shape.draw(g);
		}
	}

	//adds shapes to the shapeModel arraylist, repaints
	public void addShape(Shape newShape) {
		
		shapeModel.addShape(newShape);
		repaint();
	}
	


	//Get pointer of a collection first before you process the collection 
	
	public void clearShapes() {
		
		Iterator it = shapeModel.iterator();
		
		while(it.hasNext()) {
			
			it.next();
			it.remove();
		}
		
		repaint();
	}
	

}
