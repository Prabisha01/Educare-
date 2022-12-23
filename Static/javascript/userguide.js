// Initialized AOS Animation 
AOS.init();

const video = document.querySelectorAll('video');
const playBtn = document.getElementById('playBtn');
const playBtnSmall = document.getElementsByClassName('play-btn');

let flag = 0;
let flag2 = 0;

function playBigVideo (id){
    console.log(id)
    let selectedId = document.getElementById(id);
        if(flag == 0){
        playBtn.style.display = "none"
        selectedId.play();
        selectedId.controls = true;
        flag = 1;
    }
}

function playThis (id){
    console.log(id)
    let selectedId = document.getElementById(id);
        if(flag2 == 0){
        playBtnSmall[id].style.display = "none"
        selectedId.play();
        selectedId.controls = true;
        playBtnSmall.style.display = "none"
        flag2 = 1;
    }
}

for( let i=1; i<video.length; i++){

    video[i].addEventListener('click',()=>{
            if(flag2 == 1  || flag==1){
                playBtn[i].style.display= "";
                video[i].pause();
                video[i].controls = false;
                flag2 = 0;
            }
        
    });
}



// let flag = 0;
// let flag2 = 0;

// playBtn.addEventListener('click', () =>{
//     if(flag == 0){
//         playBtn.style.display= "none";
//         video[0].play();
//         video[0].controls = true;
//         flag = 1;
//     }
// });
    

// for( let i=1; i<video.length; i++){

//     playBtnSmall[i].addEventListener('click',()=>{
//             if(flag2 == 0){
//                 playBtnSmall[i].style.display= "none";
//                 video[i].play();
//                 video[i].controls = true;
//                 flag2 = 1;
//             }
        
//     });

// }

// video[0].addEventListener('click',()=>{
//     video[0].run;
// });

// let run = ()=>{
//     if(flag ==1 || flag2==1){
//         playBtn.style.display= "";
//         video.pause();
//         video.controls = false;
//         flag = 0;
//         flag2 = 0;
//     }
// }