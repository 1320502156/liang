package com.example.liang.yuk.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.liang.yuk.MainActivity;
import com.example.liang.yuk.R;
import com.example.liang.yuk.bean.User;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<User.RecentBean> recentBeans;
    public Myadapter(MainActivity mainActivity, ArrayList<User.RecentBean> recentBeans) {
        this.context=mainActivity;
        this.recentBeans=recentBeans;
    }

    @Override
        public int getItemViewType(int position) {
        User.RecentBean recentBean = recentBeans.get(position);
        if (position%2==0){
                  return 1;
            }else{
                return 2;
            }

        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            RecyclerView.ViewHolder holder=null;
            if (1==viewType){
                View view = LayoutInflater.from(context).inflate(R.layout.item, null);
                holder=new OneviewHolder(view);
            }else{
                View view = LayoutInflater.from(context).inflate(R.layout.item2, null);
                holder=new TwoviewHolder(view);
            }
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            User.RecentBean recentBean = recentBeans.get(position);
            if (holder instanceof OneviewHolder){
             ((OneviewHolder) holder).tv1.setText(recentBean.getTitle());
           //  ((OneviewHolder) holder).tv2.setText(recentBean.getNews_id());
             Glide.with(context).load(recentBean.getThumbnail()).into(((OneviewHolder) holder).img);
            }else if (holder instanceof TwoviewHolder){
                ((TwoviewHolder) holder).tv3.setText(recentBean.getTitle());
              //  ((TwoviewHolder) holder).tv4.setText(recentBean.getNews_id());
                Glide.with(context).load(recentBean.getThumbnail()).into(((TwoviewHolder) holder).img2);
            }

        }

        @Override
        public int getItemCount() {
            return recentBeans.size();
        }

        public class OneviewHolder extends RecyclerView.ViewHolder{

            private final ImageView img;
            private final TextView tv1;
            private final TextView tv2;
是U和是用于给uguiubb

            public OneviewHolder(View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.img);
                tv1 = itemView.findViewById(R.id.tv1);
                tv2 = itemView.findViewById(R.id.tv2);

            }
        }
        public class TwoviewHolder extends RecyclerView.ViewHolder {

            private final ImageView img2;
            private final TextView tv3;
            private final TextView tv4;


            public TwoviewHolder(View itemView) {
                super(itemView);
                img2 = itemView.findViewById(R.id.img2);
                tv3 = itemView.findViewById(R.id.tv3);
                tv4 = itemView.findViewById(R.id.tv4);

            }
        }
}
