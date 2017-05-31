package com.biguniunibratec.biguniapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;
/**
 * Created by JOHN on 31/05/2017.
 */

public class CaronaAdapter extends RecyclerView.Adapter<CaronaLinhaViewHolder> {
    private List <Carona> caronaList;

    public CaronaAdapter(List<Carona> caronas) {
        caronaList = caronas;
    }


    @Override
    public CaronaLinhaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CaronaLinhaViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.caronalinha, parent, false));
    }

    @Override
    public void onBindViewHolder(CaronaLinhaViewHolder holder, int position) {
        holder.txtnomelista.setText(caronaList.get(position).getNome());
        holder.txtorigemlista.setText(caronaList.get(position).getOrigem());
        holder.txtdestinolista.setText(caronaList.get(position).getDestino());
        holder.txtvagalista.setText(Integer.toString(caronaList.get(position).getVaga()));

    }

    @Override
    public int getItemCount() {
        return caronaList.size();
    }

}
