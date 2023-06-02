
function setup(){
    canvas = document.getElementById("myCanvas");
    ctx = canvas.getContext("2d");
    draw(ctx);
}

function draw(){
    ctx.clearRect(0,0,canvas.width,canvas.height);
    ctx.fillStyle="#FF0000";
    ctx.fillRect(50,50,50,50);
    requestAnimationFrame(draw);
}

var canvas;
var ctx;
setup();

vect = new Vector2D(4,2);
console.log(vect.x);