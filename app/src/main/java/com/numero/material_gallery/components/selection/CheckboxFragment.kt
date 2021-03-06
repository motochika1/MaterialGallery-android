package com.numero.material_gallery.components.selection

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.fragment.findNavController
import com.numero.material_gallery.R
import com.numero.material_gallery.components.MaterialContainerTransformFragment

class CheckboxFragment : MaterialContainerTransformFragment(R.layout.fragment_checkbox) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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