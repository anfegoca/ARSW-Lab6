function setup() {
    createCanvas(640, 480);
}
const component = new StatusComponent(props);

function draw() {
    if (mouseIsPressed === true) {
        fill(0, 0, 0);
        addPoint(mouseX,mouseY);
        //ellipse(mouseX, mouseY, 20, 20);
    }
    if (mouseIsPressed === false) {
        fill(255, 255, 255);
    }
}

