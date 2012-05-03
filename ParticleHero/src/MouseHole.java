
public class MouseHole {
	Vector2d position;
	
	public MouseHole(Vector2d positionIn) {
		position = new Vector2d(positionIn);
		
	}
	
	public void update(Vector2d mousePosition) {
		position = new Vector2d(mousePosition);
	}
	
}

