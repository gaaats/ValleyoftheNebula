package com.playgendary.sportmasterss.gogogo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.playgendary.sportmasterss.R
import com.playgendary.sportmasterss.databinding.FragmentVhelBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


class VhelFragment : Fragment() {
    var counterAlphafrgtgt = 0.05f
    var diffAlphafrgt = 0.05f

    var isLaunchedAlphafrgt = false

    private val sectorsfgttg = arrayOf(700, 1000, -100, 200, -500)
    private val sectorDegreesdfrt = sectorsfgttg.clone()
    private val frgtgtsingleSectorDegree = 360 / sectorsfgttg.size
    private var fgthyhy = false

    private var _binding: FragmentVhelBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("ActivityMainBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVhelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        try {
            initExitBtnfrgttg()
            rfrgtyhyyju538()
            dfeghjk()
            binding.btnGoSpin.setOnClickListener {
                if (!fgthyhy) {
                    frghj()
                    fgthyhy = true
                }
            }

        } catch (e: Exception) {
            fgthyhy555()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun initExitBtnfrgttg() {
        binding.btnImgExitRaitFragment.setOnClickListener {
            fegrhtjk5885858()
        }
    }

    private fun frghj() {
        val winnerNumber = Random.nextInt(sectorsfgttg.size - 1)

        //calculate number of degrees for set pointer to correct sector in UI
        val needAddRotate = (360 - winnerNumber * frgtgtsingleSectorDegree).toFloat()
        val rotateAnimation = RotateAnimation(
            0f,
            (360f * sectorsfgttg.size) + needAddRotate,
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f,
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f
        )
        rotateAnimation.apply {
            duration = 1000
            fillAfter = true
            interpolator = DecelerateInterpolator()
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    val edfrgthjk = sectorsfgttg[winnerNumber]
                    Toast.makeText(
                        requireContext(),
                        "You winn $edfrgthjk$ points",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    fgthyhy = false
                }

                override fun onAnimationRepeat(p0: Animation?) {
                }
            })
            binding.imgWheelElementMain.startAnimation(rotateAnimation)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun dfeghjk() {
        for (i in sectorsfgttg.indices) {
            sectorDegreesdfrt[i] = (i + 1) * frgtgtsingleSectorDegree
        }
    }

    private fun fegrhtjk5885858() {
        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Current data will not be saved, EXIT?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().finish()
            }
            .setNegativeButton("No") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }

    private fun rfrgtyhyyju538() {
        if (!isLaunchedAlphafrgt){
            lifecycleScope.launch {
                isLaunchedAlphafrgt = !isLaunchedAlphafrgt
                while (true) {
                    binding.btnGoSpin.alpha = counterAlphafrgtgt
                    if (counterAlphafrgtgt >= 1f) {
                        diffAlphafrgt = -0.05f
                    }
                    if (counterAlphafrgtgt <= 0.1f) {
                        diffAlphafrgt = 0.05f
                    }
                    delay(20)
                    counterAlphafrgtgt += diffAlphafrgt
                }
            }

        }

    }

    private fun fgthyhy555() {
        Snackbar.make(
            binding.root,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }
}