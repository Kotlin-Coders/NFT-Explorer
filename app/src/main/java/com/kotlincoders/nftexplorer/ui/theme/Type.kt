package com.kotlincoders.nftexplorer.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kotlincoders.nftexplorer.R

val NftsExplorerFontFamily = FontFamily(
    Font(R.font.jaldi_regular)
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = NftsExplorerFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        brush = Brush.verticalGradient(
            colors = listOf(NftExplorerPink, NftExplorerOrange)
        )
    ),
    titleMedium = TextStyle(
        fontFamily = NftsExplorerFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    titleSmall = TextStyle(
        fontFamily = NftsExplorerFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
)