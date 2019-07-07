package cn.test.materialdesign.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.test.materialdesign.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.VH> {
    private List<String> lists;
    private OnRecyclerViewItemClickListener onItemClickListener;
    private OnRecyclerViewItemLongClickListener onItemLongClickListener;

    public ListAdapter(List<String> data) {
        this.lists = data;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.title.setText(lists.get(position));
        holder.itemView.setOnClickListener((View v) -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new VH(v);
    }

    public static class VH extends RecyclerView.ViewHolder {
        public TextView title;

        public VH(View v) {
            super(v);
            title = v.findViewById(R.id.tv_item);
        }
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnRecyclerViewItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnRecyclerViewItemLongClickListener listener) {
        this.onItemLongClickListener = listener;
    }
}
