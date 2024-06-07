import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MenuGame {
    private GameLoop gameLoop;
    private Image menuGame;
    private Image pvz_logo;
    private Image playButton;
    private Rectangle bounds;
    public MenuGame(GameLoop gameLoop){
        this.gameLoop=gameLoop;
        bounds=new Rectangle(400,500,500,100);
        importImage();
    }
    public void importImage(){
        try {menuGame=ImageIO.read(new File("D:/Code/GitHub/OOP-Game-OcCho/res/MenuGame/wallpaper.jpg"));
        } catch (IOException e) {e.printStackTrace();}
        try {pvz_logo=ImageIO.read(new File("D:/Code/GitHub/OOP-Game-OcCho/res/MenuGame/pvz_logo.png"));
        } catch (IOException e) {e.printStackTrace();}
        try {playButton=ImageIO.read(new File("D:/Code/GitHub/OOP-Game-OcCho/res/MenuGame/PlayDemo.png"));
        } catch (IOException e) {e.printStackTrace();}
    }
    public void render(Graphics2D g2){
        g2.drawImage(menuGame,0,0,1300,750,null);
        g2.drawImage(pvz_logo, 300,50,700,200, null);
        g2.drawImage(playButton,bounds.x,bounds.y,bounds.width,bounds.height, null);
    }
    public Rectangle getBounds() {
        return bounds;
    }
    public void handleMouseClick(int mouseX, int mouseY) {
        if(this.getBounds().contains(mouseX,mouseY)){
            gameLoop.getPlaying().resetGame();
            GameScenes.setGameScenes(GameScenes.PLAYING); 
            gameLoop.repaint(); 
        }
    }
    public void update(){}
}