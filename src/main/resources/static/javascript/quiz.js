const quizData=[
    {
        question: "Q1. The _______ function is a predefined method in Dart.",
        a: "a. declare()",
        b: "b. list()",
        c: "c. main()",
        d: "d. return()",
        correct: "c"
    },
    {
        question: "Q2. Dart is an Object-Oriented language.",
        a: "a. Yes.",
        b: "b. No",
        c: "c. Can be yes or no",
        d: "d. none of them",
        correct: "A",
    },

    {
        question: "Q3. An ________ is a real-time representation of any entity.",
        a: "a. class",
        b: "b. Method",
        c: "c. Object",
        d: "d. None of the above",
        correct: "c",
    },

    {
        question: "Dart programs run in _______ modes ?",
        a: "a. 2",
        b: "b. 3",
        c: "c. 4",
        d: "d. 5",
        correct: "a",
    },
    {
        question: "Q5. Which of the following command specifies where to find imported libraries.",
        a: "a. -C",
        b: "b.  -p",
        c: "c. -h",
        d: "d. All of the abouve",
        correct: "b",
    },
    {
        question: "Q6. As per Grady Brooch, every object must have ________ features.",
        a: "a. 0",
        b: "b. 1",
        c: "c. 2",
        d: "d. 3",
        correct: "d",
    },

];

const quiz = document.getElementById('quiz')
const answerEls = document.querySelectorAll('.answer')
const questionEl = document.getElementById('question')
const a_text = document.getElementById('a_text')
const b_text = document.getElementById('b_text')
const c_text = document.getElementById('c_text')
const d_text = document.getElementById('d_text')
const submitBtn = document.getElementById('submit')


let currentQuiz = 0
let score = 0

loadQuiz()

function loadQuiz(){

    deselectAnswers()

    const currentquizData = quizData[currentQuiz]

    questionEl.innerText = currentquizData.question
    a_text.innerText = currentquizData.a
    b_text.innerText = currentquizData.b
    c_text.innerText = currentquizData.c
    d_text.innerText = currentquizData.d
}

function deselectAnswers(){
    answerEls.forEach(answerEl => answerEl.checked = false)

}

function getSelected(){
    let answer
    answerEls.forEach(answerEl => {
        if(answerEl.checked){
            answer = answerEl.id
        }
    })
    return answer
}

submitBtn.addEventListener('click',()=>{
    const answer = getSelected()
    if(answer){
        if (answer == quizData[currentQuiz].correct){
            score++
        }
        currentQuiz++

        if(currentQuiz < quizData.length){
            loadQuiz()
        }else {
            quiz.innerHTML =`
            <h2>You answered ${score}/${quizData.length} question correctly</h2>
            
            <button onclick="location.reload()">Reload</button>
            `
        }
    }
})

