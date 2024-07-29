<script setup>
import {ref} from "vue";
import {Key, MagicStick} from "@element-plus/icons-vue";
import {ElMessage} from "element-plus";
import {tempUserName} from "@/stores/tempUserName.js"
import axios from "axios";
import {useRouter} from "vue-router";

const codePlus = ref(null)
const newPassword = ref('')
const reInputPassword = ref('')
const tempName = tempUserName()
const router = useRouter()

async function submit() {
  const targetCode = '040909';
  if(codePlus.value !== targetCode) {
    ElMessage.error('二级验证码错误')
  } else if(newPassword.value !== reInputPassword.value) {
    ElMessage.error('两次输入的密码不相同')
  } else if(newPassword.value === '' || reInputPassword.value=== '') {
    ElMessage.error('密码不能为空')
  }
  try {
    const response = await axios.post('http://localhost:8080/user/forgetPassword',{
      username: tempName.userName,
      password: newPassword.value
    })
    if(response.status === 200) {
      ElMessage.success('密码修改成功')
      await router.push('/login')
    }
  } catch (error) {
    ElMessage.error('系统繁忙请稍后重试')
  }
}

</script>

<template>
  <h1 style="margin-left: 100px">请输入二级验证码</h1>
 <div class="mainBox">

    <div class="inputSize">
      <el-input
          v-model="codePlus"
          placeholder="请输入二级验证码"
          :autofocus="true"
          :prefix-icon="MagicStick"
      >
      </el-input>
    </div>

    <div class="inputSize">
      <el-input
          v-model="newPassword"
          placeholder="请输入您的新密码"
          :prefix-icon="Key"
          show-password
      >
      </el-input>
    </div>

    <div class="inputSize">
      <el-input
          v-model="reInputPassword"
          placeholder="再次输入您的新密码"
          :prefix-icon="Key"
          show-password
      >
      </el-input>
    </div>

    <div>
      <el-button
          round
          style="width: 200px; margin-top: 30px"
          color="#626aef"
          plain
          @click="submit"
      >
        确定提交
      </el-button>
    </div>

 </div>
</template>

<style scoped>
.mainBox {
  height: 500px;
  width: 60vw;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: rgba(255, 255, 255, 0.1);
}

.inputSize {
  width: 400px;
  margin-bottom: 30px;
}
</style>
