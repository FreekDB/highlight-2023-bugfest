class Beetle extends Animal {
  constructor(designModeActive, designImage, columnWidth, rowHeight) {
    super();

    this.designModeActive = designModeActive;
    this.designImage = designImage;
    this.columnWidth = columnWidth;
    this.rowHeight = rowHeight;

    this.beetlePoints = [];
  }

  initializePoints() {
    this.beetlePoints = [
      [
        // Body points.
        new p5.Vector(0.50 * this.columnWidth, 0.57 * this.rowHeight),
        new p5.Vector(0.47 * this.columnWidth, 0.55 * this.rowHeight),
        new p5.Vector(0.45 * this.columnWidth, 0.45 * this.rowHeight),
        new p5.Vector(0.46 * this.columnWidth, 0.42 * this.rowHeight),
        new p5.Vector(0.48 * this.columnWidth, 0.39 * this.rowHeight),
        new p5.Vector(0.50 * this.columnWidth, 0.40 * this.rowHeight),
        new p5.Vector(0.50 * this.columnWidth, 0.57 * this.rowHeight),
      ],
      [
        // Head points.
        new p5.Vector(0.50 * this.columnWidth, 0.40 * this.rowHeight),
        new p5.Vector(0.48 * this.columnWidth, 0.38 * this.rowHeight),
        new p5.Vector(0.48 * this.columnWidth, 0.35 * this.rowHeight),
        new p5.Vector(0.50 * this.columnWidth, 0.34 * this.rowHeight),
        new p5.Vector(0.50 * this.columnWidth, 0.33 * this.rowHeight),
        new p5.Vector(0.50 * this.columnWidth, 0.39 * this.rowHeight),
      ],
      [
        // Antenna points.
        new p5.Vector(0.48 * this.columnWidth, 0.34 * this.rowHeight),
        new p5.Vector(0.46 * this.columnWidth, 0.26 * this.rowHeight),
        new p5.Vector(0.45 * this.columnWidth, 0.23 * this.rowHeight),
        new p5.Vector(0.44 * this.columnWidth, 0.20 * this.rowHeight),
      ],
      [
        // Hindleg points.
        new p5.Vector(0.47 * this.columnWidth, 0.56 * this.rowHeight),
        new p5.Vector(0.46 * this.columnWidth, 0.61 * this.rowHeight),
        new p5.Vector(0.43 * this.columnWidth, 0.64 * this.rowHeight),
        new p5.Vector(0.41 * this.columnWidth, 0.66 * this.rowHeight),
      ],
      [
        // Middleleg points.
        new p5.Vector(0.45 * this.columnWidth, 0.46 * this.rowHeight),
        new p5.Vector(0.43 * this.columnWidth, 0.48 * this.rowHeight),
        new p5.Vector(0.40 * this.columnWidth, 0.49 * this.rowHeight),
        new p5.Vector(0.38 * this.columnWidth, 0.51 * this.rowHeight),
      ],
      [
        // Foreleg points.
        new p5.Vector(0.46 * this.columnWidth, 0.42 * this.rowHeight),
        new p5.Vector(0.46 * this.columnWidth, 0.36 * this.rowHeight),
        new p5.Vector(0.43 * this.columnWidth, 0.31 * this.rowHeight),
        new p5.Vector(0.41 * this.columnWidth, 0.27 * this.rowHeight),
      ],
    ];
  }

  draw() {
    if (this.designModeActive) {
      image(this.designImage, this.columnWidth / 2, this.rowHeight / 2, this.columnWidth, this.rowHeight);
    }
    else {
      this.initializePoints();

			for (let partIndex = 0; partIndex < this.beetlePoints.length; partIndex++) {
				for (let pointIndex = 0; pointIndex < this.beetlePoints[partIndex].length; pointIndex++) {
					let newX = 2 / 2 * this.beetlePoints[partIndex][pointIndex].x;
					let newY = 2 / 2 * this.beetlePoints[partIndex][pointIndex].y;
					this.beetlePoints[partIndex][pointIndex] = new p5.Vector(newX, newY);
				}
			}

      this.randomizePoints(this.beetlePoints, 0.02);

      // Draw the body.

			// fill(81, 226, 191);
			// fill(colors[random(colors.length)]);
			fill(color(random(255), random(255), random(255)));

			this.drawShape(this.beetlePoints[0], this.LEFT_SIDE, CLOSE);
			this.drawShape(this.beetlePoints[0], this.RIGHT_SIDE, CLOSE);

			// Draw the head.
			fill(color(random(255), random(255), random(255)));

			this.drawShape(this.beetlePoints[1], this.LEFT_SIDE, CLOSE);
			this.drawShape(this.beetlePoints[1], this.RIGHT_SIDE, CLOSE);

			fill(backgroundColor);

			// Draw the antenna.
			this.drawShape(this.beetlePoints[2], this.LEFT_SIDE, CLOSE);
			this.drawShape(this.beetlePoints[2], this.RIGHT_SIDE, CLOSE);

			// Draw the hindlegs.
			this.drawShape(this.beetlePoints[3], this.LEFT_SIDE);
			this.drawShape(this.beetlePoints[3], this.RIGHT_SIDE);

			// Draw the middlelegs.
			this.drawShape(this.beetlePoints[4], this.LEFT_SIDE);
			this.drawShape(this.beetlePoints[4], this.RIGHT_SIDE);

			// Draw the forelegs.
			this.drawShape(this.beetlePoints[5], this.LEFT_SIDE);
			this.drawShape(this.beetlePoints[5], this.RIGHT_SIDE);
    }
  }
}
