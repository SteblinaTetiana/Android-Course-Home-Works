package com.triare.p104recyclerviewfilms

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

        val films = setFilm()
        recyclerView.adapter = FilmsAdapter(films)
    }

    private fun setFilm(): List<Film> {
        val listFilms = mutableListOf<Film>()
        listFilms.add(Film(1, R.drawable.red_message, "Червоне повідомлення", "2021"))
        listFilms.add(Film(2, R.drawable.dark_knight, "Темный рыцарь", "2008"))
        listFilms.add(Film(3, R.drawable.titanic, "Титаник", "1997"))
        listFilms.add(Film(4, R.drawable.gone_with_wind, "Унесенные ветром", "1939"))
        listFilms.add(Film(5, R.drawable.forrest_gump, "Форрест Гамп", "1994"))
        listFilms.add(Film(6, R.drawable.the_lion_king, "Король Лев", "1994"))
        listFilms.add(Film(7, R.drawable.good_guys, "Славные парни", "1990"))
        listFilms.add(Film(8, R.drawable.matrix, "Матрица", "1999"))
        listFilms.add(Film(9, R.drawable.alien, "Инопланетянин", "1982"))
        listFilms.add(Film(10, R.drawable.casablanca, "Касабланка", "1942"))
        listFilms.add(Film(11, R.drawable.avatar, "Аватар", "2009"))
        listFilms.add(Film(12, R.drawable.gladiator, "Гладиатор", "2000"))
        listFilms.add(Film(13, R.drawable.godfather, "Крестный отец", "1972"))
        listFilms.add(Film(14, R.drawable.brave_heart, "Храброе сердце", "1995"))
        listFilms.add(Film(15, R.drawable.one_plus_one, " 1+1", "2011"))
        listFilms.add(Film(16, R.drawable.start, "Начало", "2010"))
        listFilms.add(Film(17, R.drawable.terminator, "Терминатор", "1984"))
        listFilms.add(Film(18, R.drawable.leon, "Леон", "1994"))
        listFilms.add(Film(19, R.drawable.bluff, "Блеф", "1976"))
        listFilms.add(Film(20, R.drawable.negotiator, "Переговорщик", "1998"))
        listFilms.add(Film(21, R.drawable.crew, "Экипаж", "1979"))
        listFilms.add(Film(22, R.drawable.alone_at_home, "Один дома", "1990"))
        listFilms.add(Film(23, R.drawable.seven, "Семь", "1995"))
        listFilms.add(Film(24, R.drawable.outcast, "Изгой", "2000"))
        listFilms.add(Film(25, R.drawable.casino, " Казино", "1995"))
        listFilms.add(Film(26, R.drawable.pianist, "Пианист", "2002"))
        listFilms.add(Film(27, R.drawable.rocky, "Рокки", "1976"))
        listFilms.add(Film(28, R.drawable.obsession, "Одержимость", "2014"))
        listFilms.add(Film(29, R.drawable.moonshiners, "Самогонщики", "1961"))
        listFilms.add(Film(30, R.drawable.rambo, "Рэмбо", "1982"))
        listFilms.add(Film(31, R.drawable.predator, "Хищник", "1987"))
        listFilms.add(Film(32, R.drawable.kill_bill, "Убить Билла", "2003"))
        listFilms.add(Film(33, R.drawable.raid, "Рейд", "2011"))
        listFilms.add(Film(34, R.drawable.commando, "Коммандос", "1985"))
        listFilms.add(Film(35, R.drawable.specialist, "Специалист", "1994"))
        listFilms.add(Film(36, R.drawable.cliffhanger, "Скалолаз", "1993"))
        listFilms.add(Film(37, R.drawable.rock, "Скала", "1996"))
        listFilms.add(Film(38, R.drawable.machete, "Мачете", "2010"))
        listFilms.add(Film(39, R.drawable.avengers, "Мстители", "2012"))
        listFilms.add(Film(40, R.drawable.speed, "Скорость", "1994"))
        listFilms.add(Film(41, R.drawable.bad_boys, "Плохие парни", "1995"))
        listFilms.add(Film(42, R.drawable.fast_and_the_furious, "Форсаж", "2001"))
        listFilms.add(Film(43, R.drawable.taxi, "Такси", "1998"))
        listFilms.add(Film(44, R.drawable.logan, "Логан", "2017"))
        listFilms.add(Film(45, R.drawable.oldeuboi, "Олдбой", "2003"))
        listFilms.add(Film(46, R.drawable.john_wick, "Джон Уик", "2014"))
        listFilms.add(Film(47, R.drawable.taken, "Заложница", "2008"))
        listFilms.add(Film(48, R.drawable.transformers, "Трансформеры", "2007"))
        listFilms.add(Film(49, R.drawable.shooter, "Стрелок", "2007"))
        listFilms.add(Film(50, R.drawable.expendables, "Неудержимые", "2010"))

        return listFilms
    }
}