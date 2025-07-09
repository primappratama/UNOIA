package entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nama: String,
    val username: String,
    val email: String,
    val password: String
)
