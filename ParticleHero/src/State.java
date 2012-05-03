
public class State {
	boolean mouseLeftClickDown;
	Vector2d mouseLeftClickDownCoord1;
	Vector2d mouseLeftClickDownCoord2;
	
	int mouseMode;
	char buildMode;
	
	Player player;
	MouseHole mouseHole;
	
	Particle[] ParticleList;
	Hole[] holeList;
	BField[] bFieldList;
	RField[] rFieldList;
	EField[] eFieldList;
	
	
	public State() {
		player = new Player();
		mouseMode = 1;
		mouseHole = new MouseHole(new Vector2d());
		ParticleList = new Particle[0];
		holeList = new Hole[0];
		bFieldList = new BField[0];
		rFieldList = new RField[0];
		eFieldList = new EField[0];
		mouseLeftClickDown = false;
		char buildMode = '-';
		
	}
	
	public void resetNonPlayerAgents() {
		mouseMode = 1;
		ParticleList = new Particle[0];
		holeList = new Hole[0];
		bFieldList = new BField[0];
		rFieldList = new RField[0];
		eFieldList = new EField[0];
	}
	
	public void resetWells() {
		mouseMode = 1;
		holeList = new Hole[0];
		bFieldList = new BField[0];
		rFieldList = new RField[0];
		eFieldList = new EField[0];
	}
	public void resetParticles() {
		ParticleList = new Particle[0];
	}
}
