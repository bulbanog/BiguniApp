package com.biguniunibratec.biguniapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Rayssa&Thiago on 12/04/2017.
 */

public class CaronaLinhaViewHolder extends RecyclerView.ViewHolder {

    public TextView txtnomelista;
    public TextView txtorigemlista;
    public TextView txtdestinolista;
    public TextView txtvagalista;
    public ImageView imagelista;



    public CaronaLinhaViewHolder(View itemView) {
        super(itemView);

        TextView txtorigemlista = (TextView) itemView.findViewById(R.id.txtorigemlista);
        TextView txtdestinolista = (TextView) itemView.findViewById(R.id.txtdestinolista);
        TextView txtnomelista = (TextView) itemView.findViewById(R.id.txtnomelista);
        TextView txtvagalista =(TextView) itemView.findViewById(R.id.txtvagalista);
        ImageView imagelista = (ImageView) itemView.findViewById(R.id.imagelista);
    }
}
