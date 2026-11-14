
package com.example.tenantmanagementsystem.data.repository

import com.example.tenantmanagementsystem.data.local.TenantDao
import com.example.tenantmanagementsystem.data.local.TenantEntity
import com.example.tenantmanagementsystem.data.model.Tenant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TenantRepository(
    private val tenantDao: TenantDao
) {

    // Retrieve all tenants from Room
    fun getAllTenants(): Flow<List<Tenant>> {
        return tenantDao.getAllTenants().map { entities ->
            entities.map { entity ->
                Tenant(
                    name = entity.name,
                    phone = entity.phone,
                    rent = entity.rent
                )
            }
        }
    }

    // Insert a new tenant
    suspend fun addTenant(tenant: Tenant) {
        val entity = TenantEntity(
            name = tenant.name,
            phone = tenant.phone,
            rent = tenant.rent
        )

        tenantDao.insertTenant(entity)
    }

    // Update an existing tenant
    suspend fun updateTenant(tenant: TenantEntity) {
        tenantDao.updateTenant(tenant)
    }

    // Delete a tenant
    suspend fun deleteTenant(tenant: TenantEntity) {
        tenantDao.deleteTenant(tenant)
    }
}
