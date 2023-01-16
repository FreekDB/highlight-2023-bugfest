
function setup() {
	createCanvas(windowWidth, windowHeight, WEBGL);

	// sprite = new Sprite();
	// sprite.diameter = 50;
	// sprite.rotationSpeed = 1;
	// rectMode(CENTER);
	// createCanvas(100, 100, WEBGL);

}



function draw() {




	// SWARM OF INSECTS



 background(150, 100, 50);

	var r = random(255);
	var b = random(255);
	var g = random(255);

	background(r, b, g);

	for(let j = 0; j < 20; j++) {

		rotateX(millis() / 500);
		for(let i = 0; i < 20; i++) {

				rotateY(millis() / 700);
				rotateZ(millis() / 700);

				translate(windowWidth/50, windowHeight/50);
				translate(p5.Vector.fromAngle(millis() / 1000, 10*j));

				let c = color('hsb(160, 100%, 50%)');
				fill(c);
				triangle(60 + i * 30, 50, 60, 100, 100, 40);
				let d = color(255, 204, 0);
				fill(d);
				triangle(60 + i * 30, 50, 50, 100, 10, 80);
			  colorMode(HSB, 100);
				let e = color(50, 55, 100);
				fill(e);
				triangle(60 + i * 30, 50, 20, 10, 50, 120);
		}
	}

	for(let j = 0; j < 10; j++) {

		// rotateX(millis() / 2000);
		rotateY(millis() / 2050);
		// square(70, 70, 100);
		rotateX(millis() / 2050);
		// circle(70, 70, 50);


		for(let i = 0; i < 100; i++) {
				j = i;
				rotateY(millis() / 1000);
				// rotateZ(millis() / 00);

				translate(windowWidth/50, windowHeight/50);
				translate(p5.Vector.fromAngle(millis() / 500, 10*j));

				let c = color('hsb(160, 100%, 50%)');
				fill(c);
				triangle(60 + i * 30, 50, 60, 100, 100 + j, 40);
				let d = color(255, 204, 0);
				fill(d);
				triangle(60 + i * 30, 50, 50, 100, 10 + j, 80);
			  colorMode(HSB, 100);
				let e = color(50, 55, 100);
				fill(e);
				triangle(60 + i * 30, 50, 20, 10, 50 + j, 120);
		}

				let c = color('hsb(160, 100%, 50%)');
				fill(c);
				rect(60 + j * 30, 100 + j, 20, 20);
				let d = color(255, 204, 0);
				fill(d);
				rect(60 + j * 30, 10 + j, 30, 40);
			  colorMode(HSB, 100);
				let e = color(50, 55, 100);
				fill(e);
				rect(60 + j * 30, 50 + j, 60, 80);
	}









// 	// ABSTRACT CIRCLE SQUARE

// 	background(205, 102, 94);


// 	rotateY(millis() / 1000);
// 	square(20, 20, 50);
// 	rotateX(millis() / 1000);
// 	circle(20, 20, 40);

// 	rotateY(millis() / 1050);
// 	square(70, 70, 100);
// 	rotateX(millis() / 1050);
// 	circle(70, 70, 80);

// 	rotateY(millis() / 1100);
// 	square(120, 120, 150);
// 	rotateX(millis() / 1100);
// 	circle(120, 120, 120);

// 	rotateY(millis() / 1150);
// 	square(170, 170, 200);
// 	rotateX(millis() / 1150);
// 	circle(170, 170, 180);



// 	//// ABSTRACT SPHERICAL 2
// 	rotateY(millis() / 1200);
// 	sphere(40, 24, 16);

// 	for(let i = 0; i < 20; i++) {
// 			rotateY(millis() / 1200);
// 			square(220, 220, i*10);
// 			rotateX(millis() / 1200);
// 			circle(220, 220, i*20);
// 	}

// 	for(let i = 0; i < 20; i++) {
// 			rotateX(millis() / 1200);
// 			triangle(30, 75, 58, 20, 86, 75);
// 			rotateY(millis() / 1200);
// 			ellipse(220, 220, i*10);


}


// function setup() {
// 	new Canvas(200, 100);


// }

// function draw() {
// 	circle(mouseX , mouseY + 50, 20);
// 	square(mouseX , mouseY - 50, 20);
// 	ellipse(mouseX, mouseY - 50, 15, 8);
// }


// function draw() {
// 	circle(mouseX + 50, mouseY, 20);
// 	square(mouseX - 50, mouseY, 20);
// 	ellipse(mouseX - 50, mouseY, 15, 8);
// }