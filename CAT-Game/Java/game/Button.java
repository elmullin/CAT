package game;

import processing.core.*;

public class Button extends PApplet{
  public int positionX, positionY;
  public int recHeight, recWidth;
  public int[] backgroundColor, highlightColor;
  public boolean rectOver, rectPressed;
  public String imageName, imageSmallName;
  public PImage image, imageSmall;
  
  public Button() {
    this.positionX = 640/2-100;
    this.positionY = 360/2-100/2;
    this.recHeight = 100;
    this.recWidth = 200;
    this.backgroundColor = new int[3];
    this.backgroundColor[0] = 77;
    this.backgroundColor[1] = 77;
    this.backgroundColor[2] = 77;
    this.highlightColor = new int[3];
    this.highlightColor[0] = 51;
    this.highlightColor[1] = 51;
    this.highlightColor[2] = 51;
    this.rectOver = false;
    this.rectPressed = false;
    this.imageName = "assets/thumbs-up.png";
    this.imageSmallName = "assets/thumbs-up-small.png";
    this.image = loadImage(imageName);
    this.imageSmall = loadImage(imageSmallName);
  }
  
  public Button(int posX, int posY, int h, int w, int[] backColor, int[] highColor, boolean recOver, boolean recPrss, String imgName, String imgSmallName) {
    this.positionX = posX;
    this.positionY = posY;
    this.recHeight = h;
    this.recWidth = w;
    this.backgroundColor = new int[3];
    this.backgroundColor[0] = backColor[0];
    this.backgroundColor[1] = backColor[1];
    this.backgroundColor[2] = backColor[2];
    this.highlightColor = new int[3];
    this.highlightColor[0] = highColor[0];
    this.highlightColor[1] = highColor[1];
    this.highlightColor[2] = highColor[2];
    this.rectOver = recOver;
    this.rectPressed = recPrss;
    this.imageName = imgName;
    this.imageSmallName = imgSmallName;
    this.image = loadImage(this.imageName);
    this.imageSmall = loadImage(this.imageSmallName);
  }
  
  public void drawButton() {  
     if (overRect(this.positionX, this.positionY, this.recWidth, this.recHeight)) {
        this.rectOver = true;
        fill(color(this.highlightColor[0], this.highlightColor[1], this.highlightColor[2]));
     } else {
        this.rectOver = false;
        fill(color(this.backgroundColor[0], this.backgroundColor[1], this.backgroundColor[2]));
     }
     
     stroke(255);
     if (this.rectPressed) {
        print("Pressed!\n");
        roundrect(this.positionX + 5, this.positionY + 5, this.recWidth - 10, this.recHeight - 10, 30);
        imageMode(CENTER);
        image(this.imageSmall, this.positionX + this.recHeight, this.positionY + (this.recHeight / 2));
        this.rectPressed = false;
      }
      else {
        roundrect(this.positionX, this.positionY, this.recWidth, this.recHeight, 30);
        imageMode(CENTER);
        image(this.image, this.positionX + this.recHeight, this.positionY + (this.recHeight / 2));
      }
  }
  
  public boolean overRect(int x, int y, int width, int height) {
    if (mouseX >= x && mouseX <= x+width && mouseY >= y && mouseY <= y+height) {
      return true;
    } else {
      return false;
    }
  }
  
  public void roundrect(int x, int y, int w, int h, int r) {
     noStroke();
     rectMode(CORNER);

     int  ax, ay, hr;

     ax=x+w-1;
     ay=y+h-1;
     hr = r/2;

     rect(x, y, w, h);
     arc(x, y, r, r, radians(180.0f), radians(270.0f));
     arc(ax, y, r,r, radians(270.0f), radians(360.0f));
     arc(x, ay, r,r, radians(90.0f), radians(180.0f));
     arc(ax, ay, r,r, radians(0.0f), radians(90.0f));
     rect(x, y-hr, w, hr);
     rect(x-hr, y, hr, h);
     rect(x, y+h, w, hr);
     rect(x+w,y,hr, h);
  } 
}