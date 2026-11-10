package com.example.tenantmanagementsystem.ui.tenants

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenantmanagementsystem.ui.tenants.AddTenantFragmentDirections
import com.example.tenantmanagementsystem.data.model.Tenant
import com.example.tenantmanagementsystem.data.repository.TenantRepository
import com.example.tenantmanagementsystem.databinding.FragmentAddTenantBinding

class AddTenantFragment : Fragment() {

    private var _binding: FragmentAddTenantBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTenantBinding.inflate(
            inflater, container, false
        )
        Log.d("TENANT_LIFECYCLE", "AddTenantFragment: onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "AddTenantFragment: onViewCreated")


        binding.saveButton.setOnClickListener {
            val name = binding.tenantNameEditText.text.toString().trim()
            val phone = binding.phoneEditText.text.toString().trim()
            val rent = binding.rentEditText.text.toString().trim()

            if (name.isEmpty() || phone.isEmpty() || rent.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Please fill in all fields",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if (phone.filter { it.isDigit() }.length < 10) {
                binding.phoneEditText.error = "Enter a valid phone number"
                return@setOnClickListener
            }

            val tenant = Tenant(name, phone, rent)

            TenantRepository.addTenant(tenant)

            val action =
                AddTenantFragmentDirections
                    .actionAddTenantFragmentToViewTenantsFragment(tenant)

            findNavController().navigate(action)
        }


    }

    override fun onStart() {
        super.onStart()
        Log.d("TENANT_LIFECYCLE", "AddTenantFragment: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TENANT_LIFECYCLE", "AddTenantFragment: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TENANT_LIFECYCLE", "AddTenantFragment: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TENANT_LIFECYCLE", "AddTenantFragment: onStop")
    }

    override fun onDestroyView() {
        Log.d("TENANT_LIFECYCLE", "AddTenantFragment: onDestroyView")
        super.onDestroyView()
        _binding = null
    }
}