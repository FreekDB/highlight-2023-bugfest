function setup() {
	createCanvas(windowWidth, windowHeight);
	background(100);
}

function draw() {
	background(100);
	//circle(mouseX, mouseY, 20);
	noStroke()
	fill('#780000');
	ellipse(300, 300, 350, 450);
	fill('#0a0908');
	arc(300, 500, 150, 150, 0, HALF_PI);
	arc(300, 500, 150, 150, 0, PI);
	fill('#003049');
	//line(
	quad(300, 500, 300, 20, 169, 63, 30, 76);
		//quad(300, 500, 300, 20, 369, 63, 300, 76);
		quad(300, 500, 300, 20, 369, 63, 500, 76);

fill('#003049');
	arc(300, 500, 86, 86, 0, HALF_PI);
	arc(300, 500, 86, 86, 0, PI);
	fill('#0a0908');
		  for (var i = 0; i <= 10; i++) {
				var x = random(140);
				var y = random(140);

				ellipse(300 + x, 300 + y, 35, 45);
				ellipse(300 - x, 300 - y, 35, 45);

			}
}
