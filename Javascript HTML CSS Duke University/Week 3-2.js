var image = null;
var imagegrey = null;
var imagefg = null;
var imagebg = null;

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
    dd1.style.backgroundColor = "fuchsia";
    dd2.style.backgroundColor = "orange";
    //dd1.className = "yellowblock";
    //dd2.className = "blueblock";
    //dd1.style.color="fuchsia";
    //dd2.style.color="black";
    //dd1.innerHTML = "Hello";
    //dd2.innerHTML = "Goodbye";
    //b1.value="Tekst 2 (change color)";
  } else {
    dd1.style.backgroundColor = "orange";
    dd2.style.backgroundColor = "fuchsia";
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
  ctx.clearRect(0, 0, dd1.width, dd1.height);
}

function docolor() {
  var dd1 = document.getElementById("d1");
  var colorinput = document.getElementById("clr");
  var color = colorinput.value;
  d1.style.backgroundColor = color;
}
function docolor2() {
  var dd2 = document.getElementById("d2");
  var colorinput = document.getElementById("clr");
  var color = colorinput.value;
  d2.style.backgroundColor = color;
}
function dosquare() {
  var dd2 = document.getElementById("d2");
  var ctx = dd2.getContext("2d");
  var squaresize = document.getElementById("sldr");
  var sizeinput = squaresize.value;
  ctx.fillStyle = "yellow";
  ctx.clearRect(0, 0, dd2.width, dd2.height);
  ctx.fillRect(10, 10, sizeinput, sizeinput);
}
function upload() {
  var imgcanvas = document.getElementById("can");
  var fileinput = document.getElementById("finput");
  image = new SimpleImage(fileinput);
  image.drawTo(imgcanvas);
  imagegrey = image;
}
function makeGrey() {
  for (var pxl of imagegrey.values()) {
    var avg = (pxl.getRed() + pxl.getGreen() + pxl.getBlue()) / 3;
    pxl.setRed(avg);
    pxl.setGreen(avg);
    pxl.setBlue(avg);
  }
  var imgcanvas = document.getElementById("cangrey");
  imagegrey.drawTo(imgcanvas);
}
function uploadfg() {
  var imgcanvas = document.getElementById("cvs1");
  var fileinput = document.getElementById("finputfg");
  imagefg = new SimpleImage(fileinput);
  imagefg.drawTo(imgcanvas);
}
function uploadbg() {
  var imgcanvas = document.getElementById("cvs2");
  var fileinput = document.getElementById("finputbg");
  imagebg = new SimpleImage(fileinput);
  imagebg.drawTo(imgcanvas);
}
function docomposite() {
  if (imagefg == null || !imagefg.complete()) {
    alert("Foreground not loaded");
    return;
  }
  if (imagebg == null || !imagebg.complete()) {
    alert("Background not loaded");
    return;
  }
  var output = new SimpleImage(imagefg.getWidth(), imagefg.getHeight());
  for (var pxl of imagefg.values()) {
    var x = pxl.getX();
    var y = pxl.getY();
    var newpxl;
    if (pxl.getGreen() > pxl.getRed() + pxl.getBlue()) {
      newpxl = imagebg.getPixel(x, y);
      //      pxl.setRed(newpxl.getRed());
      //      pxl.setGreen(newpxl.getGreen());
      //      pxl.setBlue(newpxl.getBlue());
    } else {
      newpxl = imagefg.getPixel(x, y);
    }
    output.setPixel(x, y, newpxl);
  }
  var imgcanvas = document.getElementById("cvs3");
  output.drawTo(imgcanvas);
}
function doclearcanvases() {
  var cvsa = document.getElementById("cvs1");
  var cvsb = document.getElementById("cvs2");
  var cvsc = document.getElementById("cvs3");
  var ctxa = cvsa.getContext("2d");
  var ctxb = cvsb.getContext("2d");
  var ctxc = cvsc.getContext("2d");
  ctxa.fillStyle = "white";
  ctxa.clearRect(0, 0, cvsa.width, cvsa.height);
  ctxb.fillStyle = "white";
  ctxb.clearRect(0, 0, cvsb.width, cvsb.height);
  ctxc.fillStyle = "white";
  ctxc.clearRect(0, 0, cvsc.width, cvsc.height);
}
