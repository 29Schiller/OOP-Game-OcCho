package PvZ.Plants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class OptionPlants {
    private Rectangle bound1,bound2,bound3;
    private Image peaChoose;
    private Image wallNutChoose;
    private Image sunFlowerChoose;
    private String Type;
    private boolean isChoose;
    private int rowSpawn;
    private int XSpwan;
    private static boolean[][] plantPositions;
    public OptionPlants(){
        bound1=new Rectangle(120,20,100,65);
        bound2=new Rectangle(230,20,100,65);
        bound3=new Rectangle(340,20,100,65);
        plantPositions = new boolean[5][9];
    }
    
    public String getType() {return Type;}
    public void setType(String type){this.Type=type;}
    public boolean isChoose() {return isChoose;}
    public void setChoose(boolean isChoose) {this.isChoose = isChoose;}
    public int getRowSpawn() {return rowSpawn;}
    public void setRowSpawn(int rowSpawn) {this.rowSpawn = rowSpawn;}
    public int getXSpwan() {return XSpwan;}
    public void setXSpwan(int xSpwan) {XSpwan = xSpwan;}
    public boolean isOccupied(int row, int col) {return plantPositions[row][col];}
    public void setOccupied(int row, int col, boolean occupied) {plantPositions[row][col] = occupied;}

    public void importImage(){
        try {peaChoose=ImageIO.read(new File("D:/Code/GitHub/OOP-Game-OcCho/res/Plants/OptionChoose/Peashooter.png"));
        } catch (IOException e) {e.printStackTrace();}
        try {wallNutChoose=ImageIO.read(new File("D:/Code/GitHub/OOP-Game-OcCho/res/Plants/OptionChoose/Wallnut.png"));
        } catch (IOException e) {e.printStackTrace();}
        try {sunFlowerChoose=ImageIO.read(new File("D:/Code/GitHub/OOP-Game-OcCho/res/Plants/OptionChoose/Sunflower.png"));
        } catch (IOException e) {e.printStackTrace();}
    }

    public void handPlantsChoose(int mouseX, int mouseY) {
        if (this.getBound1().contains(mouseX, mouseY)) {
            setChoose(true);
            setType("Pea");
        }
        if (this.getBound2().contains(mouseX, mouseY)) {
            setChoose(true);
            setType("WallNut");
        }
        if (this.getBound3().contains(mouseX, mouseY)) {
            setChoose(true);
            setType("SunFlower");}
    }
    public void ChoosePositionForPlant(int mouseX, int mouseY) {
        int row = -1, col = -1;
        if (115 < mouseY && mouseY <= 224) row = 0;
        else if (224 < mouseY && mouseY <= 333) row = 1;
        else if (333 < mouseY && mouseY <= 442) row = 2;
        else if (442 < mouseY && mouseY <= 551) row = 3;
        else if (551 < mouseY && mouseY <= 660) row = 4;
    
        if (350 <= mouseX && mouseX <= 445) col = 0;
        else if (445 < mouseX && mouseX <= 540) col = 1;
        else if (540 < mouseX && mouseX <= 635) col = 2;
        else if (635 < mouseX && mouseX <= 730) col = 3;
        else if (730 < mouseX && mouseX <= 825) col = 4;
        else if (825 < mouseX && mouseX <= 920) col = 5;
        else if (920 < mouseX && mouseX <= 1015) col = 6;
        else if (1015 < mouseX && mouseX <= 1110) col = 7;
        else if (1110 < mouseX && mouseX <= 1205) col = 8;
    
        if (row != -1 && col != -1 && row < plantPositions.length && col < plantPositions[0].length && plantPositions[row][col]==false) {
            setXSpwan(397 + 90 * col);
            setRowSpawn(row + 1); 
        }
    }
    public Rectangle getBound1() {return bound1;}
    public Rectangle getBound2() {return bound2;}
    public Rectangle getBound3() {return bound3;}
    
    public void renderImage(Graphics2D g2){
        g2.drawImage(peaChoose, 120,20,100,65, null);
        g2.drawImage(wallNutChoose, 230,20,100,65, null);
        g2.drawImage(sunFlowerChoose, 340,20,100,65, null);
    }
}
