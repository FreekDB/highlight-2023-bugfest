let shape = 0;
function draw() {
background(255);

createCanvas(windowWidth, windowHeight);

for (let i = 0; i < windowHeight; i = i+10) {
for (let x = 0; x < windowWidth; x = x+10) {
fill(0,0,random(200,200));

if (shape ==0){
stroke(0,0,200);
line(x, i, x, i);
}
if (shape ==1){
ellipse(x, i, random(10,20),10);
}

if (shape ==2){
ellipse(x, i, random(1,20),random(1,20));
}
}
}

console.log(shape);
}

function mousePressed() {
shape=shape+1;
//background(240, 0, 0);
if (shape ==3){
shape = 0;
}
}
