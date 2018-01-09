package matrix.gym.com;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PanelPhoto extends JPanel {

	private BufferedImage bi;
	
	
	public BufferedImage getBi() {
		return bi;
	}


	public void setBi(BufferedImage bi) {
		this.bi = bi;
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(bi, 0,0, this.getWidth(), this.getHeight(), null);
		
		
	}
	
}
