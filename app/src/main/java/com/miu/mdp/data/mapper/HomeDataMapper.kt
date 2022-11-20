package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.HomeData
import com.miu.mdp.domain.model.HomeDataDTO

fun HomeData.toHomeDataDTO() = HomeDataDTO(
    userDTO = user.toUserDTO(),
    userDetailDTO = userDetail.toUserDetailDTO(),
)
