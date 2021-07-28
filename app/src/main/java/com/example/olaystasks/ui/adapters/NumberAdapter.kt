package com.example.olaystasks.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.olaystasks.databinding.NumberItemBinding

class NumberAdapter():
RecyclerView.Adapter<NumberAdapter.NumberViewHolder>(){
    var numberList: List<Int> = mutableListOf()
    var myHolder: NumberViewHolder? = null

    fun updateNumberList(listOfNumbers: List<Int>){
        this.numberList = listOfNumbers
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        return NumberViewHolder(
        NumberItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
            )
        )
    }


    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        this.myHolder = holder
        holder.binding.apply{
            val number = numberList[position]
            tvNumberItem.text = number.toString()
        }
    }

    override fun getItemCount(): Int = numberList.size


    class NumberViewHolder(var binding: NumberItemBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bindTo(number: Int){
                    with(binding){
                        tvNumberItem.text = number.toString()
                    }
                }
            }
}