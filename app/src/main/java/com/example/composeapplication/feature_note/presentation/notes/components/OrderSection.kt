 package com.example.composeapplication.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.composeapplication.R
import com.example.composeapplication.feature_note.domain.util.NoteOrder
import com.example.composeapplication.feature_note.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(orderType = OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(text = stringResource(id = R.string.note_order_title),
                selected = noteOrder is NoteOrder.Title,
                onSelect = { onOrderChange(NoteOrder.Title(noteOrder.orderType)) })
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_small)))
            DefaultRadioButton(text = stringResource(id = R.string.note_order_date),
                selected = noteOrder is NoteOrder.Date,
                onSelect = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) })
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_small)))
            DefaultRadioButton(text = stringResource(id = R.string.note_order_color),
                selected = noteOrder is NoteOrder.Color,
                onSelect = { onOrderChange(NoteOrder.Color(noteOrder.orderType)) })
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_medium)))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(text = stringResource(id = R.string.note_order_type_Ascending),
                selected = noteOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Ascending))
                })
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_small)))
            DefaultRadioButton(text = stringResource(id = R.string.note_order_type_descending),
                selected = noteOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(noteOrder.copy(OrderType.Descending))
                })
        }
    }
}