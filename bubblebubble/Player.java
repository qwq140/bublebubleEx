package bubblebubble;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel{
	
	public Player player = this;
	public final static String TAG = "Player : ";
	
	public ImageIcon icPlayerR, icPlayerL;
	public int x = 55;
	public int y = 535;
	
	public boolean isRight = false;
	public boolean isLeft = false;
	public boolean isUp = false;
	public boolean isDown = false;
	public boolean isAttack = false;
	
	public int floor = 1; // 535, 415, 295, 177

	public Player() {
		icPlayerR = new ImageIcon("image/playerR.png");
		icPlayerL = new ImageIcon("image/playerL.png");
		setIcon(icPlayerR);
		setSize(50, 50);
		setLocation(x, y);
	}

	
	public void moveRight() {
		System.out.println(TAG+"moveRight()");
		
		if(isRight == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					setIcon(icPlayerR);
					isRight = true;
					while(isRight) {
						x++;
						setLocation(x, y); // 내부에 repaint() 존재
						if(y<=415 && (x>=110 && x<=170)&& isUp==false) {
							moveDown();
						} else if (y<=415 &&(x>=780 && x<=860)) {
							moveDown();
						}
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();	
		}
	}
	
	public void moveLeft() {
		System.out.println(TAG+"moveLeft()");
		
		if(isLeft == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					setIcon(icPlayerL);
					isLeft = true;
					while(isLeft) {
						x--;
						setLocation(x, y); // 내부에 repaint() 존재
						if(y<=415 && (x>=110 && x<=170)&& isUp==false) {
							moveDown();
						} else if (y<=415 &&(x>=780 && x<=860)) {
							moveDown();
						}
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();	
		}
	}
	
	public void moveUp() {
		System.out.println(TAG+"moveUp()");
		if(isUp == false) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					isUp = true;
					for (int i = 0; i < 130; i++) {
						y--;
						setLocation(x, y); // 내부에 repaint() 존재
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					isUp=false;
					moveDown();
				}
			}).start();
		}
	}
	
	public void moveDown() {
		System.out.println(TAG+"moveDown()");
		if(isDown == false && y < 536) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					isDown = true;
					while(isDown) {
						y++;
						setLocation(x, y); // 내부에 repaint() 존재
						if (y == 536) {
							y = 536;
							isDown = false;
							floor = 1;
						}
						if (y == 415 && (x<110 || (x>170 && x<780 )|| x>830)) {
							isDown = false;
							floor = 2;
						}
						if (y == 295 && (x<110 || (x>170 && x<780 )|| x>830) ) {
							isDown = false;
							floor = 3;
						}
						if (y == 177 && (x<110 || (x>170 && x<780 )|| x>830)) {
							isDown = false;
							floor = 4;
						}
						try {
							Thread.sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();	
		}
	}
	
	// 구현안함
	public void attack() {
		System.out.println(TAG+"moveUp()");
		if(isAttack== false) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					isAttack=true;
				}
			});
		}
	}
}
