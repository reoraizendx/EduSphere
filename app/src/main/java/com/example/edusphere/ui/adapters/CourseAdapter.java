package com.example.edusphere.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.edusphere.R;
import com.example.edusphere.model.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private List<Course> courses = new ArrayList<>();

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course currentCourse = courses.get(position);
        holder.courseTitle.setText(currentCourse.getTitle());
        holder.courseDescription.setText(currentCourse.getDescription());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        notifyDataSetChanged();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseTitle;
        private final TextView courseDescription;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTitle = itemView.findViewById(R.id.course_title);
            courseDescription = itemView.findViewById(R.id.course_description);
        }
    }
}
