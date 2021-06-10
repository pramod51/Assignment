package com.assign.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.assign.assignment.Database.MyAppDatabase;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PostAdopter extends RecyclerView.Adapter<PostAdopter.ViewHolder> {
    private ArrayList<Post> postModels;
    private Context context;

    public PostAdopter(ArrayList<Post> postModels, Context context) {
        this.postModels = postModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_iitems,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post=postModels.get(position);
        Glide.with(context).load(post.getFlag()).into(holder.flagImageView);
        holder.name.setText(post.getName());
        holder.capital.setText(post.getCapital());
        holder.regions.setText(post.getRegion());
        holder.subRegion.setText(post.getSubregion());
        holder.population.setText(post.getPopulation());
        ArrayList<Languages> languages=post.getLanguages();
        String lang="";
        /*for (Languages l:languages){
            lang+="Name: "+l.getName()+"\n";
            lang+="nativeName: "+l.nativeName+"\n\n";
        }*/
        holder.language.setText(lang);
        //holder.borders.setText(post.getBorders().toString());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postModels.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,capital,regions,subRegion,population,language,borders;
        ImageView flagImageView;
        Button delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            capital=itemView.findViewById(R.id.capital);
            regions=itemView.findViewById(R.id.region);
            subRegion=itemView.findViewById(R.id.sub_region);
            population=itemView.findViewById(R.id.population);
            language=itemView.findViewById(R.id.language);
            borders=itemView.findViewById(R.id.borders);
            flagImageView=itemView.findViewById(R.id.flag);
            delete=itemView.findViewById(R.id.delete);
        }
    }
}
