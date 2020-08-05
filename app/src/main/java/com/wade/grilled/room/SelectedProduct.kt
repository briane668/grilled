package com.wade.stylish.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "product_selected_table")
data class SelectedProduct(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "product_selected_mainimage")
    var image: String = "",

    @ColumnInfo(name = "product_selected_id")
    var selectId: Long = 0L,

    @ColumnInfo(name = "product_selected_title")
    var selectTitle: String = "",

    @ColumnInfo(name = "product_selected_price")
    var selectPrice: Int = 0,

    @ColumnInfo(name = "product_selected_color")
    var selectColor: String = "",

    @ColumnInfo(name = "product_selected_color_Name")
    var selectColorName: String = "",

    @ColumnInfo(name = "product_selected_size")
    var selectSize: String = "",

    @ColumnInfo(name = "product_selected_amount")
    var selectAmount: Int = 0,

    @ColumnInfo(name = "product_stock")
    var stock: Int = 0
) : Parcelable