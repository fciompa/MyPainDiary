package cz.ictsystem.mypaindiary.repository

import cz.ictsystem.mypaindiary.database.EntryEntity
import java.util.*

data class Entry(
    val id: Int = 0,
    val entryDate: Date = Date(),
    val intensity: Int = 0,
    val description: String = "",
    val note: String = ""
) {
    constructor(e: EntryEntity) : this(
        e.id,
        e.entryDate,
        e.intensity,
        e.description,
        e.note
    )
}
