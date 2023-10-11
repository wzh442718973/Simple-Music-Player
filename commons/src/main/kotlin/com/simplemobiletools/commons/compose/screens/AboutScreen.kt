package com.simplemobiletools.commons.compose.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.simplemobiletools.commons.R
import com.simplemobiletools.commons.compose.extensions.MyDevices
import com.simplemobiletools.commons.compose.lists.SimpleColumnScaffold
import com.simplemobiletools.commons.compose.settings.SettingsGroup
import com.simplemobiletools.commons.compose.settings.SettingsHorizontalDivider
import com.simplemobiletools.commons.compose.settings.SettingsListItem
import com.simplemobiletools.commons.compose.settings.SettingsTitleTextComponent
import com.simplemobiletools.commons.compose.theme.AppThemeSurface
import com.simplemobiletools.commons.compose.theme.SimpleTheme

private val startingTitlePadding = Modifier.padding(start = 60.dp)

@Composable
internal fun AboutScreen(
    goBack: () -> Unit,
    version: String,
    onVersionClick: () -> Unit,
    onInviteClick: () -> Unit,
    onEmailClick: () -> Unit,
    onPrivacyPolicyClick: () -> Unit,
) {
    SimpleColumnScaffold(title = stringResource(id = R.string.about), goBack = goBack) {

        TwoLinerTextItem(text = stringResource(id = R.string.invite_friends), icon = R.drawable.ic_add_person_vector, click = onInviteClick)

        TwoLinerTextItem(
            click = onPrivacyPolicyClick,
            text = stringResource(id = R.string.privacy_policy),
            icon = R.drawable.ic_unhide_vector
        )

        TwoLinerTextItem(
            click = onEmailClick,
            text = stringResource(id = R.string.my_email),
            icon = R.drawable.ic_mail_vector
        )

        TwoLinerTextItem(
            click = onVersionClick,
            text = version,
            icon = R.drawable.ic_info_vector
        )
    }
}



@Composable
internal fun SocialText(
    text: String,
    icon: Int,
    tint: Color? = null,
    click: () -> Unit
) {
    SettingsListItem(
        click = click,
        text = text,
        icon = icon,
        isImage = true,
        tint = tint,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
internal fun TwoLinerTextItem(text: String, icon: Int, click: () -> Unit) {
    SettingsListItem(
        tint = SimpleTheme.colorScheme.onSurface,
        click = click,
        text = text,
        icon = icon,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@MyDevices
@Composable
private fun AboutScreenPreview() {
    AppThemeSurface {
        AboutScreen(
            goBack = {},
            version = "5.0.4",
            onVersionClick = {},
            onPrivacyPolicyClick = {},
            onInviteClick = {},
            onEmailClick = {},
        )
    }
}
