package triangle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SierpinskiTriangle {
	public static int SIZE = 1000;

	JFrame frame;
	JPanel panel;
	final int n = 7;

	
	
	@SuppressWarnings("serial")
	public void display() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				paintSierpinskiTriangle(n, 20, 20, 900, (Graphics2D)g);
			}
		};
		panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				panel.repaint();
			}
		});
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setSize(SIZE, SIZE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SierpinskiTriangle triangle = new SierpinskiTriangle();
		triangle.display();
	}

	public static void paintSierpinskiTriangle(int n, int x, int y, int hypo, Graphics2D g) {
		if(n <= 0) return;
		
		g.drawLine(x, y, x+hypo, y);
		g.drawLine(x, y, x, y+hypo);
		g.drawLine(x+hypo, y, x, y+hypo);
		
		paintSierpinskiTriangle(n-1, x, y, hypo/2, g);
		paintSierpinskiTriangle(n-1, x+hypo/2, y, hypo/2, g);
		paintSierpinskiTriangle(n-1, x, y+hypo/2, hypo/2, g);
		
//		if(n == 4) g.setColor(Color.RED);
//		if(n == 3) g.setColor(Color.YELLOW);
//		if(n == 2) g.setColor(Color.GREEN);
//		if(n == 1) g.setColor(Color.MAGENTA);
	}

}
