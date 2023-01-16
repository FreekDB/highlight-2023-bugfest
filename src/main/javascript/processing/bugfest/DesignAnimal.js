class DesignAnimal extends Animal {
  constructor() {  // designModeActive, designImage, columnWidth, rowHeight) {
    super();

		this.designPoints = [];
		this.designPointsClosed = false;
	}

	addPoint(point) {
		this.designPoints.push(point);
	}

	removeLastPoint() {
		this.designPoints.pop();
	}

	toggleDesignPointsClosed() {
		this.designPointsClosed = !this.designPointsClosed;
	}

  // For the design mode, use row count 4 (for standardized sizes).
	draw() {
		for (let pointIndex = 0; pointIndex < this.designPoints.length; pointIndex++) {
			circle(this.designPoints[pointIndex].x, this.designPoints[pointIndex].y, 4);
		}

		if (this.designPoints.length >= 3) {
			if (this.designPointsClosed) {
				this.drawShape(this.designPoints, this.LEFT_SIDE, CLOSE);
			}
			else {
				this.drawShape(this.designPoints, this.LEFT_SIDE);
			}
		}
	}

  printDesignPoints() {
    for (let pointIndex = 0; pointIndex < this.designPoints.length; pointIndex++) {
      console.log("new p5.Vector(" + (this.designPoints[pointIndex].x / columnWidth).toFixed(2) + " * columnWidth, " +
                  (this.designPoints[pointIndex].y / rowHeight).toFixed(2) + " * rowHeight),");
    }
	}
}
