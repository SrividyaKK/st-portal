package universe.sk.stportal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ComplaintAdapter extends ArrayAdapter<Complaint> {
    private Context context;
    private ArrayList<Complaint> complaints;

    // View lookup cache
    private static class ViewHolder {
        TextView busNum, compDate, compMsg;
    }

    public ComplaintAdapter(ArrayList<Complaint> data, Context context) {
        super(context, R.layout.row_complaint, data);
        this.complaints = data;
        this.context = context;
    }

//    private int lastPosition = -1;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Complaint complaint = complaints.get(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.row_complaint, parent, false);
            viewHolder.busNum = convertView.findViewById(R.id.tvBusNumber);
            viewHolder.compDate = convertView.findViewById(R.id.tvCompDate);
            viewHolder.compMsg = convertView.findViewById(R.id.tvCompMsg);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.busNum.setText(complaint.getBusNum());
        viewHolder.compDate.setText(complaint.getCompDate());
        viewHolder.compMsg.setText(complaint.getCompMsg());

        return convertView; //return the completed view to render on screen
    }
}
