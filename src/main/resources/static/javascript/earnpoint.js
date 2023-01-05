



<div id='score'> <!--Create div to later reference in js--> 
		<p id='store'>Score: 0</p> <!--Your current score-->
		<p id='place'></p>
		</div>
		
		<button onclick='addScore();'>Click to add to score</button>
		
		<script> 
		//Begin javascript
		var totalScore = 0; //Your current score
		var parent = document.getElementById("score"); //Gets the div the score will be kept in
		var newChild;
		var child;
		
		