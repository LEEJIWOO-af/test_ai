package com.example.aitest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.aitest.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        // get app information and make list with it
        val appInfo = requireActivity().packageManager.getApplicationInfo(requireActivity().packageName, 0)
        val appList = listOf(
            "Name: ${requireActivity().packageManager.getApplicationLabel(appInfo)}",
            "Package: ${appInfo.packageName}",
            "Version: ${requireActivity().packageManager.getPackageInfo(appInfo.packageName, 0).versionName}",
            "Version Code: ${requireActivity().packageManager.getPackageInfo(appInfo.packageName, 0).versionCode}",
            "Target SDK: ${appInfo.targetSdkVersion}",
            "Min SDK: ${appInfo.minSdkVersion}",
            "Data Directory: ${appInfo.dataDir}",
            "Source Directory: ${appInfo.sourceDir}"
        )
        // show list in text view
        _binding?.textviewFirst?.text = appList.joinToString("\n")

        return _binding?.root
    }
}