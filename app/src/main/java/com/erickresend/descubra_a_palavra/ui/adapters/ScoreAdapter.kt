package com.erickresend.descubra_a_palavra.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erickresend.descubra_a_palavra.data.models.DuoModel
import com.erickresend.descubra_a_palavra.databinding.ResPlayersBinding
import com.erickresend.descubra_a_palavra.databinding.ResScoreBinding

class ScoreAdapter(
    var onItemClick: ScoreAdapter.OnItemClick
) : RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>() {

    private var list = mutableListOf<DuoModel>()

    interface OnItemClick {
        fun onClick(player: DuoModel)
    }

    inner class ScoreViewHolder(private val binding: ResScoreBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(duo: DuoModel) {
            binding.textPlayer1.text = duo.name1
            binding.textPlayer2.text = duo.name2
            binding.textScorePlayer1.text = duo.score1.toString()
            binding.textScorePlayer2.text = duo.score2.toString()
            binding.cardPlayer.setOnClickListener {
                onItemClick.onClick(duo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val binding = ResScoreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScoreViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        val player = list[position]
        holder.bind(player)
    }

    fun setPlayerList(players: List<DuoModel>) {
        list = players.toMutableList()
        notifyDataSetChanged()
    }
}