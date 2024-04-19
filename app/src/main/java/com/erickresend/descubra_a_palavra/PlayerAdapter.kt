package com.erickresend.descubra_a_palavra

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erickresend.descubra_a_palavra.databinding.ResPlayersBinding

class PlayerAdapter(
    var onItemClick: OnItemClick
): RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    private var list = mutableListOf<DuoModel>()

    interface OnItemClick {
        fun onClick(player: DuoModel)
    }

    inner class PlayerViewHolder(private val binding: ResPlayersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(player: DuoModel) {
            binding.textPlayer1.text = player.name1
            binding.textPlayer2.text = player.name2
            binding.cardPlayer.setOnClickListener {
                onItemClick.onClick(player)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ResPlayersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = list[position]
        holder.bind(player)
    }

    fun setPlayerList(players: List<DuoModel>) {
        list = players.toMutableList()
        notifyDataSetChanged()
    }
}