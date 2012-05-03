
public class Vec2dMath {

	public static Vector2d scale(float scaler, Vector2d vec) {
		return new Vector2d(scaler*vec.x,scaler*vec.y);
	}
	public static Vector2d add(Vector2d a, Vector2d b) {
		return new Vector2d(a.x+b.x,a.y+b.y);
	}
	public static Vector2d multiply(Vector2d a, Vector2d b) {
		return new Vector2d(a.x*b.x,a.y*b.y);
	}
	public static float dot(Vector2d a, Vector2d b) {
		return a.x*b.x+a.y*b.y;
	}
	public static Vector2d hackedCrossProduct(Vector2d a, float z) {
		return new Vector2d(a.y*z,-a.x*z);
	}
	public static float magnitude(Vector2d a) {
		return (float)Math.sqrt(dot(a,a));
	}
	public static Vector2d unit(Vector2d a) {
		if (a.x==0&&a.y==0) {
			return a;
		}
		else {
			return scale(1/magnitude(a),a);
		}
		
	}
	public static Vector2d rotate(Vector2d a, float angle) {
		
		return new Vector2d((float)(a.x*Math.cos(angle)-a.y*Math.sin(angle)),(float)(a.x*Math.sin(angle)+a.y*Math.cos(angle)));
		
	}
}
