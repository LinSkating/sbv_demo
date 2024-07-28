<script setup>

import {ref} from "vue";
import {ElMessage, ElMessageBox} from "element-plus";

const code = ref('点击获取验证码')
const inputCode = ref('')

function getCode() {
  const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'
  let res = ''
  for(let i = 0; i < 8; i++) {
    const min = Math.ceil(0);
    const max = Math.floor(57);
    const ind = Math.floor(Math.random() * (max - min + 1)) + min
    res += characters.charAt(ind)
  }
  code.value = res
}

function submit() {
  if(code.value === inputCode.value) {
    ElMessage.success('验证成功')
    ElMessageBox.alert(
        '<img src="/myWeChat.jpg" alt="sdv" style="width: 300px; height: 410px">' +
        '<p><strong>请添加获取二级验证码</strong></p>',
        {
          dangerouslyUseHTMLString: true,
        },
    )
  } else {
    ElMessage.error('验证码错误')
  }
}
</script>

<template>
  <h1 style="margin-left: 100px">输入验证码成功后添加Wechat</h1>
  <div class="mainBox">
    <div style="display: flex">
      <div style="width: 300px">
        <el-input placeholder="请输入当前验证码" v-model="inputCode"></el-input>
      </div>
      <div style="margin-left: 100px">
        <el-button @click="getCode"> {{code}} </el-button>
      </div>
    </div>

    <div >
      <el-button
          style="width: 200px; margin-top: 50px"
          :round="true"
          color="#626aef"
          plain
          @click="submit"
      >
        提交
      </el-button>
    </div>
  </div>

</template>

<style scoped>
.mainBox{
  height: 500px;
  width: 60vw;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: rgba(255, 255, 255, 0.1);
}
</style>
