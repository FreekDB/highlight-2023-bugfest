// This class contains some general fields and methods.

class Animal {
  constructor() {
		this.LEFT_SIDE = "left side";
		this.RIGHT_SIDE = "right side";
	}

	drawShape(points, side, shapeMode) {
    beginShape();

    // Do the first point twice.
    curveVertex(side == this.LEFT_SIDE ? points[0].x : this.columnWidth - points[0].x, points[0].y);

    for (let pointIndex = 0; pointIndex < points.length; pointIndex++) {
      curveVertex(side == this.LEFT_SIDE ? points[pointIndex].x : this.columnWidth - points[pointIndex].x, points[pointIndex].y);
    }

    if (shapeMode != undefined) {
      endShape(shapeMode);
    }
    else {
      endShape();
    }
  }

  randomizePoints(points, range) {
    for (let partIndex = 0; partIndex < points.length; partIndex++) {
      for (let pointIndex = 1; pointIndex < points[partIndex].length - 1; pointIndex++) {
        points[partIndex][pointIndex] = this.randomizePoint(points[partIndex][pointIndex], range);
      }
    }
  }

  randomizePoint(point, range) {
    return new p5.Vector(point.x * random(1 - range, 1 + range), point.y * random(1 - range, 1 + range));
  }
}
