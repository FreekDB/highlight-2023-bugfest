function setup() {
    createCanvas(windowWidth, windowHeight);
    background(0,127,0);
    fill(0,196,0);

    //for (let i = 20; i >= 0; i--) {
    //    strokeWeight(2 + i);
    //    square(100,100,200 + i * 10);
    //}

    //var x = windowWidth / 3;
    //var y = (windowHeight / 3) * 2;
    //
    //for (let i = 0; i < 16; i++) {
    //    push();
    //    rotate((PI/1000) * i * 8);
    //    push();
    //    rotate((PI/1000) * i * 8 + PI/100);
    //    triangle(x - 100 + i * 5, y - i * 16,
    //                     x + 100 - i * 5, y - i * 16,
    //                     x              , y - i * 16 - 100);
    //    pop();
    //    pop();
    //}

    var x_step = 4;
    var a_step = PI / 256;

    for (let k = 0; k < 512; k++) {
        push();
        var x = random(0, windowWidth);
        var y = random(0, windowHeight);
        translate(x, y);
        rotate(random(0, 2 * PI));
        scale(random(0.16, 0.64));
        for (let i = 0; i < 32; i++) {
            push();
            translate(x_step * exp(i/10),
                                0 - i * 10);
            rotate(a_step * i);
            scale(1.0 - i * 0.03);
            triangle(-100, 100, 100, 100, 0, -100);
            pop();
        }
        pop();
    }
}

function draw() {
    //square(mouseX, mouseY, random(5, 155));
    //circle(mouseX+random(1,10), mouseY+random(1,10), random(5, 155));
    //line(windowWidth/2,windowHeight/2,mouseX,mouseY);
    //ellipse(mouseX,mouseY,random(5,50),random(5,50));

    //var x = mouseX;
    //var y = mouseY;
    //
    //for (let i = 0; i < 16; i++) {
    //    push();
    //    rotate((PI/1000) * i * 8 + PI/100);
    //    triangle(x - 100 + i * 5, y - i * 16,
    //                     x + 100 - i * 5, y - i * 16,
    //                     x              , y - i * 16 - 100);
    //    pop();
    //}
}
