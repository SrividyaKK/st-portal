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

public class ApplicationAdapter extends ArrayAdapter<Application> {
    Context context;
    private ArrayList<Application> applications;

    // View lookup cache
    private static class ViewHolder {
        TextView adminNum, name, status ;
    }

    public ApplicationAdapter(ArrayList<Application> data, Context context) {
        super(context, R.layout.row_application, data);
        this.applications = data;
        this.context = context;
    }

//    private int lastPosition = -1;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Application application = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ApplicationAdapter.ViewHolder viewHolder; // view lookup cache stored in tag
        final View result;

        if (convertView == null) {
            viewHolder = new ApplicationAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_complaint, parent, false);
            viewHolder.adminNum = convertView.findViewById(R.id.tvAdminNumber);
            viewHolder.name = convertView.findViewById(R.id.tvName);
            viewHolder.status = convertView.findViewById(R.id.tvStatus);

            result = convertView;
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ApplicationAdapter.ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.adminNum.setText(application.getid());
        viewHolder.name.setText(application.getname());
        viewHolder.status.setText(application.getstatus());

        return convertView; //return the completed view to render on screen
        //return super.getView(position, convertView, parent);
    }
}
