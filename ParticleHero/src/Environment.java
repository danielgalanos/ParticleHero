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
	Agents agents;
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
		agents = new Agents();
	
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		float dt = delta/1000.0f;
		//mymessage = "" + Math.sqrt(mousePosition.getX()*mousePosition.getX()+mousePosition.getY()*mousePosition.getY());
		
		agents.player.update(container, agents, dt);
		
		
		if (agents.mouseMode==1) {
			
		}
		else if (agents.mouseMode==2) {
			agents.mouseHole.update(new Vector2d(container.getInput().getAbsoluteMouseX(), container.getInput().getAbsoluteMouseY()));
		}
		
		
		for (int i=0;i<agents.ParticleList.length;i++) {
			if (agents.ParticleList[i].position.x < -width*2 || agents.ParticleList[i].position.y < -height*2 || agents.ParticleList[i].position.x > width*3 || agents.ParticleList[i].position.y > height*3){
				agents.ParticleList = ArrayOperations.removeElement(agents.ParticleList, i);
			}
			else {
				agents.ParticleList[i].update(agents,dt);
			}
		}
		
		
		if (counter%60==0) {
			System.out.println(agents.ParticleList.length);
		}
		counter++;
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		//g.drawString(mymessage, 0, 100);
		
		
		g.drawImage(playerImg,agents.player.position.x-playerImg.getWidth()/2, agents.player.position.y-playerImg.getHeight()/2);
		
		g.setColor(new Color(255,255,255));
		g.drawString(Character.toString(agents.buildMode), container.getWidth()-50, 10);
		g.setBackground(new Color(0,0,0));
		

		
		// draws rainbow line! woo
		/*
		for (float lambda = 730;lambda>=400;lambda-=1) {
			g.setColor(new Color(WavelengthToRGB.convert(lambda)[0],WavelengthToRGB.convert(lambda)[1],WavelengthToRGB.convert(lambda)[2]));
			g.drawRect(lambda, 300, 2, 2);
		}*/

		
		
		//g.setColor(new Color(40,140,173));
		for (int i=0;i<agents.ParticleList.length;i++) {
			//g.drawImage(ParticleImg,agents.ParticleList[i].position.x-ParticleImg.getWidth()/2, agents.ParticleList[i].position.y-ParticleImg.getHeight()/2);
			g.setColor(new Color(agents.ParticleList[i].rgb[0],agents.ParticleList[i].rgb[1],agents.ParticleList[i].rgb[2]));
			g.fillOval(agents.ParticleList[i].position.x-4f/2f, agents.ParticleList[i].position.y-4f/2f, 4, 4);
		}
		
		
		for (int i=0;i<agents.holeList.length;i++) {
			g.drawImage(holeImg,agents.holeList[i].position.x-holeImg.getWidth()/2, agents.holeList[i].position.y-holeImg.getHeight()/2);
		}
		
		
		g.setColor(new Color(0,127,89));
		for (int i=0;i<agents.eFieldList.length;i++) {
			g.drawRect(agents.eFieldList[i].position.x, agents.eFieldList[i].position.y, agents.eFieldList[i].widthHeight.x, agents.eFieldList[i].widthHeight.y);
		}
		
		
		g.setColor(new Color(68,107,151));
		for (int i=0;i<agents.bFieldList.length;i++) {
			g.drawRect(agents.bFieldList[i].position.x, agents.bFieldList[i].position.y, agents.bFieldList[i].widthHeight.x, agents.bFieldList[i].widthHeight.y);
		}
		
		g.setColor(new Color(255,249,131));
		for (int i=0;i<agents.rFieldList.length;i++) {
			g.drawRect(agents.rFieldList[i].position.x, agents.rFieldList[i].position.y, agents.rFieldList[i].widthHeight.x, agents.rFieldList[i].widthHeight.y);
		}
		

		
		
		g.setColor(new Color(30,30,30));
		if (agents.mouseLeftClickDown==true) {
			g.drawRect(agents.mouseLeftClickDownCoord1.x, agents.mouseLeftClickDownCoord1.y,
					(agents.mouseLeftClickDownCoord2.x-agents.mouseLeftClickDownCoord1.x), (agents.mouseLeftClickDownCoord2.y-agents.mouseLeftClickDownCoord1.y));
		}
	}
}