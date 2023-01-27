package com.example.payroll.presentation

import android.content.Context
import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.example.payroll.R
import com.example.payroll.data.database.MonthData
import com.example.payroll.databinding.FragmentMonthListBinding
import com.example.payroll.databinding.ListItemMonthBinding

class MonthListFragment: Fragment() {
    lateinit var binding: FragmentMonthListBinding
    private var callbacks: Callbacks? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacks = context as Callbacks?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMonthListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDetach() {
        super.onDetach()
        callbacks = null
    }

    companion object {
        fun newInstance(): MonthListFragment = MonthListFragment()
    }

    private inner class MonthAdapter(var month: List<MonthData>): ListAdapter<MonthData, MonthAdapter.abstMonthHolder >(DiffCallback()) {

        private abstract inner class abstMonthHolder(view: View): RecyclerView.ViewHolder(view) {
        }

        private inner class MonthHolder(view: View) : abstMonthHolder(view), View.OnClickListener {

            lateinit var month: MonthData
            val binding = ListItemMonthBinding.bind(view)

            init {
                itemView.setOnClickListener(this)
            }

            fun bind(month: MonthData) {
                this.month = month
                binding.monthTitle.text = month.title
                binding.monthDate.text =
                    DateFormat.format("EEE, d MMM, yyyy, HH:mm", this.month.date).toString()
                binding.monthSolved.visibility = if (month.isSolved) {
                    View.VISIBLE
                } else View.GONE
            }

            override fun onClick(v: View?) {
                callbacks?.onMonthSelected(id = month.id)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): abstMonthHolder {
            val createNewView = layoutInflater.inflate(R.layout.list_item_month, parent, false)
            return MonthHolder(view = createNewView)

        }

        override fun onBindViewHolder(holder: abstMonthHolder, position: Int) {
            when (holder) {
                is MonthHolder -> holder.bind(month = getItem(position))
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<MonthData>() {
        override fun areItemsTheSame(oldItem: MonthData, newItem: MonthData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MonthData, newItem: MonthData): Boolean {
            return oldItem == newItem
        }

    }




}