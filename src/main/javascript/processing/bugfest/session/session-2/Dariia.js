var i = 0;
function setup() {
  createCanvas(1400, 800);
  smooth(10);
}

function draw() {
  background(100, 100, 100);
  stroke(2);
  drawBug(i);

  drawBug(i+20);

  drawBug(i-120);
  stroke(40);
  drawBug(i/2);
  stroke(02);
  drawBug(i*2);

  if (i < width && frameCount % 10 == 0) {
    i+=20;
  } else {
    //i--;
  }
}

function drawBug(i) {
  rotate(i);
  arc(698, 480, 50, 300, HALF_PI, PI);
  arc(701, 480, 50, 300, 0, HALF_PI);
  rect(670.5, 445, 60, 30, 20, 20, 20, 20);
  rect(670.5, 412, 60, 30, 20, 20, 20, 20);
  quad(666, 380, 686, 409, 714.5, 409, 734.5, 380);
  arc(700, 376, 50, 50, PI, TWO_PI);
}
