package com.createsapp.mvvmretrofit2coroutines.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.createsapp.mvvmretrofit2coroutines.models.Employee
import com.createsapp.mvvmretrofit2coroutines.R

class EmployeesAdapter(
    private val context: Context,
    private var listEmployee: MutableList<Employee>
) : RecyclerView.Adapter<EmployeesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val getEmployee = listEmployee[position]
        holder.employeeName?.text = getEmployee.employeeName
        holder.employeeInfo1?.text = getEmployee?.employeeUserName + "|" + getEmployee?.employeeEmail
        holder.employeeInfo2?.text = getEmployee.employeePhone + "|" + getEmployee.employeeWebsite
        val employeeAddressObj = getEmployee.employeeAddressObject
        holder.employeeAddress?.text = employeeAddressObj?.employeeSuite+ "," +
                employeeAddressObj?.employeeStreet + ","+employeeAddressObj?.employeeCity + ","+employeeAddressObj?.employeeZipCode
    }

    override fun getItemCount(): Int {
        return listEmployee.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var employeeName:TextView?=null
        var employeeInfo1: TextView?=null
        var employeeInfo2: TextView?=null
        var employeeAddress: TextView?=null

        init {
            employeeName = itemView.findViewById(R.id.txt_employee_name)
            employeeInfo1 = itemView.findViewById(R.id.txt_employee_info1)
            employeeInfo2 = itemView.findViewById(R.id.txt_employee_info2)
            employeeAddress = itemView.findViewById(R.id.txt_employee_address)
        }
    }


}