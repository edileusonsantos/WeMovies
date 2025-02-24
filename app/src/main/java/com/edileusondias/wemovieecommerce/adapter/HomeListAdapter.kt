package com.edileusondias.wemovieecommerce.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edileusondias.wemovieecommerce.R
import com.edileusondias.wemovieecommerce.model.ProductsList
import com.edileusondias.wemovieecommerce.util.SharedPreferences

class HomeListAdapter(private val products: ProductsList) :
    RecyclerView.Adapter<HomeListAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
        val name: TextView = view.findViewById(R.id.name)
        val price: TextView = view.findViewById(R.id.price)
        val addCart: Button = view.findViewById(R.id.add_cart)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.home_row_item, viewGroup, false)

        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.products.size
    }

    override fun onBindViewHolder(viewHolder: ProductViewHolder, position: Int) {
        val product = products.products[position]
        viewHolder.name.text = product.title
        viewHolder.price.text = product.price.toString()

        viewHolder.addCart.setOnClickListener { view ->
            SharedPreferences.saveProduct(
                view.context,
                product.id.toString(),
                product
            )
        }

        Glide.with(viewHolder.itemView).load(product.image).into(viewHolder.image)
    }


}