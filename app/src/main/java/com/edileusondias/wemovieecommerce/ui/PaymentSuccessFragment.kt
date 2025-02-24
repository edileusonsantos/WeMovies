package com.edileusondias.wemovieecommerce.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.edileusondias.wemovieecommerce.databinding.FragmentPaymentSuccessBinding

class PaymentSuccessFragment : Fragment() {

    private var _binding: FragmentPaymentSuccessBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPaymentSuccessBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val finalizeOrderButton: Button = binding.goHomeButton
        finalizeOrderButton.setOnClickListener {
            requireActivity()
                .supportFragmentManager
                .beginTransaction()
                .remove(this)
                .disallowAddToBackStack()
                .commitNow()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}