import Vector3D from './vector3D.js'

var canvas; //get canvas element
var ctx; //get 2D context
var location; //2D vector for location
var velocity; //2D vector for velocity

function main(){
    canvas = document.getElementById("myCanvas");
    ctx = canvas.getContext("2d");
    location = new Vector3D(100,100,0);
    velocity = new Vector3D(2.5,5,0);
    //console.log(location.x);
    draw();
}

function draw(){
    ctx.clearRect(0,0,canvas.width,canvas.height); //background(255);
    location = location.add(velocity);
    if(location.x > canvas.width || location.x < 0){
        velocity.x = velocity.x * -1;
    }
    if(location.y > canvas.height || location.y < 0){
        velocity.y = velocity.y * -1;
    }
    ctx.beginPath();
    ctx.ellipse(location.x,location.y,10,10,0,0,Math.PI*2);
    ctx.stroke();

    requestAnimationFrame(draw);
}

main();