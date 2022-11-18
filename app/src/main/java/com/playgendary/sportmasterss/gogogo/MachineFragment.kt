package com.playgendary.sportmasterss.gogogo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.playgendary.sportmasterss.R
import com.playgendary.sportmasterss.databinding.FragmentMachineBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MachineFragment : Fragment() {
    private val edeffrtttgllll = SlotListAdapter()
    private val ceeeeeeentrgtgt = SlotListAdapter()
    private val rrrrrrrrrrroght = SlotListAdapter()

    private val rftgyhyhyy = dfrgtthyhyy56()

    private var frgyhyjuji: FragmentMachineBinding? = null
    private val frgttgyhy5 get() = frgyhyjuji ?: throw RuntimeException("ActivityMainBinding = null")

    private var dfrgtggyh66 = 300

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        frgyhyjuji = FragmentMachineBinding.inflate(inflater, container, false)
        return frgttgyhy5.root
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        frgttgyhy5.root.background.alpha = 210

        frgttgyhy5.tvUserBetCount.text = dfrgtggyh66.toString()

        frgttgyhy5.btnImgPlus.setOnClickListener {
            dfrgtggyh66 += 100
            frgttgyhy5.tvUserBetCount.text = dfrgtggyh66.toString()
        }
        frgttgyhy5.btnImgMinus.setOnClickListener {
            if (dfrgtggyh66 >= 100) dfrgtggyh66 -= 100
            frgttgyhy5.tvUserBetCount.text = dfrgtggyh66.toString()
        }


        initExitBtn()
        val linearLayoutManagerLeftdferfgtghyt = frgttgyhy5.recVLeft.layoutManager as LinearLayoutManager
        val linearLayoutManagerCenterrrrrrrr = frgttgyhy5.recVCenter.layoutManager as LinearLayoutManager
        val frgthyhyhyyh = frgttgyhy5.recVRight.layoutManager as LinearLayoutManager

        disableScrollingRecVeivs()
        initAdaptersRecV()
        submitListsForRecV()

        frgttgyhy5.btnGoSpin.setOnClickListener {
            // just change time of each scrolling recViev for better performance
            initScrollingSlotMachine(linearLayoutManagerLeftdferfgtghyt, 8, 12)
            initScrollingSlotMachine(linearLayoutManagerCenterrrrrrrr, 12, 18)
            initScrollingSlotMachine(frgthyhyhyyh, 20, 27)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initExitBtn() {
        frgttgyhy5.btnImgExitttttt.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onDestroy() {
        frgyhyjuji = null
        super.onDestroy()
    }

    private fun submitListsForRecV() {
        edeffrtttgllll.submitList(frgtghyhyhyhhy())
        ceeeeeeentrgtgt.submitList(frgtghyhyhyhhy())
        rrrrrrrrrrroght.submitList(frgtghyhyhyhhy())
    }

    private fun initAdaptersRecV() {
        frgttgyhy5.recVLeft.adapter = edeffrtttgllll
        frgttgyhy5.recVRight.adapter = ceeeeeeentrgtgt
        frgttgyhy5.recVCenter.adapter = rrrrrrrrrrroght
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun disableScrollingRecVeivs() {
        frgttgyhy5.recVLeft.setOnTouchListener { _, _ -> true }
        frgttgyhy5.recVRight.setOnTouchListener { _, _ -> true }
        frgttgyhy5.recVCenter.setOnTouchListener { _, _ -> true }
    }

    private fun initScrollingSlotMachine(
        linearLayoutManager: LinearLayoutManager,
        minNumberScrolling: Int,
        maxNumberScrolling: Int
    ) {
        lifecycleScope.launch {
            val numberTopdrfgtgtgt = Random.nextInt(minNumberScrolling, maxNumberScrolling)
            var timeForDelayLeftfrgtgtgt = 100L
            for (i in 1..numberTopdrfgtgtgt) {
                linearLayoutManager.scrollToPositionWithOffset(i, 0)
                delay(timeForDelayLeftfrgtgtgt)
                timeForDelayLeftfrgtgtgt += 5
            }
            if (maxNumberScrolling == 27) {
                Snackbar.make(
                    frgttgyhy5.root,
                    "You win ${Random.nextInt(from = 100, until = 1500)} points",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }

    private fun frgtghyhyhyhhy(): List<SlotElement> {
        val preList = mutableListOf<SlotElement>()
        for (i in 1..50) {
            preList.add(
                SlotElement(
                    Random.nextInt(Int.MAX_VALUE),
                    rftgyhyhyy.random(),
                )
            )
        }
        return preList
    }

    private fun dfrgtthyhyy56(): List<Int> {
        return listOf(
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
            R.drawable.a7,
            R.drawable.a8,
            R.drawable.a9
        )
    }
}