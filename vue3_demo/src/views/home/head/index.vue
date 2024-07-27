<script setup>

import {Bell, Help, Share, Star, User, UserFilled} from "@element-plus/icons-vue";
</script>

<template>
  <div class="head">
    <el-avatar :icon="UserFilled" />

    <div class="hover">
      <button class="button">
        <el-icon :size="25" class="el-icon">
          <User />
        </el-icon>
        <span class="font">用户</span>
      </button>
    </div>

    <div class="hover">
      <button class="button">
        <el-icon :size="25" class="el-icon">
          <Bell />
        </el-icon>
        <span class="font">信息</span>
      </button>
    </div>

    <div class="hover">
      <button class="button">
        <el-icon :size="25" class="el-icon">
          <Star />
        </el-icon>
        <span class="font">收藏</span>
      </button>
    </div>

    <el-popover>
      <template #reference>
        <div class="hover">
          <button class="button">
            <el-icon :size="25" class="el-icon">
              <Help />
            </el-icon>
            <span class="font">帮助</span>
          </button>
        </div>
      </template>
      <template #default>
        <div>
          <!-- 在用该组件时，src中路径用‘ ’包裹，再用“ ”包裹整个路径 -->
          <el-image :src=" '/myWeChat.jpg' "></el-image>
        </div>
      </template>
    </el-popover>


    <div class="hover">
      <button class="button">
        <el-icon :size="25" class="el-icon">
          <Share />
        </el-icon>
        <span class="font">分享</span>
      </button>
    </div>
  </div>
</template>

<style scoped>
/*
效果：鼠标经过图标时，图标会相对于文字向上跳动
步骤：
  1. 先在父元素上加上相对定位 （position: relative）
  2. 给想要跳动的元素加上动画（transform: translateY(-5px)）（在伪类选择器上）
     和 过渡属性（transition: transform 0.3s ease）
*/
.button{
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: rgb(255,255,255,0);
  border: rgb(255,255,255,0);
  position: relative;
}

.button .el-icon {
  transition: transform 0.3s ease;
}

.button:hover .el-icon {
  transform: translateY(-5px); /* 当鼠标悬停时向上移动5像素 */
}

.head{
  height: 80px;
  display: flex;
  justify-content: end;
  align-items: center;
}

.hover{
  margin-left: 15px;
}

.hover :hover{
  cursor: pointer;
  color: #ffc0cb;
}

.font{
  font-size: 15px;
  font-weight: bolder;
}

</style>
