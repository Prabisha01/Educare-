function validate()
{
var username=document.getElementById("user").value;
var password=document.getElementById("pws").value;
    if(username=="admin" && password=="admin" ){
      window.location.assign("homepage.html");
        alert("login succesfull");
      
    }
    else{
        alert("Incorrect UserID or Password");
    }
}