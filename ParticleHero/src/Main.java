import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import java.util.Random;

public class Main {

	
	public static void main(String[] args) {
		Random randy = new Random();
		int height = 1000;
		int width = 1201;
		//int height = 1080;
		//int width = 1920;
		
		try {
			AppGameContainer app = new AppGameContainer(new Environment(height, width));
			app.setDisplayMode(width, height, false);
			app.setVSync(true);
			app.setSmoothDeltas(true);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
		
		/*testing
		Vector2d[] a = new Vector2d[5000];
		float[][] b = new float[5000][2];
		for (int i = 0;i<5000;i++) {
			float x = randy.nextFloat();
			float y = randy.nextFloat();
			a[i] = new Vector2d(x,y);
			b[i][0] = x;
			b[i][1] = y;
		}
		
		
		long timeStart = System.currentTimeMillis();
		for (int i = 0;i<5000000;i++) {
			for (int j = 0;j<5000;j++) {
				float mag1 = Vec2dMath.floatMag(b[j]);
				float mag2 = Vec2dMath.magnitude(a[j]);
				if (mag1!=mag2) {
					System.out.println(mag1-mag2);
				}
			}
		}
		System.out.println(System.currentTimeMillis()-timeStart);*/
		
	}
}