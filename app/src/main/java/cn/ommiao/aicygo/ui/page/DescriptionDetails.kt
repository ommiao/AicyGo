package cn.ommiao.aicygo.ui.page

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cn.ommiao.library.theme.Appearance

@Composable
fun DescriptionDetails(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        style = Appearance.typography.body01,
        color = Appearance.colors.textSecondary
    )
}