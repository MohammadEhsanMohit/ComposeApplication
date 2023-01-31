package com.example.composeapplication.feature.note.presentation.notes

import com.example.composeapplication.feature.note.domain.util.NoteOrder
import com.example.composeapplication.feature.note.domain.util.OrderType


data class NotesState(
    val notes : List<com.example.composeapplication.feature.note.domain.model.Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible : Boolean = false
)