package com.edileusondias.wemovieecommerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edileusondias.wemovieecommerce.R
import com.edileusondias.wemovieecommerce.model.ProductsList
import com.edileusondias.wemovieecommerce.util.SharedPreferences

class CartListAdapter(private val products: ProductsList) :
    RecyclerView.Adapter<CartListAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
        val name: TextView = view.findViewById(R.id.name)
        val price: TextView = view.findViewById(R.id.price)
        val removeCart: ImageView = view.findViewById(R.id.remove_cart)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cart_row_item, viewGroup, false)

        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.products.size
    }

    override fun onBindViewHolder(viewHolder: ProductViewHolder, position: Int) {
        val product = products.products[position]
        viewHolder.name.text = product.title
        viewHolder.price.text = product.price.toString()

        viewHolder.removeCart.setOnClickListener { view ->
            SharedPreferences.removeProduct(
                view.context,
                product.id.toString()
            )
        }

        Glide.with(viewHolder.itemView).load(product.image).into(viewHolder.image)
    }


}