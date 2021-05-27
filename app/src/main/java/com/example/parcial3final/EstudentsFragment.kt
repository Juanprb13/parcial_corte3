package com.example.parcial3final

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial3final.databinding.FragmentEstudentsBinding
import com.xwray.groupie.GroupieAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EstudentsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EstudentsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        var binding = DataBindingUtil.inflate<FragmentEstudentsBinding>(inflater,R.layout.fragment_estudents,container,false);
        binding.countriesRecyclerView.layoutManager =  LinearLayoutManager(view?.getContext())

        var adapter = GroupieAdapter()
        adapter.add(StudenItem("Juan","3134473",4.7624622,-74.10321060000001))
        adapter.add(StudenItem("Sofia","123456675",4.757958770882261,-74.09962149343849))
        adapter.add(StudenItem("Diana","123456675",4.757958770882261,-74.09962149343849))
        binding.countriesRecyclerView.adapter = adapter

        //return binding.root
        return binding.root
    }


}