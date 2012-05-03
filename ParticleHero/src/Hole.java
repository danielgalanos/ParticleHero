
public class Hole {
	Vector2d position;
	Vector2d velocity;
	float strength;
	
	public Hole(Vector2d positionIn, Vector2d velocityIn,float strengthIn) {
		position = new Vector2d(positionIn);
		velocity = new Vector2d(velocityIn);
		strength = strengthIn;
	}
	
	public void update(State state, float dt) {

		position = Vec2dMath.add(position, Vec2dMath.scale(dt, velocity));
	}
	
}

