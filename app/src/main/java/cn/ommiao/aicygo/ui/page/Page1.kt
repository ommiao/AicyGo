package cn.ommiao.aicygo.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cn.ommiao.aicygo.AicyGoShortcutHelper.LaunchMode
import cn.ommiao.aicygo.LocalPrimaryColor
import cn.ommiao.aicygo.R
import cn.ommiao.library.theme.Appearance
import cn.ommiao.library.theme.foundation.Spacer

@Composable
fun Page1(modifier: Modifier = Modifier, onAddShortcutClick: (LaunchMode) -> Unit) {
    PageScaffold(
        modifier = modifier,
        illustration = {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.mipmap.img_add_shortcut),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        },
        description = {
            DescriptionTitle(
                text = stringResource(R.string.title_add_launcher_shortcut)
            )
            Appearance.spacing.extraLarge.Spacer()
            DescriptionDetails(
                text = stringResource(R.string.desc_add_launcher_shortcut)
            )
            Appearance.spacing.large.Spacer()
            NakedButton(
                text = stringResource(R.string.btn_add_voice_shortcut)
            ) { onAddShortcutClick(LaunchMode.VOICE) }
            Appearance.spacing.medium.Spacer()
            NakedButton(
                text = stringResource(R.string.btn_add_ai_search_shortcut)
            ) { onAddShortcutClick(LaunchMode.AI_SEARCH) }
        }
    )
}

@Composable
private fun NakedButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Text(
        modifier = modifier.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() },
            onClick = onClick
        ),
        text = text,
        style = Appearance.typography.body02,
        color = LocalPrimaryColor.current
    )
}