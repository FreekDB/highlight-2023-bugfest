class Bacterium extends Animal {
  constructor(designModeActive, designImage, columnWidth, rowHeight) {
		super();

    this.designModeActive = designModeActive;
		this.designImage = designImage;
    this.columnWidth = columnWidth;
    this.rowHeight = rowHeight;

    this.bacteriumPoints = [];

		this.colorBlack = color(0);
    this.colorRed = color(231, 24, 9);
		this.colorOrange = color(255, 165, 0);
		this.colorYellow = color(255, 231, 0);
		this.colors = [this.colorRed, this.colorOrange, this.colorYellow];
	}

  initializePoints() {
    this.bacteriumPoints = [
      [
        // Body points.
				new p5.Vector(0.34 * columnWidth, 0.40 * rowHeight),
				new p5.Vector(0.42 * columnWidth, 0.66 * rowHeight),
				new p5.Vector(0.50 * columnWidth, 0.74 * rowHeight),
				new p5.Vector(0.56 * columnWidth, 0.75 * rowHeight),
				new p5.Vector(0.63 * columnWidth, 0.70 * rowHeight),
				new p5.Vector(0.66 * columnWidth, 0.58 * rowHeight),
				new p5.Vector(0.62 * columnWidth, 0.47 * rowHeight),
				new p5.Vector(0.56 * columnWidth, 0.31 * rowHeight),
				new p5.Vector(0.50 * columnWidth, 0.25 * rowHeight),
				new p5.Vector(0.44 * columnWidth, 0.24 * rowHeight),
				new p5.Vector(0.38 * columnWidth, 0.26 * rowHeight),
				new p5.Vector(0.35 * columnWidth, 0.32 * rowHeight),
				new p5.Vector(0.33 * columnWidth, 0.40 * rowHeight),
      ],
			[
				new p5.Vector(0.34 * columnWidth, 0.40 * rowHeight),
				new p5.Vector(0.29 * columnWidth, 0.38 * rowHeight),
				new p5.Vector(0.24 * columnWidth, 0.38 * rowHeight),
				new p5.Vector(0.20 * columnWidth, 0.39 * rowHeight),
				new p5.Vector(0.16 * columnWidth, 0.37 * rowHeight),
				new p5.Vector(0.14 * columnWidth, 0.35 * rowHeight),
			],
			[
				new p5.Vector(0.38 * columnWidth, 0.56 * rowHeight),
				new p5.Vector(0.34 * columnWidth, 0.54 * rowHeight),
				new p5.Vector(0.29 * columnWidth, 0.58 * rowHeight),
				new p5.Vector(0.24 * columnWidth, 0.61 * rowHeight),
				new p5.Vector(0.19 * columnWidth, 0.61 * rowHeight),
			],
			[
				new p5.Vector(0.59 * columnWidth, 0.35 * rowHeight),
				new p5.Vector(0.63 * columnWidth, 0.32 * rowHeight),
				new p5.Vector(0.69 * columnWidth, 0.31 * rowHeight),
				new p5.Vector(0.73 * columnWidth, 0.33 * rowHeight),
				new p5.Vector(0.76 * columnWidth, 0.31 * rowHeight),
				new p5.Vector(0.78 * columnWidth, 0.26 * rowHeight),
			],
			[
				new p5.Vector(0.64 * columnWidth, 0.49 * rowHeight),
				new p5.Vector(0.69 * columnWidth, 0.50 * rowHeight),
				new p5.Vector(0.74 * columnWidth, 0.49 * rowHeight),
				new p5.Vector(0.78 * columnWidth, 0.49 * rowHeight),
				new p5.Vector(0.86 * columnWidth, 0.51 * rowHeight),
			],
    ];
  }

  draw() {
    if (this.designModeActive) {
      image(this.designImage, this.columnWidth / 2, this.rowHeight / 2, this.columnWidth, this.rowHeight);
    }
    else {
      this.initializePoints();
      this.randomizePoints(this.bacteriumPoints, 0.02);

      // Draw the body.

      fill(this.colors[int(random(this.colors.length))]);

      this.drawShape(this.bacteriumPoints[0], this.LEFT_SIDE, CLOSE);
      // this.drawShape(this.bacteriumPoints[0], this.RIGHT_SIDE, CLOSE);

      // Draw the legs.
      stroke(0);
      strokeWeight(1);
      fill(255);

			for (let legIndex = 0; legIndex < 4; legIndex++) {
        this.drawShape(this.bacteriumPoints[legIndex + 1], this.LEFT_SIDE, CLOSE);
        // this.drawShape(this.bacteriumPoints[legIndex + 1], this.RIGHT_SIDE, CLOSE);
			}
		}
  }
}
