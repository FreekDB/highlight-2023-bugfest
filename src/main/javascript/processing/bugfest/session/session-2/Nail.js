function setup() {
	createCanvas(windowWidth, windowHeight,WEBGL);
	background(100);
}

function draw() {
	si = 20
	for (let i = 0; i < 200; i++) {
		// fill(random(255),random(255),random(255));
		// rect(si,si,2000-i*si,2000-i*si,);
		// fill(random(255),random(255),random(255));
		// rect(si+random(255),si+random(255),2000-i*si,2000-i*si,);
		// fill(random(255),random(255),random(255));
		// ellipse(si+random(2000),si+random(2000),random(255),random(255));
	}
	for (let k = 0; k < 1; k ++) {
		a = random(2000);
		b = random(2000);
		c = random(255);
		d = random(255);
		r = random(255);
		g = random(255);
		b = random(255);
	  translate(a,b);
  	noStroke();

	for (let i = 0; i < 10; i ++) {
		fill(r,g,b);
		ellipse(0, 30, 20, 80);
    rotate(PI/5);

  }}
	rect(0, 70, 20, 80);
	 for (let i = 0; i < 10; i ++) {

  }
  // translate(-240 * 2, 200, 0);
  // push();
  // rotateZ(frameCount * 0.01);
  // rotateX(frameCount * 0.01);
  // rotateY(frameCount * 0.01);
  // cone(70, 70);
  // pop();

}
