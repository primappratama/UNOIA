package dao

import entity.UserEntity
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE (email = :input OR username = :input) AND password = :password LIMIT 1")
    fun login(input: String, password: String): UserEntity?

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM users WHERE email = :email OR username = :username LIMIT 1")
    fun checkUserExist(email: String, username: String): UserEntity?

}
