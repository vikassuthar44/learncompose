package com.example.learncompose.animation.fab

import androidx.compose.ui.graphics.vector.ImageVector

data class FabItemDataModel(
    val imageResourceId: ImageVector,
    val title: String,
    val isChild: Boolean = false
)
