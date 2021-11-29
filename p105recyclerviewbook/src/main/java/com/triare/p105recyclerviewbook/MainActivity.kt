package com.triare.p105recyclerviewbook

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
        val books = setBook()
        recyclerView.adapter = BooksAdapter(books)
    }

    private fun setBook(): List<Book> {
        val listBooks = mutableListOf<Book>()
        listBooks.add(Book(1, R.drawable.master_and_margarita, "Мастер и Маргарита", "Михаил Булгаков"))
        listBooks.add(Book(2, R.drawable.shantaram, "Шантарам", "Грегори Дэвид Робертс"))
        listBooks.add(Book(3, R.drawable.three_comrades, "Три товарища", "Эрих Мария Ремарк"))
        listBooks.add(Book(4, R.drawable.little_prince, "Маленький принц", "Антуан де Сент-Экзюпери"))
        listBooks.add(Book(5, R.drawable.over_the_precipice_in_the_rye, "Над пропастью во ржи", "Джером Д. Сэлинджер"))
        listBooks.add(Book(6, R.drawable.dandelion_wine, "Вино из одуванчиков", "Рэй Брэдбери"))
        listBooks.add(Book(7, R.drawable.anna_karenina, "Анна Каренина", "Лев Толстой"))
        listBooks.add(Book(8, R.drawable.crime_and_punishment, "Преступление и наказание", "Фёдор Достоевский"))
        listBooks.add(Book(9, R.drawable.one_hundred_years_of_loneliness, "Сто лет одиночества", "Габриэль Гарсиа Маркес"))
        listBooks.add(Book(10, R.drawable.idiot, "Идиот", "Фёдор Достоевский"))
        listBooks.add(Book(11, R.drawable.arc_de_triomphe, "Триумфальная арка", "Эрих Мария Ремарк"))
        listBooks.add(Book(12, R.drawable.great_gatsby, "Великий Гэтсби", "Фрэнсис Скотт Фицджеральд"))
        listBooks.add(Book(13, R.drawable.eugene_onegin, "Евгений Онегин", "Александр Пушкин"))
        listBooks.add(Book(14, R.drawable.loan_life, "Жизнь взаймы", "Эрих Мария Ремарк"))
        listBooks.add(Book(15, R.drawable.fight_club, "Бойцовский клуб", "Чак Паланик"))
        listBooks.add(Book(16, R.drawable.book_thief, "Книжный вор", "Маркус Зусак"))
        listBooks.add(Book(17, R.drawable.green_mile, "Зелёная миля", "Стивен Кинг"))
        listBooks.add(Book(18, R.drawable.war_and_peace, "Война и мир", "Лев Толстой"))
        listBooks.add(Book(19, R.drawable.martian, "Марсианин", "Энди Вейер"))
        listBooks.add(Book(20, R.drawable.demons, "Бесы", "Фёдор Достоевский"))
        listBooks.add(Book(21, R.drawable.dead_souls, "Мёртвые души", "Николай Васильевич Гоголь"))
        listBooks.add(Book(22, R.drawable.alchemist, "Алхимик", "Пауло Коэльо"))
        listBooks.add(Book(23, R.drawable.dogs_heart, "Собачье сердце", "Михаил Булгаков"))
        listBooks.add(Book(24, R.drawable.gameof_thrones, "Игра престолов", "Джордж Р. Р. Мартин"))
        listBooks.add(Book(25, R.drawable.martin_eden, "Мартин Иден", "Джек Лондон"))
        listBooks.add(Book(26, R.drawable.lord_of_the_rings, "Властелин колец", "Джон Рональд Руэл Толкин"))
        listBooks.add(Book(27, R.drawable.lord_of_the_flies, "Повелитель мух", "Уильям Голдинг"))
        listBooks.add(Book(28, R.drawable.shadow_of_the_mountain, "Тень горы", "Грегори Дэвид Робертс"))
        listBooks.add(Book(29, R.drawable.perfumer, "Парфюмер", "Патрик Зюскинд"))
        listBooks.add(Book(30, R.drawable.dr_zhivago, "Доктор Живаго", "Борис Пастернак"))
        listBooks.add(Book(31, R.drawable.cattle_yard, "Скотный Двор", "Джордж Оруэлл"))
        listBooks.add(Book(32, R.drawable.up_from_the_mind, "Горе от ума", "А. С. Грибоедов"))
        listBooks.add(Book(33, R.drawable.da_vinci_code, "Код да Винчи", "Дэн Браун"))
        listBooks.add(Book(34, R.drawable.godfather, "Крёстный отец", "Марио Пьюзо"))
        listBooks.add(Book(35, R.drawable.battle_of_the_kings, "Битва королей", "Джордж Р. Р. Мартин"))
        listBooks.add(Book(36, R.drawable.cloud_atlas, "Облачный атлас", "Дэвид Митчелл"))
        listBooks.add(Book(37, R.drawable.picnic_on_the_roadside, "Пикник на обочине", "Аркадий Стругацкий, Борис Стругацкий"))
        listBooks.add(Book(38, R.drawable.scarlet_sails, "Алые паруса", "Александр Грин"))
        listBooks.add(Book(39, R.drawable.rejected, "Отверженные", "Виктор Гюго"))
        listBooks.add(Book(40, R.drawable.lolita, "Лолита", "Владимир Набоков"))
        listBooks.add(Book(41, R.drawable.faust, "Фауст", "Иоганн Вольфганг Гете"))
        listBooks.add(Book(42, R.drawable.source, "Источник", "Айн Рэнд"))
        listBooks.add(Book(43, R.drawable.steve_jobs, "Стив Джобс", "Уолтер Айзексон"))
        listBooks.add(Book(44, R.drawable.inferno, "Инферно", "Дэн Браун"))
        listBooks.add(Book(45, R.drawable.storm_of_swords, "Буря мечей", "Джордж Р. Р. Мартин"))
        listBooks.add(Book(46, R.drawable.oblomov, "Обломов", "Иван Гончаров"))
        listBooks.add(Book(47, R.drawable.three_comrades, "Три мушкетёра", "Александр Дюма"))
        listBooks.add(Book(48, R.drawable.airport, "Аэропорт", "Артур Хейли"))
        listBooks.add(Book(49, R.drawable.magus, "Волхв", "Джон Фаулз"))
        listBooks.add(Book(50, R.drawable.sherlock_holmes, "Шерлок Холмс", "Артур Конан Дойл"))

        return listBooks
    }
}