package com.handini.teamsoccer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ListTeamAdapter extends RecyclerView.Adapter<ListTeamAdapter.ViewHolder> {
    private ArrayList<TeamItem> teamItems;
    private Context context;

    public ArrayList<TeamItem> getTeamItems() {
        return teamItems;
    }

    public void setTeamItems(ArrayList<TeamItem> teamItems) {
        this.teamItems = teamItems;
    }

    public ListTeamAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lis_row,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(getTeamItems().get(i).getStrTeamBadge()).into(viewHolder.imageView);
        viewHolder.tvTeam.setText(String.format("\t\t\t%s", getTeamItems().get(i).getStrTeam()));
        viewHolder.tvManager.setText(String.format("\t\t\t%s", getTeamItems().get(i).getStrManager()));
        viewHolder.tvStadion.setText(String.format("\t\t\t%s", getTeamItems().get(i).getStrStadium()));

    }

    @Override
    public int getItemCount() {

        return getTeamItems().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.img_photo)
    CircleImageView imageView;

    @BindView(R.id.tv_nameteam)
    TextView tvTeam;

    @BindView(R.id.tv_manager)
    TextView tvManager;

    @BindView(R.id.tv_stadion)
    TextView tvStadion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
