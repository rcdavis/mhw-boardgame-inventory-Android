package mhw.inventory.db

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.room.TypeConverter

class MutableStateIntTypeConverter {
    @TypeConverter
    fun fromMutableState(state: MutableState<Int>): Int {
        return state.value
    }

    @TypeConverter
    fun toMutableState(v: Int): MutableState<Int> {
        return mutableStateOf(v)
    }
}

/*class StateIntTypeConverter {
    @TypeConverter
    fun fromState(state: State<Int>): Int {
        return state.value
    }

    @TypeConverter
    fun toState(v: Int): State<Int> {
        return mutableStateOf(v)
    }
}*/
