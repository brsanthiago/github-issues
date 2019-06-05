package br.com.brsantiago.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.brsantiago.databinding.CardIssueBinding
import br.com.brsantiago.domain.Issue


class IssueAdapter(private val issues: MutableList<Issue>) :
    RecyclerView.Adapter<IssueAdapter.IssueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        return IssueViewHolder(
            CardIssueBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun getItemCount() = issues.size


    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        holder.bind(issues[position])
    }

    class IssueViewHolder(private var binding: CardIssueBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(issue: Issue) {
            this.binding.issue = issue
        }
    }
}