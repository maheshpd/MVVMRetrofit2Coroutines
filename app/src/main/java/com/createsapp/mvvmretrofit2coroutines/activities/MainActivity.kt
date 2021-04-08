package com.createsapp.mvvmretrofit2coroutines.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.createsapp.mvvmretrofit2coroutines.*
import com.createsapp.mvvmretrofit2coroutines.adapters.EmployeesAdapter
import com.createsapp.mvvmretrofit2coroutines.models.Employee
import com.createsapp.mvvmretrofit2coroutines.utils.ApiStatus
import com.createsapp.mvvmretrofit2coroutines.viewmodels.EmployeeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var listEmployees: MutableList<Employee>
    private lateinit var employeesAdapter: EmployeesAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_employees.layoutManager = LinearLayoutManager(this@MainActivity)
        listEmployees = mutableListOf<Employee>()
        employeesAdapter = EmployeesAdapter(this, listEmployees)
        recycler_employees.adapter = employeesAdapter

        val employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel::class.java)
        employeeViewModel.getEmployee().observe(this, Observer {
            it?.let { apiResponse ->
                when (apiResponse.apiStatus) {
                    ApiStatus.SUCCESS -> {
                        recycler_employees.visibility = View.VISIBLE
                        apiResponse.data?.let {
                            listEmployees.clear()
                            listEmployees.addAll(it)
                            employeesAdapter.apply {
                                notifyDataSetChanged()
                            }
                        }
                    }

                    ApiStatus.ERROR -> {
                        recycler_employees.visibility = View.VISIBLE
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    }

                    ApiStatus.LOADING -> {
                        recycler_employees.visibility = View.GONE
                    }

                }
            }
        })


    }
}