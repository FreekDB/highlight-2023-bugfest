class Butterfly extends Animal {
  constructor(designModeActive, designImage, columnWidth, rowHeight) {
    super();

    this.designModeActive = designModeActive;
    this.designImage = designImage;
    this.columnWidth = columnWidth;
    this.rowHeight = rowHeight;

  	this.RANDOM_RANGE = 0.3;
		this.COLOR_COUNT = 8;

		this.butterflyPoints = [];
		this.layerPoints = [];
		this.innerPoints = [];
		this.innerShapeCount = 6;
		this.middlePoint = new p5.Vector(0, 0);
		this.middleFactor = 0.3;
		this.colors = [];
		this.backgroundColor = color(0);
	}

  initialize() {
	  this.backgroundColor = color(random(255), random(255), random(255));
		this.middleFactor = random(0.1, 0.5);
		this.innerShapeCount = int(random(2, 10));

		this.colors = [];

		for (let colorIndex = 0; colorIndex < this.COLOR_COUNT; colorIndex++) {
			this.colors.push(color(random(255), random(255), random(255)));
		}

		this.butterflyPoints = [
			[
				// Body points.
				new p5.Vector(0.5 * this.columnWidth, 0.2 * this.rowHeight),
				new p5.Vector(0.45 * this.columnWidth, 0.5 * this.rowHeight),
				new p5.Vector(0.5 * this.columnWidth, 0.6 * this.rowHeight)
			],
			[
				// Lower wing.
				new p5.Vector(0.5 * this.columnWidth, 0.3 * this.rowHeight),
				new p5.Vector(0.45 * this.columnWidth, 0.6 * this.rowHeight),
				new p5.Vector(0.35 * this.columnWidth, 0.7 * this.rowHeight),
				new p5.Vector(0.25 * this.columnWidth, 0.5 * this.rowHeight)
			],
			[
				// Upper wing.
				new p5.Vector(this.columnWidth / 2, this.rowHeight / 3),
				new p5.Vector(this.columnWidth / 2.5, this.rowHeight / 6),
				new p5.Vector(this.columnWidth / 4, this.rowHeight / 9),
				new p5.Vector(this.columnWidth / 9, this.rowHeight / 7),
				new p5.Vector(this.columnWidth / 6, this.rowHeight / 3),
				new p5.Vector(this.columnWidth / 4, this.rowHeight / 2)
			],
			[
				// Antenna points.
				new p5.Vector(this.columnWidth / 2, 0.2 * this.rowHeight),
				new p5.Vector(this.columnWidth / 2.1, 0.01 * this.rowHeight),
				new p5.Vector(this.columnWidth / 2.3, 0.01 * this.rowHeight)
			]
		];
	}

  draw() {
    if (this.designModeActive) {
      image(this.designImage, this.columnWidth / 2, this.rowHeight / 2, this.columnWidth, this.rowHeight);
    }
    else {
      this.initialize();
      this.randomizePoints(this.butterflyPoints, this.RANDOM_RANGE);

			fill(this.colors[0]);

			// Draw the head.
			ellipse(this.columnWidth / 2.03, this.rowHeight / 5, 0.1 * this.rowHeight, 0.1 * this.rowHeight);
			ellipse(this.columnWidth / 1.97, this.rowHeight / 5, 0.1 * this.rowHeight, 0.1 * this.rowHeight);

			for (let layerIndex = 0; layerIndex < this.butterflyPoints.length - 1; layerIndex++) {
				// Copy butterflyPoints to layerPoints and calculate the center position.
				this.layerPoints = [];
				this.middlePoint = new p5.Vector(0, 0);

				for (let pointIndex = 0; pointIndex < this.butterflyPoints[layerIndex].length; pointIndex++) {
					this.layerPoints.push(this.butterflyPoints[layerIndex][pointIndex]);
					this.middlePoint.add(this.layerPoints[pointIndex]);
				}

				this.middlePoint.div(this.butterflyPoints[layerIndex].length);

				fill(this.colors[(3 * layerIndex) % this.COLOR_COUNT]);

				// Draw the outer edge of the left and right wings.
				this.drawShape(this.layerPoints, this.LEFT_SIDE, CLOSE);
				this.drawShape(this.layerPoints, this.RIGHT_SIDE, CLOSE);

				for (let innerShapeIndex = 0; innerShapeIndex < this.innerShapeCount; innerShapeIndex++) {
					let decorationPoints = [];
					this.innerPoints = [];

					for (let pointIndex = 0; pointIndex < this.layerPoints.length; pointIndex++) {
						decorationPoints.push(this.layerPoints[pointIndex]);
						this.innerPoints.push(this.mid(this.layerPoints[pointIndex], this.middlePoint, this.middleFactor));
						decorationPoints.push(this.innerPoints[pointIndex]);
					}

					fill(this.colors[(3 * layerIndex + innerShapeIndex) % this.COLOR_COUNT]);

					// Draw the internal decoration of the left and right wings.
					this.drawShape(decorationPoints, this.LEFT_SIDE, CLOSE);
					this.drawShape(decorationPoints, this.RIGHT_SIDE, CLOSE);

					this.layerPoints = this.innerPoints.slice();
				}

				let starPoints = [];

				for (let pointIndex = 0; pointIndex < this.innerPoints.length; pointIndex++) {
					starPoints.push(this.innerPoints[pointIndex]);
					starPoints.push(this.middlePoint);
				}

				// Draw the internal star shape of the left and right wings.
				this.drawShape(starPoints, this.LEFT_SIDE, CLOSE);
				this.drawShape(starPoints, this.RIGHT_SIDE, CLOSE);
			}

			let antennaPoints = [];

			for (let pointIndex = 0; pointIndex < this.butterflyPoints[this.butterflyPoints.length - 1].length; pointIndex++) {
				antennaPoints.push(this.butterflyPoints[this.butterflyPoints.length - 1][pointIndex]);
			}

			// Draw the left and right antenna.
			this.drawShape(antennaPoints, this.LEFT_SIDE);
			this.drawShape(antennaPoints, this.RIGHT_SIDE);
		}
	}

  randomizePoints(points, range) {
		for (let layerIndex = 0; layerIndex < points.length; layerIndex++) {
			for (let pointIndex = 1; pointIndex < points[layerIndex].length - 1; pointIndex++) {
				if (layerIndex != 0 || pointIndex != 3) {
					points[layerIndex][pointIndex] = this.randomizePoint(points[layerIndex][pointIndex], range);
				}
			}
		}
	}

	mid(vector1, vector2, factor) {
		return new p5.Vector(
			vector1.x + factor * (vector2.x - vector1.x),
			vector1.y + factor * (vector2.y - vector1.y)
		);
	}
}
