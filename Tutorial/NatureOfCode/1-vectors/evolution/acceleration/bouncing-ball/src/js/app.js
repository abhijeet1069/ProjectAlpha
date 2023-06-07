import Vector3D from './vector3D.js'
import {getRandomInteger} from './helper.js'

/*
Vector Motion : 
Acceleration is the rate of change of velocity.

Acceleration Algorithms:
    A constant acceleration
    A totally random acceleration
    Acceleration towards the mouse

*/

class Mover{
    constructor(){
        this.location = new Vector3D(canvas.width/2,canvas.height/2); //z value is automatically assigned to 0
        this.velocity = new Vector3D();
        this.acceleration = new Vector3D();
        this.radius = 10;
        this.topSpeed = 5;
    }

    update(){
        var dir =  mouse.sub(this.location);
        this.acceleration = dir.unit();
        this.acceleration = this.acceleration.mult(0.2);
        
        this.velocity = this.velocity.add(this.acceleration);
        this.velocity = this.velocity.limit(this.topSpeed);
       // console.log(this.velocity.toString());
        this.location = this.location.add(this.velocity);
    }

    checkEdges(){
        if(this.location.x+this.radius > canvas.width || this.location.x-this.radius < 0){
            this.velocity.x = this.velocity.x * -1;
        }
        if(this.location.y+this.radius > canvas.height || this.location.y-this.radius < 0){
            this.velocity.y = this.velocity.y * -1;
        }
    }

    display(){
        ctx.fillStyle='red';
        ctx.beginPath();
        ctx.ellipse(this.location.x,this.location.y,this.radius,this.radius,0,0,Math.PI*2);
        ctx.closePath();
        ctx.fill();
        //ctx.stroke();
    }
}

//global variables
var canvas; //get canvas element
var ctx; //get 2D context
var location; //2D vector for location
var velocity; //2D vector for velocity
var mover;
var mouse = new Vector3D(); //to prevent 

function getMouseCoordinates(event){
    const rect = canvas.getBoundingClientRect();
    const mouseX = event.clientX - rect.left;
    const mouseY = event.clientY - rect.top;
    return new Vector3D(mouseX,mouseY);
}

function main(){
    canvas = document.getElementById("myCanvas");
    ctx = canvas.getContext("2d");
    canvas.addEventListener('mousemove',function(event){
        mouse = getMouseCoordinates(event);
    });
    mover = new Mover();
    draw();
}

function draw(){
    ctx.clearRect(0,0,canvas.width,canvas.height); //background(255);
    mover.update();
    //mover.checkEdges();
    mover.display();
    requestAnimationFrame(draw);
}


main();
