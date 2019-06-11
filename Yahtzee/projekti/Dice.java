package projekti;

import java.util.Random;

import javafx.scene.image.Image;

public class Dice {
	private Image currentFace = new Image("img/d1.png");
	public int roll() {
		Random generator = new Random(System.currentTimeMillis());
		return generator.nextInt(7);
	}
	public void setFace(int num) {
		switch(num) {
		case 1:
			currentFace = new Image("img/d1.png");
			break;
		case 2:
			currentFace = new Image("img/d2.png");
			break;
		case 3:
			currentFace = new Image("img/d3.png");
			break;
		case 4:
			currentFace = new Image("img/d4.png");
			break;
		case 5:
			currentFace = new Image("img/d5.png");
			break;
		case 6:
			currentFace = new Image("img/d6.png");
			break;
		default:
			break;			
		}
	}
	
	public Image getFace() {
		return currentFace;
	}
}
