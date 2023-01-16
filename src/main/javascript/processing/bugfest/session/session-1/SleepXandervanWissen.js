let play = true;

function setup() {
	createCanvas(windowWidth, windowHeight);
	background(100);
	frameRate(5);
}

function draw() {
	var r = random(255);
	var g = random(255);
	var b = random(255);

  fill(r,g,b);

	circle(mouseX, mouseY, 20);
  x=random(2000);
	y=random(2000);
  if (play) {
	  line(0,0, 500, 500);
    rect(10+x,10+y,30,30);
//    rect(j+10,j+10,j+20,j+20);

	}
	  else if (!play) {
    	for (i = 0; i<10; i++) {
	    r = random(255);
	    g = random(255);
	    b = random(255);
      fill(r,g,b);
			//w=random(100);
      //circle(x,y,w);
      circle(x,y,100-i*10);
      circle(x+100,y,100-i*10);
	    }
	  }
}

function mousePressed() {
  if (mouseButton == LEFT) {
    this.draw();
  }
  else if (mouseButton == RIGHT) {
    this.draw();
  }

	if (!play) {
    play = true;
  }
}

function keyPressed() {
  if (key == 's' || key == 'S') {
		play = false;
  }
  else if (key == 'p' || key == 'P') {
      play = true;
  }
}
