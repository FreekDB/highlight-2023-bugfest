class Ladybug extends Animal {
  constructor(designModeActive, designImage, columnWidth, rowHeight) {
		super();

    this.designModeActive = designModeActive;
		this.designImage = designImage;
    this.columnWidth = columnWidth;
    this.rowHeight = rowHeight;

    this.ladybugPoints = [];

		this.colorBlack = color(0);
    this.colorRed = color(231, 24, 9);
		this.colorOrange = color(255, 165, 0);
		this.colorYellow = color(255, 231, 0);
		this.colors = [this.colorRed, this.colorOrange, this.colorYellow];
	}

  initializePoints() {
    this.ladybugPoints = [
      [
        // Body points.
        new p5.Vector(0.50 * this.columnWidth, 0.81 * this.rowHeight),
        new p5.Vector(0.37 * this.columnWidth, 0.75 * this.rowHeight),
        new p5.Vector(0.28 * this.columnWidth, 0.61 * this.rowHeight),
        new p5.Vector(0.26 * this.columnWidth, 0.51 * this.rowHeight),
        new p5.Vector(0.28 * this.columnWidth, 0.40 * this.rowHeight),
        new p5.Vector(0.33 * this.columnWidth, 0.29 * this.rowHeight),
        new p5.Vector(0.40 * this.columnWidth, 0.31 * this.rowHeight),
        new p5.Vector(0.50 * this.columnWidth, 0.32 * this.rowHeight),
      ],
      [
        // Head points.
        new p5.Vector(0.50 * this.columnWidth, 0.32 * this.rowHeight),
        new p5.Vector(0.42 * this.columnWidth, 0.31 * this.rowHeight),
        new p5.Vector(0.34 * this.columnWidth, 0.29 * this.rowHeight),
        new p5.Vector(0.38 * this.columnWidth, 0.22 * this.rowHeight),
        new p5.Vector(0.43 * this.columnWidth, 0.19 * this.rowHeight),
        new p5.Vector(0.47 * this.columnWidth, 0.17 * this.rowHeight),
        new p5.Vector(0.50 * this.columnWidth, 0.17 * this.rowHeight),
      ],
      [
        // Spot 1 points.
        new p5.Vector(0.27 * this.columnWidth, 0.44 * this.rowHeight),
        new p5.Vector(0.30 * this.columnWidth, 0.46 * this.rowHeight),
        new p5.Vector(0.30 * this.columnWidth, 0.51 * this.rowHeight),
        new p5.Vector(0.26 * this.columnWidth, 0.53 * this.rowHeight),
        new p5.Vector(0.27 * this.columnWidth, 0.48 * this.rowHeight),
      ],
      [
        // Spot 2 points.
        new p5.Vector(0.39 * this.columnWidth, 0.53 * this.rowHeight),
        new p5.Vector(0.42 * this.columnWidth, 0.54 * this.rowHeight),
        new p5.Vector(0.45 * this.columnWidth, 0.57 * this.rowHeight),
        new p5.Vector(0.45 * this.columnWidth, 0.61 * this.rowHeight),
        new p5.Vector(0.41 * this.columnWidth, 0.61 * this.rowHeight),
        new p5.Vector(0.38 * this.columnWidth, 0.58 * this.rowHeight),
        new p5.Vector(0.38 * this.columnWidth, 0.56 * this.rowHeight),
      ],
      [
        // Spot 3 points.
        new p5.Vector(0.50 * this.columnWidth, 0.34 * this.rowHeight),
        new p5.Vector(0.46 * this.columnWidth, 0.35 * this.rowHeight),
        new p5.Vector(0.43 * this.columnWidth, 0.39 * this.rowHeight),
        new p5.Vector(0.45 * this.columnWidth, 0.43 * this.rowHeight),
        new p5.Vector(0.48 * this.columnWidth, 0.45 * this.rowHeight),
        new p5.Vector(0.51 * this.columnWidth, 0.45 * this.rowHeight),
      ],
      [
        // Foreleg points.
        new p5.Vector(0.34 * this.columnWidth, 0.30 * this.rowHeight),
        new p5.Vector(0.31 * this.columnWidth, 0.28 * this.rowHeight),
        new p5.Vector(0.31 * this.columnWidth, 0.19 * this.rowHeight),
        new p5.Vector(0.23 * this.columnWidth, 0.12 * this.rowHeight),
        new p5.Vector(0.23 * this.columnWidth, 0.12 * this.rowHeight),
      ],
      [
        // Middleleg points.
        new p5.Vector(0.28 * this.columnWidth, 0.41 * this.rowHeight),
        new p5.Vector(0.22 * this.columnWidth, 0.50 * this.rowHeight),
        new p5.Vector(0.11 * this.columnWidth, 0.54 * this.rowHeight),
        new p5.Vector(0.11 * this.columnWidth, 0.54 * this.rowHeight),
      ],
      [
        // Hindleg points.
        new p5.Vector(0.28 * this.columnWidth, 0.62 * this.rowHeight),
        new p5.Vector(0.26 * this.columnWidth, 0.66 * this.rowHeight),
        new p5.Vector(0.29 * this.columnWidth, 0.73 * this.rowHeight),
        new p5.Vector(0.32 * this.columnWidth, 0.76 * this.rowHeight),
        new p5.Vector(0.21 * this.columnWidth, 0.88 * this.rowHeight),
        new p5.Vector(0.21 * this.columnWidth, 0.88 * this.rowHeight),
      ],
    ];
  }

  fun drawOrganism() {
    if (this.designModeActive) {
      image(this.designImage, this.columnWidth / 2, this.rowHeight / 2, this.columnWidth, this.rowHeight);
    }
    else {
      this.initializePoints();
      this.randomizePoints(this.ladybugPoints, 0.02);

      // Draw the body.

      fill(this.colors[int(random(this.colors.length))]);

      this.drawShape(this.ladybugPoints[0], this.LEFT_SIDE, CLOSE);
      this.drawShape(this.ladybugPoints[0], this.RIGHT_SIDE, CLOSE);

      // Draw the head.
      fill(0);

      this.drawShape(this.ladybugPoints[1], this.LEFT_SIDE, CLOSE);
      this.drawShape(this.ladybugPoints[1], this.RIGHT_SIDE, CLOSE);

      // Draw the spots.
      fill(this.colorBlack);

			for (let spotIndex = 0; spotIndex < 3; spotIndex++) {
				if (random() <= 0.6) {
					this.drawShape(this.ladybugPoints[spotIndex + 2], this.LEFT_SIDE, CLOSE);
					this.drawShape(this.ladybugPoints[spotIndex + 2], this.RIGHT_SIDE, CLOSE);
				}
			}

      // Draw the legs.
      stroke(0);
      strokeWeight(3);
      fill(255);

      this.drawShape(this.ladybugPoints[5], this.LEFT_SIDE);
      this.drawShape(this.ladybugPoints[5], this.RIGHT_SIDE);
      this.drawShape(this.ladybugPoints[6], this.LEFT_SIDE);
      this.drawShape(this.ladybugPoints[6], this.RIGHT_SIDE);
      this.drawShape(this.ladybugPoints[7], this.LEFT_SIDE);
      this.drawShape(this.ladybugPoints[7], this.RIGHT_SIDE);

      strokeWeight(1.5);
    }
  }
}
