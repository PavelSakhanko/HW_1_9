package me.pavelsakhanko.androidApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.pavelsakhanko.shared.models.Recipe

class RecipesAdapter : RecyclerView.Adapter<RecipeViewHolder>() {

    private var items: ArrayList<Recipe> = arrayListOf()

    fun updateItems(items: List<Recipe>) {
        this.items = arrayListOf()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context),parent)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = items[position]
        holder.bindItem(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}