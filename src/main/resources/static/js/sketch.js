function setup() {
    createCanvas(1000, 1000);
}

function dibujo(p){
    if(p!==null){
    fill(0, 0, 0);
    ellipse(p.x, p.y, 20, 20);
}
    
}
function draw() {
    if (mouseIsPressed === true) {
        fill(0, 0, 0);
        //ellipse(mouseX, mouseY, 20, 20);
        StatusComponent.addPoint(mouseX,mouseY);
    }
    if (mouseIsPressed === false) {
        fill(255, 255, 255);
    }
}
function limpiar(){
    background(255,255,255);
}

