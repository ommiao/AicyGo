package cn.ommiao.aicygo

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import androidx.core.content.getSystemService

object AicyGoShortcutHelper {

    fun addHomeScreenShortcut(context: Context) {
        val shortcutManager = context.getSystemService<ShortcutManager>() ?: return

        if (!shortcutManager.isRequestPinShortcutSupported) return

        val shortcutIntent = Intent(context, ShortcutDispatchActivity::class.java).apply {
            action = Intent.ACTION_VIEW
        }

        val shortcut = ShortcutInfo.Builder(context, "aicy_go_scan")
            .setShortLabel("AI Scan")
            .setLongLabel("AI Scan")
            .setIcon(Icon.createWithResource(context, R.mipmap.ic_launcher_aisearch))
            .setIntent(shortcutIntent)
            .build()

        shortcutManager.requestPinShortcut(shortcut, null)
    }
}
