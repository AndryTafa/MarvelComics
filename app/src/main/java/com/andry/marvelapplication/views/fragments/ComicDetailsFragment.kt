package com.andry.marvelapplication.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.compose.rememberAsyncImagePainter
import com.andry.marvelapplication.R
import com.andry.marvelapplication.data.models.Comic
import com.andry.marvelapplication.ui.customComposables.*
import com.andry.marvelapplication.utils.EmptyObjects
import com.andry.marvelapplication.viewmodels.MainViewModel

class ComicDetailsFragment : Fragment() {

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
        var selectedComic: Comic? = EmptyObjects.emptyComic()
        val bundle: Bundle? = arguments
        if (bundle != null) {
            selectedComic = bundle.getParcelable("selectedComic")
            Log.d(TAG, "RECEIVED $selectedComic")
        }
        view.apply {
            setContent {
                AppLayout(comic = selectedComic)
            }
        }
        return view
    }

    @Composable
    fun AppLayout(comic: Comic?) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            ThumbnailImageDetailsView(comic = comic)
            Row(modifier = Modifier.weight(1f)) { ComicTitleDetailsView(comic = comic) }
            Row(modifier = Modifier.weight(2f)) { ComicDescriptionDetailsView(comic = comic) }
            Row(modifier = Modifier.weight(1f)) {
                ExtraInfoRow(
                    comic = comic,
                    modifier = Modifier.padding(20.dp)
                )
            }
        }
    }
}
