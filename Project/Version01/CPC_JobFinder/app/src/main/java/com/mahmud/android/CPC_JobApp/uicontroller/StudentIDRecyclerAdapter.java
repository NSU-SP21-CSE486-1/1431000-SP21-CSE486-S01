package com.mahmud.android.CPC_JobApp.uicontroller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahmud.android.CPC_JobApp.R;
import com.mahmud.android.CPC_JobApp.datasource.local.room.entity.StudentInfo;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentIDRecyclerAdapter
    extends RecyclerView.Adapter<StudentIDRecyclerAdapter.StudentIDViewHolder> {

  private List<StudentInfo> mStudentIDList;
  private OnStudentIDListener mOnStudentIDListener;

  class StudentIDViewHolder
      extends RecyclerView.ViewHolder
      implements View.OnClickListener{

    public final TextView studentIdItemView;
    OnStudentIDListener onStudentIDListener;

    public StudentIDViewHolder(@NonNull View itemView
        , StudentIDRecyclerAdapter mAdapter
        , OnStudentIDListener onStudentIDListener) {
      super(itemView);
      studentIdItemView = itemView.findViewById(R.id.id_view_for_recyclerview);
      this.onStudentIDListener = onStudentIDListener;
      itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      onStudentIDListener.onStudentIDClick(getAdapterPosition());
    }
  }

  public StudentIDRecyclerAdapter(OnStudentIDListener onStudentIDListener
      , List<StudentInfo> ids) {
    this.mOnStudentIDListener = onStudentIDListener;
    setStudentIDList(ids);
  }

  public void setStudentIDList(List<StudentInfo> ids){
    if(ids != null)
      mStudentIDList = ids;
    else
      mStudentIDList = new LinkedList<>();
  }
  public Integer getStudentID(int index){
    Integer id = null;

    if(mStudentIDList != null && index < mStudentIDList.size())
      id = mStudentIDList.get(index).getStudentID();

    return id;
  }

  @NonNull
  @Override
  public StudentIDViewHolder onCreateViewHolder(@NonNull ViewGroup parent
      , int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View mItemView = inflater.inflate(R.layout.display_student_ids_row_layout
        , parent
        , false);
    mItemView.setClickable(true);
    mItemView.setFocusableInTouchMode(true);
    return new StudentIDViewHolder(mItemView, this, mOnStudentIDListener);
  }

  @Override
  public void onBindViewHolder(@NonNull StudentIDViewHolder holder
      , int position) {
    Integer mCurrent = mStudentIDList.get(position).getStudentID();
    holder.studentIdItemView.setText(mCurrent.toString());
  }

  @Override
  public int getItemCount() {
    return mStudentIDList.size();
  }

  public StudentInfo getStudentInfoAtPosition(int position){
    return mStudentIDList.get(position);
  }

  public interface OnStudentIDListener{
    void onStudentIDClick(int position);
  }
}
