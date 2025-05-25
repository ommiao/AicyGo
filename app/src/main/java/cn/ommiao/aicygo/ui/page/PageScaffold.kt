package cn.ommiao.aicygo.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import cn.ommiao.library.theme.Appearance
import cn.ommiao.library.theme.foundation.Spacer
import cn.ommiao.library.theme.foundation.shape

@Composable
fun PageScaffold(
    modifier: Modifier = Modifier,
    illustration: @Composable BoxScope.() -> Unit,
    description: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = Appearance.spacing.large)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1 / 1.2f)
                .clip(Appearance.radius.large.shape())
                .background(Appearance.colors.backgroundSecondaryBase)
        ) {
            illustration()
        }
        Appearance.spacing.twoExtraLarge.Spacer()
        description()
    }
}