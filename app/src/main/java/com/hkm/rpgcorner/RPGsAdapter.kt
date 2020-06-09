package com.hkm.rpgcorner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RPGsAdapter(private val listRPG: ArrayList<RPG>) : RecyclerView.Adapter<RPGsAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_rpg, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listRPG.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val rpg = listRPG[position]

        Glide.with(holder.itemView.context)
            .load(rpg.photo)
            .apply(RequestOptions().override(516, 780))
            .into(holder.imgPhoto)

        Glide.with(holder.itemView.context)
            .load(rpg.store)
            .apply(RequestOptions().override(64, 64))
            .into(holder.imgStore)

        holder.tvName.text = rpg.name
        holder.tvDetail.text = rpg.detail
        holder.tvPrice.text = rpg.price

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listRPG[holder.adapterPosition]) }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var imgStore: ImageView = itemView.findViewById(R.id.img_sell_photo)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: RPG)
    }
}