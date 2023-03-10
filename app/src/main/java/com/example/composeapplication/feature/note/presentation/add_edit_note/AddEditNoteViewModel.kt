package com.example.composeapplication.feature.note.presentation.add_edit_note

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapplication.feature.note.domain.use_case.NoteUseCases
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class AddEditNoteViewModel(
    private val noteUseCases: NoteUseCases,
    _currentNoteId: Int?
) : ViewModel() {

    init {
        _currentNoteId?.let { noteId ->
            if(noteId!= -1) {
                viewModelScope.launch {
                    noteUseCases.getNote(noteId)?.also { note ->
                        currentNoteId = note.id
                        _noteTitle.value = noteTitle.value.copy(
                            text = note.title,
                            isHintVisible = false
                        )
                        _noteContent.value = noteContent.value.copy(
                            text = note.content,
                            isHintVisible = false
                        )
                        _noteColor.value = note.color
                    }
                }
            }
        }
    }

    private val _noteTitle = mutableStateOf(NoteTextFieldState(
        hint = "Enter Title"
    ))
    val noteTitle : State<NoteTextFieldState> = _noteTitle

    private val _noteContent = mutableStateOf(NoteTextFieldState(
        hint = "Enter Some Content"
    ))
    val noteContent : State<NoteTextFieldState> = _noteContent


    private val _noteColor = mutableStateOf<Int>(com.example.composeapplication.feature.note.domain.model.Note.noteColors.random().toArgb())
    val noteColor : State<Int> = _noteColor

    private var currentNoteId : Int? = null

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event : AddEditNoteEvent) {
        when(event) {
            is AddEditNoteEvent.EnteredTitle -> {
                _noteTitle.value = noteTitle.value.copy(
                    text = event.value
                )
            }
            is AddEditNoteEvent.ChangeTitleFocus -> {
                _noteTitle.value = noteTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteTitle.value.text.isBlank()
                )
            }
            is AddEditNoteEvent.EnteredContent -> {
                _noteContent.value = noteContent.value.copy(
                    text = event.value
                )
            }
            is AddEditNoteEvent.ChangeContentFocus -> {
                _noteContent.value = noteContent.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteContent.value.text.isBlank()
                )
            }
            is AddEditNoteEvent.ChangeColor -> {
                _noteColor.value = event.color
            }
            AddEditNoteEvent.SaveNote -> {
                viewModelScope.launch {
                    try {
                        noteUseCases.addNote.invoke(
                            com.example.composeapplication.feature.note.domain.model.Note(
                                title = noteTitle.value.text,
                                content = noteContent.value.text,
                                color = noteColor.value,
                                timeStamp = System.currentTimeMillis(),
                                id = currentNoteId
                            )
                        )

                        _eventFlow.emit(UiEvent.SaveNote)
                    } catch (e : com.example.composeapplication.feature.note.domain.model.InvalidNoteException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackBar(
                                e.message ?: "Couldn't Save Note!"
                            )
                        )
                    }
                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackBar(val message:String) : UiEvent()
        object SaveNote : UiEvent()
    }
}