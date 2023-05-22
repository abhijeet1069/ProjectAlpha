var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");
var buffer = ctx.getImageData(0,0,canvas.clientWidth,canvas.height);

console.log(buffer);