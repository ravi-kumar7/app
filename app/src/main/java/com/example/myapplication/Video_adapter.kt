package com.example.myapplication

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView

class Video_adapter(var videolist: ArrayList<String>):RecyclerView.Adapter<Video_adapter.ViewHolder>(){

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val video:VideoView = view.findViewById(R.id.video)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return videolist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var video = videolist[position]
        holder.video.setVideoURI(video.toUri())
        holder.video.setOnTouchListener( View.OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN){
                holder.video.start()
            }
            true
        })
    }
}