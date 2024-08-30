<script setup>
import {getTimeTravelDetail} from "@/stores/getTimeTravelDetail.js";
import {setUsername} from "@/stores/setUsername.js";
import {ref} from "vue";

const item = getTimeTravelDetail()
const user = setUsername()
const isShow = ref(false)
const common = ref()
</script>

<template>
  <div class="mainBox">
    <div style="height: 10vh; display: flex; align-items: center">
      <el-avatar size="large" style="margin:0 20px"> {{ item.curItem.author }} </el-avatar>
      <h1>{{ item.curItem.author }}的时光漂流瓶</h1>
    </div>
    <div
        style="height: 40vh;
               display: flex;
               justify-content: center;
               align-items: center"
    >
      <h2>{{ item.curItem.sentence }}</h2>
    </div>
    <div style="height: 10vh; display: flex; align-items: center">
      <el-avatar size="large" style="margin:0 20px"> {{ user.curUsername }} </el-avatar>
      <div>
        <el-input
            v-model="common"
            class="input"
            placeholder="哎呦，不错哟，发条评论吧！"
            clearable
            @focus="isShow = true"
            @blur="isShow=false"
        />
        <el-button
            type="primary"
            size="large"
            v-show="isShow"
            style="margin-left: 10px; border-radius: 20px"
        >
          发布
        </el-button>
      </div>
    </div>
    <el-divider border-style="dashed"></el-divider>
  </div>
</template>

<style scoped>
  .mainBox {
    width: 70vw;
    height: 100vh;
    margin: 0 auto;
  }

  .input {
    width: 50vw;
    height: 5vh;
  }
</style>
