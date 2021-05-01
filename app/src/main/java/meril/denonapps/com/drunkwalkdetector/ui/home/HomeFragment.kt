package meril.denonapps.com.drunkwalkdetector.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import meril.denonapps.com.drunkwalkdetector.R
import meril.denonapps.com.drunkwalkdetector.databinding.FragmentHomeBinding
import meril.denonapps.com.drunkwalkdetector.utils.Utils
import meril.denonapps.com.drunkwalkdetector.viewmodel.HomeViewModel
import javax.inject.Inject


class HomeFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<HomeViewModel> { viewModelFactory }

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container, false
        ).apply {
            viewModel = this@HomeFragment.viewModel
            lifecycleOwner = this@HomeFragment
        }
        setupUi()
        subscribeForEvents()

        return binding.root
    }

    private fun setupUi() {
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        val contact = sharedPref.getString(Utils.EMERGENCY_CONTACT, "") ?: ""
        viewModel.setContactNumber(contact)
    }

    private fun subscribeForEvents() {
        viewModel.saveContact.observe(viewLifecycleOwner, {
            saveContact()
        })

        viewModel.removeContact.observe(viewLifecycleOwner, {
            removeContact()
        })

        viewModel.contactNumber.observe(viewLifecycleOwner, {
            arrangeContactUi(it)
        })
    }

    private fun arrangeContactUi(number: String) {
        if (number.isNotEmpty()) {
            binding.let {
                it.enterContact.visibility = View.GONE
                it.removeContact.visibility = View.VISIBLE
                it.tvContact.text = number
            }
        } else {
            binding.let {
                it.enterContact.visibility = View.VISIBLE
                it.removeContact.visibility = View.GONE
            }
        }
    }

    private fun removeContact() {
        val number = ""
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString(Utils.EMERGENCY_CONTACT, number)
            apply()
        }
        viewModel.setContactNumber(number)
    }

    private fun saveContact() {
        val number = binding.etContact.text.toString()
        if (number.isNotEmpty()) {
            val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
            with(sharedPref.edit()) {
                putString(Utils.EMERGENCY_CONTACT, number)
                apply()
            }
            binding.etContact.text.clear()
            viewModel.setContactNumber(number)
        } else {
            Toast.makeText(
                requireContext(), resources.getString(R.string.error_message_number),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {}
    }

}