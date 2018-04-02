package diegorys.es.ejemplolistasadapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.Logger;

import diegorys.es.ejemplolistasadapter.R;
import diegorys.es.ejemplolistasadapter.SuperHeroe;

/**
 * Created by Diego on 29/10/2015.
 */
public class SuperHeroeAdapter extends ArrayAdapter<SuperHeroe> {
    Context context;
    int layoutResourceId;
    SuperHeroe data[] = null;

    public SuperHeroeAdapter(Context context, int layoutResourceId, SuperHeroe[] data) {
        super(context, layoutResourceId, data);

        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        SuperHeroeHolder holder = null;

        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new SuperHeroeHolder();
            holder.imgAvatar = (ImageView)row.findViewById(R.id.imgAvatar);
            holder.txtNombre = (TextView)row.findViewById(R.id.txtNombre);
            row.setTag(holder);
        }else{
            holder = (SuperHeroeHolder)row.getTag();
        }

        SuperHeroe heroe = this.data[position];
        holder.txtNombre.setText(heroe.nombre);
        holder.imgAvatar.setImageResource(heroe.icon);

        return row;
    }

    static class SuperHeroeHolder{
        ImageView imgAvatar;
        TextView txtNombre;
    }
}
