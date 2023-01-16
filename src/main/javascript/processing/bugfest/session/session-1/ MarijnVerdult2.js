length = []; thickness = []; angle = [];
distance = []; shimmer = [];
ndots = []; dots = []; nlegs = []; legAngle = [];
X = []; Y = [];
r = []; g = []; b = [];
time = 0;

n = 10;

function setup() {
	createCanvas(windowWidth, windowHeight);
	rectMode(CENTER);
	background(0, 0 ,0);
	frameRate(10);

	// define 999 random bugs
	for (let i = 0; i < 999; i++) {
		length[i] = random(50);
		thickness[i] = random(25);
		angle[i] = random(2*PI);
		X[i] = 0.5*displayWidth;
		Y[i] = 0.5*displayHeight;
		distance[i] = random(10);
		shimmer[i] = distance[i] / 20 * random(1);
		r[i] = random(255);
		g[i] = random(255);
		b[i] = random(255);
		ndots[i] = random(10);
		dots[i] = [];
		for (let j = 0; j < ndots[i]; j++) {
			dots[i][j] = [random(-0.5*thickness[i]+5,0.5*thickness[i]-5),random(-length[i]+5,length[i]-5)];
		}
		nlegs[i] = round(length[i] / 10) + 2;
	}
}

function calculateX(X, angle, dotX, dotY) {
	return X + cos(angle) * dotY - sin(angle) * dotX;
}

function calculateY(Y, angle, dotX, dotY) {
	return Y + sin(angle) * dotY + cos(angle) * dotX;
}

function draw() {
	clear();

	time = time + 1;
	for (let i = 0; i < n + time / 20; i++) {

		angle[i] = angle[i] + randomGaussian(0,shimmer[i]);
		X[i] = X[i] + cos(angle[i]) * distance[i];
		Y[i] = Y[i] + sin(angle[i]) * distance[i];

		headX = X[i] + cos(angle[i]) * length[i];
		headY = Y[i] + sin(angle[i]) * length[i];
		assX = X[i] - cos(angle[i]) * length[i];
		assY = Y[i] - sin(angle[i]) * length[i];

		// legs
		strokeWeight(thickness[i]/5);
		stroke(r[i]+100, g[i]+100, b[i]+100);
		legAngle[i] = 0.5 * sin(time * distance[i] / 5);
		for (let j = 0; j < nlegs[i]; j++) {
			legX = assX + (j / (nlegs[i] - 1)) * (2 * cos(angle[i]) * length[i]);
			legY = assY + (j / (nlegs[i] - 1)) * (2 * sin(angle[i]) * length[i]);
			// left
			legLeftX = legX + cos(angle[i] - 0.5 * PI + legAngle[i]) * thickness[i];
			legLeftY = legY + sin(angle[i] - 0.5 * PI + legAngle[i]) * thickness[i];
			line(legX, legY, legLeftX, legLeftY);
			// right
			legRightX = legX + cos(angle[i] + 0.5 * PI - legAngle[i]) * thickness[i];
			legRightY = legY + sin(angle[i] + 0.5 * PI - legAngle[i]) * thickness[i];
			line(legX, legY, legRightX, legRightY);
			// next leg opposite direction
			legAngle[i] = -legAngle[i];
		}

		// antenna's
		strokeWeight(thickness[i]/10);
		noFill()
		// left
		antennaCenterLeftX = headX + cos(angle[i] - 0.5 * PI) * (10 * thickness[i]);
		antennaCenterLeftY = headY + sin(angle[i] - 0.5 * PI) * (10 * thickness[i]);
		arc(antennaCenterLeftX, antennaCenterLeftY, 20 * thickness[i], 20 * thickness[i],  angle[i] + (0.5 - length[i]/200) * PI, angle[i] + 0.5 * PI);
		// right
		antennaCenterRightX = headX + cos(angle[i] + 0.5 * PI) * (10 * thickness[i]);
		antennaCenterRightY = headY + sin(angle[i] + 0.5 * PI) * (10 * thickness[i]);
		arc(antennaCenterRightX, antennaCenterRightY, 20 * thickness[i], 20 * thickness[i],  angle[i] + 1.5 * PI, angle[i] + (1.5 + length[i]/200) * PI);

// 		// eyes
// 		fill(255);
// 		Xxx = headX - cos(0.5 - length[i]/200) * 10 * thickness[i] + 10 * thickness[i];
// 		Yyy = headY + sin(0.5 - length[i]/200) * 10 * thickness[i];
// 		circle(Xxx, Yyy,thickness[i]);

		// body
		stroke(r[i], g[i], b[i]);
		strokeWeight(thickness[i]);
		line(assX, assY, headX, headY);

		// // dots
		// strokeWeight(0);
		// fill(255);
		// for (let j = 0; j < ndots[i]; j++) {
		// 	circle(calculateX(X[i], angle[i], dots[i][j][0], dots[i][j][1]), calculateY(Y[i], angle[i], dots[i][j][0], dots[i][j][1]), 6);
		// }
	}
}
