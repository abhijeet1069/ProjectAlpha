import Vector3D from './vector3D.js'

class Mover{
    constructor(initX, initY){
        this.position = new Vector3D(); //z value is automatically assigned to 0
        this.position.x = initX || canvas.width/2;
        this.position.y = initY || canvas.height/2;
        this.velocity = new Vector3D(0,0);
        this.acceleration = new Vector3D(0,0);
        this.mass = 1;
        this.radius = 16;
    }

    applyForce(force){
        let f = force.mult(1/this.mass); //larger the mass, smaller the force
        this.acceleration = this.acceleration.add(f);
    }

    update(){    
        this.velocity = this.velocity.add(this.acceleration);
        this.position = this.position.add(this.velocity);
        this.acceleration = this.acceleration.mult(0); //clear acceleration in each frame
    }

    checkEdges(){
        // Bounce variable to simulate an inelastic collision(-0.9)
        let bounce = -1;
        if (this.position.x > canvas.width - this.radius) {
            this.position.x = canvas.width - this.radius;
            this.velocity.x *= bounce;
        } 
        else if (this.position.x < this.radius) {
            this.position.x = this.radius;
            this.velocity.x *= bounce;
        }
        if (this.position.y > canvas.height - this.radius) {
            this.position.y = canvas.height - this.radius;
            this.velocity.y *= bounce;
        }
    }

    display(){
        ctx.fillStyle='red';
        ctx.beginPath();
        ctx.ellipse(this.position.x,this.position.y,this.mass*16,this.mass*this.radius,0,0,Math.PI*2);
        ctx.closePath();
        ctx.fill();
        //ctx.stroke();
    }
}

//global variables
var canvas; //get canvas element
var ctx; //get 2D context
var mover = []; 
const moverCount = 1;

function main(){
    canvas = document.getElementById("myCanvas");
    ctx = canvas.getContext("2d");
    for(let i = 0; i < moverCount; i++){
        mover[i] = new Mover(i*(canvas.width/moverCount),30);
    }
    draw();
}

function draw(){
    ctx.clearRect(0,0,canvas.width,canvas.height); //background(255);
    for(let i = 0; i < moverCount; i++){
        let wind = new Vector3D(0.1,0.1);
        let gravity = new Vector3D(0,0.1*mover[i].mass); //gravitational force depends of object's mass
        mover[i].applyForce(wind);
        mover[i].applyForce(gravity);
        mover[i].update();
        mover[i].display();
        mover[i].checkEdges();
    }
    //console.log(mover[0].velocity.toString())
    requestAnimationFrame(draw);
}


main();
