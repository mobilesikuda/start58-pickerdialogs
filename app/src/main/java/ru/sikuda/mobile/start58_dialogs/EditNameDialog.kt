package ru.sikuda.mobile.start58_dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.DialogFragment


class EditNameDialog : DialogFragment() {

    private var mEditText: EditText? = null

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View {
        val view: View = inflater.inflate(R.layout.fragment_edit_name, container)
        mEditText = view.findViewById(R.id.txt_your_name)
        getDialog()?.setTitle("Hello")
        return view
    }
}