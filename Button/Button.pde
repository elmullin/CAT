/*Dynamic Button
  Created by Erick Harris
  CPE 307
  CAT - Corral and Transfer
*/

int rectX, rectY;
int rectHeight = 100;
int rectWidth = 200;
color rectColor;
color highlightColor;
color backgroundColor;
boolean rectOver = false;
boolean rectPressed = false;
PImage img;
PImage imgSmall;

void setup() {
  size(640, 360);
  background(color(255));
  setupButton();
  ellipseMode(CENTER);
}

void draw() {
  drawButton();
}

void mousePressed() {
  if (rectOver) {
    rectPressed = true;
    print("Thumbs Up!\n");
  }
}

void setupButton() {
  rectColor = color(77,77,77);
  highlightColor = color(51,51,51);
  rectX = width/2-rectHeight;
  rectY = height/2-rectHeight + 50;
  img = loadImage("thumbs-up.png");
  imgSmall = loadImage("thumbs-up-small.png");
}

void drawButton() {
    if (overRect(rectX, rectY, rectWidth, rectHeight)) {
      rectOver = true;
    } else {
      rectOver = false;
    }
    
    background(color(255));
    
    if (rectOver) {
      fill(highlightColor);
    } else {
      fill(rectColor);
    }
    
    stroke(255);
    if (rectPressed) {
      roundrect(rectX + 5, rectY + 5, rectWidth - 10, rectHeight - 10, 30);
      imageMode(CENTER);
      image(imgSmall, rectX + rectHeight, rectY + (rectHeight / 2));
      rectPressed = false;
    }
    else {
      roundrect(rectX, rectY, rectWidth, rectHeight, 30);
      imageMode(CENTER);
      image(img, rectX + rectHeight, rectY + (rectHeight / 2));
    }
}

void roundrect(int x, int y, int w, int h, int r) {
 noStroke();
 rectMode(CORNER);

 int  ax, ay, hr;

 ax=x+w-1;
 ay=y+h-1;
 hr = r/2;

 rect(x, y, w, h);
 arc(x, y, r, r, radians(180.0), radians(270.0));
 arc(ax, y, r,r, radians(270.0), radians(360.0));
 arc(x, ay, r,r, radians(90.0), radians(180.0));
 arc(ax, ay, r,r, radians(0.0), radians(90.0));
 rect(x, y-hr, w, hr);
 rect(x-hr, y, hr, h);
 rect(x, y+h, w, hr);
 rect(x+w,y,hr, h);
}

boolean overRect(int x, int y, int width, int height)  {
  if (mouseX >= x && mouseX <= x+width && 
      mouseY >= y && mouseY <= y+height) {
    return true;
  } else {
    return false;
  }
}