package com.aralb.foodapplication.ui.base

import android.app.Dialog
<<<<<<< HEAD
=======
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.aralb.foodapplication.R

abstract class BaseFragment<VB : ViewBinding>
    (private val bindingInflater: (inflater: LayoutInflater) -> VB) :
    Fragment() {

    lateinit var binding: VB

    private lateinit var progressDialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = bindingInflater(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observer()


    }

    open fun observer() {}
<<<<<<< HEAD
=======

>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
    fun showLoadingProgress() {
        if (!::progressDialog.isInitialized) {
            progressDialog = Dialog(requireContext())
            progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            progressDialog.setContentView(R.layout.loading_progress)
<<<<<<< HEAD

=======
            progressDialog.setCancelable(false)
            progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
>>>>>>> 14d3ed5d30dc645b49d060de44ef39e20161d7a6
        }
        progressDialog.show()
    }

    fun dismissLoadingProgress() {
        if (::progressDialog.isInitialized && progressDialog.isShowing) {
            progressDialog.dismiss()
        }

    }
}

