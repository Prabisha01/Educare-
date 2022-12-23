function submit()
{
    let user=document.getElementById("user").value;
    let pws=document.getElementById("pws").value;
    let logged=document.getElementById("loggedin");
// var user=document.getElementById("user").nodeValue;
// var pws=document.getElementById("pws").nodeValue;
    if(username=="admin" && password=="pass" ){
        alert("login succesfull");
    }
    else{
        alert("login unsuccessfull")
    }
    

    alert("Incorrect UserID or Password")
}

function validateForm() {
    var x = document.forms["user"][""].value;
    if (x == "") {
      alert("Name must be filled out");
      return false;
    }
  }