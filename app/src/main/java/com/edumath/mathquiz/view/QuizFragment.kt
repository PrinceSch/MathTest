package com.edumath.mathquiz.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.edumath.mathquiz.databinding.FragmentQuizBinding
import com.edumath.mathquiz.model.TestList

class QuizFragment: Fragment() {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController
    private val questionList = TestList().getList()

    private var questionNumber = 0
    private var counterCorrect = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        navController = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        with(binding){
            countQuiz.text = "Вопрос ${questionNumber + 1} из 15"
            question.text = questionList[questionNumber].text

            val buttons = listOf(
                button0,
                button1,
                button2,
                button3,
                button4,
                button5,
                button6,
                button7,
                button8,
                button9
            )
            buttons.forEachIndexed { index, materialButton ->
                materialButton.setOnClickListener {
                    answerField.text = answerField.text.toString() + index
                }
            }
            buttonAnswer.setOnClickListener {
                val correct = checkAnswer((answerField.text).toString().toInt())
                if (correct){ counterCorrect++ }
                nextQuestion()
            }
            buttonClear.setOnClickListener {
                answerField.text = ""
            }
        }
    }

    private fun nextQuestion() {
        questionNumber++
        binding.answerField.text = ""
        if (questionNumber == questionList.size) {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Правильных ответов: $counterCorrect из 15")
                .setPositiveButton("На главную"){ _, _ ->
                    findNavController().popBackStack()
                }
                .show()
        } else init()
    }

    private fun checkAnswer(answer: Int) : Boolean{
        return answer == questionList[questionNumber].answer
    }

}