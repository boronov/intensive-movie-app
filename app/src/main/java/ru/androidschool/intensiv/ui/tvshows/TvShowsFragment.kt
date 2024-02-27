package ru.androidschool.intensiv.ui.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import ru.androidschool.intensiv.data.MockRepository
import ru.androidschool.intensiv.databinding.TvShowsFragmentBinding

class TvShowsFragment : Fragment() {

    private var _binding: TvShowsFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter by lazy {
        GroupAdapter<GroupieViewHolder>()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TvShowsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvShowsRecyclerView.adapter = adapter.apply { addAll(listOf()) }

        val tvShowsList = MockRepository.getTvShow().map {
            TvShowPreviewItem(it) { tvShow ->
                // TODO обработать слушатель
                Toast.makeText(this.context, "Clicked: ${tvShow.title}", Toast.LENGTH_SHORT).show()
            }
        }.toList()

        binding.tvShowsRecyclerView.adapter = adapter.apply { addAll(tvShowsList) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
