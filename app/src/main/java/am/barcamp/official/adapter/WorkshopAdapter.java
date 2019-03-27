package am.barcamp.official.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import am.barcamp.official.R;
import am.barcamp.official.dto.ScheduleItem;

public class WorkshopAdapter extends RecyclerView.Adapter<WorkshopAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public Button saveButton;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.workshop_name);
            saveButton = itemView.findViewById(R.id.save_button);
        }
    }

    private List<ScheduleItem> workshops;

    public WorkshopAdapter(List<ScheduleItem> workshops) {
        this.workshops = workshops;
    }

    @Override
    public int getItemCount() {
        return workshops.size();
    }

    @Override
    public WorkshopAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View workshopView = inflater.inflate(R.layout.item_workshop, parent, false);

        ViewHolder viewHolder = new ViewHolder(workshopView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WorkshopAdapter.ViewHolder viewHolder, int position) {
        ScheduleItem workshop = workshops.get(position);

        TextView textView = viewHolder.nameTextView;
        textView.setText(workshop.getEn().getTopic());
        Button button = viewHolder.saveButton;
        button.setText("Save");
        button.setEnabled(true);
    }
}
