
var attempt = 3; // Variable to count number of attempts.
// Below function Executes on click of login button.
function validate(){
    var username = document.getElementById("user").value;
    var password = document.getElementById("pws").value;
    if ( username == "admin" && password == "admin"){
        alert ("Login successfully");
        window.location = "homepage.html"; // Redirecting to other page.
        return false;
    }
    else{
        attempt --;// Decrementing by one.
        alert("You have left "+attempt+" attempt;");
// Disabling fields after 3 attempts.
        if( attempt == 0){
            document.getElementById("user").disabled = true;
            document.getElementById("pws").disabled = true;
            document.getElementById("b1").disabled = true;
            return false;
        }
    }
}
