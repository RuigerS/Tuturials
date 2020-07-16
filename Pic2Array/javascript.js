var image = null;
var imagegrey = null;
var imagefg = null;
var imagebg = null;
var leftx = 500;
var rightx = 500;
var highy = 300;
var lowy = 300;
var cvs = document.getElementById("cvs");
var cvs2 = document.getElementById("cvs2");
var oimg = new SimpleImage(136, 67);
var ctx = cvs.getContext("2d");
var output = document.getElementById("output");
var outputarray = document.getElementById("jojo");
var x;
var y;
var found;
var hcount = 0;
var vcount = 0;

function upload() {
  var fileinput = document.getElementById("finput");
  imagefg = new SimpleImage(fileinput);
  cvs.width = 1168;
  cvs.height = 662;
  cvs2.width = 136;
  cvs2.height = 67;
  imagefg.drawTo(cvs);
}
function docalc() {
  for (var pxl of imagefg.values()) {
    if (pxl.getBlue() > 150 && pxl.getX() != 0 && pxl.getY() != 0) {
      pxl.setRed(255);
    } else {
      pxl.setRed(0);
    }
    pxl.setBlue(0);
    pxl.setGreen(0);
  }
  for (x = 0; x < 1168; x++) {
    found = false;
    for (y = 0; y < 662; y++) {
      var tmppxl = imagefg.getPixel(x, y);
      if (tmppxl.getRed() > 50) {
        found = true;
      }
    }
    if (found == false) {
      for (z = 0; z < 662; z++) {
        imagefg.getPixel(x, z).setGreen(255);
      }
    }
    if (found == true) {
      if (x < leftx) leftx = x;
      if (x > rightx) rightx = x;
    }
  }
  for (y = 0; y < 662; y++) {
    found = false;
    for (x = 0; x < 1168; x++) {
      var tmppxl = imagefg.getPixel(x, y);
      if (tmppxl.getRed() > 50) {
        found = true;
      }
    }
    if (found == false) {
      for (z = 0; z < 1168; z++) {
        imagefg.getPixel(z, y).setGreen(255);
      }
    }
    if (found == true) {
      if (y < highy) highy = y;
      if (y > lowy) lowy = y;
    }
  }
  y = highy;
  var last;
  while (y < lowy) {
    x = leftx;
    last = false;
    hcount = 0;
    while (x < rightx) {
      var tmppxl = imagefg.getPixel(x, y);
      if (tmppxl.getGreen() < 50) {
        if (last == false) {
          last = true;
          var water = false;
          if (imagefg.getPixel(x + 3, y + 3).getRed() < 50) {
            water = true;
          }
          if (water == true) {
            oimg.getPixel(hcount, vcount).setBlue(255);
          }
          if (water == false) {
            oimg.getPixel(hcount, vcount).setRed(255);
          }
          hcount++;
          var tmpx = x;
          var tmpy = y;
          while (imagefg.getPixel(tmpx, tmpy).getGreen() < 50) {
            while (imagefg.getPixel(tmpx, tmpy).getGreen() < 50) {
              if (water == true) {
                imagefg.getPixel(tmpx, tmpy).setBlue(255);
              }
              if (water == false) {
                imagefg.getPixel(tmpx, tmpy).setRed(255);
              }
              tmpx++;
            }
            tmpy++;
            tmpx = x;
          }
        }
      }
      if (tmppxl.getGreen() > 50) {
        if (last == true) {
          last = false;
        }
      }
      x++;
    }
    vcount++;
    while (imagefg.getPixel(x, y).getGreen() < 50) {
      y++;
    }
    while (imagefg.getPixel(x, y).getGreen() > 50 && y < lowy) {
      y++;
    }
  }
  output.innerHTML =
    "LeftX:" +
    leftx +
    " LowY:" +
    lowy +
    " RightX:" +
    rightx +
    " HighY:" +
    highy +
    " HCount:" +
    hcount +
    " VCount:" +
    vcount;
  oimg.drawTo(cvs2);
  imagefg.drawTo(cvs);
}

function empt() {
  var string = "{ ";
  for (y = 0; y < 67; y++) {
    string += " {";
    for (x = 0; x < 136; x++) {
      if (oimg.getPixel(x, y).getRed() > 50) {
        string += "1,";
      }
      if (oimg.getPixel(x, y).getBlue() > 50) {
        string += "0,";
      }
    }
    string += " },<br>";
  }
  string += " }";
  outputarray.innerHTML = string;
}
