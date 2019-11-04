

import javax.swing.*;
import java.awt.Graphics;



public abstract class Shape implements Cloneable{
	
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean fill;
	
	public Shape(int x, int y, int width, int height, boolean fill) {
		
		this.x = x;
		this.y = y;
		this.width  = width;
		this.height = height;
		this.fill = fill;
	}
	
	public int getX() {
		return x;
	}

	/*public void setX(int x) {
		this.x = x;
	}*/

	public int getY() {
		return y;
	}

	/*public void setY(int y) {
		this.y = y;
	}
*/
	public int getWidth() {
		return width;
	}

	/*public void setWidth(int width) {
		this.width = width;
	} */

	public int getHeight() {
		return height;
	}

	/*public void setHeight(int height) {
		this.height = height;
	}
	*/
	
	public boolean getFill() {
		return fill;
	}
	
	public void setCenter(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		
	}
	
	public abstract void draw(Graphics g);
	//public abstract void fill(Graphics g);
	
	public Object clone() {
		
		try {
			
			return super.clone();
			
		}
		catch(CloneNotSupportedException e) {
			
			return null;
		}
		
	}
	

}
