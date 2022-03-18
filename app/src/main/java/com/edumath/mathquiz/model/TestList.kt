package com.edumath.mathquiz.model

class TestList {

    fun getList() : List<Test>{
        return listOf(
            Test("621 - 347", 247),
            Test("473 + 352", 825),
            Test("21 * 4", 84),
            Test("810 : 9", 90),
            Test("855 - 129", 726),
            Test("950 - 15", 935),
            Test("63 * 4", 252),
            Test("729 : 9", 81),
            Test("330 - 220", 110),
            Test("28 : 2 * 8 + 320", 432),
            Test("(450 - 370) : 5 * 8", 128),
            Test("40 : 5 * 7 - 39", 15),
            Test("(30 * 5 - 80) : 5", 14),
            Test("(280 : 20 + 32) * 19", 874),
            Test("(13 * 70 - 360) : 50", 11)
        )
    }

}