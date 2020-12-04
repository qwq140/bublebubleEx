package bubblebubble;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleApp extends JFrame implements Initable{
	
	private BubbleApp bubbleApp = this;
	private static final String TAG = "BubbleApp : ";
	private JLabel laBackground;
	private Player player;
	
	public BubbleApp() {
		init();
		setting();
		batch();
		listener();

		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BubbleApp();
	}

	@Override
	public void init() {
		laBackground = new JLabel(new ImageIcon("image/bg.png"));
		player = new Player();
	}

	@Override
	public void setting() {
		setTitle("버블버블");
		setSize(1000, 639);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setContentPane(laBackground);
	}

	@Override
	public void batch() {
		add(player);
	}

	@Override
	public void listener() {
		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.moveRight();
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.moveLeft();
				}else if(e.getKeyCode() == KeyEvent.VK_UP) { 
					player.moveUp();
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.isRight = false;
				}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.isLeft = false;
				}
			}
		});
	}
}
