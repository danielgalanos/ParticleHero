import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
	

public class Player {
	boolean waitingForLeftMouseClickRelease = false;
	
	int width;
	int height;

	Vector2d position;
	Vector2d velocity;
	
	public Player(Vector2d positionIn, Vector2d velocityIn) {
		position = positionIn;
		velocity = velocityIn;
		width = 10;
		height = 10;

	}
	public Player() {
		position = new Vector2d();
		velocity = new Vector2d();
		width = 10;
		height = 10;

	}
	
	public void update(GameContainer container, Agents agents, float dt) {
		//position = Vec2dMath.add(position, Vec2dMath.scale(dt, velocity));
		
		
		if(container.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
			if (agents.mouseLeftClickDown == false) {
				agents.mouseLeftClickDown = true;
				agents.mouseLeftClickDownCoord1 = new Vector2d(container.getInput().getAbsoluteMouseX(), container.getInput().getAbsoluteMouseY());
			}
			agents.mouseLeftClickDownCoord2 = new Vector2d(container.getInput().getAbsoluteMouseX(), container.getInput().getAbsoluteMouseY());	
		}
		else {
			if (agents.mouseLeftClickDown == true) {
				agents.mouseLeftClickDown = false;
				if (agents.buildMode=='b')
					agents.bFieldList = ArrayOperations.append(agents.bFieldList,new BField(agents.mouseLeftClickDownCoord1,Vec2dMath.add(agents.mouseLeftClickDownCoord2,
							Vec2dMath.scale(-1, agents.mouseLeftClickDownCoord1)),5f));
				else if (agents.buildMode=='r')
					agents.rFieldList = ArrayOperations.append(agents.rFieldList,new RField(agents.mouseLeftClickDownCoord1,Vec2dMath.add(agents.mouseLeftClickDownCoord2,
							Vec2dMath.scale(-1, agents.mouseLeftClickDownCoord1)),.005f));
				else if (agents.buildMode=='e')
					agents.eFieldList = ArrayOperations.append(agents.eFieldList,new EField(agents.mouseLeftClickDownCoord1,Vec2dMath.add(agents.mouseLeftClickDownCoord2,
							Vec2dMath.scale(-1, agents.mouseLeftClickDownCoord1)),.005f));
			}
		}
		if(container.getInput().isKeyPressed(Input.KEY_1)) {
			agents.mouseMode=1;
		}
		
		if(container.getInput().isKeyPressed(Input.KEY_2)) {
			agents.mouseMode=2;
		}
		
		
		
		
		if(container.getInput().isKeyDown(Input.KEY_W)) {
			position.y -= 100 * dt;
		}
		if(container.getInput().isKeyDown(Input.KEY_S)) {
			position.y += 100 * dt;
		}
		if(container.getInput().isKeyDown(Input.KEY_A)) {
			position.x -= 100 * dt;
		}
		if(container.getInput().isKeyDown(Input.KEY_D)) {
			position.x += 100 * dt;
		}
		
		
		if(container.getInput().isKeyPressed(Input.KEY_G)) {
			agents.holeList = ArrayOperations.append(agents.holeList,new Hole(new Vector2d(position),new Vector2d(),1000));
		}
		if(container.getInput().isKeyPressed(Input.KEY_B)) {
			agents.buildMode = 'b';
		}
		if(container.getInput().isKeyPressed(Input.KEY_R)) {
			agents.buildMode = 'r';
		}
		if(container.getInput().isKeyPressed(Input.KEY_E)) {
			agents.buildMode = 'e';
		}
		if(container.getInput().isKeyPressed(Input.KEY_C)) {
			agents.resetNonPlayerAgents();
		}
		if(container.getInput().isKeyPressed(Input.KEY_X)) {
			agents.resetWells();
		}
		if(container.getInput().isKeyPressed(Input.KEY_Z)) {
			agents.resetParticles();
		}
		
		
		if(container.getInput().isKeyDown(Input.KEY_SPACE)) {
			Vector2d mousePos = new Vector2d(container.getInput().getAbsoluteMouseX(), container.getInput().getAbsoluteMouseY());
			Vector2d velocityCalc = Vec2dMath.scale(100,Vec2dMath.unit(Vec2dMath.add(mousePos, Vec2dMath.scale(-1, position))));
			agents.ParticleList = ArrayOperations.append(agents.ParticleList, new Particle(new Vector2d(position),velocityCalc));
			agents.ParticleList = ArrayOperations.append(agents.ParticleList, new Particle(new Vector2d(position),Vec2dMath.rotate(velocityCalc, (float)Math.PI/6f)));
			agents.ParticleList = ArrayOperations.append(agents.ParticleList, new Particle(new Vector2d(position),Vec2dMath.rotate(velocityCalc, (float)-Math.PI/6f)));
			agents.ParticleList = ArrayOperations.append(agents.ParticleList, new Particle(new Vector2d(position),Vec2dMath.rotate(velocityCalc, (float)Math.PI/3f)));
			agents.ParticleList = ArrayOperations.append(agents.ParticleList, new Particle(new Vector2d(position),Vec2dMath.rotate(velocityCalc, (float)-Math.PI/3f)));
			
		}
		
		/*
		if(container.getInput().isKeyPressed(Input.KEY_SPACE)) {
			Vector2d mousePos = new Vector2d(container.getInput().getAbsoluteMouseX(), container.getInput().getAbsoluteMouseY());
			Vector2d velocityCalc = Vec2dMath.scale(100,Vec2dMath.unit(Vec2dMath.add(mousePos, Vec2dMath.scale(-1, position))));
			
			
			agents.ParticleList = ArrayOperations.append(agents.ParticleList, new Particle(new Vector2d(position),velocityCalc));
		}*/

	}
	
}
