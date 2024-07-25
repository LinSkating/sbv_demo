<script setup>

import {Bell, Help, Search, Star, User, UserFilled} from "@element-plus/icons-vue";
</script>

<template>
  <el-container style="height: 98vh">
    <el-header class="color1">
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

        <div class="hover">
          <button class="button">
            <el-icon :size="25" class="el-icon">
              <Help />
            </el-icon>
            <span class="font">帮助</span>
          </button>
        </div>

        <el-button
            :icon="Search"
            color="#626aef"
            round
            style="width: 100px; justify-content: space-between; margin-left: 15px"
        >
          Search
        </el-button>
      </div>
    </el-header>
    <el-container>
      <el-aside class="color2"></el-aside>
      <el-main class="color3"></el-main>
    </el-container>
  </el-container>
</template>

<style scoped>
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
  margin-left: 10px;
}

.hover :hover{
  cursor: pointer;
  color: #98FB98;
}

.font{
  font-size: 15px;
  font-weight: bolder;
}

.button{
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: rgb(255,255,255,0);
  border: rgb(255,255,255,0);
  position: relative;
}

.color1{
  height: 10vh;
  background-color: lightskyblue;
}

.color2{
  width: 15vw;
  background-color: palegreen;
}

.color3{
  background-color: yellow;
}
</style>
