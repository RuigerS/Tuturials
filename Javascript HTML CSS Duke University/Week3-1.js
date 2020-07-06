function domessage() {
  alert("clicked button with JS function");
}

function doconfirm() {
  var choice = confirm("Wedde gij ut zeker?");
  if (choice == true) {
    alert("True confirm ACK ACK");
  } else {
    alert("False confirm NACK NACK");
  }
}

function changecolor() {
  var dd1 = document.getElementById("d1");
  var dd2 = document.getElementById("d2");
  var btn1 = document.getElementById("b1");
  if (dd1.className == "blueblock") {
    dd1.className = "yellowblock";
    dd2.className = "blueblock";
    dd1.style.color="fuchsia";
    dd2.style.color="black";
    dd1.innerHTML = "Hello";
    dd2.innerHTML = "Goodbye";
    b1.value="Tekst 2 (change color)";
  } else {
    dd1.className = "blueblock";
    dd2.className = "yellowblock";
    dd1.style.color="black";
    dd2.style.color="fuchsia";
    dd1.innerHTML = "Hoi";
    dd2.innerHTML = "Doei";
    b1.value="Tekst 1 (change color)";
  }
}
