//
//
//
//
// <div id='score'> <!--Create div to later reference in js-->
// 		<p id='store'>Score: 0</p> <!--Your current score-->
// 		<p id='place'></p>
// 		</div>
//
// 		<button onclick='addScore();'>Click to add to score</button>
//
// 		<script>
// 		//Begin javascript
// 		var totalScore = 0; //Your current score
// 		var parent = document.getElementById("score"); //Gets the div the score will be kept in
// 		var newChild;
// 		var child;
// 		function addScore() {
// 		    totalScore += 1; //Add to total score
//
// 		    var para = document.createElement("p"); //Create new paragraph
// 		    var node = document.createTextNode("Score: " + totalScore); //Create text for p
//             para.appendChild(node); //Attach text to p
//             if (document.getElementById('store')) {
//                 parent.removeChild(document.getElementById('store')); //Remove current score count
//
//             }
//             if (newChild) {
//                 parent.removeChild(newChild); //Remove last score
//             }
//                 newChild = parent.insertBefore(para,document.getElementById('place')); //Get new score
// 		}
//
// 		</script>
//
//