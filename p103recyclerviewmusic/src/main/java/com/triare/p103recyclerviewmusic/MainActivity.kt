package com.triare.p103recyclerviewmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val musics = setMusic()
        recyclerView.adapter = MusicAdapter(musics)
    }

    private fun setMusic(): List<Music> {
        val listMusics = mutableListOf<Music>()
        listMusics.add(Music(1, "Солнце Монако", "Люся Чеботина"))
        listMusics.add(Music(2, "Sorry 2", "NK, Вася Демчук"))
        listMusics.add(Music(3, "Наверно, ты меня не помнишь", "JONY, HammAli"))
        listMusics.add(Music(4, "Love Nwantiti (Remix)", "AX'EL, CKay, Dj Yo"))
        listMusics.add(Music(5, "ЛА ЛА ЛА", "Клава Кока"))
        listMusics.add(Music(6, "Останься", "NЮ, Асия"))
        listMusics.add(Music(7, "so low", "escape, Даня Милохин"))
        listMusics.add(Music(8, "Август-это ты", "Мот"))
        listMusics.add(Music(9, "ZITTI E BUONI", "Maneskin"))
        listMusics.add(Music(10, "Стеклянная", "GUMA"))
        listMusics.add(Music(11, "Baby mama", "Скриптонит, Райда"))
        listMusics.add(Music(12, "По глазам", "SLAVA MARLOW"))
        listMusics.add(Music(13, "Зажигать", "MONATIK"))
        listMusics.add(Music(14, "Довела", "VERBEE"))
        listMusics.add(Music(15, "Унесённые ветрами", "Rauf & Faik"))
        listMusics.add(Music(16, "БУМ", "Канги"))
        listMusics.add(Music(17, "Федерико Феллини", "Galibri & Mavik"))
        listMusics.add(Music(18, "Я в моменте", "Джарахов, Markul"))
        listMusics.add(Music(19, "На часах ноль-ноль", "Dabro"))
        listMusics.add(Music(20, "Cayendo", "T-Fest, дора"))
        listMusics.add(Music(21, "MANTERO (Call Me By Your Name)", "Lil Nas X"))
        listMusics.add(Music(22, "Я весь мир обошёл", "HammAli & Navai"))
        listMusics.add(Music(23, "Rampampam", "Minelli"))
        listMusics.add(Music(24, "Истеричка", "Artik & Asti"))
        listMusics.add(Music(25, "Почуття", "NK"))
        listMusics.add(Music(26, "ДУРАКАМ ВЕЗЁТ", "ФОГЕЛЬ"))
        listMusics.add(Music(27, "Веснушки", "NЮ"))
        listMusics.add(Music(28, "Вахтёрам", "Бумбокс"))
        listMusics.add(Music(29, "Улыбка", "PIZZA"))
        listMusics.add(Music(30, "Hey Boy", "Sia, Burna Boy"))
        listMusics.add(Music(31, "По щекам слёзы", "JANAGA, Kucher"))
        listMusics.add(Music(32, "Венера-Юпитер", "Ваня Дмитриенко"))
        listMusics.add(Music(33, "Пьяную домой", "Клава Кока"))
        listMusics.add(Music(34, "Vibe", "NK"))
        listMusics.add(Music(35, "gorit", "DOROFEEVA"))
        listMusics.add(Music(36, "Feeling Good", "Michaela Buble"))
        listMusics.add(Music(37, "СЛЁЗЫ", "Анет Сай"))
        listMusics.add(Music(38, "Rolls Royce", "Джиган, Тимати, Егор Крид"))
        listMusics.add(Music(39, "Shake Ya Boom Boom", "Static & Ben EI Tavori, Black Eyed Peas"))
        listMusics.add(Music(40, "Упс, ты не та", "Mitchel"))
        listMusics.add(Music(41, "Deep End", "Foushee"))
        listMusics.add(Music(42, "Костёр", "HENSY"))
        listMusics.add(Music(43, "Take You Dancing", "Jason Derulo"))
        listMusics.add(Music(44, "Back to Me", "Vanotek, Eneli"))
        listMusics.add(Music(45, "Кобра", "The Hardkiss, MONATIK"))
        listMusics.add(Music(46, "Рок-н-рол", "Бумбокс"))
        listMusics.add(Music(47, "Девочка с картинки", "Егор Крид"))
        listMusics.add(Music(48, "Бумажный дом", "Мот"))
        listMusics.add(Music(49, "Сияй", "Ramil"))
        listMusics.add(Music(50, "Юность", "Dabro"))

        return listMusics
    }
}