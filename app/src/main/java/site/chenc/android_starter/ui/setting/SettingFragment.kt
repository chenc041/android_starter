package site.chenc.android_starter.ui.setting

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import site.chenc.android_starter.databinding.FragmentSettingBinding

class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val settingViewModel =
            ViewModelProvider(this)[SettingViewModel::class.java]

        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.navigationSetting
        settingViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        var seekBar: SeekBar = binding.seekBar2;
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.d("SeekBar","当前进度: $progress")
                settingViewModel.updateText(progress)
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                Log.d("SeekBar","onStopTrackingTouch")
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                Log.d("SeekBar","onStartTrackingTouch")
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}