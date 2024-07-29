<script setup>

import {ref} from "vue";
import {Avatar, Back, Right} from "@element-plus/icons-vue";
import {ElMessage} from "element-plus";
import router from "@/router/index.js";
import {successStep} from "@/stores/successStep.js";
import {tempUserName} from "@/stores/tempUserName.js"

const username = ref('')
// 使用pinia时对于仓库暴露出来的名要加() eg：successStep()
const curStep = successStep()
const tempName = tempUserName()

function next() {
  if (username.value === '') {
    ElMessage.error('请输入用户名')
  } else {
    curStep.next()
    tempName.setUserName(username.value)
    router.push('/forgetPassword/stepTwo')
  }
}

</script>

<template>
  <h1 style="margin: 30px 25px">第一步：请输入您的用户名</h1>
  <div class="progress">
    <el-input
        v-model="username"
        style="width: 400px; height: 40px;"
        placeholder="请输入你的用户名"
        :prefix-icon="Avatar"
        clearable
        :autofocus="true"
    />

    <div style="display: flex; width: 800px; margin-top: 30px; justify-content: space-around">
      <div>
        <el-button
            type="primary"
            round
            :icon="Back"
            @click="router.push('/login')"
        >
          返回
        </el-button>
      </div>

      <div>
        <el-button type="success" round :icon="Right" @click="next" color="#FFC0CB">继续</el-button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.progress {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 500px;
  width: 60vw;
  background-color: rgba(255, 255, 255, 0.1);
}
</style>
