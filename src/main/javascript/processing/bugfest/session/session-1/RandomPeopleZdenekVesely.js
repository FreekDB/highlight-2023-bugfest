function setup() {
	createCanvas(windowWidth, windowHeight);
	background(100);
	var r_color = random(255);
	var g_color = random(255);
	var b_color = random(255);

	var neck_x = 500;
	var neck_y = 200;
	var body_length = random(20, 200);

	var body_w = random(3,20)
	var head_size = random(30, 100)

	var arm_length = random(20, 80)
	var leg_length = random(20, 120)


	stroke(r_color, g_color, b_color);
	strokeWeight(body_w);


	line(neck_x, neck_y, neck_x , neck_y + body_length )
	circle(neck_x, neck_y - head_size / 2, head_size)
	line(neck_x, neck_y, neck_x + arm_length , neck_y + arm_length )
	line(neck_x, neck_y, neck_x - arm_length , neck_y + arm_length )
	line(neck_x, neck_y + body_length, neck_x + leg_length , neck_y + body_length + leg_length )
	line(neck_x, neck_y + body_length, neck_x - leg_length , neck_y + body_length + leg_length )

}
