package cn.ommiao.aicygo

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.core.content.getSystemService

object AicyGoShortcutHelper {

    fun addHomeScreenShortcut(context: Context, mode: LaunchMode) {
        val shortcutManager = context.getSystemService<ShortcutManager>() ?: return

        if (!shortcutManager.isRequestPinShortcutSupported) return

        val shortcutIntent = Intent(Intent.ACTION_MAIN).apply {
            setClassName(
                "com.meizu.voiceassistant",
                "com.meizu.voiceassistant.MainActivity"
            )
            putExtra("voice_entrance", mode.flymeExtraLabel)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK
        }

        val shortcut = ShortcutInfo.Builder(context, "aicy_go_${mode.name.lowercase()}")
            .setShortLabel(mode.label)
            .setLongLabel(mode.label)
            .setIcon(Icon.createWithResource(context, mode.icon))
            .setIntent(shortcutIntent)
            .build()

        shortcutManager.requestPinShortcut(shortcut, null)
    }

    enum class LaunchMode(
        val label: String,
        @DrawableRes val icon: Int,
        val flymeExtraLabel: String
    ) {
        VOICE(
            label = "Voice",
            icon = R.mipmap.ic_launcher_voice,
            flymeExtraLabel = "home_long_press",
        ),
        AI_SEARCH(
            label = "Ai Search",
            icon = R.mipmap.ic_launcher_aisearch,
            flymeExtraLabel = "Launcher_AI_Search",
        )
    }
}
