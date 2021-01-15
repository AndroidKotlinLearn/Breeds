package br.com.breeds

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.breeds.databinding.BreedsFragmentBinding

class BreedsFragment: Fragment() {
    lateinit var viewModel: BreedsViewModel

    companion object {
        fun newInstance(viewModel: BreedsViewModel): BreedsFragment {
            val fragment = BreedsFragment()
            fragment.viewModel = viewModel
            return fragment        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: BreedsFragmentBinding = BreedsFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.recycleView.adapter = BreedsAdapter(emptyList())
        binding.recycleView.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }
}