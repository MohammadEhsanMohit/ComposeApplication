package com.example.composeapplication.feature.note.presentation.notes


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapplication.feature.note.domain.use_case.NoteUseCases
import com.example.composeapplication.feature.note.domain.util.NoteOrder
import com.example.composeapplication.feature.note.domain.util.OrderType

import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class NotesViewModel (
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state : State<NotesState> = _state

    private var recentlyDeleteNote : com.example.composeapplication.feature.note.domain.model.Note? = null

    private var getNotesJob : Job? = null
    init {
        getNotes(NoteOrder.Date(OrderType.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when(event) {
            is NotesEvent.DeleteNote -> viewModelScope.launch {
                noteUseCases.deleteNoteUseCase.invoke(event.note)
                recentlyDeleteNote = event.note
            }
            is NotesEvent.Order -> {
                if(state.value.noteOrder::class == event.noteOrder::class
                    && state.value.noteOrder.orderType == event.noteOrder.orderType) {
                    return
                }
                getNotes(event.noteOrder)
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(recentlyDeleteNote?:return@launch)
                    recentlyDeleteNote = null
                }
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getNotes(noteOrder: NoteOrder) {
        getNotesJob?.cancel()
        getNotesJob = noteUseCases.getNotesUseCase(noteOrder)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    noteOrder = noteOrder
                )
            }
            .launchIn(viewModelScope)
    }

}