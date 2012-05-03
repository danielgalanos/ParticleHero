
public class Particle {
	Vector2d position;
	Vector2d velocity;
	float wavelength;
	int[] rgb;
	public Particle(Vector2d positionIn, Vector2d velocityIn) {
		position = new Vector2d(positionIn);
		velocity = new Vector2d(velocityIn);
		wavelength = 730-(730-400)*Vec2dMath.magnitude(velocity)/400;
		rgb = WavelengthToRGB.convert(wavelength);
	}
	
	public void update(State state, float dt) {
		Vector2d updateVelocity = new Vector2d(velocity);
		Vector2d force = new Vector2d();
		float velocityMagnitude = Vec2dMath.magnitude(velocity);
		
		
		/**************************************** Mousey Things ****************************************/
		if (state.mouseMode == 2) {
			Vector2d difference = Vec2dMath.add(state.mouseHole.position, Vec2dMath.scale(-1, position));
			force = Vec2dMath.add(force,Vec2dMath.scale(1000, Vec2dMath.unit(difference)));
		}
		/***********************************************************************************************/
		
		
		
		/**************************************** Electric Field ****************************************/
		for (int i=0;i<state.eFieldList.length;i++) {
			if (state.eFieldList[i].isInField(position)) {
				//force = Vec2dMath.add(force,Vec2dMath.scale((-1*state.eFieldList[i].strength*(Vec2dMath.magnitude(velocity)*Vec2dMath.magnitude(velocity))),Vec2dMath.unit(velocity)));
				force = Vec2dMath.add(force,Vec2dMath.scale((100*state.eFieldList[i].strength*(Vec2dMath.magnitude(velocity))),Vec2dMath.unit(velocity)));
			}
		}
		/************************************************************************************************/
			
		
		
		/**************************************** Magnetic Field ****************************************/
		Vector2d tempF = new Vector2d();
		for (int i=0;i<state.bFieldList.length;i++) {
			if (state.bFieldList[i].isInField(position)) {
				tempF = Vec2dMath.add(tempF,Vec2dMath.hackedCrossProduct(velocity, state.bFieldList[i].strength));	
			}
		}
		Vector2d tempV = Vec2dMath.scale(velocityMagnitude, Vec2dMath.unit(Vec2dMath.add(velocity, Vec2dMath.scale(dt,tempF))));
		force = Vec2dMath.add(force, Vec2dMath.scale(1f/(dt),Vec2dMath.add(tempV, Vec2dMath.scale(-1,velocity))));
		/************************************************************************************************/
		
		
		
		/**************************************** Drag Field ****************************************/
		for (int i=0;i<state.rFieldList.length;i++) {
			if (state.rFieldList[i].isInField(position)) {
				//force = Vec2dMath.add(force,Vec2dMath.scale((-1*state.rFieldList[i].strength*(Vec2dMath.magnitude(velocity)*Vec2dMath.magnitude(velocity))),Vec2dMath.unit(velocity)));
				force = Vec2dMath.add(force,Vec2dMath.scale((-100*state.rFieldList[i].strength*(Vec2dMath.magnitude(velocity))),Vec2dMath.unit(velocity)));
			}
		}
		/********************************************************************************************/
		
		
		
		/**************************************** Gravity Points ****************************************/
		for (int i=0;i<state.holeList.length;i++) {
			Vector2d difference = Vec2dMath.add(state.holeList[i].position, Vec2dMath.scale(-1, position));
			float distance = Vec2dMath.magnitude(difference);
			if (distance>0)
				force = Vec2dMath.add(force, Vec2dMath.scale((state.holeList[i].strength/(distance)),difference));
		}
		/************************************************************************************************/
		
		
		
		/********************* Updates Velocity / Position / Wavelength / Color *********************/
		updateVelocity = Vec2dMath.add(updateVelocity, Vec2dMath.scale(dt,force));
		velocity = new Vector2d(updateVelocity);
		position = Vec2dMath.add(position, Vec2dMath.scale(dt, updateVelocity));
		
		wavelength = 730-(730-400)*velocityMagnitude/1000;
		rgb = WavelengthToRGB.convert(wavelength);
		/******************************************************************************************/
	}
	
}
