package cn.ommiao.aicygo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cn.ommiao.aicygo.ui.IndicatorBar
import cn.ommiao.aicygo.ui.TitleBar
import cn.ommiao.aicygo.ui.page.Page1
import cn.ommiao.aicygo.ui.page.Page2
import cn.ommiao.aicygo.ui.page.Page3
import cn.ommiao.aicygo.ui.page.Page4
import cn.ommiao.library.theme.Appearance
import cn.ommiao.library.theme.EdgeToEdgeEffect
import cn.ommiao.library.theme.Theme
import cn.ommiao.library.theme.foundation.Typography
import kotlinx.coroutines.delay

val LocalPrimaryColor = compositionLocalOf<Color> { error("not provide") }
val LocalPrimaryBackgroundColor = compositionLocalOf<Color> { error("not provide") }
private const val TOTAL_PAGE = 4

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val theme = Appearance.Theme.SYSTEM
            Theme(
                theme = theme,
                typography = Typography(defaultFontFamily = null)
            ) {
                EdgeToEdgeEffect(theme)
                CompositionLocalProvider(
                    LocalPrimaryColor provides Color(0xFF0066FF),
                    LocalPrimaryBackgroundColor provides Color(0xFFCCE0FF)
                ) {
                    var userScrollEnabled by rememberSaveable { mutableStateOf(false) }
                    val pagerState = rememberPagerState { TOTAL_PAGE }
                    LaunchedEffect(Unit) {
                        delay(500)
                        pagerState.animateScrollBy(120f)
                        pagerState.animateScrollBy(-120f)
                        userScrollEnabled = true
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Appearance.colors.backgroundPrimaryBase)
                            .systemBarsPadding()
                    ) {
                        TitleBar()
                        HorizontalPager(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            state = pagerState,
                            userScrollEnabled = userScrollEnabled
                        ) { pageIndex ->
                            when (pageIndex + 1) {
                                1 -> {
                                    Page1 {
                                        AicyGoShortcutHelper.addHomeScreenShortcut(this@MainActivity)
                                    }
                                }

                                2 -> {
                                    Page2()
                                }

                                3 -> {
                                    Page3()
                                }

                                4 -> {
                                    Page4()
                                }
                            }
                        }
                        IndicatorBar(
                            current = pagerState.currentPage,
                            total = TOTAL_PAGE
                        )
                    }
                }
            }
        }
    }
}
