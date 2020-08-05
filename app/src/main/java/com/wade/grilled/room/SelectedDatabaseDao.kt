package com.wade.stylish.room

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface SelectedDatabaseDao {

    @Insert
    fun insert(selectedProduct: SelectedProduct)

    /**
     * When updating a row with a value already set in a column,
     * replaces the old value with the new one.
     *
     * @param night new value to write
     */
    @Update
    fun update(selectedProduct: SelectedProduct)

    /**
     * Selects and returns the row that matches the supplied start time, which is our key.
     *
     * @param key startTimeMilli to match
     */
    @Query("SELECT * from product_selected_table WHERE id = :key")
    fun get(key: Long): SelectedProduct?

    /**
     * Deletes all values from the table.
     *
     * This does not delete the table, only its contents.
     */
    @Query("DELETE FROM product_selected_table")
    fun clear()

    /**
     * Selects and returns all rows in the table,
     *
     * sorted by start time in descending order.
     */
    @Query("SELECT * FROM product_selected_table ORDER BY id DESC")
    fun getAllProducts(): LiveData<List<SelectedProduct>>

    /**
     * Selects and returns the latest night.
     */
    @Query("SELECT * FROM product_selected_table ORDER BY id DESC LIMIT 1")
    fun getNewProduct(): SelectedProduct?

    /**
     * Selects and returns the night with given nightId.
     */
    @Query("SELECT * FROM product_selected_table WHERE product_selected_title LIKE :title AND product_selected_color LIKE :color AND product_selected_size LIKE :size ")
    fun getSameProduct(title: String, color: String, size: String): SelectedProduct?

    @Delete
    fun delete(selectedProduct: SelectedProduct)


    @Query("SELECT * FROM product_selected_table")
    fun link():Cursor


}