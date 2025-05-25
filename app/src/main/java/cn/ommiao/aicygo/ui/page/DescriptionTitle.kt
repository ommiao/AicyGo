package cn.ommiao.aicygo.ui.page

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cn.ommiao.library.theme.Appearance

@Composable
fun DescriptionTitle(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        style = Appearance.typography.title01,
        color = Appearance.colors.textPrimary
    )
}