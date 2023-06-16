import Vector3D from './vector3D.js'
import {getRandomInteger} from './helper.js'

/**
A force is a vector that causes an object with mass to accelerate.

Newton's Law of Motion:
    Newton's first law:
    An object at rest stays at rest and an object in motion stays in motion.
        In our processing world, An object's PVector velocity will remain constant if it is in a
    state of equilibrium.

    Newton's second law:
        Force equals mass times acceleration.

    Newton's third law:
    For every action there is an equal and opposite reaction.
        If we calculate a PVector f that is a force of object A on object B, we must also
    apply the force PVector.mult(f,-1) that B exerts on object A.

    Mass - It is a measure of the amount of matter in the object. Measured in KG
    Weight - Force of gravity on an object. Measured in Newtons.
    Density - Amount of mass per unit of volume. Measured in grams per centimeter.

    In the world of Processing,
    Assumption : Suppose, all our objects have a mass equal to 1.
    So, F = ma , Vector F = Vector a
 */

class Mover{
    constructor(initX, initY){
        this.location = new Vector3D(); //z value is automatically assigned to 0
        this.location.x = initX || canvas.width/2;
        this.location.y = initY || canvas.height/2;
        this.velocity = new Vector3D(0,0);
        this.acceleration = new Vector3D(0,0);
        this.mass = 1;
    }

    applyForce(force){
        let f = force.mult(1/this.mass); //larger the mass, smaller the force
        this.acceleration = this.acceleration.add(f);
    }

    update(){    
        this.velocity = this.velocity.add(this.acceleration);
        this.location = this.location.add(this.velocity);
        this.acceleration = this.acceleration.mult(0); //clear acceleration in each frame
    }

    checkEdges(){
        if(this.location.x > canvas.width || this.location.x < 0){
            this.velocity.x = this.velocity.x * -1;
        }
        if(this.location.y> canvas.height || this.location.y< 0){
            this.velocity.y = this.velocity.y * -1;
        }
    }

    display(){
        ctx.fillStyle='red';
        ctx.beginPath();
        ctx.ellipse(this.location.x,this.location.y,this.mass*16,this.mass*16,0,0,Math.PI*2);
        ctx.closePath();
        ctx.fill();
        //ctx.stroke();
    }
}

//global variables
var canvas; //get canvas element
var ctx; //get 2D context
var mover1;
var mover2; 

function main(){
    canvas = document.getElementById("myCanvas");
    ctx = canvas.getContext("2d");
    mover1 = new Mover();
    draw();
}

function draw(){
    ctx.clearRect(0,0,canvas.width,canvas.height); //background(255);
    let wind = new Vector3D(0.1,0.1);
    let gravity = new Vector3D(0,0.1*mover1.mass); //gravitational force depends of object's mass
    mover1.applyForce(wind);
    mover1.applyForce(gravity);

    mover1.update();
    mover1.display();
    mover1.checkEdges();
    requestAnimationFrame(draw);
}


main();
