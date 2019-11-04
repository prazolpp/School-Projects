
import java.awt.event.*;

import javax.swing.JTextField;
public class CanvasEditor implements MouseListener { //this class alters the shapes in the canvas and also changes the
	                                                 //status texts

	private Shape currentShape;  // instance of the shape
	private JTextField statusText; //textfield related to the shape
	
	public CanvasEditor(Shape initialShape) { //shape constructor
		
		this.currentShape = initialShape;
		
		
	}
	
	public CanvasEditor(Shape initialShape,JTextField textfield) { //shape and textfield constructor
		
		this.currentShape = initialShape;
		this.statusText = textfield;
		
	}
	
	
	
	public void setCurrentShape(Shape currentShape, JTextField textfield ) {  //sets the shape to mentioned shape
		
		this.currentShape = currentShape;
		this.statusText = textfield;
	}
	
	
	public void mouseClicked(MouseEvent e) { //function to act when mouse is clicked
		
		Shape newShape = (Shape)currentShape.clone(); //Creates new shape based on the shape constructed and cloned 
		newShape.setCenter(e.getX(), e.getY()); //sets the shape to center around the mouse clicked region 
		DrawingCanvas drawingCanvas = (DrawingCanvas)e.getSource(); //creates a drawingCanvas after mouse(clicked)event occurs
		drawingCanvas.addShape(newShape); //adds the related shape to drawingCanvas
		
    }
	
	
	public void mouseReleased(MouseEvent e) {};
	public void mouseEntered(MouseEvent e) {};
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	};
	
	
	
}
