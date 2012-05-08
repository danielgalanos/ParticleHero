import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Image;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.AppGameContainer;

public class Environment extends BasicGame {
	String mymessage = "HIU";
	int counter = 0;
	
	int height;
	int width;
	State state;
	Image ParticleImg;
	Image holeImg;
	Image playerImg;
	
	
	
	
	public Environment(int heightIn, int widthIn) {
		super("Environment");
		height = heightIn;
		width = widthIn;
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		container.setTargetFrameRate(60);
		ParticleImg = new Image("./Sprites/BlueBall4x4.gif");
		playerImg = new Image("./Sprites/Player.gif");
		holeImg = new Image("./Sprites/Hole.gif");
		state = new State();
	
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		float dt = delta/1000.0f;
		
		
		
		/******************************************* Player Update ******************************************/
		state.player.update(container, state, dt);
		/****************************************************************************************************/
		
		
		
		/****************************************** Mousey Updates ******************************************/
		if (state.mouseMode==1) {
			//maybe stuff one day
		}
		else if (state.mouseMode==2) {
			state.mouseHole.update(new Vector2d(container.getInput().getAbsoluteMouseX(), container.getInput().getAbsoluteMouseY()));
		}
		/****************************************************************************************************/
		
		
		
		/***************************************** Particle Update *******&**********************************/
		for (int i=0;i<state.ParticleList.length;i++) {
			if (state.ParticleList[i].position.x < -width*2 || state.ParticleList[i].position.y < -height*2 || state.ParticleList[i].position.x > width*3 || state.ParticleList[i].position.y > height*3){
				state.ParticleList = ArrayOperations.removeElement(state.ParticleList, i);
			}
			else {
				state.ParticleList[i].update(state,dt);
			}
		}
		/****************************************************************************************************/
		
		
		if (counter%60==0) {
			//System.out.println(state.ParticleList.length);
		}
		counter++;
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		//g.drawString(mymessage, 0, 100);
		
		/******************************************* Draw Player ********************************************/
		g.drawImage(playerImg,state.player.position.x-playerImg.getWidth()/2, state.player.position.y-playerImg.getHeight()/2);
		/****************************************************************************************************/
		
		
		
		/**************************************** Display Build Mode ****************************************/
		g.setColor(new Color(255,255,255));
		g.drawString(Character.toString(state.buildMode), container.getWidth()-50, 10);
		g.setBackground(new Color(0,0,0));
		/****************************************************************************************************/

		

		/***************************************** Draw Particles! ******************************************/
		//g.setColor(new Color(40,140,173));
		for (int i=0;i<state.ParticleList.length;i++) {
			//g.drawImage(ParticleImg,state.ParticleList[i].position.x-ParticleImg.getWidth()/2, state.ParticleList[i].position.y-ParticleImg.getHeight()/2);
			g.setColor(new Color(state.ParticleList[i].rgb[0],state.ParticleList[i].rgb[1],state.ParticleList[i].rgb[2]));
			g.fillOval(state.ParticleList[i].position.x-4f/2f, state.ParticleList[i].position.y-4f/2f, 4, 4);
		}
		/****************************************************************************************************/
		
		
		
		/**************************************** Draw Other Agents *****************************************/
		for (int i=0;i<state.holeList.length;i++) {
			g.drawImage(holeImg,state.holeList[i].position.x-holeImg.getWidth()/2, state.holeList[i].position.y-holeImg.getHeight()/2);
		}
		g.setColor(new Color(0,127,89));
		for (int i=0;i<state.eFieldList.length;i++) {
			g.drawRect(state.eFieldList[i].position.x, state.eFieldList[i].position.y, state.eFieldList[i].widthHeight.x, state.eFieldList[i].widthHeight.y);
		}
		g.setColor(new Color(68,107,151));
		for (int i=0;i<state.bFieldList.length;i++) {
			g.drawRect(state.bFieldList[i].position.x, state.bFieldList[i].position.y, state.bFieldList[i].widthHeight.x, state.bFieldList[i].widthHeight.y);
		}
		g.setColor(new Color(255,249,131));
		for (int i=0;i<state.rFieldList.length;i++) {
			g.drawRect(state.rFieldList[i].position.x, state.rFieldList[i].position.y, state.rFieldList[i].widthHeight.x, state.rFieldList[i].widthHeight.y);
		}
		/****************************************************************************************************/

		
		
		/*********************************** Draw Box When Mouse Held Down **********************************/
		g.setColor(new Color(30,30,30));
		if (state.mouseLeftClickDown==true) {
			g.drawRect(state.mouseLeftClickDownCoord1.x, state.mouseLeftClickDownCoord1.y,
					(state.mouseLeftClickDownCoord2.x-state.mouseLeftClickDownCoord1.x), (state.mouseLeftClickDownCoord2.y-state.mouseLeftClickDownCoord1.y));
		}
		/****************************************************************************************************/
	}
	
	// draws rainbow line! woo
	/*
	for (float lambda = 730;lambda>=400;lambda-=1) {
		g.setColor(new Color(WavelengthToRGB.convert(lambda)[0],WavelengthToRGB.convert(lambda)[1],WavelengthToRGB.convert(lambda)[2]));
		g.drawRect(lambda, 300, 2, 2);
	}*/
}
