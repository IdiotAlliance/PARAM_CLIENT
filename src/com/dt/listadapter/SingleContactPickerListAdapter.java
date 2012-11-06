package com.dt.listadapter;

import java.util.List;

import com.dt.bean.Contact;
import com.dt.param.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ����������ϵ�˶�ѡ�б��apdater
 * @author HP
 *
 */
public class SingleContactPickerListAdapter extends BaseAdapter{
	
	private LayoutInflater inflater;
	private List<Contact> contacts;
	
	public SingleContactPickerListAdapter(Context context,List<Contact> contacts){
		this.contacts = contacts;
		this.inflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return contacts.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return contacts.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if(convertView==null){
			convertView = inflater.inflate(R.layout.simple_multi_choice_item, null);
			holder = new ViewHolder();
			holder.checkBox = (ImageView) convertView.findViewById(R.id.simple_multi_choice_checkbox);
			holder.name = (TextView) convertView.findViewById(R.id.simple_multi_choice_name);
			holder.number = (TextView) convertView.findViewById(R.id.simple_multi_choice_number);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		if(this.contacts.get(position).chosen)
			holder.checkBox.setImageResource(R.drawable.checkbox_selected);
		else
			holder.checkBox.setImageResource(R.drawable.checkbox_unselected);
		holder.name.setText(this.contacts.get(position).name);
		holder.number.setText(this.contacts.get(position).number);
		
		return convertView;
	}

	private class ViewHolder{
		ImageView checkBox;
		TextView name;
		TextView number;
	}
	
}
