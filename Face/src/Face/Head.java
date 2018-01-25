/**
 * 
 */
package Face;

/**
*Assignment: A06 Face
*Class: Head.java
*Programmer: Brandon Robinson
*Date: Mar 23, 2017
*/
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/**
 *paints the circle (head)
 */
@SuppressWarnings("serial")
public class Head extends JPanel {
	
	/**
	 * Color theColor
	 */
	Color theColor=Color.YELLOW;
	/**
	 * int colorCounter
	 */
	private int colorCounter=1;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(theColor);
		g.fillOval(200, 50, 350, 350);

	}
	
	/**
	 * changes the fill color of the circle (head)
	 */
	public void changeColor(){
		Color[] colors = { Color.YELLOW, Color.GREEN, Color.ORANGE, Color.RED };
		theColor =colors[colorCounter];
		if (colorCounter==3){
			colorCounter=0;
		}
		else
		colorCounter++;
	}

}
