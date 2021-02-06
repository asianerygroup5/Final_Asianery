package com.example.asianery5;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.StudentViewer> {

    List<POJO> asianeryDetails;
    Context context;
    OpenHelper dbhelper;
    SQLiteDatabase sqLiteDatabase;

    public RecycleAdapter(List<POJO> asianeryDetails) {
        this.asianeryDetails = asianeryDetails;
    }

    @NonNull
    @Override
    public StudentViewer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View iteView = inflater.inflate(R.layout.asianery_info, parent, false);
        StudentViewer viewHolder = new StudentViewer(iteView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewer holder, final int position) {
        final POJO pojo = asianeryDetails.get(position);

        holder.sID.setText("User #: " + pojo.getS_id());
        holder.cName.setText(" " + pojo.getC_name());
        holder.cDescription.setText(" " + pojo.getC_description());
        holder.cExperience.setText(" " + pojo.getC_experience());
        holder.pName.setText("From: " + pojo.getP_name());
        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int pId = pojo.getS_id();
                dbhelper = new OpenHelper(context);
                sqLiteDatabase = dbhelper.getWritableDatabase();
                sqLiteDatabase.delete(DatabaseInfo.TABLE_NAME, DatabaseInfo._ID+ " = " + pId,null);
                notifyItemRangeChanged(position,asianeryDetails.size());
                asianeryDetails.remove(position);
                notifyItemRemoved(position);
                sqLiteDatabase.close();
            }
        });

        holder.Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, update.class);
                intent.putExtra("stuId", pojo.getS_id());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return asianeryDetails.size();
    }

    public class StudentViewer extends RecyclerView.ViewHolder {
        TextView sID;
        TextView cName;
        TextView cDescription;
        TextView cExperience;
        TextView pName;
        TextView Delete;
        TextView Update;

        TextView tName;
        TextView tDescription;
        TextView tExperience;

        public StudentViewer(View itemView) {
            super(itemView);
            sID = itemView.findViewById(R.id.txtid);
            cName = itemView.findViewById(R.id.txtname);
            cDescription = itemView.findViewById(R.id.txtdescription);
            cExperience = itemView.findViewById(R.id.txtexperience);
            pName = itemView.findViewById(R.id.txtpname);
            Delete = itemView.findViewById(R.id.Delete);
            Update = itemView.findViewById(R.id.Update);

            tName = itemView.findViewById(R.id.tCName);
            tDescription = itemView.findViewById(R.id.tCDescription);
            tExperience = itemView.findViewById(R.id.tCExperience);

        }
    }
    public void deleteStudent() {

    }
}
