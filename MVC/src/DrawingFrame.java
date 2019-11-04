


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawingFrame extends JFrame{  //class extends JFrame 
   
	private CanvasEditor canvasEditor;    //declaration of CanvasEditor object
    private DrawingCanvas drawingCanvas;  //declaration of drawingCanvas object
    private JTextField statusTextField;//declaration of StatusField object
    private boolean fill;

    public DrawingFrame(){              //constructor
        
    	this.setTitle("Drawing Application"); //sets title of the JFrame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //adds exit function

        drawingCanvas = new DrawingCanvas();  //instantiates the drawingCanvas object  
        JPanel toolStatusPanel = getToolStatusPanel(); //creates toolStatusPanel object

        this.add(drawingCanvas, BorderLayout.CENTER); //adds drawingCanvas and puts it at center of the screen
        this.add(toolStatusPanel, BorderLayout.SOUTH);//adds toolStatusPanel and puts it at the bottom

    }

    private JPanel getToolStatusPanel() { //gets toolstatuspanel 
      
    	JPanel toolBarPanel = new JPanel(); //creates an object of and instatiates JPanel: toolbarpanel 

        JPanel radioPanel = new JPanel();   //creates panel for radiobuttons 
        JRadioButton emptyButton = new JRadioButton("Empty", true); //empty button to create unfilled object
        JRadioButton filledButton = new JRadioButton("Filled", false); //filled button to fill up the shapes

        //To make the buttons toggle buttongroup, when one button is pressed, unpresses another button
        ButtonGroup bg = new ButtonGroup(); 
        bg.add(emptyButton);
        bg.add(filledButton);
        
  
      emptyButton.addActionListener(new ActionListener() {
       	
        	public void actionPerformed(ActionEvent e) {
        		
        		fill = false;
        		System.out.println("Empty");	
        		
        		
        		
        	}
        	
        });
        
        filledButton.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		fill = true;
        		System.out.println("filled");
        	}
        	
        	
        });
        
        
        //Add the two radioButton to the panel
        radioPanel.add(emptyButton);
        radioPanel.add(filledButton);

        Dimension buttonSize = new Dimension(100,40); //dimension size object for buttons
        JButton ellipseButton = new JButton("Ellipse"); //creates ellipse button 
        ellipseButton.setPreferredSize(buttonSize); //sets size of the button

        JButton circleButton = new JButton("Circle");  //similar to ellipse button
        circleButton.setPreferredSize(buttonSize);

        JButton rectButton = new JButton("Rectangle");
        rectButton.setPreferredSize(buttonSize);

        JButton squareButton = new JButton("Square");
        squareButton.setPreferredSize(buttonSize);

        JButton clearButton = new JButton("Clear");
        clearButton.setPreferredSize(buttonSize);

        toolBarPanel.add(ellipseButton); //adds the buttons 
        toolBarPanel.add(circleButton);
        toolBarPanel.add(rectButton);
        toolBarPanel.add(squareButton);
        toolBarPanel.add(clearButton);

        JPanel toolStatusPanel = new JPanel();
        toolStatusPanel.setLayout(new BorderLayout()); //sets border layout of the toolstatuspanel 

        statusTextField = new JTextField(30); //creates textfield and sets the size
        statusTextField.setPreferredSize(new Dimension(40,30));

        toolStatusPanel.add(radioPanel, BorderLayout.NORTH);  //creates border layouts for the panels
        toolStatusPanel.add(toolBarPanel, BorderLayout.CENTER);
        toolStatusPanel.add(statusTextField, BorderLayout.SOUTH);

        canvasEditor = new CanvasEditor(new Ellipse(0,0,100,60,fill), statusTextField); //creates canvaseditor and instantiates it

        
      
        //adds actionlistener to the buttons through anonymous classes 
        //Local process and can also be done with lambda expression 
        ellipseButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                canvasEditor.setCurrentShape(new Ellipse(0,0,100,60,fill), new JTextField("Ellipse"));
                statusTextField.setText("Ellipse Selected.");
              
            }
        });

        circleButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
           
                canvasEditor.setCurrentShape(new Circle(0,0,60,60,fill), new JTextField("Circle"));
             
                statusTextField.setText("Circle Selected.");
               
            }
        });

        rectButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
     
                canvasEditor.setCurrentShape(new Rectangle(0,0,100,60,fill), new JTextField("Rectangle"));
               
                statusTextField.setText("Rectangle Selected.");
                
            
            }
        });

        squareButton.addActionListener(new ActionListener(){
        		
        	public void actionPerformed(ActionEvent e){
                canvasEditor.setCurrentShape(new Square(0,0,60,60,fill), new JTextField("Square"));
                statusTextField.setText("Square Selected.");
                
   
            }
        });

        
        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //locate the collection location
                //check the objects currently in this class
                //use the object to get into the collection
                //need to remove shape
                drawingCanvas.clearShapes();
            }
        });

        //Mouselistener function is added to the canvasEditor
        
        drawingCanvas.addMouseListener(canvasEditor);

        //returns the toolStatusPanel object
        return toolStatusPanel;
    }

	
}