import java.awt.Graphics;

public class Rectangle extends Shape {

	public Rectangle(int x, int y, int width, int height, boolean fill) {
		super(x, y, width, height, fill);

	}

	@Override
	public void draw(Graphics g) {
		if(!getFill()) {
		g.drawRect(getX() - getWidth() / 2, getY() - getHeight() / 2 , getWidth(), getHeight());
		
	    }
		else {
		g.fillRect(getX() - getWidth() / 2, getY() - getHeight() / 2 , getWidth(), getHeight());
		
	    }

    }
}