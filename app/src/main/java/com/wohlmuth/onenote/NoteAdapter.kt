package com.wohlmuth.onenote

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class NoteAdapter(context: Context): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = inflater.inflate(R.layout.list_item, parent, false)
        val title = view.findViewById(R.id.tvTitle) as TextView
        val message = view.findViewById(R.id.tvMessage) as TextView
        val note: Note = getItem(position) as Note

        title.text = note.title
        message.text = note.message

        return view
    }

    override fun getItem(p0: Int): Any {
        return Note(0, 0, "Test", "Pizza")
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return 20
    }

}