package com.galileo.diegusweb.tipcalc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.galileo.diegusweb.tipcalc.R;
import com.galileo.diegusweb.tipcalc.model.TipRecord;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HP on 04/06/2016.
 */
public class TipAdapter extends RecyclerView.Adapter<TipAdapter.ViewHolder> {
    Context context;
    List<TipRecord> dataset;

    public TipAdapter(Context context, List<TipRecord> dataset){
        this.dataset = dataset;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TipRecord element = dataset.get(position);
        String strTip = String.format(context.getString(R.string.global_message_tip),
                element.getTip());

        holder.txtContent.setText(strTip);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void add(TipRecord record){
        dataset.add(0, record);
        notifyDataSetChanged();
    }

    public void clear(){
        dataset.clear();
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.txtContent)
        TextView txtContent;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}