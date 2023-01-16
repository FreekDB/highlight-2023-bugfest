// Original sketch by Pierre MARZIN: https://openprocessing.org/sketch/1416893
// Modified and extended by: Freek de Bruijn.
// Version: September 4th, 2022.

let rowCount;
let columnCount;
let rowHeight;
let columnWidth;

let backgroundColor;

let play = true;

const BUTTERFLY_MODE = "butterfly mode";
const BEETLE_MODE = "beetle mode";
const LADYBUG_MODE = "ladybug mode";
const BACTERIUM_MODE = "bacterium mode";
const modes = [BUTTERFLY_MODE, BEETLE_MODE, LADYBUG_MODE, BACTERIUM_MODE];

let mode = BACTERIUM_MODE;
let rotationActive = false;
let designModeActive = false;
let designAnimal;
let butterflyImage;
let beetleDesignImage;
let ladybugDesignImage;
let bacteriumDesignImage;

function setup() {
  createCanvas(windowWidth, windowHeight);
  randomSeed(1234);
  backgroundColor = color(random(255), random(255), random(255));
  background(backgroundColor);
  strokeWeight(1.5);
  strokeJoin(ROUND);
  imageMode(CENTER);

	this.designAnimal = new DesignAnimal();

	butterflyImage = loadImage("https://mir-s3-cdn-cf.behance.net/project_modules/1400/60395395888605.5ea1c0315c764.jpg");
	beetleDesignImage = loadImage("beetle-01.png");
	ladybugDesignImage = loadImage("https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/40b97e58613507.5a02e49b918b1.jpg");
	// caterpillars:
	// https://www.researchgate.net/profile/Mark-Williams-49/publication/290193055/figure/fig7/AS:614287072563200@1523468859101/8-Structure-of-larva-or-caterpillar-of-a-butterfly-of-the-family-Lycaenidae.png
	bacteriumDesignImage = loadImage("friendly-bacterium.png");
}

function draw() {
  if (play) {
    // backgroundColor = color(random(255), random(255), random(255));
    backgroundColor = 255;
    background(backgroundColor);
    // rowCount = int(random(1, 6));
	rowCount = 4;
    rowHeight = int(windowHeight / rowCount);
    columnCount = int(((windowWidth > windowHeight) ? 1.5 : 0.75) * rowCount);
    columnWidth = int(windowWidth / columnCount);

    for (let rowIndex = 0; rowIndex < rowCount; rowIndex++) {
      for (let columnIndex = 0; columnIndex < columnCount; columnIndex++) {
        push();

		translate(columnIndex * columnWidth, rowIndex * rowHeight);

		if (rotationActive) {
  			rotate(random(TWO_PI));
  		}

		if (!designModeActive) {
		  if (mode == BUTTERFLY_MODE) {
			new Butterfly(false, null, columnWidth, rowHeight).draw();
		  }
          else if (mode == BEETLE_MODE) {
            new Beetle(false, null, columnWidth, rowHeight).draw();
          }
          else if (mode == LADYBUG_MODE) {
            new Ladybug(false, null, columnWidth, rowHeight).draw();
          }
          else if (mode == BACTERIUM_MODE) {
            new Bacterium(false, null, columnWidth, rowHeight).draw();
          }
		}
        else {
          if (mode == BUTTERFLY_MODE) {
            new Butterfly(true, butterflyImage, columnWidth, rowHeight).draw();
          }
          else if (mode == BEETLE_MODE) {
            new Beetle(true, beetleDesignImage, columnWidth, rowHeight).draw();
          }
          else if (mode == LADYBUG_MODE) {
            new Ladybug(true, ladybugDesignImage, columnWidth, rowHeight).draw();
          }
          else if (mode == BACTERIUM_MODE) {
            new Bacterium(true, bacteriumDesignImage, columnWidth, rowHeight).draw();
          }

          this.designAnimal.draw();
        }

        pop();
      }
    }

    play = false;
  }
}

function touchStarted() {
  if (!play) {
    play = true;
  }
}

function mousePressed() {
  if (mouseButton == LEFT) {
    this.designAnimal.addPoint(new p5.Vector(mouseX, mouseY));
  }
  else if (mouseButton == RIGHT) {
    this.designAnimal.removeLastPoint();
  }

	if (!play) {
    play = true;
  }
}

function keyPressed() {
  if (key == 'm' || key == 'M') {
		mode = modes[(modes.indexOf(mode) + 1) % modes.length];
  }
  else if (key == 'r' || key == 'R') {
	  rotationActive = !rotationActive;
  }
  else if (key == 'd' || key == 'D') {
    designModeActive = !designModeActive;
  }
  else if (key == 'c' || key == 'C') {
    this.designAnimal.toggleDesignPointsClosed();
  }
  else if (key == 'l' || key == 'L') {
    this.designAnimal.printDesignPoints();
  }

	if (!play) {
    play = true;
  }
}

function deviceTurned() {
  play = true;
  setup();
}
