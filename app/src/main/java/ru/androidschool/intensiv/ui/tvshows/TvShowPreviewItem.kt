package ru.androidschool.intensiv.ui.tvshows

import android.view.View
import com.squareup.picasso.Picasso
import com.xwray.groupie.viewbinding.BindableItem
import ru.androidschool.intensiv.R
import ru.androidschool.intensiv.data.TvShow
import ru.androidschool.intensiv.databinding.ItemFullWidthWithTextBinding

class TvShowPreviewItem(
    private val content: TvShow,
    private val onClick: (tvShow: TvShow) -> Unit
) : BindableItem<ItemFullWidthWithTextBinding>() {

    override fun getLayout() = R.layout.item_full_width_with_text

    override fun bind(view: ItemFullWidthWithTextBinding, position: Int) = with(view) {
        imagePreview.setOnClickListener {
            onClick.invoke(content)
        }

        Picasso.get()
            .load(content.posterUrl)
            .into(imagePreview)

        description.text = content.title
        movieRating.rating = content.rating
    }

    override fun initializeViewBinding(v: View): ItemFullWidthWithTextBinding =
        ItemFullWidthWithTextBinding.bind(v)
}
