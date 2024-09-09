package com.kodiiiofc.example.iamhistorian

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

class QuestionStorage() : Parcelable {

    class Question(val question: String, val answers: List<String>, val correctAnswer: Int) : Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readString() ?: "",
            parcel.createStringArrayList() ?: arrayListOf(),
            parcel.readInt()
        )

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(question)
            parcel.writeStringList(answers)
            parcel.writeInt(correctAnswer)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Question> {
            override fun createFromParcel(parcel: Parcel): Question {
                return Question(parcel)
            }

            override fun newArray(size: Int): Array<Question?> {
                return arrayOfNulls(size)
            }
        }

    }


    fun getQuestion(): Question {
        val range = 0..(questions.size - 1)
        val questionNumber = range.random()
        val question = questions[questionNumber]
        questions.removeAt(questionNumber)
        return question
    }

    private val questions = mutableListOf(
        //#0
        Question(
            "Какое событие ознаменовало начало эпохи Петра I и стало символом его реформ?",
            listOf(
                "Переход к рекрутской армии",
                "Основание Санкт-Петербурга",
                "Введение Юлианского календаря",
                "Принятие Табели о рангах"
            ),
            1
        ),
        //#1
        Question(
            "В каком году произошло Куликовское сражение, в котором войска князя Дмитрия Донского победили Орду?",
            listOf(
                "1240 год",
                "1380 год",
                "1480 год",
                "1612 год"
            ),
            1
        ),
        //#2
        Question(
            "Кто был первым правителем династии Романовых?",
            listOf(
                "Борис Годунов",
                "Иван Грозный",
                "Алексей Михайлович",
                "Михаил Федорович"
            ),
            3
        ),
        //#3
        Question(
            "Как называлась политика СССР, направленная на массовую индустриализацию и коллективизацию в 1920-х и 1930-х годах?",
            listOf(
                "НЭП",
                "Пятилетка",
                "Холодная война",
                "Великая отечественная война"
            ),
            1
        ),
        //#4
        Question(
            "Какое событие стало ключевым моментом в свержении власти Николая II?",
            listOf(
                "Октябрьская революция",
                "Февральская революция",
                "Кровавое воскресенье",
                "Восстание декабристов"
            ),
            1
        ),
        //#5
        Question(
            "Какое княжество стало центром объединения русских земель в конце XIV века?",
            listOf(
                "Киевское княжество",
                "Владимиро-Суздальское княжество",
                "Московское княжество",
                "Новгородское княжество"
            ),
            2
        ),
        //#6
        Question(
            "В каком году произошло принятие христианства на Руси?",
            listOf(
                "882 год",
                "988 год",
                "1015 год",
                "1054 год"
            ),
            1
        ),
        //#7
        Question(
            "Какой титул принял Иван IV Грозный в 1547 году?",
            listOf(
                "Великий князь",
                "Царь",
                "Император",
                "Самодержец"
            ),
            1
        ),
        //#8
        Question(
            "Кто возглавлял восстание декабристов в 1825 году?",
            listOf(
                "Александр I",
                "Михаил Кутузов",
                "Павел I",
                "Руководители Северного и Южного общества"
            ),
            3
        ),
        //#9
        Question(
            "Какой российский император отменил крепостное право в 1861 году?",
            listOf(
                "Александр I",
                "Николай I",
                "Александр II",
                "Александр III"
            ),
            2
        ),
        //#10
        Question(
            "Кто был командующим русской армией в Отечественной войне 1812 года?",
            listOf(
                "Михаил Кутузов",
                "Петр Багратион",
                "Александр Суворов",
                "Михаил Барклай-де-Толли"
            ),
            0
        ),
        //#11
        Question(
            "Какое событие считается началом Смутного времени в России?",
            listOf(
                "Восстание Пугачева",
                "Вторжение Лжедмитрия I",
                "Принятие христианства",
                "Полтавская битва"
            ),
            1
        ),
        //#12
        Question(
            "Кто был последним императором Российской империи?",
            listOf(
                "Александр III",
                "Николай II",
                "Петр III",
                "Павел I"
            ),
            1
        ),
        //#13
        Question(
            "Кто был руководителем СССР во время Великой Отечественной войны?",
            listOf(
                "Владимир Ленин",
                "Иосиф Сталин",
                "Никита Хрущев",
                "Леонид Брежнев"
            ),
            1
        ),
        //#14
        Question(
            "Какая страна напала на СССР в 1941 году, начав Великую Отечественную войну?",
            listOf(
                "США",
                "Япония",
                "Германия",
                "Великобритания"
            ),
            2
        ),
        // #15
        Question(
            "Какой российский государственный деятель был известен своей реформой в области судебной системы в 1864 году?",
            listOf("Петр Столыпин", "Александр II", "Сергей Витте", "Николай I"),
            1
        ),
        // #16
        Question(
            "Кто был первым генеральным секретарем ЦК КПСС?", listOf(
                "Леонид Брежнев", "Владимир Ленин", "Иосиф Сталин", "Михаил Горбачев"
            ), 2
        ),
    // #17
        Question(
            "Какая крупная битва произошла в 1709 году в ходе Северной войны?",
            listOf(
                "Полтавская битва",
                "Бородинское сражение",
                "Битва при Лесной",
                "Куликовская битва"
            ), 0
        ),
    // #18
        Question(
            "Кто из российских правителей первым принял титул императора?",
            listOf("Иван IV Грозный", "Борис Годунов", "Петр I", "Алексей Михайлович"), 2
        ),

        // #19

        Question(
            "Какой конфликт был известен как Русско-японская война?",
            listOf("1904-1905 гг.", "1914-1917 гг.", "1941-1945 гг.", "1939-1940 гг."), 0
        ),

        // #20
        Question(
            "Какая дата считается официальным днем основания Санкт-Петербурга?",
            listOf("1696 год", "1703 год", "1721 год", "1745 год"), 1
        ),

        // #21
        Question(
            "Как назывался союз советских республик, образованный в 1922 году?",
            listOf("Российская Империя", "СССР", "РСФСР", "ВКП(б)"), 2
        ),
    // #22
        Question(
            "В каком году произошло Бородинское сражение?",
            listOf("1709 год", "1812 год", "1905 год", "1914 год"), 1
        ),

        // #23

        Question(
            "Какое событие положило конец Советскому Союзу?",
            listOf(
                "Принятие Конституции СССР",
                "Октябрьская революция",
                "Подписание Беловежских соглашений",
                "Война в Афганистане"
            ), 2
        ),

        // #24
        Question(
            "Кто стал первым президентом Российской Федерации?",
            listOf("Михаил Горбачев", "Борис Ельцин", "Владимир Путин", "Дмитрий Медведев"), 1
        )
    )

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionStorage> {
        override fun createFromParcel(parcel: Parcel): QuestionStorage {
            return QuestionStorage(parcel)
        }

        override fun newArray(size: Int): Array<QuestionStorage?> {
            return arrayOfNulls(size)
        }
    }

}