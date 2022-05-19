package com.example.phincon.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import com.example.phincon.R
import com.example.phincon.databinding.DialogWelcomeBinding
import com.example.phincon.viewmodels.ThankYouViewModel
import javax.inject.Inject

@AndroidEntryPoint
class ThankYouDialog @Inject constructor() : DialogFragment(R.layout.dialog_welcome) {

    private lateinit var binding: DialogWelcomeBinding
    private val viewModel: ThankYouViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isCancelable = false
        binding = DialogWelcomeBinding.bind(view)
        dialog?.window?.attributes?.windowAnimations = R.style.DialogTheme
        viewModel.saveDialogShown()
        binding.confirmButton.setOnClickListener {
            dialog?.dismiss()
        }
    }

}