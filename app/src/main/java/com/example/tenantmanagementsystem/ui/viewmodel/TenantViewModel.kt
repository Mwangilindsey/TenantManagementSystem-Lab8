
package com.example.tenantmanagementsystem.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.tenantmanagementsystem.data.local.TenantDatabase
import com.example.tenantmanagementsystem.data.local.TenantEntity
import com.example.tenantmanagementsystem.data.model.Tenant
import com.example.tenantmanagementsystem.data.repository.TenantRepository
import kotlinx.coroutines.launch

class TenantViewModel(application: Application) :
    AndroidViewModel(application) {

    // 1. Connect to the database
    private val database = TenantDatabase.getDatabase(application)

    // 2. Create the repository
    private val repository = TenantRepository(database.tenantDao())

    // 3. Observe tenants from Room
    val tenants: LiveData<List<Tenant>> =
        repository.getAllTenants().asLiveData()

    // 4. Calculate the number of tenants
    val tenantCountText: LiveData<String> = tenants.map { list ->
        "Tenants\n${list.size}"
    }

    // 5. Calculate total rent
    val totalRentText: LiveData<String> = tenants.map { list ->
        val total = list.sumOf {
            it.rent.toDoubleOrNull() ?: 0.0
        }
        "Total rent\nKSh %,.0f".format(total)
    }

    // 6. Display all tenants
    val allTenantsText: LiveData<String> = tenants.map { list ->
        if (list.isEmpty()) {
            "No tenants yet. Add one from the Dashboard."
        } else {
            list.joinToString("\n\n") { it.summary() }
        }
    }

    // 7. Add a tenant
    fun addTenant(
        name: String,
        phone: String,
        rent: String
    ): Tenant? {

        val cleanName = name.trim()
        val cleanPhone = phone.trim()
        val cleanRent = rent.trim()

        if (
            cleanName.isEmpty() ||
            cleanPhone.isEmpty() ||
            cleanRent.isEmpty()
        ) {
            return null
        }

        val tenant = Tenant(
            cleanName,
            cleanPhone,
            cleanRent
        )

        viewModelScope.launch {
            repository.addTenant(tenant)
        }

        return tenant
    }

    // 8. Update a tenant
    fun updateTenant(tenant: TenantEntity) {
        viewModelScope.launch {
            repository.updateTenant(tenant)
        }
    }

    // 9. Delete a tenant
    fun deleteTenant(tenant: TenantEntity) {
        viewModelScope.launch {
            repository.deleteTenant(tenant)
        }
    }

    init {
        Log.d("TENANT_LIFECYCLE", "TenantViewModel: created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TENANT_LIFECYCLE", "TenantViewModel: onCleared")
    }
}
