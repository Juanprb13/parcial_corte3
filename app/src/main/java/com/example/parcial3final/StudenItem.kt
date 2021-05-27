package com.example.parcial3final

import com.example.parcial3final.databinding.ItemStudentBinding
import com.xwray.groupie.databinding.BindableItem

class StudenItem(val name:String, val telefono:String, val longitude: Double, val latitude: Double): BindableItem<ItemStudentBinding>() {
    override fun bind(viewBinding: ItemStudentBinding, position: Int) {
        viewBinding.NameTextView.text = name
        viewBinding.phoneTextView.text = telefono
        viewBinding.LongitudeTextView.text = longitude.toFloat().toString()
        viewBinding.LatitudeTextView.text = latitude.toFloat().toString()
    }

    override fun getLayout(): Int {
        return R.layout.item_student
    }
}