var palabra= "Tulipa gesneriana";
var pos = 0;
var restartDelay = 5;

let img; // Declare variable 'img'.
let img2; // Declare variable 'img'.

function setup() {
  createCanvas(1262*5, 2288);
	frameRate(2);
  img = loadImage('Tulix_Color.png'); // Load the image
  img2 = loadImage('Tulix_Greyscale.png'); // Load the image

}

function draw() {
  // Displays the image at its actual size at point (0,0)
	background(70);
  image(img, 0, 0, 1262, 2288);
	image(img2, 1263, 0, 1262, 2288);
	image(img, 2526, 0, 1262, 2288);
	image(img2, 3789, 0, 1262, 2288);
	image(img, 5052, 0, 1262, 2288);

	textFont('Georgia');
	textSize(700);
	fill(255, 255, 255);
	//text('Tulipa gesneriana', 300, 600);
 	text(palabra.substring(0, pos + 1), 300, 1005);

	pos++;


}
