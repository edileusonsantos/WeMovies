package com.edileusondias.wemovieecommerce.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.edileusondias.wemovieecommerce.adapter.CartListAdapter
import com.edileusondias.wemovieecommerce.databinding.FragmentCartBinding
import com.edileusondias.wemovieecommerce.viewmodel.CartViewModel

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cartViewModel =
            ViewModelProvider(this).get(CartViewModel::class.java)

        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val cartCard: CardView = binding.cartCard
        val emptyCartCard: CardView = binding.emptyCartCard
        val recyclerView: RecyclerView = binding.cartList
        cartViewModel.productsListLiveData.observe(viewLifecycleOwner) {
            val adapter = CartListAdapter(it)
            recyclerView.adapter = adapter
            if(it.products.isNotEmpty()) {
                cartCard.visibility = View.VISIBLE
                emptyCartCard.visibility = View.GONE
            }
        }


        val finalizeOrderButton: Button = binding.finalizeOrderButton
        finalizeOrderButton.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .disallowAddToBackStack()
                .add<PaymentSuccessFragment>((requireView().parent as ViewGroup).id)
                .commitNow()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}