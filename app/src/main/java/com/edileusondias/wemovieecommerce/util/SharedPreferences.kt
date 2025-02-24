package com.edileusondias.wemovieecommerce.util

import android.content.Context
import com.edileusondias.wemovieecommerce.R
import com.edileusondias.wemovieecommerce.model.Product
import com.google.gson.Gson

class SharedPreferences {
    companion object {
        fun saveProduct(context: Context, key: String, value: Product) {
            val sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_key),
                Context.MODE_PRIVATE
            )
                ?: return
            val gson = Gson();
            with(sharedPref.edit()) {
                putString(key, gson.toJson(value))
                apply()
            }
        }

        fun removeProduct(context: Context, key: String) {
            val sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_key),
                Context.MODE_PRIVATE
            )
                ?: return
            with(sharedPref.edit()) {
                remove(key)
                apply()
            }
        }

        fun getAllProducts(context: Context): MutableMap<String, *>? {
            val sharedPref = context.getSharedPreferences(
                context.getString(R.string.preference_key),
                Context.MODE_PRIVATE
            )
            with(sharedPref.edit()) {
                return sharedPref.all
            }
        }
    }
}