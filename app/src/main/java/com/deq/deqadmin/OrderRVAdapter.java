package com.deq.deqadmin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderRVAdapter extends RecyclerView.Adapter<OrderRVAdapter.ViewHolder> {
    private ArrayList<OrderModel> orderModelArrayList;
    private Context context;
    private OrderClickInterface orderClickInterface;

    public OrderRVAdapter(ArrayList<OrderModel> orderModelArrayList, Context context, OrderClickInterface orderClickInterface) {
        this.orderModelArrayList = orderModelArrayList;
        this.context = context;
        this.orderClickInterface = orderClickInterface;
    }

    int lastPos = -1;
    @NonNull
    @Override
    public OrderRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderRVAdapter.ViewHolder holder, int position) {

        OrderModel orderModel = orderModelArrayList.get(position);
        holder.personName.setText(orderModel.getPersonName());
        holder.arrivalTime.setText(orderModel.getArrivalTime());
        holder.orderData.setText(orderModel.getOrderData());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderClickInterface.onCourseClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView personName, arrivalTime, orderData;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            personName = itemView.findViewById(R.id.idIVPerson);
            arrivalTime = itemView.findViewById(R.id.idIVTime);
            orderData = itemView.findViewById(R.id.idIVOrderData);
        }
    }

    public interface OrderClickInterface{
        void onCourseClick(int position);
    }
}
