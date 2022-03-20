package com.edumath.mathquiz

import com.edumath.mathquiz.presenter.QuizPresenterImpl
import com.edumath.mathquiz.view.QuizView
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class QuizPresenterTest {

    private lateinit var presenter: QuizPresenterImpl

    @Mock
    private lateinit var quizView: QuizView

    @Before
    fun setUo(){
        MockitoAnnotations.initMocks(this)
        presenter = QuizPresenterImpl(quizView)
    }

    @Test
    fun checkAnswer_TestTrue(){
        assertTrue(presenter.checkAnswer(54, 54))
    }

    @Test
    fun checkAnswer_TestFalse(){
        assertFalse(presenter.checkAnswer(81, 62))
    }

    @Test
    fun quizEnd_TestEnding(){
        presenter.quizEnd(15)
        Mockito.verify(quizView, Mockito.times(1)).showResult()
    }

    @Test
    fun quizEnd_TestContinue(){
        presenter.quizEnd(4)
        Mockito.verify(quizView, Mockito.times(1)).nextQuestion()
    }

}