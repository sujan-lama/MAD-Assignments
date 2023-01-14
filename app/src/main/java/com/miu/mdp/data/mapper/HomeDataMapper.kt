package com.miu.mdp.data.mapper

import com.miu.mdp.data.local.entity.HomeDataRelation
import com.miu.mdp.domain.model.HomeData

fun HomeDataRelation.toHomeDataModel() = HomeData(
    user = user.toUserModel(),
    userDetail = userDetail.toUserDetailModel()
)
