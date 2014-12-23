import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class wind extends PApplet {

float a = 0;
float s = TWO_PI/120;

public void setup() {
  size(500,500);
  smooth();
  noStroke();
  noiseDetail(4);
}
 
 
public void draw() {
  doLines();
  a+=s;
}
 
public void doLines() {
  background(226,210,184);
   for(int j=50;j<450;j+=25) {
     for(int i=50;i<450;i++) {
      if(j!=50 && j!=440) { //grid
      float step = sin(a)*(sin((450-i)*PI/400.0f));
       float swing = j+step*(180.0f*noise(a+i/300.0f, a+j/300.0f,a/10.0f)-90.0f);
       float dx = randomC()/2;
       float dy = randomC()/2;
       float x = i+dx;
       float y = swing+dy;
       fill(20,150-150*sqrt(sq(dx)+sq(dy))); // pencil effect
       ellipse(x,y,2,2);
    }
  }
 }
 
}
 
//pseudo
public float randomC() {
  float r = random(0,1);
  float ang = sin(TWO_PI*random(0,1));
  return r*ang;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "wind" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
