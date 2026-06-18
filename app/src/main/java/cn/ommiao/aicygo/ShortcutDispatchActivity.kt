package cn.ommiao.aicygo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity

class ShortcutDispatchActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        @Suppress("DEPRECATION")
        overridePendingTransition(0, 0)
        finishAndRemoveTask()

        Handler(Looper.getMainLooper()).postDelayed({
            val shortcutIntent = Intent("com.meizu.voiceassistant.action.AI_BAR").apply {
                setClassName(
                    "com.meizu.voiceassistant",
                    "com.meizu.ai.picker.AIBarEntryService"
                )
                putExtra("fromWhere", "ai_bar_toggle")
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startService(shortcutIntent)
        }, 300)
    }
}
