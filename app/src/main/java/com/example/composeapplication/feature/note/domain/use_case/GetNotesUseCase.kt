package com.example.composeapplication.feature.note.domain.use_case

import com.example.composeapplication.feature.note.domain.util.NoteOrder
import com.example.composeapplication.feature.note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    private val repository : com.example.composeapplication.feature.note.domain.repository.NoteRepository
) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Ascending)) : Flow<List<com.example.composeapplication.feature.note.domain.model.Note>> {
        return repository.getNotes().map { notes ->

            when(noteOrder.orderType) {
                is  OrderType.Ascending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timeStamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }

        }
    }

}