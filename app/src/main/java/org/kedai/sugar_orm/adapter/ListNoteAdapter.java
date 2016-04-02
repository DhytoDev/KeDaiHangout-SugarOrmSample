package org.kedai.sugar_orm.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.kedai.sugar_orm.R;
import org.kedai.sugar_orm.models.Note;

import java.util.List;

/**
 * Created by Lenovo on 03/04/2016.
 */
public class ListNoteAdapter extends BaseAdapter {
    private Activity activity ;
    private List<Note> notes ;


    public ListNoteAdapter(Activity activity, List<Note> notes) {
        this.activity = activity ;
        this.notes = notes;
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null ;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_note, null) ;
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.txt_item_title);
            holder.txtTask = (TextView) convertView.findViewById(R.id.txt_item_task);
            holder.txtDate = (TextView) convertView.findViewById(R.id.txt_item_date);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Note note = (Note) getItem(position);
        holder.txtTitle.setText(note.getTitle());
        holder.txtTask.setText(note.getTask());
        holder.txtDate.setText(note.getDate());

        return convertView;
    }

    static class ViewHolder {
        TextView txtTitle ;
        TextView txtTask ;
        TextView txtDate ;
    }

}
