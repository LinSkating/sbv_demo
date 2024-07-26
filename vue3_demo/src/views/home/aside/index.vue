<script setup>
import {Operation, Postcard} from "@element-plus/icons-vue";
</script>

<template>
  <el-row>
    <el-col>
      <div
          style="display: flex;
          align-items: center;
          justify-content: center;
          margin-right: 70px;"
      >
        <el-icon size="25"><Operation /></el-icon>
        <h3 style="margin-left: 10px">菜单</h3>
      </div>

      <el-menu background-color="rgba(255, 255, 255, 0.1)" router>
        <el-sub-menu index="1">
          <template #title>
            <el-icon><Postcard /></el-icon>
            <span>关于我</span>
          </template>
          <el-menu-item-group>
            <!-- 注意设置跳转路由时要写成完整二级路由的形式 -->
            <el-menu-item index="/home/aboutMe">Life speech</el-menu-item>
            <el-menu-item index="/home/favPicture">picture</el-menu-item>
          </el-menu-item-group>
        </el-sub-menu>
      </el-menu>
    </el-col>
  </el-row>
</template>

<style scoped>

</style>
