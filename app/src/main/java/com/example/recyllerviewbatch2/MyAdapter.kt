package com.example.recyllerviewbatch2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(private val data: ArrayList<MyModelClass>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var onClickListener: OnClickListener? = null

    class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val profile = itemView.findViewById<CircleImageView>(R.id.profile_image)
        val name = itemView.findViewById<TextView>(R.id.sample_user_name)
        val number = itemView.findViewById<TextView>(R.id.sample_user_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val myItem =
            LayoutInflater.from(parent.context).inflate(R.layout.sample_layout, parent, false)
        return MyViewHolder(myItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val singleData = data[position]
        holder.name.text = singleData.name
        holder.number.text = singleData.number
        Glide.with(holder.profile.context).load(singleData.profile).into(holder.profile)

        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, singleData)
            }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int, model: MyModelClass)
    }
}