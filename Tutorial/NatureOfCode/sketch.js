
let x = 100;
let y = 100;

let xspeed = 2.5;
let yspeed = 2;
let radius = 48;

function setup(){
    var width = 800;
    var height = 600;
    createCanvas(width,height);
}

function draw(){
    background(51);
    
    // new location = velocity applied to current location
    x += xspeed;
    y += yspeed;

    if((x+radius/2 > width) || (x-radius/2 < 0)){ //radius is for end of ball to touch the edge and canvas and bounce back
        xspeed *= -1;
    }

    if((y+radius/2 > height) || (y-radius/2 < 0)){
        yspeed *= -1;
    }

    stroke(0);
    strokeWeight(2);
    fill(127);

    ellipse(x,y,radius,radius);
}


