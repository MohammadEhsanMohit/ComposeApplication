package com.example.composeapplication.feature.note.domain.model

import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.composeapplication.ui.theme.BabyBlue
import com.example.composeapplication.ui.theme.RedOrange
import com.example.composeapplication.ui.theme.RedPink
import com.example.composeapplication.ui.theme.Violet

@Entity
data class Note(
    val title :String,
    val content : String,
    val timeStamp :Long,
    val color:Int,
    @PrimaryKey val id : Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGray,Violet, BabyBlue, RedPink)
    }
}


class InvalidNoteException(message:String) : Exception(message)