function dolime() {
  var dd1 = document.getElementById("d1");
  dd1.style.backgroundColor = "lime";
}
function doyellow() {
  var dd1 = document.getElementById("d1");
  dd1.style.backgroundColor = "white";
  var ctx = dd1.getContext("2d");
  ctx.fillStyle = "yellow";
  ctx.fillRect(10, 10, 40, 40);
  ctx.fillRect(60, 10, 40, 40);
  ctx.fillStyle = "black";
  ctx.font = "30px Arial";
  ctx.fillText("Hello", 10, 80);
}

function dochangecolor() {
  var dd1 = document.getElementById("d1");
  var dd2 = document.getElementById("d2");
  //var btn1 = document.getElementById("b1");
  if (dd1.style.backgroundColor == "orange") {
    dd1.style.backgroundColor="fuchsia";
    dd2.style.backgroundColor="orange";
    //dd1.className = "yellowblock";
    //dd2.className = "blueblock";
    //dd1.style.color="fuchsia";
    //dd2.style.color="black";
    //dd1.innerHTML = "Hello";
    //dd2.innerHTML = "Goodbye";
    //b1.value="Tekst 2 (change color)";
  } else {
    dd1.style.backgroundColor="orange";
    dd2.style.backgroundColor="fuchsia";
    //dd1.className = "blueblock";
    //dd2.className = "yellowblock";
    //dd1.style.color="orange";
    //dd2.style.color="fuchsia";
    //dd1.innerHTML = "Hoi";
    //dd2.innerHTML = "Doei";
    //b1.value="Tekst 1 (change color)";
  }
}
function doclear() {
  var dd1 = document.getElementById("d1");
  var ctx = dd1.getContext("2d");
  ctx.clearRect(0,0,dd1.width,dd1.height);
}

function docolor(){
  var dd1=document.getElementById("d1");
  var colorinput=document.getElementById("clr");
  var color = colorinput.value;
  d1.style.backgroundColor=color;
}
function docolor2(){
  var dd2=document.getElementById("d2");
  var colorinput=document.getElementById("clr");
  var color = colorinput.value;
  d2.style.backgroundColor=color;
}
function dosquare(){
  var dd2=document.getElementById("d2");
  var ctx = dd2.getContext("2d");
  var squaresize=document.getElementById("sldr");
  var sizeinput = squaresize.value;
  ctx.fillStyle="yellow";
  ctx.clearRect(0,0,dd2.width,dd2.height);
  ctx.fillRect(10, 10, sizeinput, sizeinput);
}