package com.example.lab_week_06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel

class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<CatViewHolder>() {

    // Mutable list untuk menyimpan data kucing
    private val cats = mutableListOf<CatModel>()

    // Fungsi untuk mengupdate data kucing
    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)
        notifyDataSetChanged() // memberi tahu adapter bahwa data telah berubah
    }

    // Membuat ViewHolder untuk setiap item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return CatViewHolder(view, imageLoader, onClickListener)
    }

    // Mengembalikan jumlah item di list
    override fun getItemCount(): Int = cats.size

    // Mengikat data ke setiap ViewHolder
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bindData(cats[position])
    }

    // Interface untuk menangani klik pada item
    interface OnClickListener {
        fun onItemClick(cat: CatModel)
    }
}
