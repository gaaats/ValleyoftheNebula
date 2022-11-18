package com.playgendary.sportmasterss.gogogo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.playgendary.sportmasterss.R
import com.playgendary.sportmasterss.databinding.FragmentEnteringBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class EnteringFragment : Fragment() {
//
//    var counterAlphafrgtgt = 0.05f
//    var diffAlphafrgt = 0.05f
//    var isLaunchedAlphafrgt = false

    private var _binding: FragmentEnteringBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentEnteringBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnteringBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            binding.root.background.alpha = 210

            binding.btnVhel.setOnClickListener {
                findNavController().navigate(R.id.action_enteringFragment_to_vhelFragment)
            }
            binding.btnMachine.setOnClickListener {
                findNavController().navigate(R.id.action_enteringFragment_to_machineFragment)
            }
            binding.tvFortuneVheel.setOnClickListener {
                findNavController().navigate(R.id.action_enteringFragment_to_vhelFragment)
            }
            binding.tvFortuneMachine.setOnClickListener {
                findNavController().navigate(R.id.action_enteringFragment_to_machineFragment)
            }
        } catch (e: Exception) {
            edfrgtysnackBarError()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun edfrgtysnackBarError() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }
//
//    private fun rfrgtyhyyju538() {
//        if (!isLaunchedAlphafrgt){
//            lifecycleScope.launch {
//                isLaunchedAlphafrgt = !isLaunchedAlphafrgt
//                while (true) {
//                    binding.tvFortuneMachine.alpha = counterAlphafrgtgt
//                    if (counterAlphafrgtgt >= 1f) {
//                        diffAlphafrgt = -0.05f
//                    }
//                    if (counterAlphafrgtgt <= 0.1f) {
//                        diffAlphafrgt = 0.05f
//                    }
//                    delay(20)
//                    counterAlphafrgtgt += diffAlphafrgt
//                }
//            }
//
//        }
//
//    }

//    private fun rfrgtyhyyju539() {
//        if (!isLaunchedAlphafrgt){
//            lifecycleScope.launch {
//                isLaunchedAlphafrgt = !isLaunchedAlphafrgt
//                while (true) {
//                    binding.tvFortuneMachine.alpha = counterAlphafrgtgt
//                    if (counterAlphafrgtgt >= 1f) {
//                        diffAlphafrgt = -0.06f
//                    }
//                    if (counterAlphafrgtgt <= 0.1f) {
//                        diffAlphafrgt = 0.06f
//                    }
//                    delay(20)
//                    counterAlphafrgtgt += diffAlphafrgt
//                }
//            }
//
//        }
//
//    }
}