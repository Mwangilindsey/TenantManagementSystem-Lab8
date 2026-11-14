
package com.example.tenantmanagementsystem.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TenantDao {

    // Insert a new tenant
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTenant(tenant: TenantEntity)

    // Retrieve all tenants
    @Query("SELECT * FROM tenants ORDER BY id DESC")
    fun getAllTenants(): Flow<List<TenantEntity>>

    // Retrieve one tenant using its ID
    @Query("SELECT * FROM tenants WHERE id = :tenantId")
    suspend fun getTenantById(tenantId: Int): TenantEntity?

    // Update an existing tenant
    @Update
    suspend fun updateTenant(tenant: TenantEntity)

    // Delete a tenant
    @Delete
    suspend fun deleteTenant(tenant: TenantEntity)

    // Delete a tenant using its ID
    @Query("DELETE FROM tenants WHERE id = :tenantId")
    suspend fun deleteTenantById(tenantId: Int)
}
