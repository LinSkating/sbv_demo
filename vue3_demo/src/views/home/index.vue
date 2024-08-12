<script setup>
import {RouterView} from "vue-router";
import Head from '@/views/home/head/index.vue'
import Aside from '@/views/home/aside/index.vue'
</script>

<template>
  <el-container style="height: 98vh">
    <el-header class="colorHead">
      <Head></Head>
    </el-header>
    <el-container>
      <el-aside class="colorAside">
        <Aside></Aside>
      </el-aside>
      <el-main style="padding: 0">
        <RouterView/>
      </el-main>
    </el-container>
  </el-container>
</template>

<style scoped>
.colorHead{
  height: 10vh;
  background-color: rgba(249, 228, 188, 0.4);
}

.colorAside{
  width: 13vw;
  background-image: linear-gradient( #fffde1, #ffc0cb, #b0e0e6);
}

</style>
