import Vector3D from './vector3D.js'
import {getRandomInteger} from './helper.js'

/*
Motion 101
    1. Add velocity to location
    2. Draw object at location

*/

class Mover{
    constructor(){
        this.location = new Vector3D(getRandomInteger(0,canvas.width),getRandomInteger(0,canvas.height),0);
        this.velocity = new Vector3D(1,2,0);
    }

    update(){
        this.location = this.location.add(this.velocity);
    }

    checkEdges(){
        if(this.location.x > canvas.width || this.location.x < 0){
            this.velocity.x = this.velocity.x * -1;
        }
        if(this.location.y > canvas.height || this.location.y < 0){
            this.velocity.y = this.velocity.y * -1;
        }
    }

    display(){
        ctx.fillStyle='red';
        ctx.beginPath();
        ctx.ellipse(this.location.x,this.location.y,10,10,0,0,Math.PI*2);
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

function main(){
    canvas = document.getElementById("myCanvas");
    ctx = canvas.getContext("2d");
    mover = new Mover()
    //console.log(location.x);
    draw();
}

function draw(){
    ctx.clearRect(0,0,canvas.width,canvas.height); //background(255);
    mover.update();
    mover.checkEdges();
    mover.display();
    requestAnimationFrame(draw);
}

main();