package com.apple.matchscores

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apple.matchscores.data.Data
import com.apple.matchscores.databinding.GameBinding

class GameNameAdapter(private val gameList: List<Data>): RecyclerView.Adapter<GameNameAdapter.ViewHolder>() {
    class ViewHolder(val binding: GameBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = gameList[position]
        val teams = game.name.split(" vs ")
        val team1Score=game.scores[4].score.goals.toString()
        val team2Score=game.scores[5].score.goals.toString()
        holder.binding.team1.text = teams[0]
        holder.binding.team2.text = teams[1]
        holder.binding.score1.text = team1Score
        holder.binding.score2.text = team2Score
        holder.binding.time.text = game.length.toString()
        if (team1Score>team2Score) {
            holder.binding.team1State.setImageResource(R.drawable.ic_up)
            holder.binding.team2State.setImageResource(R.drawable.ic_down)
        }
        else if (team1Score<team2Score) {
            holder.binding.team1State.setImageResource(R.drawable.ic_down)
            holder.binding.team2State.setImageResource(R.drawable.ic_up)
        }
        else {
            holder.binding.team1State.setImageResource(R.drawable.ic_equal)
            holder.binding.team2State.setImageResource(R.drawable.ic_equal)
        }
    }
}