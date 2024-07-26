<script setup>
import {RouterView} from "vue-router";
import Head from '@/views/home/head/index.vue'
import Aside from '@/views/home/aside/index.vue'
</script>

<template>
  <el-container style="height: 98vh">
    <el-header class="color1">
      <Head></Head>
    </el-header>
    <el-container>
      <el-aside class="color2">
        <Aside></Aside>
      </el-aside>
      <el-main class="color3">
        <RouterView/>
      </el-main>
    </el-container>
  </el-container>
</template>

<style scoped>
.color1{
  height: 10vh;
  background-color: rgba(249, 228, 188, 0.4);
}

.color2{
  width: 13vw;
  background-image: linear-gradient( #fffde1, #ffc0cb, #b0e0e6);
}

.color3{
  background-color: rgba(255, 255, 0, 0.2);
}
</style>
