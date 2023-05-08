package dev.zabolotskikh.authguard.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.zabolotskikh.authguard.domain.model.AppState

@Entity(tableName = "app_state_table")
data class AppStateEntity(
    @ColumnInfo(name = "isStarted") val isStarted: Boolean,
    @ColumnInfo(name = "isAuthenticated") val isAuthenticated: Boolean,
    @ColumnInfo(name = "isPrivateMode") val isPrivateMode: Boolean,
    @PrimaryKey(autoGenerate = false) val id: Int = 0,
)

fun AppStateEntity?.toAppState(): AppState = AppState(
    isStarted = this?.isStarted ?: false,
    isAuthenticated = this?.isAuthenticated ?: false,
    isPrivateMode = this?.isPrivateMode ?: false,
)
