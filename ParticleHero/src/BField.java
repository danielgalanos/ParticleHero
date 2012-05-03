
public class BField {
	float strength;
	Vector2d position;
	Vector2d widthHeight;
	
	public BField(Vector2d positionIn, Vector2d widthHeightIn, float strengthIn) {
		position = new Vector2d(positionIn);
		widthHeight = widthHeightIn;
		strength = strengthIn;
	}
	
	public void update(Agents agents, Vector2d newPosition,float strengthIn) {
		position = newPosition;
		strength = strengthIn;
	}
	
	public boolean isInField(Vector2d coord) {
		
		if ((coord.x>=position.x && coord.x<=position.x+widthHeight.x) || (coord.x<=position.x && coord.x>=position.x+widthHeight.x)) {
			if ((coord.y>=position.y && coord.y<=position.y+widthHeight.y) || (coord.y<=position.y && coord.y>=position.y+widthHeight.y)) {
				return true;
			}
		}
		return false;
	}
	
}
