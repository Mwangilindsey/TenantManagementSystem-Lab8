package com.example.tenantmanagementsystem.ui.tenants

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.tenantmanagementsystem.ui.viewmodel.TenantViewModel
import com.example.tenantmanagementsystem.databinding.FragmentViewTenantsBinding

class ViewTenantsFragment : Fragment() {
    private val args: ViewTenantsFragmentArgs by navArgs()
    private var _binding: FragmentViewTenantsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TenantViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewTenantsBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.newTenantGroup.visibility = View.GONE

        val newTenant = args.newTenant
        binding.tenant = newTenant

        if (newTenant == null) {
            binding.newTenantGroup.visibility = View.GONE
        } else {
            binding.newTenantGroup.visibility = View.VISIBLE
        }

        binding.callButton.setOnClickListener {
            if (newTenant != null) {
                val intent = Intent(
                    Intent.ACTION_DIAL,
                    Uri.parse("tel:${newTenant.phone}")
                )
                startActivity(intent)
            }
        }

        // OBSERVER: runs now, and again every time allTenantsText changes
        viewModel.allTenantsText.observe(viewLifecycleOwner) { text ->
            binding.allTenantsTextView.text = text
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}