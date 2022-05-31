package com.example.torangvideoview

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.VideoView

class TorangVideoView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    FrameLayout(context, attr, defStyleAttr) {
    init {
        addView(inflate(context, R.layout.custom_videoview, null))

        val videoView = findViewById<VideoView>(R.id.vv)
        val btn = findViewById<ImageView>(R.id.btn_start)

        videoView.setOnClickListener {
            if (videoView.isPlaying) {
                btn.visibility = View.VISIBLE
                videoView.pause()
            } else {
                btn.visibility = View.GONE
                videoView.start()
            }
        }

        btn.setOnClickListener {
            videoView.start()
            btn.visibility = View.GONE
        }

    }

    fun setUrl(url: String) {
        findViewById<VideoView>(R.id.vv)
            .setVideoURI(Uri.parse(url))

        findViewById<VideoView>(R.id.vv).seekTo( 1 )
    }
}