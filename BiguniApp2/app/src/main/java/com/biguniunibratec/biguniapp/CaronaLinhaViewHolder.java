package com.biguniunibratec.biguniapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Rayssa&Thiago on 12/04/2017.
 */

public class CaronaLinhaViewHolder extends RecyclerView.ViewHolder {
    public CaronaLinhaViewHolder(View itemView) {
        super(itemView);

        TextView txtEndereco = (TextView) itemView.findViewById(R.id.txtendereco);
    }
}
