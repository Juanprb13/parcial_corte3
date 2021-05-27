package com.example.parcial3final

import com.example.parcial3final.databinding.CountryItemBinding
import com.xwray.groupie.databinding.BindableItem

class CountryItem(val name:String): BindableItem<CountryItemBinding>() {
    override fun bind(viewBinding: CountryItemBinding, position: Int) {
        viewBinding.NameTextView.text = name
    }

    override fun getLayout(): Int {
        return R.layout.country_item
    }

}