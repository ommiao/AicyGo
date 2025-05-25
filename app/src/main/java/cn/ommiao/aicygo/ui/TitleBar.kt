package cn.ommiao.aicygo.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import cn.ommiao.aicygo.R
import cn.ommiao.library.theme.Appearance

@Composable
fun TitleBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(
            vertical = Appearance.spacing.medium,
            horizontal = Appearance.spacing.large
        )
    ) {
        Text(
            text = stringResource(R.string.app_slogan),
            style = Appearance.typography.title02,
            color = Appearance.colors.textPrimary
        )
    }
}