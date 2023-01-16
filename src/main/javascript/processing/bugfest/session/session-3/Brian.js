function setup() {
	createCanvas(windowWidth, windowHeight);

	const s = min(windowWidth, windowHeight) * 0.9;
	createCanvas(s, s);
	background(random(255),random(255),random(255));
	frameRate(1)

}

function draw() {

	//circle(mouseX, mouseY, 2);
 //line(100,100,500,500);
	ellipseMode(CENTER);
	draw_ellipses()
	//triangles()
	//draw_rect(100,200,600,700);
	//fill(10,255,156);
	bezier(85, 200, 100, 100, 90, 90, 15, 80);

}


function draw_ellipses(){

	for (let i = 1; i < 9; i++) {
  ellipse(350+random(300),350+random(300),(60*i),60*i*random(10))
	fill(255*rands(),255*rands(),255*rands(),60)
}

}

function rands() {

	r = random(10)/10

	return r

}

function draw_rect(x1,y1,x2,y2){

	rect(x1,y1,x2,y2)

}
