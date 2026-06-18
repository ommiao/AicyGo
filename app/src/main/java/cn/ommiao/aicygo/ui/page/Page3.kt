package cn.ommiao.aicygo.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import cn.ommiao.aicygo.R
import cn.ommiao.library.theme.Appearance
import cn.ommiao.library.theme.foundation.Spacer

@Composable
fun Page3(modifier: Modifier = Modifier) {
    PageScaffold(
        modifier = modifier,
        illustration = {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.mipmap.img_hide_shortcut),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        },
        description = {
            DescriptionTitle(
                text = stringResource(R.string.title_hide_launcher_shortcut)
            )
            Appearance.spacing.extraLarge.Spacer()
            DescriptionDetails(
                text = stringResource(R.string.desc_hide_launcher_shortcut)
            )
        }
    )
}
