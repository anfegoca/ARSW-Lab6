function setup() {
    createCanvas(640, 480);
}

function draw() {
    if (mouseIsPressed === true) {
        fill(0, 0, 0);
        ellipse(mouseX, mouseY, 20, 20);
    }
    if (mouseIsPressed === false) {
        fill(255, 255, 255);
    }
}

