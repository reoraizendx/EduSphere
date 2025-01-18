package com.example.edusphere.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.edusphere.R;
import com.example.edusphere.model.Assignment;
import com.example.edusphere.modelview.AssignmentViewModel;
import java.util.List;

public class AssignmentListFragment extends Fragment {

    private AssignmentViewModel assignmentViewModel;
    private RecyclerView recyclerView;
    private AssignmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return null;
    }

    static class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {
        private List<Assignment> assignmentList;

        public void setAssignmentList(List<Assignment> assignmentList) {
            this.assignmentList = assignmentList;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_assignment, parent, false);
            return new AssignmentViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AssignmentViewHolder holder, int position) {
            Assignment assignment = assignmentList.get(position);
            holder.titleTextView.setText(assignment.getTitle());
            holder.descriptionTextView.setText(assignment.getDescription());
            holder.dueDateTextView.setText("Deadline Pengumpulan: " + assignment.getDueDate());
        }

        @Override
        public int getItemCount() {
            return assignmentList == null ? 0 : assignmentList.size();
        }

        public void setAssignmentList(Object assignments) {
        }

        static class AssignmentViewHolder extends RecyclerView.ViewHolder {
            TextView titleTextView;
            TextView descriptionTextView;
            TextView dueDateTextView;

            public AssignmentViewHolder(@NonNull View itemView) {
                super(itemView);
                titleTextView = itemView.findViewById(R.id.assignment_title);
                descriptionTextView = itemView.findViewById(R.id.assignment_description);
                dueDateTextView = itemView.findViewById(R.id.assignment_due_date);
            }
        }
    }
}
