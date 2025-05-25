package cn.ommiao.aicygo.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import cn.ommiao.aicygo.R
import cn.ommiao.library.theme.Appearance

@Composable
fun IndicatorBar(modifier: Modifier = Modifier, current: Int, total: Int) {
    Row(
        modifier = modifier.padding(Appearance.spacing.large),
        verticalAlignment = Alignment.Bottom
    ) {
        AnimatedContent(current) { page ->
            Text(
                text = "${page + 1}",
                style = Appearance.typography.body01,
                color = Appearance.colors.textPrimary
            )
        }
        Text(
            text = "/$total",
            style = Appearance.typography.body01,
            color = Appearance.colors.textPrimary
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "For Flyme AIOS 2, @oMMiao",
            style = Appearance.typography.caption,
            color = Appearance.colors.textDisabled
        )
    }
}