package com.edumath.mathquiz.presenter

import com.edumath.mathquiz.model.TestList
import com.edumath.mathquiz.view.QuizView

class QuizPresenterImpl(private val view: QuizView) {

    fun checkAnswer(answer: Int, correctAnswer: Int): Boolean{
        return answer == correctAnswer
    }

    fun quizEnd(questionNumber: Int) {
        if (questionNumber == TestList().getList().size){
            view.showResult()
        } else view.nextQuestion()
    }
}