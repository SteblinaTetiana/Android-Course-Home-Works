package com.triare.p102recyclerviewsport

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

        val sports = setInitialSport()
        val adapter = SportAdapter(sports)
        recyclerView.adapter = adapter
    }

    private fun setInitialSport(): List<Sport> {
        val listSports = mutableListOf<Sport>()
        listSports.add(Sport(1, R.drawable.badminton, getString(R.string.badminton), getString(R.string.description_badminton)))
        listSports.add(Sport(2, R.drawable.basketball, getString(R.string.basketball), getString(R.string.description_basketball)))
        listSports.add(Sport(3, R.drawable.baseball, getString(R.string.baseball), getString(R.string.description_baseball)))
        listSports.add(Sport(4, R.drawable.volleyball, getString(R.string.volleyball), getString(R.string.description_volleyball)))
        listSports.add(Sport(5, R.drawable.golf, getString(R.string.golf), getString(R.string.description_golf)))
        listSports.add(Sport(6, R.drawable.swimming, getString(R.string.swimming), getString(R.string.description_swimming)))
        listSports.add(Sport(7, R.drawable.tennis, getString(R.string.tennis), getString(R.string.description_tennis)))
        listSports.add(Sport(8, R.drawable.table_tennis, getString(R.string.table_tennis), getString(R.string.description_table_tennis)))
        listSports.add(Sport(9, R.drawable.football, getString(R.string.football), getString(R.string.description_football)))
        listSports.add(Sport(10, R.drawable.hockey, getString(R.string.hockey), getString(R.string.description_hockey)))
        listSports.add(Sport(11, R.drawable.handball, getString(R.string.handball), getString(R.string.description_handball)))
        listSports.add(Sport(12, R.drawable.boxing, getString(R.string.boxing), getString(R.string.description_boxing)))
        listSports.add(Sport(13, R.drawable.wrestling, getString(R.string.wrestling), getString(R.string.description_wrestling)))
        listSports.add(Sport(14, R.drawable.athletics, getString(R.string.athletics), getString(R.string.description_athletics)))
        listSports.add(Sport(15, R.drawable.fencing, getString(R.string.fencing), getString(R.string.description_fencing)))
        listSports.add(Sport(16, R.drawable.triathlon, getString(R.string.triathlon), getString(R.string.description_triathlon)))
        listSports.add(Sport(17, R.drawable.gymnastics, getString(R.string.gymnastics), getString(R.string.description_gymnastics)))
        listSports.add(Sport(18, R.drawable.judo, getString(R.string.judo), getString(R.string.description_judo)))
        listSports.add(Sport(19, R.drawable.water_polo, getString(R.string.water_polo), getString(R.string.dscription_water_polo)))
        listSports.add(Sport(20, R.drawable.snowboarding, getString(R.string.snowboarding), getString(R.string.description_snowboarding)))
        listSports.add(Sport(21, R.drawable.rugby, getString(R.string.rugby), getString(R.string.description_rugby)))
        listSports.add(Sport(22, R.drawable.climbing, getString(R.string.climbing), getString(R.string.description_climbing)))
        listSports.add(Sport(23, R.drawable.curling, getString(R.string.curling), getString(R.string.description_curling)))
        listSports.add(Sport(24, R.drawable.archery, getString(R.string.archery), getString(R.string.description_archery)))
        listSports.add(Sport(25, R.drawable.karate, getString(R.string.karate), getString(R.string.description_karate)))
        listSports.add(Sport(26, R.drawable.weightlifting, getString(R.string.weightlifting), getString(R.string.description_weightlifting)))
        listSports.add(Sport(27, R.drawable.biathlon, getString(R.string.biathlon), getString(R.string.description_biathlon)))
        listSports.add(Sport(28, R.drawable.ski_racing, getString(R.string.ski_racing), getString(R.string.description_ski_racing)))
        listSports.add(Sport(29, R.drawable.darts, getString(R.string.darts), getString(R.string.description_darts)))
        listSports.add(Sport(30, R.drawable.aikido, getString(R.string.aikido), getString(R.string.description_aikido)))
        listSports.add(Sport(31, R.drawable.mountaineering, getString(R.string.mountaineering), getString(R.string.description_mountaineering)))
        listSports.add(Sport(32, R.drawable.bodybuilding, getString(R.string.bodybuilding), getString(R.string.description_bodybuilding)))
        listSports.add(Sport(33, R.drawable.billiards, getString(R.string.billiards), getString(R.string.description_billiards)))
        listSports.add(Sport(34, R.drawable.sambo_fights, getString(R.string.sambo_fights), getString(R.string.description_sambo_fights)))
        listSports.add(Sport(35, R.drawable.bowling, getString(R.string.bowling), getString(R.string.description_bowling)))
        listSports.add(Sport(36, R.drawable.wakeboarding, getString(R.string.wakeboarding), getString(R.string.description_wakeboarding)))
        listSports.add(Sport(37, R.drawable.jiu_jitsu, getString(R.string.jiu_jitsu), getString(R.string.description_jiu_jitsu)))
        listSports.add(Sport(38, R.drawable.kung_fu, getString(R.string.kung_fu), getString(R.string.description_kung_fu)))
        listSports.add(Sport(39, R.drawable.pankration, getString(R.string.pankration), getString(R.string.description_pankration)))
        listSports.add(Sport(40, R.drawable.paintball, getString(R.string.paintball), getString(R.string.description_paintball)))
        listSports.add(Sport(41, R.drawable.dogfight, getString(R.string.dogfight), getString(R.string.description_dogfight)))
        listSports.add(Sport(42, R.drawable.sports_aerobics, getString(R.string.sports_aerobics), getString(R.string.description_sports_aerobics)))
        listSports.add(Sport(43, R.drawable.sumo, getString(R.string.sumo), getString(R.string.description_sumo)))
        listSports.add(Sport(44, R.drawable.taekwon_do, getString(R.string.taekwon_do), getString(R.string.description_taekwon_do)))
        listSports.add(Sport(45, R.drawable.wushu, getString(R.string.wushu), getString(R.string.description_wushu)))
        listSports.add(Sport(46, R.drawable.floorball, getString(R.string.floorball), getString(R.string.description_floorball)))
        listSports.add(Sport(47, R.drawable.equestrian_sports, getString(R.string.equestrian_sports), getString(R.string.description_equestrian_sports)))
        listSports.add(Sport(48, R.drawable.horting, getString(R.string.horting), getString(R.string.description_horting)))
        listSports.add(Sport(49, R.drawable.radio_sports, getString(R.string.radio_sports), getString(R.string.description_radio_sports)))
        listSports.add(Sport(50, R.drawable.strongman, getString(R.string.strongman), getString(R.string.description_strongman)))

        return listSports
    }
}