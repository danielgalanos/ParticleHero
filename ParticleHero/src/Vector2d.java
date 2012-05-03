
public class Vector2d {
	float x;
	float y;
	
	public Vector2d(float xIn, float yIn) {
		x = xIn;
		y = yIn;
	}
	public Vector2d() {
		x = 0;
		y = 0;
	}
	public Vector2d(Vector2d vec) {
		x = vec.x;
		y = vec.y;
	}
}
