// function setup() {
// 	createCanvas(windowWidth, windowHeight);
// 	var r = random(255);
//   var g = random(255);
//   var b = random(255);
// 	background(r, g, b);
// 	// line(100,100,500,500);
// 	// rect(0, 0, 500, 500);
// 	// translate(300, 200);
// 	// rect(0, 0, 400, 400);
// 	// translate(250, 150);
// 	// rect(0, 0, 300, 300);
// 	// for (let i = 0; i < 3; i++)
// 	// {
// 	// 	square(100, 100, 100*i, 100*i);
// 	// }
// 	// for (let i = 0; i < 9; i++)
// 	// {
// 	// 	rect(0, 0, random(500), random(500));
// 	// 	translate(random(250), random(250))
// 	// }

// 	// bug creation
// 	let p1 = { x: random(300), y: random(300) };
// 	let p2 = { x: random(500), y: random(500) };
// 	let p3 = { x: random(700), y: random(700) };
// 	noFill();
// 	stroke(random(255), random(255), random(255));
// 	strokeWeight(random(10));
// 	curve(p1.x, p1.y, p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
// }

// function draw() {
// 	circle(mouseX, mouseY, 20);
// }

let beginX = 20.0; // Initial x-coordinate
let beginY = 10.0; // Initial y-coordinate
let endX = 570.0; // Final x-coordinate
let endY = 320.0; // Final y-coordinate
let distX; // X-axis distance to move
let distY; // Y-axis distance to move
let x = 0.0; // Current x-coordinate
let y = 0.0; // Current y-coordinate
let step = 0.005; // Size of each step along the path
let pct = 0.0; // Percentage traveled (0.0 to 1.0)

function setup() {
  createCanvas(720, 400);
	var r = random(255);
  var g = random(255);
  var b = random(255);
	background(r, g, b);
  noStroke();
  distX = endX - beginX;
  distY = endY - beginY;
}

function draw() {
  fill(0, 2);
  pct += step;
	exponent = random(20);
  if (pct < 1.0) {
    x = beginX + pct * distX;
    y = beginY + pow(pct, exponent) * distY;
  }
  fill(255);
	radius = 20
	point_size = random(20)/20
  ellipse(x, y, radius*point_size, radius*point_size);
}
