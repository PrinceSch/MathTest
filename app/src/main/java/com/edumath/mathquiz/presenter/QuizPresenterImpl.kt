package com.edumath.mathquiz.presenter

import com.edumath.mathquiz.model.TestList
import com.edumath.mathquiz.view.QuizView

class QuizPresenterImpl<V: QuizView> {
    private var currentView: QuizView? = null

    fun attachView(view: V){
        if (view != currentView) {
            currentView = view
        }
    }

    fun detachView(view: V) {
        if (view == currentView) {
            currentView = null
        }
    }

    fun checkAnswer(answer: Int, correctAnswer: Int): Boolean{
        return answer == correctAnswer
    }

    fun quizEnd(questionNumber: Int) {
        if (questionNumber == TestList().getList().size){
            currentView?.showResult()
        } else currentView?.nextQuestion()
    }
}