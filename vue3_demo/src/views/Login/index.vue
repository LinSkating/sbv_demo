<script setup>
import {reactive} from "vue";
import axios from 'axios';
import {useRouter} from "vue-router";
import {ElMessage} from "element-plus";
import {successStep} from "@/stores/successStep.js";
import {setUsername} from "@/stores/setUsername.js";

const curUser = setUsername()
const router = useRouter();
const user = reactive({
  username: '',
  password: ''
});


async function clickHandle() {
  if (user.username === '' || user.password === '') {
    ElMessage.error('请输入用户名和密码')
  } else {
    try {
      const response = await axios.post('http://localhost:8080/user/Login', {
        username: user.username,
        password: user.password
      });
      if (response.data.code === '200') {
        ElMessage.success('登录成功')
        curUser.setName(user.username)
        router.push('/home')
      } else {
        ElMessage.error('账号或密码错误')
      }
    } catch (error) {
      console.error(error)
    }
  }
}

const curStep = successStep()

function forgetPassword() {
  curStep.reset()
  router.push('/forgetPassword/stepOne')
}

</script>

<template>
  <div class="changeColor bigBox">
    <div class="flex exchangeMainAxis" style="background-color: rgba(255,255,255,0.1); width: 700px; height: 400px">
      <h1 style="margin-right: 20px">登录</h1>
      <div class="flex gap" style="align-items: center">
        <div class="toWide">UserName:</div>
        <div>
          <el-input
              v-model="user.username"
              clearable placeholder="请输入用户名"
              style="width: 300px; margin-right: 6px"
          >
          </el-input>
        </div>
      </div>

      <div class="flex gap" style="align-items: center">
        <div class="toWide">Password:</div>
        <div>
          <el-input
              v-model="user.password"
              show-password placeholder="请输入密码"
              style="width: 300px"
          >
          </el-input>
        </div>
      </div>

      <div class="flex">
        <div class="flex" style="margin-right: 50px">
          <el-button type="primary" link @click="router.push('/register')">注册</el-button>
        </div>
        <div class="flex">
          <el-button
              type="primary"
              round
              style="width: 200px"
              @click="clickHandle"
          >
            Submit
          </el-button>
        </div>
        <div class="flex" style="margin-left: 30px">
          <el-button type="text" link @click="forgetPassword">忘记密码</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.bigBox {
  height: 98vh;
}

.flex {
  display: flex;
}

.exchangeMainAxis {
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.toWide {
  margin-right: 10px;
}

.gap {
  margin-bottom: 20px;
}

.changeColor {
  /* 设置渐变背景 */
  background-image: linear-gradient(to right, #AED6F1, #D7BDE2);

  /* 其他样式 */
  width: 100%;
  height: 100vh; /* 设置高度为视口的高度 */
  margin: 0; /* 清除外边距 */
  padding: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}
</style>
