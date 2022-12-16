const quizData=[
    {
        question: "Q1. Syntax error in python is detected by _________at _______",
        a: "a. compiler/ compile time",
        b: "b. interpreter/ run time",
        c: "c. compiler/ run time",
        d: "d. interpreter/ compile time",
        correct: "b"
    },
    {
        question: "Q2. Which module is used in python to create Graphics?",
        a: "a. Turtle.",
        b: "b. Canvas",
        c: "c. Tkinter",
        d: "d. Graphics",
        correct: "A",
    },

    {
        question: "Q3. Which type of Programming does Python support",
        a: "a. object-oriented programming",
        b: "b. structured programming",
        c: "c. functional programming",
        d: "d. all of the mentioned",
        correct: "d",
    },

    {
        question: "Is Python code compiled or interpreted?",
        a: "a. Python code is both compiled and interpreted",
        b: "b. Python code is neither compiled nor interpreted",
        c: "c. Python code is only compiled",
        d: "d. Python code is only interpreted",
        correct: "a",
    },
    {
        question: "Q5. What does pip stand for python?",
        a: "a. Pip Installs Python",
        b: "b.  Pip Installs Packages",
        c: "c. Preferred Installer Program",
        d: "d. All of the mentioned",
        correct: "c",
    },
    {
        question: " Which of the following is true for variable names in Python?",
        a: "a. underscore and ampersand are the only two special characters allowed",
        b: "b. unlimited length",
        c: "c. all private members must have leading and trailing underscores",
        d: "d. none of the mentioned",
        correct: "b",
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

