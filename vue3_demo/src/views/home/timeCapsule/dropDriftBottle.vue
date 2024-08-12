<script setup>
  import {ref} from "vue";
  import {Close, Select} from "@element-plus/icons-vue";
  import {setUsername} from "@/stores/setUsername.js";
  import axios from "axios";
  import {useRouter} from "vue-router";
  import {ElMessage} from "element-plus";

  const router = useRouter()
  const text = ref('');
  const curUser = setUsername()
  async function handleText() {
    if(curUser.curUsername !== '') {
      try {
        const response = await axios.post('http://localhost:8080/home/DropDriftBottle', {
          username: curUser.curUsername,
          sentence: text.value
        })
        if(response.status === 200) {
          ElMessage.success('投放成功')
          await router.push('/home/timeTravel')
        }
      } catch (error) {
        ElMessage.error('投放失败')
        console.log('投放失败' + error)
      }
    } else {
      ElMessage.error('请先登录')
    }
  }
</script>

<template>
  <!--  注意：url里用‘’ ， /代表根目录 -->
  <div
      style="background-image: url('/dropDriftBottleBackground.jpg');
      height: 88vh;
      width: 85vw;
      background-size: cover;"
  >
    <div style="text-align: center">
      <h2 class="gradient-text" style="margin-top: 0; padding-top: 100px">投放漂流瓶</h2>
    </div>
    <div style="display:flex; justify-items: center;">
      <el-input
          v-model="text"
          style="width: 400px; margin: 50px auto; opacity: 0.75"
          :autosize="{ minRows: 2, maxRows: 50 }"
          type="textarea"
          placeholder="写下你当前的想法吧！"
      />
    </div>
    <div style="margin: 0 auto; width: 20vw; display: flex; justify-content: space-between">
      <div>
        <el-button type="danger" :icon="Close" circle :size="'large'" @click="router.push('/home/timeTravel')"/>
      </div>
      <div>
        <el-button type="success" :icon="Select" circle :size="'large'" @click="handleText" />
      </div>
    </div>
  </div>

</template>

<style scoped>
.gradient-text {
  background-image: linear-gradient(to right, red, blue);
  background-clip: text;
  color: transparent;
  font-size: 30px;
}

</style>
