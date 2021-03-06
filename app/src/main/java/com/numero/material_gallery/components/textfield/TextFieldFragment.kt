package com.numero.material_gallery.components.textfield

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.numero.material_gallery.R
import com.numero.material_gallery.components.MaterialContainerTransformFragment
import com.numero.material_gallery.core.applySystemWindowInsetsPadding
import kotlinx.android.synthetic.main.fragment_text_field.*

class TextFieldFragment : MaterialContainerTransformFragment(R.layout.fragment_text_field) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        filledErrorTextInputLayout.error = "Error"
        outlineErrorTextInputLayout.error = "Error"

        customIconFilledTextInputLayout.setEndIconOnClickListener {
            Toast.makeText(requireContext(), "Clicked end icon", Toast.LENGTH_SHORT).show()
        }
        customIconOutlineTextInputLayout.setEndIconOnClickListener {
            Toast.makeText(requireContext(), "Clicked end icon", Toast.LENGTH_SHORT).show()
        }

        val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                arrayOf("Item 1", "Item 2", "Item 3", "Item 4")
        )
        filledAutoCompleteTextView.setAdapter(adapter)
        outlineAutoCompleteTextView.setAdapter(adapter)

        scrollView.applySystemWindowInsetsPadding(applyBottom = true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_common, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_current_theme -> {
                findNavController().navigate(R.id.action_show_ThemeInfoDialog)
                true
            }
            else -> false
        }
    }
}