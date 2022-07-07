package com.andry.marvelapplication.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.andry.marvelapplication.data.models.Comic
import com.andry.marvelapplication.ui.customComposables.DescriptionComicText
import com.andry.marvelapplication.ui.customComposables.HeaderComicText
import com.andry.marvelapplication.ui.customComposables.ThumbnailImageListView
import com.andry.marvelapplication.viewmodels.MainViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch


class ComicsListFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private val TAG = this.javaClass.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return configureView()
    }

    private fun configureView(): View {
        val view = ComposeView(requireContext())
        view.apply {
            setContent {
                AppLayout()
            }
        }
        return view
    }

    @Composable
    fun AppLayout() {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize(),
        ) {
            val comics = viewModel.comics.collectAsState()

            if (comics.value.isNotEmpty()) {
                ComicsList(comics.value)
            } else {
                HeaderComicText(
                    title = "No comics available at this time.",
                )
            }
        }
    }

    @Composable
    fun ComicsList(comics: List<Comic>) {
        val scope = rememberCoroutineScope() // this was the way I wanted to call coroutines in compose during the interview :)
        val isRefreshing = viewModel.isRefreshing.collectAsState()

        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing.value),
            onRefresh = {
                scope.launch {
                    viewModel.refreshComic()
                }
            },
        ) {
            LazyColumn(
                contentPadding = PaddingValues(8.dp)
            ) {
                items(comics.size) {
                    ComicCell(comic = comics[it])
                }
            }
        }

    }

    @Composable
    fun ComicCell(comic: Comic) {

        val thumbnailUrl = "${comic.thumbnail.path}.${comic.thumbnail.extension}"

        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(vertical = 7.dp, horizontal = 5.dp)
                .clickable(onClick = {
                    openComicDetailsfragment(comic)
                }),
        ) {
            ThumbnailImageListView(thumbnailUrl = thumbnailUrl)
            Column {
                HeaderComicText(title = comic.title, modifier = Modifier.padding(5.dp))
                comic.description?.let {
                    DescriptionComicText(
                        string = it,
                        modifier = Modifier.padding(
                            start = 5.dp,
                            bottom = 8.dp,
                            top = 2.dp,
                            end = 5.dp
                        )
                    )
                }
            }
        }
    }


    private fun openComicDetailsfragment(comic: Comic) {

        val bundle = Bundle()
        bundle.putParcelable("selectedComic", comic)

        val fragment = ComicDetailsFragment()
        fragment.arguments = bundle

        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(this.id, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }
}
