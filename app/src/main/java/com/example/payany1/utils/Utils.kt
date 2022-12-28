package com.example.payany1.utils

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import java.text.SimpleDateFormat
import java.util.*

fun navigate(navController: NavController, direction: NavDirections) {
    navController.navigate(direction)
}
fun Fragment.navigation(direction: NavDirections) {
    navigate(findNavController(), direction)
}

//fun navOption(): NavOptions {
//    return NavOptions.Builder()
//        .setEnterAnim(R.anim.from_right)
//        .setExitAnim(R.anim.to_left)
//        .setPopEnterAnim(R.anim.from_left)
//        .setPopExitAnim(R.anim.to_right)
//        .build()
//}

fun currentDate(): String {
    val sdf = SimpleDateFormat("dd MMMM,yyyy", Locale.getDefault())
    val date = Date()
    return sdf.format(date)
}
fun View.hide() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.visibility(visible: Boolean) {
    if (visible) visible() else hide()
}