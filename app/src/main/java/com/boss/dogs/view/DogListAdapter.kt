package com.boss.dogs.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.boss.dogs.R
import com.boss.dogs.databinding.ItemDogBinding
import com.boss.dogs.model.DogBreed
import com.boss.dogs.util.getProgressDrawable
import com.boss.dogs.util.loadImage
import kotlinx.android.synthetic.main.item_dog.view.*

class DogListAdapter(val dogList: ArrayList<DogBreed>): RecyclerView.Adapter<DogListAdapter.DogViewHolder>(),DogClickListener {

    fun updateDogList(newDogsList: List<DogBreed>){
        dogList.clear()
        dogList.addAll(newDogsList)
        notifyDataSetChanged()
    }

    class DogViewHolder(var view: ItemDogBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemDogBinding>(inflater,R.layout.item_dog,parent,false)
        return DogViewHolder(view)
    }

    override fun getItemCount() = dogList.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.dog = dogList[position]
        holder.view.listener = this


//        holder.view.name.text = dogList[position].dogBreed
//        holder.view.lifespan.text = dogList[position].lifeSpan
//        holder.view.setOnClickListener {
//            val action = ListFragmentDirections.actionDetailFragment()
//            action.dogUuid = dogList[position].uuid
//            Navigation.findNavController(it).navigate(action)
//        }
//
//        holder.view.imageView.loadImage(dogList[position].imageUrl, getProgressDrawable(holder.view.imageView.context))
    }

    override fun onDogClicked(v: View) {
            val uuid = v.dogId.text.toString().toInt()
            val action = ListFragmentDirections.actionDetailFragment()
            action.dogUuid = uuid
            Navigation.findNavController(v).navigate(action)
    }
}