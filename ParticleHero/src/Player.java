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
		width = 10; //not currently in use
		height = 10; //not currently in use

	}
	public Player() {
		position = new Vector2d();
		velocity = new Vector2d();
		width = 10;
		height = 10;

	}
	
	public void update(GameContainer container, State state, float dt) {

		
		
		/***************************************** Movement Keys ********************************************/
		if(container.getInput().isKeyDown(Input.KEY_W) || container.getInput().isKeyDown(Input.KEY_UP)) {
			position.y -= 100 * dt;
		}
		if(container.getInput().isKeyDown(Input.KEY_S) || container.getInput().isKeyDown(Input.KEY_DOWN)) {
			position.y += 100 * dt;
		}
		if(container.getInput().isKeyDown(Input.KEY_A) || container.getInput().isKeyDown(Input.KEY_LEFT)) {
			position.x -= 100 * dt;
		}
		if(container.getInput().isKeyDown(Input.KEY_D) || container.getInput().isKeyDown(Input.KEY_RIGHT)) {
			position.x += 100 * dt;
		}
		/****************************************************************************************************/
		
		
		
		/**************************************** Left Click On Mouse ***************************************/
		if(container.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
			if (state.mouseLeftClickDown == false) {
				state.mouseLeftClickDown = true;
				state.mouseLeftClickDownCoord1 = new Vector2d(container.getInput().getAbsoluteMouseX(), container.getInput().getAbsoluteMouseY());
			}
			state.mouseLeftClickDownCoord2 = new Vector2d(container.getInput().getAbsoluteMouseX(), container.getInput().getAbsoluteMouseY());	
		}
		else {
			if (state.mouseLeftClickDown == true) {
				state.mouseLeftClickDown = false;
				if (state.buildMode=='b')
					state.bFieldList = ArrayOperations.append(state.bFieldList,new BField(state.mouseLeftClickDownCoord1,Vec2dMath.add(state.mouseLeftClickDownCoord2,
							Vec2dMath.scale(-1, state.mouseLeftClickDownCoord1)),5f));
				else if (state.buildMode=='r')
					state.rFieldList = ArrayOperations.append(state.rFieldList,new RField(state.mouseLeftClickDownCoord1,Vec2dMath.add(state.mouseLeftClickDownCoord2,
							Vec2dMath.scale(-1, state.mouseLeftClickDownCoord1)),.005f));
				else if (state.buildMode=='e')
					state.eFieldList = ArrayOperations.append(state.eFieldList,new EField(state.mouseLeftClickDownCoord1,Vec2dMath.add(state.mouseLeftClickDownCoord2,
							Vec2dMath.scale(-1, state.mouseLeftClickDownCoord1)),.005f));
			}
		}
		/****************************************************************************************************/
		
		
		
		/**************************************** Mouse Mode Keys *******************************************/
		if(container.getInput().isKeyPressed(Input.KEY_1)) {
			state.mouseMode=1;
		}
		
		if(container.getInput().isKeyPressed(Input.KEY_2)) {
			state.mouseMode=2;
		}
		/****************************************************************************************************/
		
		
		
		/**************************************** Build Mode Keys *******************************************/
		if(container.getInput().isKeyPressed(Input.KEY_B)) {
			state.buildMode = 'b';
		}
		if(container.getInput().isKeyPressed(Input.KEY_R)) {
			state.buildMode = 'r';
		}
		if(container.getInput().isKeyPressed(Input.KEY_E)) {
			state.buildMode = 'e';
		}
		/****************************************************************************************************/
		
		
		
		/********************************** Soon To Be Build Mode Keys **************************************/
		if(container.getInput().isKeyPressed(Input.KEY_G)) {
			state.holeList = ArrayOperations.append(state.holeList,new Hole(new Vector2d(position),new Vector2d(),1000));
		}
		/****************************************************************************************************/

		
		
		/**************************************** Clear Stuff Keys ******************************************/
		if(container.getInput().isKeyPressed(Input.KEY_C)) {
			state.resetNonPlayerAgents();
		}
		if(container.getInput().isKeyPressed(Input.KEY_X)) {
			state.resetWells();
		}
		if(container.getInput().isKeyPressed(Input.KEY_Z)) {
			state.resetParticles();
		}
		/****************************************************************************************************/
		
		
		
		/**************************************** Shoot Stuff Key ********************************************/
		if(container.getInput().isKeyDown(Input.KEY_SPACE)) {
			Vector2d mousePos = new Vector2d(container.getInput().getAbsoluteMouseX(), container.getInput().getAbsoluteMouseY());
			Vector2d velocityCalc = Vec2dMath.scale(100,Vec2dMath.unit(Vec2dMath.add(mousePos, Vec2dMath.scale(-1, position))));
			state.ParticleList = ArrayOperations.append(state.ParticleList, new Particle(new Vector2d(position),velocityCalc));
			/* EXTRA PEW PEW
			state.ParticleList = ArrayOperations.append(state.ParticleList, new Particle(new Vector2d(position),Vec2dMath.rotate(velocityCalc, (float)Math.PI/6f)));
			state.ParticleList = ArrayOperations.append(state.ParticleList, new Particle(new Vector2d(position),Vec2dMath.rotate(velocityCalc, (float)-Math.PI/6f)));
			state.ParticleList = ArrayOperations.append(state.ParticleList, new Particle(new Vector2d(position),Vec2dMath.rotate(velocityCalc, (float)Math.PI/3f)));
			state.ParticleList = ArrayOperations.append(state.ParticleList, new Particle(new Vector2d(position),Vec2dMath.rotate(velocityCalc, (float)-Math.PI/3f)));
			*/		
		}
		/****************************************************************************************************/


	}
	
}
