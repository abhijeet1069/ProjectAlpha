const Vector3D = require('./vector3D');

var canvas; //get canvas element
var ctx; //get 2D context
var location; //2D vector for location
var velocity; //2D vector for velocity

function main(){
    canvas = document.getElementById("myCanvas");
    ctx = canvas.getContext("2d");
    location = new Vector3D(100,100,0);
    velocity = new Vector3D(2.5,5,0);
    console.log(location.x);
    //draw();
}

function draw(){
    ctx.clearRect(0,0,canvas.width,canvas.height); //background(255);
    
    requestAnimationFrame(draw);
}

main();