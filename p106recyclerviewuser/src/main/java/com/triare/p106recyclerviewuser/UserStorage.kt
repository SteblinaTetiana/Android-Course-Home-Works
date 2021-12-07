package com.triare.p106recyclerviewuser

import android.content.Context
import com.github.javafaker.Faker


object UserStorage {

    fun random(context: Context) = MutableList(50) {
        val faker = Faker.instance()
        User(
            id = it.toLong(),
            name = faker.name().name(),
            company = faker.company().name(),
            avatar = images[it % images.size]
        )
    }

    private val images = mutableListOf(
        "https://images.unsplash.com/photo-1600267185393-e158a98703de?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=600&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjI0MDE0NjQ0&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=800",
        "https://images.unsplash.com/photo-1579710039144-85d6bdffddc9?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=600&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjI0MDE0Njk1&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=800",
        "https://images.unsplash.com/photo-1488426862026-3ee34a7d66df?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=600&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjI0MDE0ODE0&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=800",
        "https://images.unsplash.com/photo-1620252655460-080dbec533ca?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=600&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjI0MDE0NzQ1&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=800",
        "https://images.unsplash.com/photo-1613679074971-91fc27180061?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=600&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjI0MDE0NzUz&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=800",
        "https://images.unsplash.com/photo-1485795959911-ea5ebf41b6ae?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=600&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjI0MDE0NzU4&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=800",
        "https://images.unsplash.com/photo-1545996124-0501ebae84d0?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=600&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjI0MDE0NzY1&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=800",
        "https://images.unsplash.com/flagged/photo-1568225061049-70fb3006b5be?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=600&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjI0MDE0Nzcy&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=800",
        "https://images.unsplash.com/photo-1567186937675-a5131c8a89ea?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=600&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjI0MDE0ODYx&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=800",
        "https://images.unsplash.com/photo-1546456073-92b9f0a8d413?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=600&ixid=MnwxfDB8MXxyYW5kb218fHx8fHx8fHwxNjI0MDE0ODY1&ixlib=rb-1.2.1&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=800",
        "https://aif-s3.aif.ru/images/019/507/eeba36a2a2d37754bab8b462f4262d97.jpg",
        "https://st.depositphotos.com/1937573/2310/i/600/depositphotos_23100736-stock-photo-handsome-man-outdoors-portrait.jpg",
        "https://klike.net/uploads/posts/2019-10/1570368924_222.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPGFoDfKjBKavF5DJXYtxSEHhFzyS1ajx9fA&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRByWdUH886gYORd-XwWpOU20Ma5RIfumkTtA&usqp=CAU",
        "https://static.tildacdn.com/tild3931-6635-4265-b232-663830313530/12.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCQ7vUm2D6Vq_mEOg_IrRStQeB0yCtWmal8Q&usqp=CAU",
        "https://st.depositphotos.com/1525321/2496/i/600/depositphotos_24960979-stock-photo-handsome-young-man.jpg",
        "https://ukr.media/static/ba/aimg/3/2/4/324860_1.jpg",
        "https://media.istockphoto.com/photos/woman-in-swimsuit-and-hat-at-sea-picture-id480556900?k=20&m=480556900&s=170667a&w=0&h=19Ai8Ep87Dk9ZWApiZKwHimgsQkk3EI0HK4JpaHQmZ0=",
        "https://healthyhair.net.ua/wp-content/uploads/foto-na-avu-v-vk-dlya-devushek-krasivye-so-spiny-rusye-volosy_4.jpg",
        "https://vjoy.cc/wp-content/uploads/2020/12/43533094_355218565220573_3820872257655643359_n-856x1024-1.jpg"
    )
}