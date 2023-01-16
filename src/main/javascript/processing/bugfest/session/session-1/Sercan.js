function setup() {
	createCanvas(windowWidth, windowHeight);
	background(100);
}

function draw() {
	background(255);
	drawBug(100);
	drawBug(random(190,200));
	drawBug(300);
}

function drawBug(i) {

	v_x = i;
	v_y = 200;
	v_w = 80;
	v_h = 100;
	v_x_head = v_x
	v_y_head = v_y-(v_h*0.8)
	v_w_head = v_w*0.6
	v_x_leg_left = v_x-(v_w/2)
	v_x_leg_right = v_x+(v_w/2)
	v_y_leg_up = v_y-v_h
	v_y_leg_down = v_y+v_h

	noFill();
	arc(v_x_leg_left, v_y_leg_up, 60, 60, HALF_PI, PI); // leg1
	//arc(v_x_leg_right, v_y_leg_up, 60, 60, HALF_PI, PI); // leg2
	arc(v_x_leg_left, v_y_leg_down, 60, 60, HALF_PI, PI); // leg3
	//leg4 = arc(v_x_leg_right, v_y_leg_down, 60, 60, HALF_PI, PI); // leg4

	ellipseMode(RADIUS); // Inner white ellipse
	fill(255);
	ellipse(v_x,v_y,v_w,v_h); // Outer white ellipse

	fill(random(255),random(255),random(255));
	ellipse(v_x_head,v_y_head,v_w_head,40);


}
